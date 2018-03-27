package swax.webservice.serviceImpl.notification;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import swax.webservice.dao.notification.INotificationDAO;
import swax.webservice.entity.user.Notification;
import swax.webservice.entity.user.NotificationStatusEnum;
import swax.webservice.entity.user.NotificationTypeEnum;
import swax.webservice.entity.user.User;
import swax.webservice.service.notification.INotificationService;
import swax.webservice.tools.DateUtils;

@Service(value="notificationService")
public class NotificationServiceImpl implements INotificationService {
	
	@Resource(name = "notificationDAO")
	private INotificationDAO notificationDAO = null;

	@Override
	public Notification getNotification(User user, NotificationTypeEnum type, String details) {
		Notification notification = new Notification();
		notification.setUser(user);
		notification.setDateAdded(DateUtils.dateToString(new Date()));
		notification.setStatus(NotificationStatusEnum.ToRead.getUserStatus());
		notification.setSubject(type.toString());
		notification.setMessage(type.getNotificationType());
		notification.setDetails(details);
		return notification;
	}

	@Override
	public Integer createUpdateEntity(Notification notification) {
		return this.notificationDAO.saveAndFlush(notification).getNotificationId();
	}

	

}
