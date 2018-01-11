package swax.webservice.serviceImpl;
import java.util.ArrayList;import java.util.List;import org.springframework.stereotype.Service;import swax.webservice.entity.AlbumDiscogs;import swax.webservice.entity.AlbumFormatEnum;import swax.webservice.service.IAlbumDiscogsService;
@Service("albumDiscogsService")public class AlbumDiscogsServiceImpl implements IAlbumDiscogsService {	@Override
	public List<AlbumDiscogs> trimAlbumsDiscogs(List<AlbumDiscogs> albumsDiscogs) {				albumsDiscogs.remove(0);				List<AlbumDiscogs> albumsDiscogsResult = new ArrayList<AlbumDiscogs>();				for (AlbumDiscogs albumDiscogs: albumsDiscogs) {			boolean swaxAlbum = false;			for (String format: AlbumFormatEnum.albumFormats()) {				if (albumDiscogs.getFormat().contains(format)) {					swaxAlbum = true;				}			}			if (swaxAlbum) {				albumsDiscogsResult.add(albumDiscogs);			}		}				return albumsDiscogsResult;			}
}