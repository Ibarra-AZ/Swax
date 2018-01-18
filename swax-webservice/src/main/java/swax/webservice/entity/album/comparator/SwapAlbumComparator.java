package swax.webservice.entity.album.comparator;

import java.util.Comparator;

import swax.webservice.entity.album.SwapAlbum;

public class SwapAlbumComparator implements Comparator<SwapAlbum> {

	@Override
	public int compare(SwapAlbum o1, SwapAlbum o2) {
		return o1.getDateAdded().compareTo(o2.getDateAdded());
	}

}
