/* tslint:disable */
import { ExceptionUiConfig } from './exception-ui-config';
import { ValidationError } from './validation-error';
import { InfectedStatisticsViewModelListWithOptionsResponse } from './infected-statistics-view-model-list-with-options-response';
export interface InfectedStatisticsViewModelListWithOptionsResponseApiResponse {
  success?: boolean;
  message?: string;
  detail?: string;
  uiConfig?: ExceptionUiConfig;
  errors?: Array<ValidationError>;
  content?: InfectedStatisticsViewModelListWithOptionsResponse;
}
