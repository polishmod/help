/* tslint:disable */
type UserHealthStatus =
  'healthy' |
  'recovered' |
  'quarantine' |
  'death';
module UserHealthStatus {
  export const HEALTHY: UserHealthStatus = 'healthy';
  export const RECOVERED: UserHealthStatus = 'recovered';
  export const QUARANTINE: UserHealthStatus = 'quarantine';
  export const DEATH: UserHealthStatus = 'death';
  export function values(): UserHealthStatus[] {
    return [
      HEALTHY,
      RECOVERED,
      QUARANTINE,
      DEATH
    ];
  }
}

export { UserHealthStatus }