package swax.web.form;
import org.springframework.web.multipart.MultipartFile;import lombok.Data;@Data
public class PojoModelSwapAlbumForm {		private String mediaGrading;		private String sleeveGrading;		private String waxValue;		private String description;		private MultipartFile imgFilePath;		private String albumId;	private String errorMsg = "";	}