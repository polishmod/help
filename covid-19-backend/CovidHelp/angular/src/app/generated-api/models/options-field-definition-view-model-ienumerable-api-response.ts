/* tslint:disable */
import { ExceptionUiConfig } from './exception-ui-config';
import { ValidationError } from './validation-error';
import { OptionsFieldDefinitionViewModel } from './options-field-definition-view-model';
export interface OptionsFieldDefinitionViewModelIEnumerableApiResponse {
  success?: boolean;
  message?: string;
  detail?: string;
  uiConfig?: ExceptionUiConfig;
  errors?: Array<ValidationError>;
  content?: Array<OptionsFieldDefinitionViewModel>;
}
