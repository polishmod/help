import { NbMenuItem } from '@nebular/theme';

export const MENU_ITEMS: NbMenuItem[] = [

  {
    title: 'Settings',
    icon: 'settings-outline',
    children: [
      {
        title: 'My Account',
        link: '/pages/settings/account',
      },
      {
        title: 'All users',
        link: '/pages/settings/users',
      },
      {
        title: 'Countries',
        link: '/pages/settings/countries',
      },
    ],
  },
];
