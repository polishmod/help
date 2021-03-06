/* tslint:disable */
import { ExceptionUiConfig } from './exception-ui-config';
import { ValidationError } from './validation-error';
import { CountryViewModelPagedList } from './country-view-model-paged-list';
export interface CountryViewModelPagedListApiResponse {
  success?: boolean;
  message?: string;
  detail?: string;
  uiConfig?: ExceptionUiConfig;
  errors?: Array<ValidationError>;
  content?: CountryViewModelPagedList;
}
