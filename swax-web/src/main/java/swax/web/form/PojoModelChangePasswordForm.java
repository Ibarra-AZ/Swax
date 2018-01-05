package swax.web.form;

import org.hibernate.validator.constraints.NotEmpty;

public class PojoModelChangePasswordForm {

	@NotEmpty
	private String email;
	
	private String errorMsg = "";

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
}
