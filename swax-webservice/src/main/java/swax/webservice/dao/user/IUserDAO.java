package swax.webservice.dao.user;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;import swax.webservice.entity.user.User;
@Repository("userDAO")@Transactionalpublic interface IUserDAO extends JpaRepository<User, Integer> {
	public User findByEmailAndPassword(String email, String password);	public User findByEmail(String email);	public User findByUserName(String userName);	public User findByEmailOrUserName(String email, String userName);
}
