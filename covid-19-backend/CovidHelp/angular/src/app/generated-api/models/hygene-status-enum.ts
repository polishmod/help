/* tslint:disable */
type HygeneStatusEnum =
  'no' |
  'aLittle' |
  'atLeastOne' |
  'moreThanOne' |
  'severeSymptoms';
module HygeneStatusEnum {
  export const NO: HygeneStatusEnum = 'no';
  export const A_LITTLE: HygeneStatusEnum = 'aLittle';
  export const AT_LEAST_ONE: HygeneStatusEnum = 'atLeastOne';
  export const MORE_THAN_ONE: HygeneStatusEnum = 'moreThanOne';
  export const SEVERE_SYMPTOMS: HygeneStatusEnum = 'severeSymptoms';
  export function values(): HygeneStatusEnum[] {
    return [
      NO,
      A_LITTLE,
      AT_LEAST_ONE,
      MORE_THAN_ONE,
      SEVERE_SYMPTOMS
    ];
  }
}

export { HygeneStatusEnum }