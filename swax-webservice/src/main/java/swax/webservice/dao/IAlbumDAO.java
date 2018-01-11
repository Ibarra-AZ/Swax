package swax.webservice.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import swax.webservice.entity.Album;
import swax.webservice.entity.AlbumDiscogs;

@Repository("albumDAO")
@Transactional
public interface IAlbumDAO extends JpaRepository<Album, Integer> {

	void save(List<AlbumDiscogs> albumsDiscogs);

}
