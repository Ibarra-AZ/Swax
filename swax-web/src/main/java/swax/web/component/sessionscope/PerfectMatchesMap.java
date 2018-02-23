package swax.web.component.sessionscope;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import lombok.Data;
import swax.webservice.entity.album.SwapAlbum;

@SessionScope
@Component
@Data
public class PerfectMatchesMap {
	
	private Map<Integer, List<SwapAlbum>> perfectMatchesMap;

}
