import { Component, OnInit, Input } from '@angular/core';
import { NzNotificationService } from 'ng-zorro-antd';
import { Notification } from 'src/app/core/notification/notification';
import { Baia } from 'src/app/commons/models/baia';
import { BaiaResource } from 'src/app/baia/resource/baia-resource';

@Component({
  selector: 'app-baia-crete',
  templateUrl: './baia-crete.component.html',
  styleUrls: ['./baia-crete.component.css']
})
export class BaiaCreteComponent implements OnInit {

  baia: Baia;
  constructor(private resource: BaiaResource, private notification: NzNotificationService) { }

  ngOnInit() {
    this.baia = new Baia();
  }

  save() {
    this.resource.post(this.baia).subscribe();
    Notification.createSuccessNotification('Foi!', 'Salvo com sucesso', this.notification);
  }

}
