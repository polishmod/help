/* tslint:disable */
import { ExceptionUiConfig } from './exception-ui-config';
import { ValidationError } from './validation-error';
import { InfectedStatisticsViewModelPagedListWithOptionsResponse } from './infected-statistics-view-model-paged-list-with-options-response';
export interface InfectedStatisticsViewModelPagedListWithOptionsResponseApiResponse {
  success?: boolean;
  message?: string;
  detail?: string;
  uiConfig?: ExceptionUiConfig;
  errors?: Array<ValidationError>;
  content?: InfectedStatisticsViewModelPagedListWithOptionsResponse;
}
