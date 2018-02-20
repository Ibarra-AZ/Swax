package swax.webservice.dao.user;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;import org.springframework.data.jpa.repository.Query;import org.springframework.stereotype.Repository;import swax.webservice.entity.user.User;
@Repository("userDAO")@Transactionalpublic interface IUserDAO extends JpaRepository<User, Integer> {		public User findByUserId(int userId);
	public User findByEmailAndPassword(String email, String password);	public User findByEmail(String email);	public User findByUserName(String userName);	public User findByEmailOrUserName(String email, String userName);		@Query(value = "SELECT COUNT(*) FROM USERS WHERE STATUS='Authorized'", nativeQuery = true)	public int countUsers();
}
