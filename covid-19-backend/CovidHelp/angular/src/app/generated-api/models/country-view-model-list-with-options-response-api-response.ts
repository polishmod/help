/* tslint:disable */
import { ExceptionUiConfig } from './exception-ui-config';
import { ValidationError } from './validation-error';
import { CountryViewModelListWithOptionsResponse } from './country-view-model-list-with-options-response';
export interface CountryViewModelListWithOptionsResponseApiResponse {
  success?: boolean;
  message?: string;
  detail?: string;
  uiConfig?: ExceptionUiConfig;
  errors?: Array<ValidationError>;
  content?: CountryViewModelListWithOptionsResponse;
}
