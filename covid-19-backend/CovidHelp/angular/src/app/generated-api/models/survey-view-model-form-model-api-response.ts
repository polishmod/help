/* tslint:disable */
import { ExceptionUiConfig } from './exception-ui-config';
import { ValidationError } from './validation-error';
import { SurveyViewModelFormModel } from './survey-view-model-form-model';
export interface SurveyViewModelFormModelApiResponse {
  success?: boolean;
  message?: string;
  detail?: string;
  uiConfig?: ExceptionUiConfig;
  errors?: Array<ValidationError>;
  content?: SurveyViewModelFormModel;
}
