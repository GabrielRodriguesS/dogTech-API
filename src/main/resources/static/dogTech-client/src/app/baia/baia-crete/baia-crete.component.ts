import { Component, OnInit } from '@angular/core';
import { NzNotificationService } from 'ng-zorro-antd';
import { Notification } from 'src/app/core/notification/notification';
import { Baia } from 'src/app/commons/models/baia';
import { BaiaResource } from 'src/app/baia/resource/baia-resource';
import { FormBuilder, Validators } from '@angular/forms';
import { FormGroupBuilder } from '../../core/forms/form-group-builder';

@Component({
  selector: 'app-baia-crete',
  templateUrl: './baia-crete.component.html',
  styleUrls: ['./baia-crete.component.css']
})
export class BaiaCreteComponent implements OnInit {

  baia: Baia;
  form: FormGroupBuilder<Baia>;

  constructor(private resource: BaiaResource, private formBuilder: FormBuilder,
    private notification: NzNotificationService) {
  }

  ngOnInit() {
    this.form = new FormGroupBuilder<Baia>(
      this.formBuilder.group({
        name: [null, [Validators.required]],
        number: [null, []]
      }));
  }

  save(): void {
    if (this.form.isValid()) {
      this.baia = this.form.getValue();
      this.resource.post(this.baia).subscribe();
      Notification.createSuccessNotification('Foi!', 'Salvo com sucesso', this.notification);
    }
  }

}
