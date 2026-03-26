import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class WordService {

  private baseUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) {}

  getN5Words(limit:number):Observable<any>{
    return this.http.get(`${this.baseUrl}/collections/n5/words?limit=${limit}`);
  }

  startReview(wordIds:number[]):Observable<any>{
    return this.http.post(`${this.baseUrl}/review/start`,wordIds);
  }

  getReviewWords():Observable<any>{
    return this.http.get(`${this.baseUrl}/review/next`);
  }

}