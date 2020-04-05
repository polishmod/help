/* tslint:disable */
import { GeoPointViewModel } from './geo-point-view-model';
export interface CityViewModel {
  countryId?: number;
  name?: string;
  location?: GeoPointViewModel;
  optionText?: string;
  id?: number;
  guid?: string;
  optionId?: string;
  isDeleted?: boolean;
  optionAdditionalInfo?: {[key: string]: string};
}
