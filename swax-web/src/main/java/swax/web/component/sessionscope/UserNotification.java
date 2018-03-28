package swax.web.component.sessionscope;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import lombok.Data;
import swax.webservice.entity.notification.Notification;

@SessionScope
@Component
@Data
public class UserNotification {
	
	private List<Notification> userNotifications;

}
