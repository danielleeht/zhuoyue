export const APP_MENU: AppMenuItem[] = [

  {
    name: 'Home',
    description: 'Home page',
    icon: 'public',
    link: ['']
  },
  {
    name: 'Playground',
    description: 'Playground page',
    icon: 'casino',
    link: ['playground']
  },
  {
    name: 'Crud',
    description: 'Simple crud',
    icon: 'edit',
    link: ['crud'],
    roles: ['ROLE_ADMIN']
  },
  {
    name: '图书管理',
    description: '爬虫图书及网站图书管理',
    icon: 'book',
    link: ['book'],
    roles: ['ROLE_ADMIN']
  },
  {
    name: 'About',
    description: 'About page',
    icon: 'person',
    link: ['about']
  }
];

export interface AppMenuItem {
  name: string;
  description: string;
  icon: string;
  link: string[];
  roles?: string[];
}
