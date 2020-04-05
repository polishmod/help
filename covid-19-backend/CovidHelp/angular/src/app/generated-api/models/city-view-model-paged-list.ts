/* tslint:disable */
import { CityViewModel } from './city-view-model';
export interface CityViewModelPagedList {
  count?: number;
  list?: Array<CityViewModel>;
  index?: number;
  size?: number;
}
