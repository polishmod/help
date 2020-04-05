/* tslint:disable */
type PeriodStatusEnum =
  'no' |
  'oneThreeDaysAgo' |
  'fourSixDaysAgo' |
  'sevenTenDaysAgo' |
  'tenFourteenDaysAgo';
module PeriodStatusEnum {
  export const NO: PeriodStatusEnum = 'no';
  export const ONE_THREE_DAYS_AGO: PeriodStatusEnum = 'oneThreeDaysAgo';
  export const FOUR_SIX_DAYS_AGO: PeriodStatusEnum = 'fourSixDaysAgo';
  export const SEVEN_TEN_DAYS_AGO: PeriodStatusEnum = 'sevenTenDaysAgo';
  export const TEN_FOURTEEN_DAYS_AGO: PeriodStatusEnum = 'tenFourteenDaysAgo';
  export function values(): PeriodStatusEnum[] {
    return [
      NO,
      ONE_THREE_DAYS_AGO,
      FOUR_SIX_DAYS_AGO,
      SEVEN_TEN_DAYS_AGO,
      TEN_FOURTEEN_DAYS_AGO
    ];
  }
}

export { PeriodStatusEnum }