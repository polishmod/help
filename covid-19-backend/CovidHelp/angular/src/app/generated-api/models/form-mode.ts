/* tslint:disable */
type FormMode =
  'add' |
  'edit' |
  'view';
module FormMode {
  export const ADD: FormMode = 'add';
  export const EDIT: FormMode = 'edit';
  export const VIEW: FormMode = 'view';
  export function values(): FormMode[] {
    return [
      ADD,
      EDIT,
      VIEW
    ];
  }
}

export { FormMode }