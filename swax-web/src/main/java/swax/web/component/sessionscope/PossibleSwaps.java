package swax.web.component.sessionscope;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import lombok.Data;
import swax.webservice.dto.PossibleSwapDTO;

@SessionScope
@Component
@Data
public class PossibleSwaps {
	
	private List<PossibleSwapDTO> possibleSwaps;

}
