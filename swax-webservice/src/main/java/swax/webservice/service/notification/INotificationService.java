package swax.webservice.service.notification;

import swax.webservice.entity.user.Notification;
import swax.webservice.entity.user.NotificationTypeEnum;
import swax.webservice.entity.user.User;

public interface INotificationService {
	
	public Notification getNotification(User user, NotificationTypeEnum type, String details);
	
	public Integer createUpdateEntity(Notification notification);

}
