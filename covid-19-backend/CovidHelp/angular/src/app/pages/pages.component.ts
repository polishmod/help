import {Component} from '@angular/core';
import {NbAccessChecker} from '@nebular/security';
import {MENU_ITEMS} from './pages-menu';
import {NbMenuItem} from '@nebular/theme';
import {HttpLoaderService} from 'defdev-angular-nebular'
import {environment} from '../../environments/environment';

@Component({
  selector: 'ngx-pages',
  template: `
    <nb-layout windowMode>
      <nb-layout-header fixed>
        <ngx-header [userMenu]="userMenu" [title]="appTitle"></ngx-header>
      </nb-layout-header>

      <nb-sidebar class="menu-sidebar" tag="menu-sidebar" responsive>
        <nb-menu *ngIf='menu != null' [items]="menu"></nb-menu>
      </nb-sidebar>

      <nb-layout-column [nbSpinner]="loaderService.isLoading$ | async">
        <router-outlet></router-outlet>
      </nb-layout-column>

      <nb-layout-footer fixed>
        <ngx-footer [companyName]="'Ministry of National Defense'"></ngx-footer>
      </nb-layout-footer>
    </nb-layout>
  `,
})
export class PagesComponent {
  appTitle = environment.appName;
  menu = MENU_ITEMS;
  userMenu = [
    {
      title: 'My account',
      link: '/pages/settings/account'
    },

    {
      title: 'Log out',
      link: '/auth/logout'
    },
  ];

  constructor(public accessChecker: NbAccessChecker, public loaderService: HttpLoaderService) {
    this.authMenuItems();

  }

  authMenuItems() {
    this.menu.forEach(item => {
      this.authMenuItem(item);
    });
  }

  authMenuItem(menuItem: NbMenuItem) {
    if (menuItem.data && menuItem.data['permission'] && menuItem.data['resource']) {
      this.accessChecker.isGranted(menuItem.data['permission'], menuItem.data['resource']).subscribe(granted => {
        menuItem.hidden = !granted;
      });
    } else {
      menuItem.hidden = false;
    }
    if (!menuItem.hidden && menuItem.children != null) {
      menuItem.children.forEach(item => {
        if (item.data && item.data['permission'] && item.data['resource']) {
          this.accessChecker.isGranted(item.data['permission'], item.data['resource']).subscribe(granted => {
            item.hidden = !granted;
          });
        } else {
          // if child item do not config-list any `data.permission` and `data.resource` just inherit parent item's config-list
          item.hidden = menuItem.hidden;
        }
      });
    }
  }
}
