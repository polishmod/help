/* tslint:disable */
type ExceptionUiType =
  'notification' |
  'dialog';
module ExceptionUiType {
  export const NOTIFICATION: ExceptionUiType = 'notification';
  export const DIALOG: ExceptionUiType = 'dialog';
  export function values(): ExceptionUiType[] {
    return [
      NOTIFICATION,
      DIALOG
    ];
  }
}

export { ExceptionUiType }