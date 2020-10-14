import { Moment } from 'moment';

export interface IDowJonesIndex {
  id?: number;
  quarter?: number;
  stock?: string;
  date?: Moment;
  open?: number;
  high?: number;
  low?: number;
  close?: number;
  volume?: number;
  percentChangePrice?: number;
  percentChangeVolumeOverLastWeek?: number;
  previousWeeksVolume?: number;
  nextWeeksOpen?: number;
  nextWeeksClose?: number;
  percentChangeNextWeeksPrice?: number;
  daysToNextDividend?: number;
  percentReturnNextDividend?: number;
}

export class DowJonesIndex implements IDowJonesIndex {
  constructor(
    public id?: number,
    public quarter?: number,
    public stock?: string,
    public date?: Moment,
    public open?: number,
    public high?: number,
    public low?: number,
    public close?: number,
    public volume?: number,
    public percentChangePrice?: number,
    public percentChangeVolumeOverLastWeek?: number,
    public previousWeeksVolume?: number,
    public nextWeeksOpen?: number,
    public nextWeeksClose?: number,
    public percentChangeNextWeeksPrice?: number,
    public daysToNextDividend?: number,
    public percentReturnNextDividend?: number
  ) {}
}
