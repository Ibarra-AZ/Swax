package swax.web.component.sessionscope;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import lombok.Data;

@SessionScope
@Component
@Data
public class HasCollection {
	
	private boolean hasCollection = false;

}
