import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Serie {
  _id: string;
  title: string;
  channel: string;
  rating: number;
}

export interface CreateSerieResponse {
  _id: string;
  title: string;
  channel: string;
  rating: number;
}

@Injectable({
  providedIn: 'root'
})
export class SeriesService {
  private baseUrl = 'https://peticiones.online/api/series';

  constructor(private http: HttpClient) {}

  getAll(): Observable<Serie[]> {
    return this.http.get<Serie[]>(this.baseUrl);
  }

  create(payload: { title: string; channel: string; rating: number }): Observable<CreateSerieResponse> {
    return this.http.post<CreateSerieResponse>(this.baseUrl, payload);
  }
}
