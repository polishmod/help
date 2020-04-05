import {NgModule} from '@angular/core';

import {PagesComponent} from './pages.component';
import {PagesRoutingModule} from './pages-routing.module';
import {SettingsModule} from './settings/settings.module';
import {DefdevAngularNebularModule, ThemeModule} from 'defdev-angular-nebular';


const PAGES_COMPONENTS = [
  PagesComponent,
];

@NgModule({
  imports: [
    PagesRoutingModule,
    SettingsModule,
    DefdevAngularNebularModule,
    ThemeModule,
  ],
  declarations: [
    ...PAGES_COMPONENTS,
  ],

})
export class PagesModule {
}
