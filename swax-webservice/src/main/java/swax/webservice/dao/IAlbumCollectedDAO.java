package swax.webservice.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import swax.webservice.entity.AlbumCollected;

@Repository("albumCollectedDAO")
@Transactional
public interface IAlbumCollectedDAO extends JpaRepository<AlbumCollected, Integer> {

}
