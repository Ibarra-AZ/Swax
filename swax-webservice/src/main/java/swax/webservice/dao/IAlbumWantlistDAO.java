package swax.webservice.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import swax.webservice.entity.AlbumWantlist;
import swax.webservice.entity.User;

@Repository("albumWantlistDAO")
@Transactional
public interface IAlbumWantlistDAO extends JpaRepository<AlbumWantlist, Integer> {

	List<AlbumWantlist> findByUser(User user);

}
