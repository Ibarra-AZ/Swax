package swax.webservice.entity.album;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import swax.webservice.entity.user.User;

@Entity
@Table(name="COLLECTION")
public class AlbumCollected implements Serializable {

	private static final long serialVersionUID = 5886673759992245183L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="ALBUM_COLLECTED_ID", unique = true, nullable = false)
	private Integer albumCollectedId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USER_ID", nullable = false)
	private User user;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="DISCOGS_ID", unique = false, nullable = false)
	private Album album;
	
	@Column(name="MEDIA_GRADING", nullable = true)
	private String mediaGrading;
	
	@Column(name="SLEEVE_GRADING", nullable = true)
	private String sleeveGrading;
	
	@Column(name="NOTES", nullable = true)
	private String notes;
	
	@Column(name="DATE_ADDED", nullable = true)
	private String dateAdded;
	
	/**
	 * CONSTRUCTORS
	 */
	
	public AlbumCollected() {
	}
	
	public AlbumCollected(User user, Album album, String mediaGrading, String sleeveGrading, String notes,
			String dateAdded) {
		super();
		this.user = user;
		this.album = album;
		this.mediaGrading = mediaGrading;
		this.sleeveGrading = sleeveGrading;
		this.notes = notes;
		this.dateAdded = dateAdded;
	}

	public AlbumCollected(User user, AlbumDiscogs albumDiscogs) {
		this.user = user;
		this.album = new Album(albumDiscogs);
		this.mediaGrading = albumDiscogs.getMediaCondition();
		this.sleeveGrading = albumDiscogs.getSleeveCondition();
		this.notes = albumDiscogs.getCollectionNotes();
		this.dateAdded = albumDiscogs.getDateAdded();
	}

	/**
	 * GETTERS & SETTERS
	 */
	
	public Integer getAlbumCollectedId() {
		return albumCollectedId;
	}

	public void setAlbumCollectedId(Integer collectionId) {
		this.albumCollectedId = collectionId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
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

	public String getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}	

}