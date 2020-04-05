/* tslint:disable */
import { CountryViewModel } from './country-view-model';
import { OptionsFieldDefinitionViewModel } from './options-field-definition-view-model';
export interface CountryViewModelListWithOptionsResponse {
  result?: Array<CountryViewModel>;
  options?: Array<OptionsFieldDefinitionViewModel>;
}
