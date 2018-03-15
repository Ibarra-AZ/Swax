package swax.webservice.service.album;
import java.util.List;import swax.webservice.dto.AlbumWantlistDTO;import swax.webservice.dto.PossibleSwapDTO;import swax.webservice.entity.album.AlbumDiscogs;import swax.webservice.entity.album.AlbumWantlist;import swax.webservice.entity.user.User;public interface IAlbumWantlistService {
	public List<AlbumWantlist> findAll();	public Integer createUpdateEntity(AlbumWantlist albumWantlist);	void createUserWantlist(User user, List<AlbumDiscogs> albumsDiscogs);	public List<AlbumWantlist> findByUser(User user);	List<AlbumWantlistDTO> getAlbumsWantlistDTO(User user, List<PossibleSwapDTO> possibleSwaps);		void deleteByUser(User user);
}
