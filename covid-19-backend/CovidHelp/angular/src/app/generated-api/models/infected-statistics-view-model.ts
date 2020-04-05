/* tslint:disable */
import { GeoPointViewModel } from './geo-point-view-model';
export interface InfectedStatisticsViewModel {
  recovered?: number;
  countryId?: number;
  countryLocation?: GeoPointViewModel;
  date?: string;
  confirmed?: number;
  deaths?: number;
  countryName?: string;
  optionText?: string;
  id?: number;
  guid?: string;
  optionId?: string;
  isDeleted?: boolean;
  optionAdditionalInfo?: {[key: string]: string};
}
