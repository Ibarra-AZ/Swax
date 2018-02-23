package swax.web.component.sessionscope;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import lombok.Data;
import swax.webservice.entity.album.SwapAlbum;

@SessionScope
@Component
@Data
public class UserSwapPropositions {
	
	private List<SwapAlbum> userSwapPropositions;

}
