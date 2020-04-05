/* tslint:disable */
import { ExceptionUiConfig } from './exception-ui-config';
import { ValidationError } from './validation-error';
import { CityViewModelPagedListWithOptionsResponse } from './city-view-model-paged-list-with-options-response';
export interface CityViewModelPagedListWithOptionsResponseApiResponse {
  success?: boolean;
  message?: string;
  detail?: string;
  uiConfig?: ExceptionUiConfig;
  errors?: Array<ValidationError>;
  content?: CityViewModelPagedListWithOptionsResponse;
}
