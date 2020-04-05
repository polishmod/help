import {Component, OnInit} from '@angular/core';
import {ApiAuthenticationService, ApiUsersService} from '../../../generated-api/services';
import {NbAuthJWTToken, NbTokenService} from '@nebular/auth';
import {environment} from '../../../../environments/environment';
import {ModelType} from '../../../constants';
import {NbRoleProvider} from '@nebular/security';
import {DialogService, extractContent, ITableConfig} from 'defdev-angular-nebular';

@Component({
  selector: 'ngx-users-settings',
  template: '<ngx-config-based-table-component [tableConfig]="tableConfig"> </ngx-config-based-table-component>'
})
export class UsersSettingsComponent implements OnInit {


  tableConfig: ITableConfig = {
    modelType: ModelType[ModelType.USER],
    title: 'Users',
    customTableActions: [
      {name: 'password', title: '<i class="nb-locked" title="Change password"></i>'},
      {name: 'login-as', title: '<i class="nb-person" title="Login as"></i>'},
    ],
    editLink: 'pages/settings/user-details',
    showBulkUpdate: false,
  }

  constructor(
    readonly service: ApiUsersService,
    readonly authService: ApiAuthenticationService,
    readonly tokenService: NbTokenService,
    readonly roleProvider: NbRoleProvider,
    readonly dialogService: DialogService) {
  }

  onCustomAction(event) {
    if (event.action === 'password') {
      this.dialogService.showPasswordDialog().onConfirm((newPassword) => {
        this.service.ChangePassword({password: newPassword, userId: event.data.id}).subscribe(() => {
        });
      });
    } else if (event.action === 'login-as') {
      this.authService.LoginAsOtherUser(event.data.id)
        .pipe(extractContent())
        .subscribe(newToken => {
          this.tokenService.set(new NbAuthJWTToken(newToken, environment.securityStrategyName));
          window.location.reload();
        });
    }

  }

  // , super admin, finaliser, planner, edit only
  ngOnInit(): void {


  }

}
