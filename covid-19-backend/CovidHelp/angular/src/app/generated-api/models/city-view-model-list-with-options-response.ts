/* tslint:disable */
import { CityViewModel } from './city-view-model';
import { OptionsFieldDefinitionViewModel } from './options-field-definition-view-model';
export interface CityViewModelListWithOptionsResponse {
  result?: Array<CityViewModel>;
  options?: Array<OptionsFieldDefinitionViewModel>;
}
