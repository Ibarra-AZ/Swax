package swax.webservice.service.notification;

import java.util.List;

import swax.webservice.entity.notification.Notification;
import swax.webservice.entity.notification.NotificationTypeEnum;
import swax.webservice.entity.user.User;

public interface INotificationService {
	
	public Notification getNotification(User user, NotificationTypeEnum type, String details);
	
	public Integer createUpdateEntity(Notification notification);

	public List<Notification> findByUser(User user);

}
