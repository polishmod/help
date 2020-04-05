/* tslint:disable */
import { NgModule, ModuleWithProviders } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { ApiConfiguration, ApiConfigurationInterface } from './api-configuration';

import { ApiAppLogsService } from './services/api-app-logs.service';
import { ApiAuthenticationService } from './services/api-authentication.service';
import { ApiCityService } from './services/api-city.service';
import { ApiConfigService } from './services/api-config.service';
import { ApiCountryService } from './services/api-country.service';
import { ApiDocumentsService } from './services/api-documents.service';
import { ApiEntityFieldsDefinitionsService } from './services/api-entity-fields-definitions.service';
import { ApiFirebaseNotificationService } from './services/api-firebase-notification.service';
import { ApiInfectedStatisticsService } from './services/api-infected-statistics.service';
import { ApiNotesService } from './services/api-notes.service';
import { ApiSurveyService } from './services/api-survey.service';
import { ApiUserLocationService } from './services/api-user-location.service';
import { ApiUsersService } from './services/api-users.service';

/**
 * Provider for all Api services, plus ApiConfiguration
 */
@NgModule({
  imports: [
    HttpClientModule
  ],
  exports: [
    HttpClientModule
  ],
  declarations: [],
  providers: [
    ApiConfiguration,
    ApiAppLogsService,
    ApiAuthenticationService,
    ApiCityService,
    ApiConfigService,
    ApiCountryService,
    ApiDocumentsService,
    ApiEntityFieldsDefinitionsService,
    ApiFirebaseNotificationService,
    ApiInfectedStatisticsService,
    ApiNotesService,
    ApiSurveyService,
    ApiUserLocationService,
    ApiUsersService
  ],
})
export class ApiModule {
  static forRoot(customParams: ApiConfigurationInterface): ModuleWithProviders {
    return {
      ngModule: ApiModule,
      providers: [
        {
          provide: ApiConfiguration,
          useValue: {rootUrl: customParams.rootUrl}
        }
      ]
    }
  }
}
