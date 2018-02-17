package swax.webservice.service.album;

import java.util.Collection;
import java.util.List;

import swax.webservice.dto.PossibleSwapDTO;
import swax.webservice.dto.SwapAlbumDTO;
import swax.webservice.entity.album.AlbumCollected;
import swax.webservice.entity.album.SwapAlbum;
import swax.webservice.entity.user.User;

public interface ISwapAlbumService {

	List<SwapAlbum> findAll();

	Integer createUpdateEntity(SwapAlbum swapAlbum);

	SwapAlbum findBySwapAlbumId(Integer albumId);

	List<SwapAlbum> findByUser(User user);

	SwapAlbumDTO getAlbumDTO(SwapAlbum swapAlbum);

	SwapAlbum findByAlbumCollected(AlbumCollected albumCollected);

	List<PossibleSwapDTO> findPossibleSwapsByUser(int user_id);

	Collection<SwapAlbum> findAllSortedByDateAdded();
	
	void deleteByUser(User user);

}
