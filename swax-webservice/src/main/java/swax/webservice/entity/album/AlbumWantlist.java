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
@Table(name="WANTLIST")
public class AlbumWantlist implements Serializable {

	private static final long serialVersionUID = 4636964225815914688L;

	@Id
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
	
	public AlbumWantlist(User user, AlbumDiscogs albumDiscogs) {
		this.user = user;
		this.albumWantlistId = Integer.valueOf(albumDiscogs.getCollection_id());
		this.album = new Album(albumDiscogs);
//		this.notes = albumDiscogs.getNotes;
		this.dateAdded = albumDiscogs.getDateAdded();
	}
	
	

}