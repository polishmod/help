import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {PagesComponent} from '../pages.component';
import {AccountSettingsComponent} from './account-settings/account-settings.component';
import {UsersSettingsComponent} from './users-settings/users-settings.component';
import {CountriesComponent} from "./countries/countries.component";
import {UserViewComponent} from "./user-view/user-view.component";

const routes: Routes = [{
  path: 'settings',
  component: PagesComponent,
  children: [
    {
      path: 'account',
      component: AccountSettingsComponent,
    },
    {
      path: 'users',
      component: UsersSettingsComponent,
    },
    {
      path: 'user-details',
      component: UserViewComponent,
    },
    {
      path: 'user-details/:id',
      component: UserViewComponent,
    },
    {
      path: 'countries',
      component: CountriesComponent,
    },
  ],
}];


@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class NgxSettingsRoutingModule {
}
