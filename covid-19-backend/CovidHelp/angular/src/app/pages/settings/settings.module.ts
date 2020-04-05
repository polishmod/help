import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {AccountSettingsComponent} from './account-settings/account-settings.component';
import {UsersSettingsComponent} from './users-settings/users-settings.component';
import {NgxSettingsRoutingModule} from './settings-routing.module';
import {FormsModule} from '@angular/forms';
import {DefdevAngularNebularModule, NebularModule} from 'defdev-angular-nebular';
import { ComponentsModule } from 'app/components/components.module';
import { CountriesComponent } from './countries/countries.component';
import { UserViewComponent } from './user-view/user-view.component';

@NgModule({
  declarations: [AccountSettingsComponent, UsersSettingsComponent, CountriesComponent, UserViewComponent],
  imports: [
    NgxSettingsRoutingModule,
    CommonModule,
    FormsModule,
    NebularModule,
    DefdevAngularNebularModule,
    ComponentsModule,
  ],
})
export class SettingsModule {
}
