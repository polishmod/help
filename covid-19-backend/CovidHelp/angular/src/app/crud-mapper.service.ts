import {Injectable} from '@angular/core';

import {Observable} from 'rxjs';
import {flatMap} from 'rxjs/operators';
import {
  ApiCityService,
  ApiConfigService,
  ApiCountryService,
  ApiDocumentsService, ApiFirebaseNotificationService,
  ApiInfectedStatisticsService,
  ApiSurveyService,
  ApiUserLocationService,
  ApiUsersService
} from './generated-api/services';
import {ApiCrudService, DialogService, extractContent} from 'defdev-angular-nebular';
import {CrudMapperApiService} from 'defdev-angular-nebular/lib/services/api/crud-mapper-api-service';
import {ModelTypes} from "./generated-api/models";


@Injectable({
  providedIn: 'root'
})
export class CrudMapperService implements CrudMapperApiService {

  constructor(
    private usersService: ApiUsersService,
    private documentsService: ApiDocumentsService,
    private configService: ApiConfigService,
    private surveyService: ApiSurveyService,
    private userLocationService: ApiUserLocationService,
    private infectedStatisticsService: ApiInfectedStatisticsService,
    private cityService: ApiCityService,
    private countryService: ApiCountryService,
    private firebaseNotificationService: ApiFirebaseNotificationService,
    private dialogService: DialogService
  ) {
  }

  GetCrudServiceForModel(modelType: string): ApiCrudService<any> {
    switch (modelType.toUpperCase()) {
      case 'USER':
        return this.usersService;
      case 'DOCUMENT':
        return this.documentsService;
      case 'CONFIG':
        return this.configService;
      case 'SURVEY':
        return this.surveyService;
      case 'USERLOCATION':
        return this.userLocationService;
      case 'INFECTEDSTATISTICS':
        return this.infectedStatisticsService;
      case 'CITY':
        return this.cityService;
      case 'COUNTRY':
        return this.countryService;
      case 'FIREBASENOTIFICATION':
        return this.firebaseNotificationService;
    }

    return undefined;
  }

  ShowEditDialog(modelName: string, additionalParamName?: string, additionalParamValue?: string): Observable<any> {
    const crudService = this.GetCrudServiceForModel(modelName);
    if (crudService != null) {
      const editData = crudService.GetWithEditData({id: -1, additionalParamName, additionalParamValue}).pipe(
        extractContent(),
        flatMap(form => {
          return this.dialogService.showDynamicEditorDialog({
            dialogName: 'Add',
            formModel: form
          }).confirm;
        }),
        flatMap(result => crudService.AddOrUpdate(result.formModel.object)),
        extractContent()
      );
      return editData;
    }
    return null;
  }
}
