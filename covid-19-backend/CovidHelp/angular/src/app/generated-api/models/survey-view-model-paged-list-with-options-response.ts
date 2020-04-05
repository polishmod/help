/* tslint:disable */
import { SurveyViewModelPagedList } from './survey-view-model-paged-list';
import { OptionsFieldDefinitionViewModel } from './options-field-definition-view-model';
export interface SurveyViewModelPagedListWithOptionsResponse {
  result?: SurveyViewModelPagedList;
  options?: Array<OptionsFieldDefinitionViewModel>;
}
