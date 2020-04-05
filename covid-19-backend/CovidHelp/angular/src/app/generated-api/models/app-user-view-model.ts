/* tslint:disable */
import { UserStatusEnum } from './user-status-enum';
import { Sex } from './sex';
import { UserHealthStatus } from './user-health-status';
export interface AppUserViewModel {
  status?: UserStatusEnum;
  sex?: Sex;
  dateOfBirth?: string;
  countryName?: string;
  countryId?: number;
  cityName?: string;
  userHealthStatus?: UserHealthStatus;
  doctorId?: number;
  userImage?: string;
  isAnonymous?: boolean;
  password?: string;
  roles?: Array<string>;
  fcmTokens?: Array<string>;
  firstName?: string;
  lastName?: string;
  email?: string;
  phone?: string;
  optionText?: string;
  id?: number;
  guid?: string;
  optionId?: string;
  isDeleted?: boolean;
  optionAdditionalInfo?: {[key: string]: string};
}
