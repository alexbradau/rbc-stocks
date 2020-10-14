import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'dow-jones-index',
        loadChildren: () => import('./dow-jones-index/dow-jones-index.module').then(m => m.RbcstocksDowJonesIndexModule),
      },
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ]),
  ],
})
export class RbcstocksEntityModule {}
