import {Component, Input, OnInit, ViewChild} from '@angular/core';
import {ApiUsersService} from '../../generated-api/services/api-users.service';
import {DialogService, extractContent, FormModel, ITableConfig} from 'defdev-angular-nebular';
import {Router} from '@angular/router';
import {map} from 'rxjs/operators';
import {AppUserViewModel} from '../../generated-api/models/app-user-view-model';
import {ModelTypes} from '../../generated-api/models/model-types';
import {ApiUserLocationService} from "../../generated-api/services";
import {OlMapComponent} from "../ol-map/ol-map.component";

@Component({
  selector: 'ngx-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.scss']
})
export class UserDetailsComponent implements OnInit {

  @Input()
  userId: number;
  formModel: FormModel<AppUserViewModel>;

  @ViewChild(OlMapComponent, {static: false})
  map: OlMapComponent;

  surveysConfig: ITableConfig = {
    modelType: ModelTypes.SURVEY,
    title: 'Surveys',
    showBulkUpdate: false,
    selectionMode: 'single',
    referencedProperty: {type: 'integer', field: 'userId', value: () => this.formModel.object.id}
  };
  notificationsConfig: ITableConfig = {
    modelType: ModelTypes.FIREBASE_NOTIFICATION,
    title: 'Notifications',
    showBulkUpdate: false,
    selectionMode: 'single',
    referencedProperty: {type: 'integer', field: 'toUserId', value: () => this.formModel.object.id}
  };
  showMap: boolean;


  constructor(
    private readonly usersService: ApiUsersService,
    private readonly dialogService: DialogService,
    private readonly userLocationService: ApiUserLocationService,
    private readonly router: Router,
  ) {
  }

  ngOnInit() {
    this.loadAccount();
  }

  public save(): void {
    if (this.formModel.object.id > 0) {
      this.usersService.Put(this.formModel.object).pipe(extractContent()).subscribe(x => this.afterSuccess(x));
    } else {
      this.usersService.Post(this.formModel.object).pipe(extractContent()).subscribe(x => this.afterSuccess(x));
    }

  }

  onCancel() {
    this.goToLastPageOrDefault();
  }

  onChangePassword() {
    this.dialogService.showInputEditorDialog({
      title: 'Change password',
      label: 'Password',
      type: 'input',
      value: ''
    }).onConfirm((model) => {
      this.usersService.ChangePassword({password: model.value}).subscribe(() => {
      });
    });
  }

  isDoctor() {
    return this.formModel && this.formModel.object.roles.indexOf('doctor') > -1;
  }

  onChangeTab($event: any) {
    if ($event.tabTitle === 'Routes') {
      setTimeout(() => {
        this.showMap = true;
        this.userLocationService.GetForUser(this.formModel.object.id).pipe(extractContent())
          .subscribe(data => {
            data.forEach(point => {
              this.map.addHeatmapPoint(point.location.lat, point.location.lon, 1);
            });
          });
      }, 300);
    }
  }

  private loadAccount() {
    this.usersService.GetWithEditData({id: this.userId}).pipe(map(d => d.content))
      .subscribe(formModel => {
        this.formModel = formModel;
      });

  }

  private afterSuccess(x: AppUserViewModel) {
    this.goToLastPageOrDefault();
  }

  private goToLastPageOrDefault() {
    this.router.navigate(['/']);
  }
}
