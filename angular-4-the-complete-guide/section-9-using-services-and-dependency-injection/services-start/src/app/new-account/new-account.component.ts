import { AccountsService } from './../accounts.service';
import { LoggingService } from './../logging.service';
import { Component } from '@angular/core';

@Component({
  selector: 'app-new-account',
  templateUrl: './new-account.component.html',
  styleUrls: ['./new-account.component.css'],
  providers: [LoggingService]
})
export class NewAccountComponent {

  constructor(private logginService: LoggingService,
              private accountsService: AccountsService) { }

  onCreateAccount(accountName: string, accountStatus: string) {
    this.accountsService.addAccount(accountName, accountStatus);
    this.logginService.logStatusChange(accountStatus);
  }
}
