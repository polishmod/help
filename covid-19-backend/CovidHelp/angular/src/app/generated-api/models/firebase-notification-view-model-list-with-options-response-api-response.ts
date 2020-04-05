/* tslint:disable */
import { ExceptionUiConfig } from './exception-ui-config';
import { ValidationError } from './validation-error';
import { FirebaseNotificationViewModelListWithOptionsResponse } from './firebase-notification-view-model-list-with-options-response';
export interface FirebaseNotificationViewModelListWithOptionsResponseApiResponse {
  success?: boolean;
  message?: string;
  detail?: string;
  uiConfig?: ExceptionUiConfig;
  errors?: Array<ValidationError>;
  content?: FirebaseNotificationViewModelListWithOptionsResponse;
}
