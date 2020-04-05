/* tslint:disable */
import { ExceptionUiConfig } from './exception-ui-config';
import { ValidationError } from './validation-error';
import { ConfigViewModel } from './config-view-model';
export interface ConfigViewModelIEnumerableApiResponse {
  success?: boolean;
  message?: string;
  detail?: string;
  uiConfig?: ExceptionUiConfig;
  errors?: Array<ValidationError>;
  content?: Array<ConfigViewModel>;
}
