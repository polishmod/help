/* tslint:disable */
import { ExceptionUiConfig } from './exception-ui-config';
import { ValidationError } from './validation-error';
import { FirebaseNotificationViewModelPagedListWithOptionsResponse } from './firebase-notification-view-model-paged-list-with-options-response';
export interface FirebaseNotificationViewModelPagedListWithOptionsResponseApiResponse {
  success?: boolean;
  message?: string;
  detail?: string;
  uiConfig?: ExceptionUiConfig;
  errors?: Array<ValidationError>;
  content?: FirebaseNotificationViewModelPagedListWithOptionsResponse;
}
