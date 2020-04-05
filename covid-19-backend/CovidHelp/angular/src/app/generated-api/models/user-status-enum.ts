/* tslint:disable */
type UserStatusEnum =
  'none' |
  'active' |
  'inactive';
module UserStatusEnum {
  export const NONE: UserStatusEnum = 'none';
  export const ACTIVE: UserStatusEnum = 'active';
  export const INACTIVE: UserStatusEnum = 'inactive';
  export function values(): UserStatusEnum[] {
    return [
      NONE,
      ACTIVE,
      INACTIVE
    ];
  }
}

export { UserStatusEnum }