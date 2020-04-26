import {CommonModule} from '@angular/common';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';

import {NgxAuthRoutingModule} from './auth-routing.module';
import {NbAuthModule} from '@nebular/auth';
import {NbAlertModule, NbCheckboxModule} from '@nebular/theme';
import {NgxLoginComponent} from './login/login.component';
import {NgxRegisterComponent} from './register/register.component';
import {NgxResetPasswordComponent} from './reset/reset-password.component';
import {DefdevAngularNebularModule} from 'defdev-angular-nebular';


@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    RouterModule,
    NbAlertModule,
    NbCheckboxModule,
    NgxAuthRoutingModule,
    NbAuthModule,
    DefdevAngularNebularModule,
  ],
  declarations: [
    NgxLoginComponent,
    NgxRegisterComponent,
    NgxResetPasswordComponent,
  ],
})
export class NgxAuthModule {
}
