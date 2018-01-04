package swax.web.form;
import org.hibernate.validator.constraints.NotEmpty;
public class PojoModelLoginForm {		@NotEmpty	private String email;
	@NotEmpty	private String password;	private String errorMsg = "";	
	public String getEmail() {		return email;	}	public void setEmail(String email) {		this.email = email;	}
	public String getPassword() {		return password;	}
	public void setPassword(String password) {		this.password = password;	}	public String getErrorMsg() {		return errorMsg;	}	public void setErrorMsg(String errorMsg) {		this.errorMsg = errorMsg;	}
}