package swax.webservice.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ALBUM")
public class Album implements Serializable {

	private static final long serialVersionUID = 6454253731785235236L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="ALBUM_ID", unique = true, nullable = false)
	private Integer albumId;
	
	@Column(name="ALBUM_NAME", unique = true, nullable = false)
	private String albumName;
	
	@Column(name="ARTIST_NAME", unique = true, nullable = false)
	private String artistName;
	
	@Column(name="RELEASE_DATE", unique = true, nullable = false)
	private Date releaseDate;
	
	@Column(name="ALBUM_FORMAT", unique = true, nullable = false)
	private String albumFormat;
	
	/**
	 * CONSTRUCTORS
	 */
	
	public Album() {
	}
	
	public Album(String albumName, String artistName, Date releaseDate, String albumFormat) {
		super();
		this.albumName = albumName;
		this.artistName = artistName;
		this.releaseDate = releaseDate;
		this.albumFormat = albumFormat;
	}

	/**
	 * GETTERS & SETTERS
	 */
	
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

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getFormat() {
		return albumFormat;
	}

	public void setFormat(String format) {
		this.albumFormat = format;
	}

}
