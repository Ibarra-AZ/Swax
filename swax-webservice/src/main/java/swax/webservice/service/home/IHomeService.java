package swax.webservice.service.home;import java.util.Collection;import swax.webservice.dto.LatestAdditionDTO;import swax.webservice.entity.user.User;public interface IHomeService {		public Collection<LatestAdditionDTO> initHome(User user);
}
