package swax.webservice.entity.user;
import static javax.persistence.GenerationType.IDENTITY;
@Entity
	private static final long serialVersionUID = -7198215437040727852L;
	@Id
	@Column(name="EMAIL", unique = true, nullable = false)
	@Column(name="PASSWORD", unique = true, nullable = false)
	@Column(name="USER_NAME", unique = true, nullable = false)
	@Column(name="COUNTRY", unique = true, nullable = false)
	public User() {
	public Integer getUserId() {