package swax.webservice.dao.album;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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

    @Query(value = "select swap_album_id, swapalbum.user_id, album_collected_id, album_id, media_grading, sleeve_grading,"
    		+ " wax_value, description, img_name, album_wantlist_id from swapalbum "
    		+ " join wantlist on swapalbum.album_id = wantlist.discogs_id"
    		+ " where (swapalbum.user_id != (?1) and album_to_swap=true);", nativeQuery = true)
    List<Object> findPossibleSwapsByUser(int user_id);

}
