package swax.webservice.entity.album;

import java.io.Serializable;

import lombok.Data;

@Data
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
	
}