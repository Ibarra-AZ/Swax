package swax.webservice.dto;

import java.io.Serializable;

public class AlbumDTO implements Serializable {

	private static final long serialVersionUID = -8368788561833058931L;
	
	private Integer albumId;
	
	private String albumName;
	
	private String artist;
	
	private String label;
	
	private String catalogNumber;
	
	private String format;
	
	private String mediaGrading;
	
	private String sleeveGrading;
	
	private String notes;
	
	private String releaseDate;
	
	private String dateAdded;
	
	private int discogsId;
	
	/** CONTRUCTORS **/
	
	public AlbumDTO() {
	}

	public AlbumDTO(Integer albumId, String albumName, String artist, String label, String catalogNumber, String format,
			String mediaGrading, String sleeveGrading, String notes, String releaseDate, String dateAdded, Integer discogsId) {
		super();
		this.albumId = albumId;
		this.albumName = albumName;
		this.artist = artist;
		this.label = label;
		this.catalogNumber = catalogNumber;
		this.format = format;
		this.mediaGrading = mediaGrading;
		this.sleeveGrading = sleeveGrading;
		this.notes = notes;
		this.releaseDate = releaseDate;
		this.dateAdded = dateAdded;
		this.discogsId = discogsId;
	}

	/** GETTERS & SETTERS **/

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

	public String getMediaGrading() {
		return mediaGrading;
	}

	public void setMediaGrading(String mediaGrading) {
		this.mediaGrading = mediaGrading;
	}

	public String getSleeveGrading() {
		return sleeveGrading;
	}

	public void setSleeveGrading(String sleeveGrading) {
		this.sleeveGrading = sleeveGrading;
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

	public int getDiscogsId() {
		return discogsId;
	}

	public void setDiscogsId(int discogsId) {
		this.discogsId = discogsId;
	}

	public String getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}	

}
