package swax.webservice.dto;

import swax.webservice.dao.album.ISwapAlbumDAO;

/**
 * 
 * @author Matthieu Ibarra
 * 
 * DTO to get the result of the query: 
 * List<PossibleSwapDTO> findPossibleSwapsByUser(int user_id);
 * @see ISwapAlbumDAO
 *
 */

public class PossibleSwapDTO {
	
	private int swapAlbumId;
	
	private int userId;
	
	private int albumWantlistId;

	public PossibleSwapDTO(int swapAlbumId, int userId, int albumWantlistId) {
		super();
		this.swapAlbumId = swapAlbumId;
		this.userId = userId;
		this.albumWantlistId = albumWantlistId;
	}

	public int getSwapAlbumId() {
		return swapAlbumId;
	}

	public void setSwapAlbumId(int swapAlbumId) {
		this.swapAlbumId = swapAlbumId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getAlbumWantlistId() {
		return albumWantlistId;
	}

	public void setAlbumWantlistId(int albumWantlistId) {
		this.albumWantlistId = albumWantlistId;
	}

	@Override
	public String toString() {
		return "PossibleSwapDTO [swapAlbumId=" + swapAlbumId + ", userId=" + userId + ", albumWantlistId="
				+ albumWantlistId + "]";
	}
	
}
