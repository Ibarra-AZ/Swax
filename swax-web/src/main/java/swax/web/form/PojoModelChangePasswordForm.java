package swax.web.form;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
public class PojoModelChangePasswordForm {

	@NotEmpty
	private String email;
	
	private String errorMsg = "";
	
}
