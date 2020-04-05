/* tslint:disable */
type InputType =
  'default' |
  'number' |
  'text' |
  'email' |
  'url' |
  'tel' |
  'password' |
  'select' |
  'radio' |
  'selectMultiple' |
  'textArea' |
  'boolean' |
  'date' |
  'time' |
  'dateTime' |
  'integer' |
  'rating' |
  'heart' |
  'color' |
  'image' |
  'file' |
  'dualBox' |
  'geolocation' |
  'html';
module InputType {
  export const DEFAULT: InputType = 'default';
  export const NUMBER: InputType = 'number';
  export const TEXT: InputType = 'text';
  export const EMAIL: InputType = 'email';
  export const URL: InputType = 'url';
  export const TEL: InputType = 'tel';
  export const PASSWORD: InputType = 'password';
  export const SELECT: InputType = 'select';
  export const RADIO: InputType = 'radio';
  export const SELECT_MULTIPLE: InputType = 'selectMultiple';
  export const TEXT_AREA: InputType = 'textArea';
  export const BOOLEAN: InputType = 'boolean';
  export const DATE: InputType = 'date';
  export const TIME: InputType = 'time';
  export const DATE_TIME: InputType = 'dateTime';
  export const INTEGER: InputType = 'integer';
  export const RATING: InputType = 'rating';
  export const HEART: InputType = 'heart';
  export const COLOR: InputType = 'color';
  export const IMAGE: InputType = 'image';
  export const FILE: InputType = 'file';
  export const DUAL_BOX: InputType = 'dualBox';
  export const GEOLOCATION: InputType = 'geolocation';
  export const HTML: InputType = 'html';
  export function values(): InputType[] {
    return [
      DEFAULT,
      NUMBER,
      TEXT,
      EMAIL,
      URL,
      TEL,
      PASSWORD,
      SELECT,
      RADIO,
      SELECT_MULTIPLE,
      TEXT_AREA,
      BOOLEAN,
      DATE,
      TIME,
      DATE_TIME,
      INTEGER,
      RATING,
      HEART,
      COLOR,
      IMAGE,
      FILE,
      DUAL_BOX,
      GEOLOCATION,
      HTML
    ];
  }
}

export { InputType }