import {Component} from '@angular/core';
import {CommonModule, NgStyle} from '@angular/common';
import {RouterOutlet} from '@angular/router';
import {ToasterComponent} from "./components/toaster/toaster.component";
import {ToastComponent} from "./components/toast/toast.component";
import {EventTypes} from "./models/event-types";
import {ToastService} from "./services/toast.service";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet, ToastComponent, ToasterComponent, NgStyle],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'angular-bootstrap-toast-service';

  EventTypes = EventTypes;

  constructor(private toastService: ToastService) {
  }

  showToast(type: EventTypes) {
    switch (type) {
      case EventTypes.Success:
        this.toastService.showSuccessToast('Success toast title', 'This is a success toast message.');
        break;
      case EventTypes.Warning:
        this.toastService.showWarningToast('Warning toast title', 'This is a warning toast message.');
        break;
      case EventTypes.Error:
        this.toastService.showErrorToast('Error toast title', 'This is an error toast message.');
        break;
      default:
        this.toastService.showInfoToast('Info toast title', 'This is an info toast message.');
        break;
    }
  }
}
