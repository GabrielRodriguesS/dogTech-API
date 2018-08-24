import { FormGroup } from '@angular/forms';

export class FormGroupBuilder<Entity> {
  private _form: FormGroup;


  constructor(form: FormGroup) {
    this._form = form;
  }

  get form(): FormGroup {
    return this._form;
  }

  set form(value: FormGroup) {
    this._form = value;
  }

  public getValue(): Entity {
    return Object.assign({}, this._form.value);
  }

  public isValid() {
    return this._form.valid;
  }

  public resetForm() {
    this._form.reset();
  }
}
