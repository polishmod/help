/* tslint:disable */
type FormGroupLayoutComponent =
  'card' |
  'simple' |
  'accordion' |
  'fieldset' |
  'none' |
  'tabs';
module FormGroupLayoutComponent {
  export const CARD: FormGroupLayoutComponent = 'card';
  export const SIMPLE: FormGroupLayoutComponent = 'simple';
  export const ACCORDION: FormGroupLayoutComponent = 'accordion';
  export const FIELDSET: FormGroupLayoutComponent = 'fieldset';
  export const NONE: FormGroupLayoutComponent = 'none';
  export const TABS: FormGroupLayoutComponent = 'tabs';
  export function values(): FormGroupLayoutComponent[] {
    return [
      CARD,
      SIMPLE,
      ACCORDION,
      FIELDSET,
      NONE,
      TABS
    ];
  }
}

export { FormGroupLayoutComponent }