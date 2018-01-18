package swax.webservice.dao.album;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import swax.webservice.entity.album.AlbumWantlist;
import swax.webservice.entity.user.User;

@Repository("albumWantlistDAO")
@Transactional
public interface IAlbumWantlistDAO extends JpaRepository<AlbumWantlist, Integer> {

	List<AlbumWantlist> findByUser(User user);

}
