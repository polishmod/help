/* tslint:disable */
type HealthStatusEnum =
  'no' |
  'sometimes' |
  'mostly' |
  'almostEver' |
  'ever';
module HealthStatusEnum {
  export const NO: HealthStatusEnum = 'no';
  export const SOMETIMES: HealthStatusEnum = 'sometimes';
  export const MOSTLY: HealthStatusEnum = 'mostly';
  export const ALMOST_EVER: HealthStatusEnum = 'almostEver';
  export const EVER: HealthStatusEnum = 'ever';
  export function values(): HealthStatusEnum[] {
    return [
      NO,
      SOMETIMES,
      MOSTLY,
      ALMOST_EVER,
      EVER
    ];
  }
}

export { HealthStatusEnum }