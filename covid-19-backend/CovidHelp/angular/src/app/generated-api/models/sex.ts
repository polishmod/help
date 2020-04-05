/* tslint:disable */
type Sex =
  'male' |
  'female';
module Sex {
  export const MALE: Sex = 'male';
  export const FEMALE: Sex = 'female';
  export function values(): Sex[] {
    return [
      MALE,
      FEMALE
    ];
  }
}

export { Sex }