import { NzNotificationService } from 'ng-zorro-antd';

export class Notification {

    public static createSuccessNotification(title: string, content: string,
        notification: NzNotificationService) {
        notification.success(title, content);
    }

    public static createErrorNotification(title: string, content: string,
        notification: NzNotificationService) {
        notification.error(title, content);
    }

    public static createInfoNotification(title: string, content: string,
        notification: NzNotificationService) {
        notification.info(title, content);
    }
}
