package swax.web.component.sessionscope;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import lombok.Data;
import swax.webservice.dto.AlbumWantlistDTO;

@SessionScope
@Component
@Data
public class UserWantlist {
	
	private List<AlbumWantlistDTO> userWantlist;

}
