package swax.webservice.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import swax.webservice.entity.Album;

@Repository("albumDAO")
@Transactional
public interface IAlbumDAO extends JpaRepository<Album, Integer> {

}
