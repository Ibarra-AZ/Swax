package swax.webservice.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import swax.webservice.entity.AlbumWantlist;

@Repository("albumWantlistDAO")
@Transactional
public interface IAlbumWantlistDAO extends JpaRepository<AlbumWantlist, Integer> {

}
