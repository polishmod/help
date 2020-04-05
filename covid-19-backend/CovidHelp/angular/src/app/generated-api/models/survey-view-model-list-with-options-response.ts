/* tslint:disable */
import { SurveyViewModel } from './survey-view-model';
import { OptionsFieldDefinitionViewModel } from './options-field-definition-view-model';
export interface SurveyViewModelListWithOptionsResponse {
  result?: Array<SurveyViewModel>;
  options?: Array<OptionsFieldDefinitionViewModel>;
}
