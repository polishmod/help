/* tslint:disable */
type ModelTypes =
  'user' |
  'note' |
  'document' |
  'email' |
  'config' |
  'survey' |
  'userLocation' |
  'infectedStatistics' |
  'city' |
  'country' |
  'firebaseNotification';
module ModelTypes {
  export const USER: ModelTypes = 'user';
  export const NOTE: ModelTypes = 'note';
  export const DOCUMENT: ModelTypes = 'document';
  export const EMAIL: ModelTypes = 'email';
  export const CONFIG: ModelTypes = 'config';
  export const SURVEY: ModelTypes = 'survey';
  export const USER_LOCATION: ModelTypes = 'userLocation';
  export const INFECTED_STATISTICS: ModelTypes = 'infectedStatistics';
  export const CITY: ModelTypes = 'city';
  export const COUNTRY: ModelTypes = 'country';
  export const FIREBASE_NOTIFICATION: ModelTypes = 'firebaseNotification';
  export function values(): ModelTypes[] {
    return [
      USER,
      NOTE,
      DOCUMENT,
      EMAIL,
      CONFIG,
      SURVEY,
      USER_LOCATION,
      INFECTED_STATISTICS,
      CITY,
      COUNTRY,
      FIREBASE_NOTIFICATION
    ];
  }
}

export { ModelTypes }