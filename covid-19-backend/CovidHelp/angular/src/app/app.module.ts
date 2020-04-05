/**
 * @license
 * Copyright Akveo. All Rights Reserved.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
import {APP_BASE_HREF} from '@angular/common';
import {BrowserModule} from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {APP_INITIALIZER, NgModule, Provider} from '@angular/core';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {AppComponent} from './app.component';
import {AppRoutingModule} from './app-routing.module';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {environment} from '../environments/environment';
import {ApiConfiguration} from './generated-api/api-configuration';
import {LogoutInterceptor} from './auth/logout/logout.interceptor';
import {AuthGuard} from './auth/auth-guard';
import {ChartModule} from 'angular2-chartjs';
import {LoggerModule, NgxLoggerLevel} from 'ngx-logger';
import {AgmCoreModule} from '@agm/core';
import {
  AuthInterceptor,
  CONFIG_CRUD_SERVICE,
  CRUD_MAPPER_SERVICE,
  DefdevAngularNebularModule,
  DOCUMENTS_CRUD_SERVICE,
  LOGGED_USER_SERVICE,
  NOTES_CRUD_SERVICE
} from 'defdev-angular-nebular';
import {ApiConfigService, ApiDocumentsService, ApiNotesService, ApiUsersService} from './generated-api/services';
import {PagesModule} from './pages/pages.module';
import {CrudMapperService} from './crud-mapper.service';


export function initApiConfiguration(config: ApiConfiguration): Function {
  return () => {
    // if (!environment.production) {
    //   config.rootUrl = 'http://localhost:4201';
    // }
  };
}


export const INIT_API_CONFIGURATION: Provider = {
  provide: APP_INITIALIZER,
  useFactory: initApiConfiguration,
  deps: [ApiConfiguration],
  multi: true,
};

@NgModule({
  declarations: [AppComponent],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    AppRoutingModule,
    NgbModule,
    ChartModule,
    PagesModule,
    AgmCoreModule.forRoot({
      apiKey: '',
    }),
    LoggerModule.forRoot({
      serverLoggingUrl: '/api/ApiAppLogs',
      level: NgxLoggerLevel.DEBUG,
      serverLogLevel: NgxLoggerLevel.ERROR,
      disableConsoleLogging: environment.production
    }),
    DefdevAngularNebularModule.forRoot({
      securityName: environment.securityStrategyName,
      nbSecurityOptions: {
        accessControl: {
          guest: {
            view: '*',
          },
          admin: {
            parent: 'guest',
            create: '*',
            edit: '*',
            remove: '*',
            list: '*',
          },

        },
      },
    }),
  ],
  bootstrap: [AppComponent],
  providers: [
    {provide: APP_BASE_HREF, useValue: '/'},
    {
      provide: HTTP_INTERCEPTORS,
      useClass: LogoutInterceptor,
      multi: true,
    },
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true,
    },
    {
      provide: NOTES_CRUD_SERVICE,
      useClass: ApiNotesService,
      multi: false,
    },
    {
      provide: DOCUMENTS_CRUD_SERVICE,
      useClass: ApiDocumentsService,
      multi: false,
    },
    {
      provide: CONFIG_CRUD_SERVICE,
      useClass: ApiConfigService,
      multi: false,
    },
    {
      provide: LOGGED_USER_SERVICE,
      useClass: ApiUsersService,
      multi: false,
    },
    {
      provide: CRUD_MAPPER_SERVICE,
      useClass: CrudMapperService,
      multi: false,
    },
    AuthGuard,
    INIT_API_CONFIGURATION,
  ],


})
export class AppModule {
}
