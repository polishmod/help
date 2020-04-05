/* tslint:disable */
import { UserLocationViewModel } from './user-location-view-model';
import { OptionsFieldDefinitionViewModel } from './options-field-definition-view-model';
export interface UserLocationViewModelListWithOptionsResponse {
  result?: Array<UserLocationViewModel>;
  options?: Array<OptionsFieldDefinitionViewModel>;
}
