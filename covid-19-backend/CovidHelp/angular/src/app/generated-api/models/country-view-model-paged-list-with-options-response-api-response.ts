/* tslint:disable */
import { ExceptionUiConfig } from './exception-ui-config';
import { ValidationError } from './validation-error';
import { CountryViewModelPagedListWithOptionsResponse } from './country-view-model-paged-list-with-options-response';
export interface CountryViewModelPagedListWithOptionsResponseApiResponse {
  success?: boolean;
  message?: string;
  detail?: string;
  uiConfig?: ExceptionUiConfig;
  errors?: Array<ValidationError>;
  content?: CountryViewModelPagedListWithOptionsResponse;
}
