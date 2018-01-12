package swax.webservice.entity;

import java.util.ArrayList;
import java.util.List;

public enum AlbumFormatEnum {
	
	SevenInches("7"),
	TenInches("10"),
	TwelveInches("12"),
	LP("LP"),
	TwoXTenInches("2x10"),
	TwoXTwelveInches("2x12");
	
	private final String albumFormat;
	
	private AlbumFormatEnum(String albumFormat) {
		this.albumFormat = albumFormat;
	}
	
	public String getAlbumFormat() {
		return albumFormat;
	}
	
	public static List<String> albumFormats() {
		List<String> albumFormats = new ArrayList<String>();
		for (AlbumFormatEnum albumFormat: AlbumFormatEnum.values()) {
			albumFormats.add(albumFormat.getAlbumFormat());
		}
		return albumFormats;
	}

}
