/* tslint:disable */
import { EditFieldDefinitionViewModel } from './edit-field-definition-view-model';
import { FormLayout } from './form-layout';
export interface FormGroupViewModel {
  formGroupField?: EditFieldDefinitionViewModel;
  editFields?: Array<EditFieldDefinitionViewModel>;
  formGroups?: Array<FormGroupViewModel>;
  name?: string;
  formLayout?: FormLayout;
  visibilityExpression?: string;
  order?: number;
}
