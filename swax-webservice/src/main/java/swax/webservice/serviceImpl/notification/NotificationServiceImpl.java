package swax.webservice.serviceImpl.notification;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import swax.webservice.dao.notification.INotificationDAO;
import swax.webservice.entity.notification.Notification;
import swax.webservice.entity.notification.NotificationStatusEnum;
import swax.webservice.entity.notification.NotificationTypeEnum;
import swax.webservice.entity.user.User;
import swax.webservice.service.notification.INotificationService;
import swax.webservice.tools.DateUtils;

@Service(value="notificationService")
public class NotificationServiceImpl implements INotificationService {
	
	@Resource(name = "notificationDAO")
	private INotificationDAO notificationDAO = null;

	@Override
	public Notification getNotification(User user, NotificationTypeEnum type, String message) {
		Notification notification = new Notification();
		notification.setUser(user);
		notification.setDateAdded(DateUtils.dateToString(new Date()));
		notification.setType(type.toString());
		notification.setStatus(NotificationStatusEnum.ToRead.toString());
		notification.setSubject(type.getNotificationType());
		notification.setMessage(message);
		return notification;
	}

	@Override
	public Integer createUpdateEntity(Notification notification) {
		return this.notificationDAO.saveAndFlush(notification).getNotificationId();
	}

	@Override
	public List<Notification> findByUser(User user) {
		return this.notificationDAO.findByUser(user);
	}

}