package swax.webservice.dao.album;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import swax.webservice.dto.PossibleSwapDTO;
import swax.webservice.entity.album.AlbumCollected;
import swax.webservice.entity.album.SwapAlbum;
import swax.webservice.entity.user.User;

@Repository("swapAlbumDAO")
@Transactional
public interface ISwapAlbumDAO extends JpaRepository<SwapAlbum, Integer>{

	List<SwapAlbum> findByUser(User user);

	SwapAlbum findBySwapAlbumId(String albumId);

	SwapAlbum findByAlbumCollected(AlbumCollected albumCollected);

	@Query(name="findPossibleSwapsbyUserCreatedQuery", nativeQuery = true)   
    List<PossibleSwapDTO> findPossibleSwapsByUser(int user_id);

	void deleteByUser(User user);
	
	@Query(value = "SELECT COUNT(*) FROM SWAPALBUM WHERE ALBUM_TO_SWAP=true", nativeQuery = true)
	int countSwaps();

}
