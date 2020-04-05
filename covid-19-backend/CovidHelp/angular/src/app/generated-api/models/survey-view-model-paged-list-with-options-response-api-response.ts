/* tslint:disable */
import { ExceptionUiConfig } from './exception-ui-config';
import { ValidationError } from './validation-error';
import { SurveyViewModelPagedListWithOptionsResponse } from './survey-view-model-paged-list-with-options-response';
export interface SurveyViewModelPagedListWithOptionsResponseApiResponse {
  success?: boolean;
  message?: string;
  detail?: string;
  uiConfig?: ExceptionUiConfig;
  errors?: Array<ValidationError>;
  content?: SurveyViewModelPagedListWithOptionsResponse;
}
