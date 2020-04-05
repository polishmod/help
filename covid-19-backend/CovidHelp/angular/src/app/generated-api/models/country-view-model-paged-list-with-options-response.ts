/* tslint:disable */
import { CountryViewModelPagedList } from './country-view-model-paged-list';
import { OptionsFieldDefinitionViewModel } from './options-field-definition-view-model';
export interface CountryViewModelPagedListWithOptionsResponse {
  result?: CountryViewModelPagedList;
  options?: Array<OptionsFieldDefinitionViewModel>;
}
