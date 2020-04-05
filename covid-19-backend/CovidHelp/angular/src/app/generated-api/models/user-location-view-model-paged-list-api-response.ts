/* tslint:disable */
import { ExceptionUiConfig } from './exception-ui-config';
import { ValidationError } from './validation-error';
import { UserLocationViewModelPagedList } from './user-location-view-model-paged-list';
export interface UserLocationViewModelPagedListApiResponse {
  success?: boolean;
  message?: string;
  detail?: string;
  uiConfig?: ExceptionUiConfig;
  errors?: Array<ValidationError>;
  content?: UserLocationViewModelPagedList;
}
