package swax.webservice.entity.album;

import java.io.Serializable;

import lombok.Data;

@Data
public class AlbumDiscogs implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String collection_id, catalog, artist, title, label, format, rating, released, release_id, collectionFolder, dateAdded, 
		mediaCondition,	sleeveCondition, collectionNotes;

	public AlbumDiscogs() {
	}
	
	public AlbumDiscogs(String collection_id, String catalog, String artist, String title, String label, String format, String rating,
			String released, String release_id, String collectionFolder, String dateAdded, String mediaCondition,
			String sleeveCondition, String collectionNotes) {
		super();
		this.collection_id=collection_id;
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

}
