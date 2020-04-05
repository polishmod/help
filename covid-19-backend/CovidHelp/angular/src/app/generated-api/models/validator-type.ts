/* tslint:disable */
type ValidatorType =
  'required' |
  'email' |
  'totalNumber' |
  'path';
module ValidatorType {
  export const REQUIRED: ValidatorType = 'required';
  export const EMAIL: ValidatorType = 'email';
  export const TOTAL_NUMBER: ValidatorType = 'totalNumber';
  export const PATH: ValidatorType = 'path';
  export function values(): ValidatorType[] {
    return [
      REQUIRED,
      EMAIL,
      TOTAL_NUMBER,
      PATH
    ];
  }
}

export { ValidatorType }