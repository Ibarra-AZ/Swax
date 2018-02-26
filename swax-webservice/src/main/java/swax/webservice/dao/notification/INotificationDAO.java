package swax.webservice.dao.notification;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import swax.webservice.entity.user.Notification;

@Repository("notificationDAO")
@Transactional
public interface INotificationDAO extends JpaRepository<Notification, Integer> {
	
	

}
