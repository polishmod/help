/* tslint:disable */
import { FirebaseNotificationTypeEnum } from './firebase-notification-type-enum';
export interface FirebaseNotificationViewModel {
  optionText?: string;
  title?: string;
  type?: FirebaseNotificationTypeEnum;
  fromUserId?: number;
  toUserId?: number;
  dateSend?: string;
  message?: string;
  id?: number;
  guid?: string;
  optionId?: string;
  isDeleted?: boolean;
  optionAdditionalInfo?: {[key: string]: string};
}
