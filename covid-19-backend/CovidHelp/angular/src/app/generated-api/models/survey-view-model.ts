/* tslint:disable */
import { HealthStatusEnum } from './health-status-enum';
import { PeriodStatusEnum } from './period-status-enum';
import { HygeneStatusEnum } from './hygene-status-enum';
export interface SurveyViewModel {
  hadSymptoms?: HealthStatusEnum;
  userId?: number;
  temperature?: number;
  returnedFromAbroad?: PeriodStatusEnum;
  hadCloseContactToDiagnosed?: PeriodStatusEnum;
  hadCloseContactDuringTravel?: PeriodStatusEnum;
  obeyToHygieneRules?: HygeneStatusEnum;
  date?: string;
  optionText?: string;
  id?: number;
  guid?: string;
  optionId?: string;
  isDeleted?: boolean;
  optionAdditionalInfo?: {[key: string]: string};
}
