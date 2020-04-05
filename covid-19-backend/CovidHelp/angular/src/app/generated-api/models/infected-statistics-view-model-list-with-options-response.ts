/* tslint:disable */
import { InfectedStatisticsViewModel } from './infected-statistics-view-model';
import { OptionsFieldDefinitionViewModel } from './options-field-definition-view-model';
export interface InfectedStatisticsViewModelListWithOptionsResponse {
  result?: Array<InfectedStatisticsViewModel>;
  options?: Array<OptionsFieldDefinitionViewModel>;
}
