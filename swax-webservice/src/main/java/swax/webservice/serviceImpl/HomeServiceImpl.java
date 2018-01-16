package swax.webservice.serviceImpl;
import java.util.ArrayList;import java.util.List;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Service;import swax.webservice.entity.SwapAlbum;import swax.webservice.service.IHomeService;import swax.webservice.service.ISwapAlbumService;
@Service("homeService")public class HomeServiceImpl implements IHomeService {		@Autowired	private ISwapAlbumService swapAlbumService = null;	@Override	public List<SwapAlbum> initHome() {		List<SwapAlbum> swapAlbums = swapAlbumService.findAll();		List<SwapAlbum> result = new ArrayList<>();		if (swapAlbums.size() >=6) {			for (int i=1; i<=6; i++) {				result.add(swapAlbums.get(swapAlbums.size()-i));			}		} else {			result = null;		}		return result;			}

}