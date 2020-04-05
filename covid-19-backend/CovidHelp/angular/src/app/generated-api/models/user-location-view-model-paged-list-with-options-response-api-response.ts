/* tslint:disable */
import { ExceptionUiConfig } from './exception-ui-config';
import { ValidationError } from './validation-error';
import { UserLocationViewModelPagedListWithOptionsResponse } from './user-location-view-model-paged-list-with-options-response';
export interface UserLocationViewModelPagedListWithOptionsResponseApiResponse {
  success?: boolean;
  message?: string;
  detail?: string;
  uiConfig?: ExceptionUiConfig;
  errors?: Array<ValidationError>;
  content?: UserLocationViewModelPagedListWithOptionsResponse;
}
