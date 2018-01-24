package swax.webservice.service.home;import java.util.Collection;import java.util.List;import swax.webservice.dto.LatestAdditionDTO;import swax.webservice.dto.PossibleSwapDTO;import swax.webservice.entity.user.User;public interface IHomeService {		public Collection<LatestAdditionDTO> initHome(User user);	List<PossibleSwapDTO> initPossibleSwaps(User user);
}
