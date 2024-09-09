package usermanagement.jrtp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import usermanagement.jrtp.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

	User findByEmail(String email);

	User findByEmailAndPwd(String email, String pwd);
}
