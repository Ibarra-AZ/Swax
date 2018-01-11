package swax.webservice.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import swax.webservice.entity.AlbumCollected;
import swax.webservice.entity.AlbumDiscogs;

@Repository("albumCollectedDAO")
@Transactional
public interface IAlbumCollectedDAO extends JpaRepository<AlbumCollected, Integer> {

	void save(List<AlbumDiscogs> albumsDiscogs);

}
