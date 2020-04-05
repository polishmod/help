/* tslint:disable */
import { ExceptionUiConfig } from './exception-ui-config';
import { ValidationError } from './validation-error';
import { InfectedStatisticsViewModelFormModel } from './infected-statistics-view-model-form-model';
export interface InfectedStatisticsViewModelFormModelApiResponse {
  success?: boolean;
  message?: string;
  detail?: string;
  uiConfig?: ExceptionUiConfig;
  errors?: Array<ValidationError>;
  content?: InfectedStatisticsViewModelFormModel;
}
