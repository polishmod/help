/* tslint:disable */
import { ConfigEntityType } from './config-entity-type';
export interface ConfigViewModel {
  optionText?: string;
  name: string;
  type: ConfigEntityType;
  value: string;
  additionalInfo?: string;
  hiddenConfig?: boolean;
  appKey: string;
  id?: number;
  guid?: string;
  optionId?: string;
  isDeleted?: boolean;
  optionAdditionalInfo?: {[key: string]: string};
}
