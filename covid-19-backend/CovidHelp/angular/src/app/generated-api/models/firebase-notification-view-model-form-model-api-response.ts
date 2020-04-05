/* tslint:disable */
import { ExceptionUiConfig } from './exception-ui-config';
import { ValidationError } from './validation-error';
import { FirebaseNotificationViewModelFormModel } from './firebase-notification-view-model-form-model';
export interface FirebaseNotificationViewModelFormModelApiResponse {
  success?: boolean;
  message?: string;
  detail?: string;
  uiConfig?: ExceptionUiConfig;
  errors?: Array<ValidationError>;
  content?: FirebaseNotificationViewModelFormModel;
}
