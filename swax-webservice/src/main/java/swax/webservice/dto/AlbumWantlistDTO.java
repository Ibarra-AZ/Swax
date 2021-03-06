package swax.webservice.dto;

import java.io.Serializable;
import java.util.List;

import swax.webservice.entity.album.SwapAlbum;

public class AlbumWantlistDTO implements Serializable {
	
	private static final long serialVersionUID = 7641323366418492095L;

	private Integer albumId;
	
	private String albumName;
	
	private String artist;
	
	private String label;
	
	private String catalogNumber;
	
	private String format;
	
	private String notes;
	
	private String releaseDate;
	
	private String dateAdded;
	
	private String discogsId;
	
	private List<SwapAlbum> possibleSwaps;
	
	/** CONTRUCTORS **/
	
	public AlbumWantlistDTO() {
	}

	public AlbumWantlistDTO(Integer albumId, String albumName, String artist, String label, String catalogNumber,
			String format, String notes, String releaseDate,
			String dateAdded, String discogsId, List<SwapAlbum> possibleSwaps) {
		super();
		this.albumId = albumId;
		this.albumName = albumName;
		this.artist = artist;
		this.label = label;
		this.catalogNumber = catalogNumber;
		this.format = format;
		this.notes = notes;
		this.releaseDate = releaseDate;
		this.dateAdded = dateAdded;
		this.discogsId = discogsId;
		this.possibleSwaps = possibleSwaps;
	}

	public Integer getAlbumId() {
		return albumId;
	}

	public void setAlbumId(Integer albumId) {
		this.albumId = albumId;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getCatalogNumber() {
		return catalogNumber;
	}

	public void setCatalogNumber(String catalogNumber) {
		this.catalogNumber = catalogNumber;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}

	public String getDiscogsId() {
		return discogsId;
	}

	public void setDiscogsId(String discogsId) {
		this.discogsId = discogsId;
	}

	public List<SwapAlbum> getPossibleSwaps() {
		return possibleSwaps;
	}

	public void setPossibleSwaps(List<SwapAlbum> possibleSwaps) {
		this.possibleSwaps = possibleSwaps;
	}

}
