/* tslint:disable */
type QueryOperatorEnum =
  'in' |
  'not_In' |
  'equal' |
  'not_Equal' |
  'between' |
  'not_Between' |
  'less' |
  'less_Or_Equal' |
  'greater' |
  'greater_Or_Equal' |
  'begins_With' |
  'not_Begins_With' |
  'contains' |
  'like' |
  'not_Contains' |
  'ends_With' |
  'not_Ends_With' |
  'is_Empty' |
  'is_Not_Empty' |
  'is_Null' |
  'is_Not_Null';
module QueryOperatorEnum {
  export const IN: QueryOperatorEnum = 'in';
  export const NOT_IN: QueryOperatorEnum = 'not_In';
  export const EQUAL: QueryOperatorEnum = 'equal';
  export const NOT_EQUAL: QueryOperatorEnum = 'not_Equal';
  export const BETWEEN: QueryOperatorEnum = 'between';
  export const NOT_BETWEEN: QueryOperatorEnum = 'not_Between';
  export const LESS: QueryOperatorEnum = 'less';
  export const LESS_OR_EQUAL: QueryOperatorEnum = 'less_Or_Equal';
  export const GREATER: QueryOperatorEnum = 'greater';
  export const GREATER_OR_EQUAL: QueryOperatorEnum = 'greater_Or_Equal';
  export const BEGINS_WITH: QueryOperatorEnum = 'begins_With';
  export const NOT_BEGINS_WITH: QueryOperatorEnum = 'not_Begins_With';
  export const CONTAINS: QueryOperatorEnum = 'contains';
  export const LIKE: QueryOperatorEnum = 'like';
  export const NOT_CONTAINS: QueryOperatorEnum = 'not_Contains';
  export const ENDS_WITH: QueryOperatorEnum = 'ends_With';
  export const NOT_ENDS_WITH: QueryOperatorEnum = 'not_Ends_With';
  export const IS_EMPTY: QueryOperatorEnum = 'is_Empty';
  export const IS_NOT_EMPTY: QueryOperatorEnum = 'is_Not_Empty';
  export const IS_NULL: QueryOperatorEnum = 'is_Null';
  export const IS_NOT_NULL: QueryOperatorEnum = 'is_Not_Null';
  export function values(): QueryOperatorEnum[] {
    return [
      IN,
      NOT_IN,
      EQUAL,
      NOT_EQUAL,
      BETWEEN,
      NOT_BETWEEN,
      LESS,
      LESS_OR_EQUAL,
      GREATER,
      GREATER_OR_EQUAL,
      BEGINS_WITH,
      NOT_BEGINS_WITH,
      CONTAINS,
      LIKE,
      NOT_CONTAINS,
      ENDS_WITH,
      NOT_ENDS_WITH,
      IS_EMPTY,
      IS_NOT_EMPTY,
      IS_NULL,
      IS_NOT_NULL
    ];
  }
}

export { QueryOperatorEnum }