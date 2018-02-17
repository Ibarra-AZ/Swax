package swax.webservice.dao.album;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import swax.webservice.entity.album.AlbumCollected;
import swax.webservice.entity.album.AlbumDiscogs;
import swax.webservice.entity.user.User;

@Repository("albumCollectedDAO")
@Transactional
public interface IAlbumCollectedDAO extends JpaRepository<AlbumCollected, Integer> {

	void save(List<AlbumDiscogs> albumsDiscogs);

	List<AlbumCollected> findByUser(User user);

	AlbumCollected findByAlbumCollectedId(Integer albumId);
	
	void deleteByUser(User user);

}
