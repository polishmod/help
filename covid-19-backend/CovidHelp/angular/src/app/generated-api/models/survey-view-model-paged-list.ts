/* tslint:disable */
import { SurveyViewModel } from './survey-view-model';
export interface SurveyViewModelPagedList {
  count?: number;
  list?: Array<SurveyViewModel>;
  index?: number;
  size?: number;
}
