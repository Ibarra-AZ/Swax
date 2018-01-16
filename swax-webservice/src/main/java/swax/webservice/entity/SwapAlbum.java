package swax.webservice.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="SWAPALBUM")
public class SwapAlbum implements Serializable {

	private static final long serialVersionUID = -5693601176310892785L;

	@Id
	@Column(name="SWAP_ALBUM_ID", unique = true, nullable = false)
	private Integer swapAlbumId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USER_ID", unique = true, nullable = false)
	private User user;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ALBUM_COLLECTED_ID", unique = true, nullable = false)
	private AlbumCollected albumCollected;
	
	@Column(name="MEDIA_GRADING", nullable = true)
	private String mediaGrading;
	
	@Column(name="SLEEVE_GRADING", nullable = true)
	private String sleeveGrading;
	
	@Column(name="WAX_VALUE", nullable = true)
	private String waxValue;
	
	@Column(name="DESCRIPTION", nullable = true)
	private String description;
	
	@Column(name="IMG_NAME", nullable = false)
	private String imgName;
	
	@Column(name="DATE_ADDED", nullable = false)
	private String dateAdded;
	
	@Column(name="ALBUM_TO_SWAP", nullable = false)
	private boolean albumToSwap;
	
	

	/** CONTRUCTORS **/
	
	public SwapAlbum(Integer swapAlbumId, User user, AlbumCollected albumCollected, String mediaGrading, String sleeveGrading,
			String waxValue, String description, String imgName, String dateAdded, boolean albumToSwap) {
		super();
		this.swapAlbumId = swapAlbumId;
		this.user = user;
		this.albumCollected = albumCollected;
		this.mediaGrading = mediaGrading;
		this.sleeveGrading = sleeveGrading;
		this.waxValue = waxValue;
		this.description = description;
		this.imgName = imgName;
		this.dateAdded = dateAdded;
		this.albumToSwap = albumToSwap;
	}
	
	public SwapAlbum(User user, AlbumCollected albumCollected, String mediaGrading, String sleeveGrading,
			String waxValue, String description, String imgName, String dateAdded, boolean albumToSwap) {
		super();
		this.user = user;
		this.albumCollected = albumCollected;
		this.mediaGrading = mediaGrading;
		this.sleeveGrading = sleeveGrading;
		this.waxValue = waxValue;
		this.description = description;
		this.imgName = imgName;
		this.dateAdded = dateAdded;
		this.albumToSwap = albumToSwap;
	}
	
	public SwapAlbum() {
	}

	/** GETTERS & SETTERS **/

	public Integer getSwapAlbumId() {
		return swapAlbumId;
	}

	public void setSwapAlbumId(Integer swapAlbumId) {
		this.swapAlbumId = swapAlbumId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public AlbumCollected getAlbumCollected() {
		return albumCollected;
	}

	public void setAlbumCollected(AlbumCollected albumCollected) {
		this.albumCollected = albumCollected;
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

	public void setWaxValue(String notes) {
		this.waxValue = notes;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public String getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}

	public boolean isAlbumToSwap() {
		return albumToSwap;
	}

	public void setAlbumToSwap(boolean albumToSwap) {
		this.albumToSwap = albumToSwap;
	}

	@Override
	public String toString() {
		return "SwapAlbum [swapAlbumId=" + swapAlbumId + ", user=" + user + ", albumCollected=" + albumCollected
				+ ", mediaGrading=" + mediaGrading + ", sleeveGrading=" + sleeveGrading + ", waxValue=" + waxValue
				+ ", description=" + description + ", imgName=" + imgName + ", dateAdded=" + dateAdded + "]";
	}
	
}