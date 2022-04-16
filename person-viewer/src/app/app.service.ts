import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Person } from './Person';

@Injectable()
export class AppService {

  private persons: Person[] = new Array();

  constructor(private httpClient: HttpClient) { }

  public getPersons(): Observable<any> {
    return new Observable((observer) => {
      const eventSource = new EventSource("http://localhost:8080/persons");
      eventSource.onmessage = (event) => {
        console.log(event);
        const person: Person = JSON.parse(event.data);
        this.persons.push(person);
        observer.next(this.persons);
      };
      eventSource.onerror = (error) => observer.error('eventSource.onerror: ' + error);
      return () => eventSource.close();
    });
  }

}
