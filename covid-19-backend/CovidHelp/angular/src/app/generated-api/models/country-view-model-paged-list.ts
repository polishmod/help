/* tslint:disable */
import { CountryViewModel } from './country-view-model';
export interface CountryViewModelPagedList {
  count?: number;
  list?: Array<CountryViewModel>;
  index?: number;
  size?: number;
}
