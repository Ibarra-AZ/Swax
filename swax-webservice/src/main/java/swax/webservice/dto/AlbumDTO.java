package swax.webservice.dto;

import java.io.Serializable;

public class AlbumDTO implements Serializable {

	private static final long serialVersionUID = -8368788561833058931L;
	
	private String artistName;
	
	private String albumName;
	
	private String releaseDate;
	
	private String albumFormat;
	
	/** CONTRUCTORS **/
	
	public AlbumDTO() {
	}
	
	public AlbumDTO(String artistName, String albumName, String releaseDate, String albumFormat) {
		super();
		this.artistName = artistName;
		this.albumName = albumName;
		this.releaseDate = releaseDate;
		this.albumFormat = albumFormat;
	}

	/** GETTERS & SETTERS **/

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
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

	public String getAlbumFormat() {
		return albumFormat;
	}

	public void setAlbumFormat(String albumFormat) {
		this.albumFormat = albumFormat;
	}	

}
