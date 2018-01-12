package swax.webservice.entity;

import java.io.Serializable;

public class AlbumDiscogsWantlist implements Serializable {

	private static final long serialVersionUID = -5425760250756322827L;
	
	private String catalog, artist, title, label, format, rating, released, releaseId, notes, dateAdded;

	/* CONTRUCTORS */
	
	public AlbumDiscogsWantlist() {
	}

	public AlbumDiscogsWantlist(String catalog, String artist, String title, String label, String format, String rating,
			String released, String releaseId, String notes, String dateAdded) {
		super();
		this.catalog = catalog;
		this.artist = artist;
		this.title = title;
		this.label = label;
		this.format = format;
		this.rating = rating;
		this.released = released;
		this.releaseId = releaseId;
		this.notes = notes;
		this.dateAdded = dateAdded;
	}
	
	/* GETTERS & SETTERS */

	public String getCatalog() {
		return catalog;
	}

	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
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
	
	public String getReleaseId() {
		return releaseId;
	}

	public void setReleaseId(String released) {
		this.releaseId = released;
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

	@Override
	public String toString() {
		return "AlbumDiscogsWantlist [catalog=" + catalog + ", artist=" + artist + ", title=" + title + ", label="
				+ label + ", format=" + format + ", rating=" + rating + ", released=" + released + ", releaseId="
				+ releaseId + ", notes=" + notes + ", dateAdded=" + dateAdded + "]";
	}
	
}