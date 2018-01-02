package swax.webservice.dao;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import swax.webservice.entity.User;
@Repository("userDAO")@Transactionalpublic interface IUserDAO extends JpaRepository<User, Integer> {
	public User findByEmailAndPassword(String email, String password);
}
