package swax.webservice.serviceImpl.album;
import java.util.List;import javax.annotation.Resource;import org.springframework.stereotype.Service;import swax.webservice.dao.album.ISwapAlbumDAO;import swax.webservice.dto.SwapAlbumDTO;import swax.webservice.entity.album.Album;import swax.webservice.entity.album.AlbumCollected;import swax.webservice.entity.album.SwapAlbum;import swax.webservice.entity.user.User;import swax.webservice.service.album.ISwapAlbumService;
@Service("swapAlbumService")public class SwapAlbumServiceImpl implements ISwapAlbumService {
	@Resource(name = "swapAlbumDAO")	private ISwapAlbumDAO swapAlbumDAO = null;
	@Override	public List<SwapAlbum> findAll() {		return this.swapAlbumDAO.findAll();	}
	@Override	public Integer createUpdateEntity(SwapAlbum swapAlbum) {		return this.swapAlbumDAO.saveAndFlush(swapAlbum).getSwapAlbumId();	}		@Override	public List<SwapAlbum> findByUser(User user) {		return this.swapAlbumDAO.findByUser(user);	}	@Override	public SwapAlbum findBySwapAlbumId(Integer albumId) {		return this.swapAlbumDAO.findBySwapAlbumId(albumId);	}	@Override	public SwapAlbumDTO getAlbumDTO(SwapAlbum swapAlbum) {		Album album = swapAlbum.getAlbumCollected().getAlbum();		SwapAlbumDTO swapAlbumDTO = new SwapAlbumDTO(swapAlbum.getSwapAlbumId(), album.getAlbumName(), album.getArtist(), 				album.getArtist(), album.getCatalogNumber(), swapAlbum.getMediaGrading(), swapAlbum.getSleeveGrading(), 				swapAlbum.getWaxValue(), swapAlbum.getDescription(), album.getReleaseDate(), swapAlbum.getImgName());		return swapAlbumDTO;	}	@Override	public SwapAlbum findByAlbumCollected(AlbumCollected albumCollected) {		return this.swapAlbumDAO.findByAlbumCollected(albumCollected);	}
}