package swax.webservice.entity.album;

import java.io.Serializable;

public class AlbumDiscogs implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String catalog, artist, title, label, format, rating, released, release_id, collectionFolder, dateAdded, 
		mediaCondition,	sleeveCondition, collectionNotes;

	public AlbumDiscogs() {
	}
	
	public AlbumDiscogs(String catalog, String artist, String title, String label, String format, String rating,
			String released, String release_id, String collectionFolder, String dateAdded, String mediaCondition,
			String sleeveCondition, String collectionNotes) {
		super();
		this.catalog = catalog;
		this.artist = artist;
		this.title = title;
		this.label = label;
		this.format = format;
		this.rating = rating;
		this.released = released;
		this.release_id = release_id;
		this.collectionFolder = collectionFolder;
		this.dateAdded = dateAdded;
		this.mediaCondition = mediaCondition;
		this.sleeveCondition = sleeveCondition;
		this.collectionNotes = collectionNotes;
	}

	public String getCatalog() {
		return catalog;
	}

	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getReleased() {
		return released;
	}

	public void setReleased(String released) {
		this.released = released;
	}

	public String getReleased_id() {
		return release_id;
	}

	public void setReleased_id(String released_id) {
		this.release_id = released_id;
	}

	public String getCollectionFolder() {
		return collectionFolder;
	}

	public void setCollectionFolder(String collectionFolder) {
		this.collectionFolder = collectionFolder;
	}

	public String getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}

	public String getMediaCondition() {
		return mediaCondition;
	}

	public void setMediaCondition(String mediaCondition) {
		this.mediaCondition = mediaCondition;
	}

	public String getSleeveCondition() {
		return sleeveCondition;
	}

	public void setSleeveCondition(String sleeveCondition) {
		this.sleeveCondition = sleeveCondition;
	}

	public String getCollectionNotes() {
		return collectionNotes;
	}

	public void setCollectionNotes(String collectionNotes) {
		this.collectionNotes = collectionNotes;
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

	@Override
	public String toString() {
		return "AlbumDiscogs [catalog=" + catalog + ", artist=" + artist + ", title=" + title + ", label=" + label
				+ ", format=" + format + ", rating=" + rating + ", released=" + released + ", released_id="
				+ release_id + ", collectionFolder=" + collectionFolder + ", dateAdded=" + dateAdded
				+ ", mediaCondition=" + mediaCondition + ", sleeveCondition=" + sleeveCondition + ", collectionNotes="
				+ collectionNotes + "]";
	}
}
