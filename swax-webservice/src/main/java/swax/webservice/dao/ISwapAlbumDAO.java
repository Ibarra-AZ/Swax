package swax.webservice.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import swax.webservice.entity.SwapAlbum;
import swax.webservice.entity.User;

@Repository("swapAlbumDAO")
@Transactional
public interface ISwapAlbumDAO extends JpaRepository<SwapAlbum, Integer>{

	List<SwapAlbum> findByUser(User user);

	SwapAlbum findBySwapAlbumId(Integer albumId);

}
