/* tslint:disable */
import { ExceptionUiConfig } from './exception-ui-config';
import { ValidationError } from './validation-error';
import { FirebaseNotificationViewModelPagedList } from './firebase-notification-view-model-paged-list';
export interface FirebaseNotificationViewModelPagedListApiResponse {
  success?: boolean;
  message?: string;
  detail?: string;
  uiConfig?: ExceptionUiConfig;
  errors?: Array<ValidationError>;
  content?: FirebaseNotificationViewModelPagedList;
}
