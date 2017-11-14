import { AccountsService } from './../accounts.service';
import { LoggingService } from '../logging.service';
import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css'],
  providers: [LoggingService, AccountsService]
})
export class AccountComponent {
  @Input() account: { name: string, status: string };
  @Input() id: number;

  constructor(private logginService: LoggingService,
      private accountsService: AccountsService) { }

  onSetTo(status: string) {
    this.accountsService.updateStatus(this.id, status);
    this.logginService.logStatusChange(status);
  }
}
