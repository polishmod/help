/* tslint:disable */
import { GeoPointViewModel } from './geo-point-view-model';
export interface UserLocationViewModel {
  userId?: number;
  location?: GeoPointViewModel;
  date?: string;
  groupTimestamp?: number;
  cityId?: number;
  countryId?: number;
  precision?: number;
  optionText?: string;
  id?: number;
  guid?: string;
  optionId?: string;
  isDeleted?: boolean;
  optionAdditionalInfo?: {[key: string]: string};
}
