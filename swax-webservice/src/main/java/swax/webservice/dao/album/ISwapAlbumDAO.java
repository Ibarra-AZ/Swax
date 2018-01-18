package swax.webservice.dao.album;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import swax.webservice.entity.album.AlbumCollected;
import swax.webservice.entity.album.SwapAlbum;
import swax.webservice.entity.user.User;

@Repository("swapAlbumDAO")
@Transactional
public interface ISwapAlbumDAO extends JpaRepository<SwapAlbum, Integer>{

	List<SwapAlbum> findByUser(User user);

	SwapAlbum findBySwapAlbumId(Integer albumId);

	SwapAlbum findByAlbumCollected(AlbumCollected albumCollected);

}
