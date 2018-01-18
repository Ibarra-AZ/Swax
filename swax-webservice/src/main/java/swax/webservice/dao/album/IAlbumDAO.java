package swax.webservice.dao.album;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import swax.webservice.entity.album.Album;
import swax.webservice.entity.album.AlbumDiscogs;

@Repository("albumDAO")
@Transactional
public interface IAlbumDAO extends JpaRepository<Album, Integer> {

	void save(List<AlbumDiscogs> albumsDiscogs);

}
