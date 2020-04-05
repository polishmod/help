/* tslint:disable */
import { FormLayout } from './form-layout';
import { FilteredOptionsConfig } from './filtered-options-config';
import { AddInlineConfig } from './add-inline-config';
import { ISelectFieldOptionViewModel } from './iselect-field-option-view-model';
import { FormValidator } from './form-validator';
import { ComputedConfig } from './computed-config';
import { InputType } from './input-type';
export interface EditFieldDefinitionViewModel {
  tableTitle?: string;
  visibilityExpression?: string;
  formLayout?: FormLayout;
  modelType?: string;
  optionsFilteredOn?: FilteredOptionsConfig;
  addInlineConfig?: AddInlineConfig;
  options?: Array<ISelectFieldOptionViewModel>;
  displayOnCreationForm?: boolean;
  displayOnUpdateForm?: boolean;
  validators?: Array<FormValidator>;
  placeholder?: string;
  computedOn?: ComputedConfig;
  helpText?: string;
  parameterName?: string;
  display?: boolean;
  filterable?: boolean;
  editable?: boolean;
  exportable?: boolean;
  order?: number;
  inputType?: InputType;
  queryType?: string;
  groupName?: string;
}
