/* tslint:disable */
import { InputType } from './input-type';
export interface FieldDefinitionViewModel {
  editable?: boolean;
  placeholder?: string;
  helpText?: string;
  parameterName?: string;
  display?: boolean;
  filterable?: boolean;
  tableTitle?: string;
  exportable?: boolean;
  order?: number;
  inputType?: InputType;
  queryType?: string;
  groupName?: string;
}
