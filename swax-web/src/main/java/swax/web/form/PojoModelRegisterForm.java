package swax.web.form;
import org.hibernate.validator.constraints.NotEmpty;import lombok.Data;@Data
public class PojoModelRegisterForm {	@NotEmpty	private String userName;
	@NotEmpty	private String email;
	@NotEmpty	private String country;
	@NotEmpty	private String password;
	@NotEmpty	private String password2;		@NotEmpty	private String discogsName;		private String errorMsg="";	
}