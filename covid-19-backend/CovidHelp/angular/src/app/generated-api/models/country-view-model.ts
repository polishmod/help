/* tslint:disable */
import { GeoPointViewModel } from './geo-point-view-model';
export interface CountryViewModel {
  code?: string;
  name?: string;
  location?: GeoPointViewModel;
  optionText?: string;
  id?: number;
  guid?: string;
  optionId?: string;
  isDeleted?: boolean;
  optionAdditionalInfo?: {[key: string]: string};
}
