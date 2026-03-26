import { Routes } from '@angular/router';
import { Login } from './auth/login/login';
import { Register } from './auth/register/register';
import { Layout } from './layout/layout';
import { Dashboard } from './pages/dashboard/dashboard';
import { Vocabulary } from './pages/vocabulary/vocabulary';
import { Report } from './pages/report/report';
import { Account } from './pages/account/account';
import { Collection } from './pages/collection/collection';
import { MyWords } from './pages/my-words/my-words';

export const routes: Routes = [
  { path: '', component: Login },
  { path: 'register', component: Register },
  {
    path: '',
    component: Layout,
    children: [
      { path: 'dashboard', component: Dashboard },
      { path: 'vocabulary', component: Vocabulary },
      { path: 'report', component: Report },
      { path: 'account', component: Account },
      {path:'collection/n5',component:Collection},
      {path:'mywords',component:MyWords}
    ]
  }
];