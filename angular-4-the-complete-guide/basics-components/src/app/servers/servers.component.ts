import { Component, OnInit } from '@angular/core';

@Component({
  // selector: '[app-servers]',
  // selector: '.app-servers',
  selector: 'app-servers',
  templateUrl: './servers.component.html'
  styleUrls: ['./servers.component.css']
})
export class ServersComponent implements OnInit {

  allowNewServer: boolean = false;
  serverName: string = 'Testserver';
  serverCreationStatus: string = 'No server was created!';
  
  constructor() {
    setTimeout(() => {
      this.allowNewServer = true;
    }, 2000);
   }

   onCreateServer() {
     this.serverCreationStatus = 'Server was created! Name is ' + this.serverName;
   }
   onUpdateServerName(event: Event) {
     this.serverName = (<HTMLInputElement>event.target).value;

   }

  ngOnInit() {
  }

}
