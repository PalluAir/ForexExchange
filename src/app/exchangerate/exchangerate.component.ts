import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { RateService } from '../service/rate.service';

@Component({
  selector: 'app-exchangerate',
  templateUrl: './exchangerate.component.html',
  styleUrls: ['./exchangerate.component.css']
})
export class ExchangerateComponent implements OnInit {

  rates: any = [];

  public from: any;
  public to: any;
  public conversionMultiple: any;
  public isAdd: boolean = false;

  isEdit: boolean = false;

  editRowId: any;

  toggle(id: any) {
    this.editRowId = id;
  }

  toggleAdd() {
    this.isAdd = !this.isAdd;
  }

  constructor(public rateService: RateService) { }

  ngOnInit(): void {
    this.getAllRates();
  }

  getAllRates() {
    this.rateService.getAllRates().subscribe(rates => {
      rates.sort((a:any,b:any)=>a.id-b.id)
      this.rates = rates;
    })
  }

  public addRate() {
    const rate = { from: this.from, to: this.to, conversionMultiple: this.conversionMultiple };
    this.rateService.addRate(rate).subscribe(response =>{
      this.isAdd = false;
      this.getAllRates();
    }) 

  }

  public cancelAdd() {
    this.isAdd = false;
  }

  public editRate(rate: any) {
    this.rateService.updateRate(rate.id, rate).subscribe(response => {
      this.editRowId = null;
      this.getAllRates();

    });
  }

  public deleteRate(rate: any) {
    this.rateService.deleteRate(rate.id).subscribe(response => {
      this.getAllRates();

    });
  }






}