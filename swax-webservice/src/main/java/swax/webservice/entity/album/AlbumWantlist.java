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
@Table(name="WANTLIST")
public class AlbumWantlist implements Serializable {

	private static final long serialVersionUID = 4636964225815914688L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="ALBUM_WANTLIST_ID", unique = true, nullable = false)
	private Integer albumWantlistId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USER_ID", nullable = false)
	private User user;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="DISCOGS_ID", nullable = false)
	private Album album;
	
	@Column(name="NOTES", nullable = true)
	private String notes;
	
	@Column(name="DATE_ADDED", nullable = true)
	private String dateAdded;
	
	/**
	 * CONSTRUCTORS
	 */
	
	public AlbumWantlist() {
	}
	
	public AlbumWantlist(User user, Album album, String notes, String dateAdded) {
		super();
		this.user = user;
		this.album = album;
		this.notes = notes;
		this.dateAdded = dateAdded;
	}
	
	public AlbumWantlist(User user, AlbumDiscogsWantlist albumDiscogsWantlist) {
		this.user = user;
		this.album = new Album(albumDiscogsWantlist);
		this.notes = albumDiscogsWantlist.getNotes();
		this.dateAdded = albumDiscogsWantlist.getDateAdded();
	}

	/**
	 * GETTERS & SETTERS
	 */

	public Integer getAlbumWantlistId() {
		return albumWantlistId;
	}
	
	public void setAlbumWantlistdId(Integer albumWantlistdId) {
		this.albumWantlistId = albumWantlistdId;
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