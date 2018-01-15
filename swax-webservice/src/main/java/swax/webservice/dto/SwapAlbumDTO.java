package swax.webservice.dto;

import java.io.Serializable;

public class SwapAlbumDTO implements Serializable {

	private static final long serialVersionUID = -2697985225176867271L;

	private Integer albumId;
	
	private String albumName;
	
	private String artist;
	
	private String label;
	
	private String catalogNumber;
	
//	private String format;
	
	private String mediaGrading;
	
	private String sleeveGrading;
	
	private String waxValue;
	
	private String description;
	
	private String releaseDate;
	
	private String imgName;
	
//	private String dateAdded;
	
//	private String discogsId;
	
	/** CONTRUCTORS **/
	
	public SwapAlbumDTO() {
	}

	public SwapAlbumDTO(Integer albumId, String albumName, String artist, String label, String catalogNumber,
			String mediaGrading, String sleeveGrading, String waxValue, String description, String releaseDate,
			String imgName) {
		super();
		this.albumId = albumId;
		this.albumName = albumName;
		this.artist = artist;
		this.label = label;
		this.catalogNumber = catalogNumber;
		this.mediaGrading = mediaGrading;
		this.sleeveGrading = sleeveGrading;
		this.waxValue = waxValue;
		this.description = description;
		this.releaseDate = releaseDate;
		this.imgName = imgName;
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

	public String getWaxValue() {
		return waxValue;
	}

	public void setWaxValue(String waxValue) {
		this.waxValue = waxValue;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

}
