package swax.webservice.service;

import java.util.List;

import swax.webservice.dto.SwapAlbumDTO;
import swax.webservice.entity.SwapAlbum;
import swax.webservice.entity.User;

public interface ISwapAlbumService {

	List<SwapAlbum> findAll();

	Integer createUpdateEntity(SwapAlbum swapAlbum);

	SwapAlbum findBySwapAlbumId(Integer albumId);

	List<SwapAlbum> findByUser(User user);

	SwapAlbumDTO getAlbumDTO(SwapAlbum swapAlbum);

}
