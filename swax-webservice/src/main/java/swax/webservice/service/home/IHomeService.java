package swax.webservice.service.home;import java.util.Collection;import swax.webservice.entity.album.SwapAlbum;import swax.webservice.entity.user.User;public interface IHomeService {		public Collection<SwapAlbum> initHome(User user);
}
