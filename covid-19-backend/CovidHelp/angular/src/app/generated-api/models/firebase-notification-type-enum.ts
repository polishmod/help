/* tslint:disable */
type FirebaseNotificationTypeEnum =
  'info' |
  'met_Infected' |
  'fill_Questionnarie' |
  'measure_Temperature';
module FirebaseNotificationTypeEnum {
  export const INFO: FirebaseNotificationTypeEnum = 'info';
  export const MET_INFECTED: FirebaseNotificationTypeEnum = 'met_Infected';
  export const FILL_QUESTIONNARIE: FirebaseNotificationTypeEnum = 'fill_Questionnarie';
  export const MEASURE_TEMPERATURE: FirebaseNotificationTypeEnum = 'measure_Temperature';
  export function values(): FirebaseNotificationTypeEnum[] {
    return [
      INFO,
      MET_INFECTED,
      FILL_QUESTIONNARIE,
      MEASURE_TEMPERATURE
    ];
  }
}

export { FirebaseNotificationTypeEnum }