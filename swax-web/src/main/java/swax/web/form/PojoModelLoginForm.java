package swax.web.form;
import org.hibernate.validator.constraints.NotEmpty;import lombok.Data;@Data
public class PojoModelLoginForm {		@NotEmpty	private String email;
	@NotEmpty	private String password;	private String errorMsg = "";
}