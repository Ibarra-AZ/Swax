package swax.web.form;
import org.hibernate.validator.constraints.NotEmpty;
public class PojoModelRegisterForm {	@NotEmpty	private String userName;
	@NotEmpty	private String email;
	@NotEmpty	private String country;
	@NotEmpty	private String password;
	@NotEmpty	private String password2;		private String errorMsg;		public String getEmail() {		return email;	}
	public void setEmail(String email) {		this.email = email;	}
	public String getPassword() {		return password;	}
	public void setPassword(String password) {		this.password = password;	}
	public String getPassword2() {		return password2;	}
	public void setPassword2(String password2) {		this.password2 = password2;	}
	public String getUserName() {		return userName;	}
	public void setUserName(String userName) {		this.userName = userName;	}
	public String getCountry() {		return country;	}
	public void setCountry(String country) {		this.country = country;	}	public String getErrorMsg() {		return errorMsg;	}	public void setErrorMsg(String errorMsg) {		this.errorMsg = errorMsg;	}
}