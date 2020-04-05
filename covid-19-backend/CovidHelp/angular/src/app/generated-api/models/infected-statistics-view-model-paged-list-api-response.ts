/* tslint:disable */
import { ExceptionUiConfig } from './exception-ui-config';
import { ValidationError } from './validation-error';
import { InfectedStatisticsViewModelPagedList } from './infected-statistics-view-model-paged-list';
export interface InfectedStatisticsViewModelPagedListApiResponse {
  success?: boolean;
  message?: string;
  detail?: string;
  uiConfig?: ExceptionUiConfig;
  errors?: Array<ValidationError>;
  content?: InfectedStatisticsViewModelPagedList;
}
