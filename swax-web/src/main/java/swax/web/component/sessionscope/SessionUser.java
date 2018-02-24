package swax.web.component.sessionscope;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import lombok.Data;
import swax.webservice.entity.user.User;

@SessionScope
@Component
@Data
public class SessionUser {
	
	private User sessionUser;

}
