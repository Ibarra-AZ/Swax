package swax.webservice.dto;

import swax.webservice.entity.album.SwapAlbum;

/**
 * 
 * @author Matthieu Ibarra
 *
 */

public class LatestAdditionDTO {
	
	private String artist;
	
	private String albumName;
	
	private String releaseDate;
	
	private String imgURL;
	
	private String swapAlbumId;

	public LatestAdditionDTO() {
		// TODO Auto-generated constructor stub
	}

	public LatestAdditionDTO(String artist, String albumName, String releaseDate, String imgURL, String swapAlbumId) {
		super();
		this.artist = artist;
		this.albumName = albumName;
		this.releaseDate = releaseDate;
		this.imgURL = imgURL;
		this.swapAlbumId = swapAlbumId;
	}
	
	public LatestAdditionDTO(SwapAlbum swapAlbum) {
		this.artist = swapAlbum.getAlbumCollected().getAlbum().getArtist();
		this.albumName = swapAlbum.getAlbumCollected().getAlbum().getAlbumName();
		this.releaseDate = swapAlbum.getAlbumCollected().getAlbum().getReleaseDate();
		this.imgURL = swapAlbum.getImgName();
		this.swapAlbumId = swapAlbum.getSwapAlbumId();
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getImgURL() {
		return imgURL;
	}

	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}

	public String getSwapAlbumId() {
		return swapAlbumId;
	}

	public void setSwapAlbumId(String swapAlbumId) {
		this.swapAlbumId = swapAlbumId;
	}

}
