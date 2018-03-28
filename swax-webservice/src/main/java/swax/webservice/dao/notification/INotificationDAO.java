package swax.webservice.dao.notification;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import swax.webservice.entity.notification.Notification;
import swax.webservice.entity.user.User;

@Repository("notificationDAO")
@Transactional
public interface INotificationDAO extends JpaRepository<Notification, Integer> {
	
	List<Notification> findByUser(User user);

}
