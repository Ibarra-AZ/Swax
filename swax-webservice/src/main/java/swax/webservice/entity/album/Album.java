package swax.webservice.entity.album;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="ALBUM")
public class Album implements Serializable {

	private static final long serialVersionUID = 6454253731785235236L;
	
//	@Id
//	@GeneratedValue(strategy = IDENTITY)
//	@Column(name="ALBUM_ID", unique = true, nullable = false)
//	private Integer albumId;
	
	@Id
	@Column(name="DISCOGS_ID", nullable = false)
	private String discogsId;
	
	@Column(name="ALBUM_NAME", nullable = false)
	private String albumName;
	
	@Column(name="ARTIST", nullable = false)
	private String artist;
	
	@Column(name="LABEL", nullable = true)
	private String label;
	
	@Column(name="CATALOG_NUMBER", nullable = true)
	private String catalogNumber;
	
	@Column(name="FORMAT", nullable = false)
	private String format;
	
	@Column(name="RELEASE_DATE", nullable = true)
	private String releaseDate;
	
	/**
	 * CONSTRUCTORS
	 */
	
	public Album() {
	}

	public Album(String discogsId, String albumName, String artist, String label, String catalogNumber, String format,
			String releaseDate) {
		super();
		this.discogsId = discogsId;
		this.albumName = albumName;
		this.artist = artist;
		this.label = label;
		this.catalogNumber = catalogNumber;
		this.format = format;
		this.releaseDate = releaseDate;
	}
	
	public Album(AlbumDiscogs albumDiscogs) {
		this.discogsId = albumDiscogs.getRelease_id();
		this.albumName = albumDiscogs.getTitle();
		this.artist = albumDiscogs.getArtist();
		this.label = albumDiscogs.getLabel();
		this.catalogNumber = albumDiscogs.getCatalog();
		this.format = albumDiscogs.getFormat();
		this.releaseDate = albumDiscogs.getReleased();
	}
	
	public Album(AlbumDiscogsWantlist albumDiscogsWantlist) {
		this.discogsId = albumDiscogsWantlist.getReleaseId();
		this.albumName = albumDiscogsWantlist.getTitle();
		this.artist = albumDiscogsWantlist.getArtist();
		this.label = albumDiscogsWantlist.getLabel();
		this.catalogNumber = albumDiscogsWantlist.getCatalog();
		this.format = albumDiscogsWantlist.getFormat();
		this.releaseDate = albumDiscogsWantlist.getReleased();
	}

}