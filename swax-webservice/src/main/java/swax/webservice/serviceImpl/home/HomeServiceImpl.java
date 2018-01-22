package swax.webservice.serviceImpl.home;
import java.util.ArrayList;import java.util.Collection;import java.util.Collections;import java.util.Comparator;import java.util.List;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Service;import swax.webservice.dto.LatestAdditionDTO;import swax.webservice.entity.album.SwapAlbum;import swax.webservice.entity.album.comparator.SwapAlbumComparator;import swax.webservice.entity.user.User;import swax.webservice.service.album.ISwapAlbumService;import swax.webservice.service.home.IHomeService;
@Service("homeService")public class HomeServiceImpl implements IHomeService {		static int LAST_ADD_NUMBER = 6;		@Autowired	private ISwapAlbumService swapAlbumService = null;	@Override	public Collection<LatestAdditionDTO> initHome(User user) {				List<LatestAdditionDTO> result = new ArrayList<>();		Comparator<SwapAlbum> comparator = new SwapAlbumComparator();		List<SwapAlbum> swapAlbums;		this.getPossibleSwaps(user);				try {						swapAlbums = swapAlbumService.findAll();			Collections.sort(swapAlbums, comparator.reversed());						int count = 1;			int index = 0;			while (count  <= LAST_ADD_NUMBER) {				if ((swapAlbums.get(index).isAlbumToSwap()==true) && !(swapAlbums.get(index).getUser().getUserId() == user.getUserId())) {					count++;					LatestAdditionDTO latestAddition = new LatestAdditionDTO(swapAlbums.get(index));					result.add(latestAddition);				}				index++;					}		} catch (Exception e) {			return null;		}				this.getPossibleSwaps(user);		return result;	}		public List<Object> getPossibleSwaps(User user) {		List<Object> possibleSwaps = this.swapAlbumService.findPossibleSwapsByUser(user.getUserId());		System.out.println(possibleSwaps.toString());		return null;							}
}