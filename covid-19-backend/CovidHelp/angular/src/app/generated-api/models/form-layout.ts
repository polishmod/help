/* tslint:disable */
type FormLayout =
  'one' |
  'two' |
  'three' |
  'four' |
  'six' |
  'default';
module FormLayout {
  export const ONE: FormLayout = 'one';
  export const TWO: FormLayout = 'two';
  export const THREE: FormLayout = 'three';
  export const FOUR: FormLayout = 'four';
  export const SIX: FormLayout = 'six';
  export const DEFAULT: FormLayout = 'default';
  export function values(): FormLayout[] {
    return [
      ONE,
      TWO,
      THREE,
      FOUR,
      SIX,
      DEFAULT
    ];
  }
}

export { FormLayout }