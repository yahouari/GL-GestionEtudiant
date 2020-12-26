import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ThemesService {
  host="http://localhost:8083"
  constructor(private http:HttpClient) { }
  getThemes()
  {
    return this.http.get(this.host+"/themes")
  }
}
