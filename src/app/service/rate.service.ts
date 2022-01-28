import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RateService {

  constructor(private http:HttpClient) { }

  
  public  getAllRates() : Observable<any>{
    const url=`http://localhost:8080/exchangerate/viewall`;
    return this.http.get<any>(url);
  }

  public  addRate(rate:any) : Observable<any>{
    const url=`http://localhost:8080/exchangerate/create`;
    return this.http.post<any>(url,rate);
  }

  public  deleteRate(id:any) : Observable<any>{
    const url=`http://localhost:8080/exchangerate/delete/${id}`;
    return this.http.delete<any>(url);
  }

  public  updateRate(id:any,rate:any) : Observable<any>{
    const url=`http://localhost:8080/exchangerate/update?id=${id}`;
    return this.http.put<any>(url,rate);
  }

  
}