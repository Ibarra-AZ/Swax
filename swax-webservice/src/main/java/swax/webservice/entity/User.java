package swax.webservice.entity;
import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;import java.util.ArrayList;import java.util.HashSet;import java.util.List;import java.util.Set;import javax.persistence.Column;
import javax.persistence.Entity;import javax.persistence.FetchType;import javax.persistence.GeneratedValue;
import javax.persistence.Id;import javax.persistence.JoinColumn;import javax.persistence.OneToMany;import javax.persistence.Table;
@Entity@Table(name="USER")public class User implements Serializable {
	private static final long serialVersionUID = -7198215437040727852L;
	@Id	@GeneratedValue(strategy = IDENTITY)	@Column(name="USER_ID", unique = true, nullable = false)	private Integer userId;
	@Column(name="EMAIL", unique = true, nullable = false)	private String email;
	@Column(name="PASSWORD", unique = true, nullable = false)	private String password;
	@Column(name="USER_NAME", unique = true, nullable = false)	private String userName;
	@Column(name="COUNTRY", unique = true, nullable = false)	private String country;		@OneToMany(targetEntity=AlbumCollected.class, mappedBy="user", fetch = FetchType.LAZY)	private List<AlbumCollected> collection;			/**	 * CONSTRUCTORS	 */	
	public User() {	}	public User(String email, String password, String userName, String country) {		super();		this.email = email;		this.password = password;		this.userName = userName;		this.country = country;	}	/**	 * GETTERS & SETTERS	 */
	public Integer getUserId() {		return userId;	}
	public void setUserId(Integer userId) {		this.userId = userId;	}
	public String getPassword() {		return password;	}
	public void setPassword(String password) {		this.password = password;	}		public String getEmail() {		return email;	}
	public void setEmail(String email) {		this.email = email;	}
	public String getUserName() {		return userName;	}
	public void setUserName(String userName) {		this.userName = userName;	}
	public String getCountry() {		return country;	}
	public void setCountry(String country) {		this.country = country;	}	public List<AlbumCollected> getCollection() {		return collection;	}	public void setCollection(List<AlbumCollected> collection) {		this.collection = collection;	}
}