package swax.webservice.entity;

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

@Entity
@Table(name="ALBUM_COLLECTED")
public class AlbumCollected implements Serializable {

	private static final long serialVersionUID = 5886673759992245183L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="ALBUM_COLLECTED_ID", unique = true, nullable = false)
	private Integer collectionId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USER_ID")
	private User user;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ALBUM_ID")
	private Album album;
	
	
	//@OneToOne(fetch=FetchType.LAZY)
//	@Column(name="ALBUM_ID")
//	private Integer albumId;
	

	
	/**
	 * CONSTRUCTORS
	 */
	
	public AlbumCollected() {
	}
	
	public AlbumCollected(User user, Album album) {
		super();
		this.user = user;
		this.album = album;
	}
	
	/**
	 * GETTERS & SETTERS
	 */
	
	public Integer getCollectionId() {
		return collectionId;
	}

	public void setCollectionId(Integer collectionId) {
		this.collectionId = collectionId;
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
	
}
