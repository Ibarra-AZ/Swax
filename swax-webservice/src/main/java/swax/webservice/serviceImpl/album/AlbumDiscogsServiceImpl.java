package swax.webservice.serviceImpl.album;
import java.util.ArrayList;import java.util.List;import org.springframework.stereotype.Service;import swax.webservice.entity.album.AlbumDiscogs;import swax.webservice.entity.album.AlbumFormatEnum;import swax.webservice.service.album.IAlbumDiscogsService;
@Service("albumDiscogsService")public class AlbumDiscogsServiceImpl implements IAlbumDiscogsService {	@Override
	public List<AlbumDiscogs> trimAlbumsDiscogs(List<AlbumDiscogs> albumsDiscogs) {				albumsDiscogs.remove(0);				List<AlbumDiscogs> albumsDiscogsResult = new ArrayList<AlbumDiscogs>();				for (AlbumDiscogs albumDiscogs: albumsDiscogs) {			boolean swaxAlbum = false;			for (String format: AlbumFormatEnum.albumFormats()) {				if (albumDiscogs.getFormat().contains(format)) {					swaxAlbum = true;				}			}			if (swaxAlbum) {				albumsDiscogsResult.add(albumDiscogs);			}		}				return albumsDiscogsResult;			}		@Override	public List<AlbumDiscogs> trimAlbumsDiscogsAPI(List<AlbumDiscogs> albumsDiscogs) {				List<AlbumDiscogs> albumsDiscogsResult = new ArrayList<AlbumDiscogs>();				for (AlbumDiscogs albumDiscogs: albumsDiscogs) {			boolean swaxAlbum = false;			for (String format: AlbumFormatEnum.albumFormats()) {				if (albumDiscogs.getFormat().contains(format)) {					swaxAlbum = true;				}			}			if (swaxAlbum) {				albumsDiscogsResult.add(albumDiscogs);			}		}				return albumsDiscogsResult;			}
}