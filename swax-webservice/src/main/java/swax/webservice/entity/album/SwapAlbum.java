package swax.webservice.entity.album;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToOne;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import lombok.Data;
import swax.webservice.dto.PossibleSwapDTO;
import swax.webservice.entity.user.User;

@Data
@Entity
@Table(name="SWAPALBUM")
@SqlResultSetMapping(
        name = "possibleSwapsMapping",
        classes = @ConstructorResult(
                targetClass = PossibleSwapDTO.class,
                columns = {
                    @ColumnResult(name = "swap_album_id",type=String.class),
                    @ColumnResult(name = "user_id",type = Integer.class),
                    @ColumnResult(name = "album_wantlist_id", type = Integer.class)}))
@NamedNativeQuery(name="findPossibleSwapsbyUserCreatedQuery",
	query="select swap_album_id, swapalbum.user_id, album_wantlist_id from swapalbum "
			+ "join (select discogs_id as discogs_id, album_wantlist_id as album_wantlist_id from wantlist where user_id=(?1)) "
			+ "as wantlist2 on swapalbum.album_id = wantlist2.discogs_id "
			+ "where (swapalbum.user_id != (?1) and album_to_swap=true);",
			resultSetMapping="possibleSwapsMapping")
public class SwapAlbum implements Serializable {

	private static final long serialVersionUID = -5693601176310892785L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="SWAP_ALBUM_ID", unique = true, nullable = false)
	private String swapAlbumId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USER_ID", unique = false, nullable = false)
	private User user;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ALBUM_COLLECTED_ID", unique = true, nullable = false)
	private AlbumCollected albumCollected;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ALBUM_ID", unique = false, nullable = false)
	private Album album;
	
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
	
	public SwapAlbum(String swapAlbumId, User user, AlbumCollected albumCollected, Album album, String mediaGrading, 
			String sleeveGrading, String waxValue, String description, String imgName, String dateAdded, boolean albumToSwap) {
		super();
		this.swapAlbumId = swapAlbumId;
		this.user = user;
		this.albumCollected = albumCollected;
		this.album = album;
		this.mediaGrading = mediaGrading;
		this.sleeveGrading = sleeveGrading;
		this.waxValue = waxValue;
		this.description = description;
		this.imgName = imgName;
		this.dateAdded = dateAdded;
		this.albumToSwap = albumToSwap;
	}
	
	public SwapAlbum(User user, AlbumCollected albumCollected, Album album, String mediaGrading, String sleeveGrading,
			String waxValue, String description, String imgName, String dateAdded, boolean albumToSwap) {
		super();
		this.user = user;
		this.albumCollected = albumCollected;
		this.album = album;
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

	public boolean isAlbumToSwap() {
		return albumToSwap;
	}

	public void setAlbumToSwap(boolean albumToSwap) {
		this.albumToSwap = albumToSwap;
	}

	@Override
	public String toString() {
		return "SwapAlbum [swapAlbumId=" + swapAlbumId + ", user=" + user + ", albumCollected=" + albumCollected
				+ ", album=" + album + ", mediaGrading=" + mediaGrading + ", sleeveGrading=" + sleeveGrading
				+ ", waxValue=" + waxValue + ", description=" + description + ", imgName=" + imgName + ", dateAdded="
				+ dateAdded + ", albumToSwap=" + albumToSwap + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((swapAlbumId == null) ? 0 : swapAlbumId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SwapAlbum other = (SwapAlbum) obj;
		if (swapAlbumId == null) {
			if (other.swapAlbumId != null)
				return false;
		} else if (!swapAlbumId.equals(other.swapAlbumId))
			return false;
		return true;
	}
	
}