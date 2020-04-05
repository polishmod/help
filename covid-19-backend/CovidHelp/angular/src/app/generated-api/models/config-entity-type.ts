/* tslint:disable */
type ConfigEntityType =
  'string' |
  'integer' |
  'double' |
  'text' |
  'lonG_TEXT' |
  'html' |
  'documents';
module ConfigEntityType {
  export const STRING: ConfigEntityType = 'string';
  export const INTEGER: ConfigEntityType = 'integer';
  export const DOUBLE: ConfigEntityType = 'double';
  export const TEXT: ConfigEntityType = 'text';
  export const LON_G_TEXT: ConfigEntityType = 'lonG_TEXT';
  export const HTML: ConfigEntityType = 'html';
  export const DOCUMENTS: ConfigEntityType = 'documents';
  export function values(): ConfigEntityType[] {
    return [
      STRING,
      INTEGER,
      DOUBLE,
      TEXT,
      LON_G_TEXT,
      HTML,
      DOCUMENTS
    ];
  }
}

export { ConfigEntityType }