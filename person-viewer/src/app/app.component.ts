import { Component, OnInit } from '@angular/core';
import { AppService } from './app.service';
import { Person } from './Person';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'person-viewer';

  constructor(private appService: AppService) {}

  public ngOnInit(): void {
      this.appService.getPersons().subscribe((data: Person[]) => {
        console.log(data);
      });
  }

}
