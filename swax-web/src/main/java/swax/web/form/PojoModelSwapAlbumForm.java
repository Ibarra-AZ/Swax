package swax.web.form;
import org.hibernate.validator.constraints.NotEmpty;import org.springframework.web.multipart.MultipartFile;
public class PojoModelSwapAlbumForm {		private String discogsURL;		private MultipartFile discogsFilePath;	private String errorMsg = "";		public String getDiscogsURL() {		return discogsURL;	}	public void setDiscogsURL(String discogsURL) {		this.discogsURL = discogsURL;	}	public String getErrorMsg() {		return errorMsg;	}	public void setErrorMsg(String errorMsg) {		this.errorMsg = errorMsg;	}	public MultipartFile getDiscogsFilePath() {		return discogsFilePath;	}	public void setDiscogsFilePath(MultipartFile discogsFilePath) {		this.discogsFilePath = discogsFilePath;	}
}