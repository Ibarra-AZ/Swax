package swax.webservice.entity.album;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import swax.webservice.entity.user.User;

@Data
@Entity
@Table(name="COLLECTION")
public class AlbumCollected implements Serializable {

	private static final long serialVersionUID = 5886673759992245183L;
	
	@Id
//	@GeneratedValue(strategy = IDENTITY)
	@Column(name="ALBUM_COLLECTED_ID", unique = true, nullable = false)
	private String albumCollectedId;
	
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
		this.albumCollectedId = albumDiscogs.getCollection_id();
		this.user = user;
		this.album = new Album(albumDiscogs);
		this.mediaGrading = albumDiscogs.getMediaCondition();
		this.sleeveGrading = albumDiscogs.getSleeveCondition();
		this.notes = albumDiscogs.getCollectionNotes();
		this.dateAdded = albumDiscogs.getDateAdded().substring(0, 10);
	}

}