package swax.webservice.dao.user;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository("userDAO")
	public User findByEmailAndPassword(String email, String password);
}