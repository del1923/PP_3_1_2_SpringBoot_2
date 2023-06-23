package web.PP_31._SpringBoot.repositiries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.PP_31._SpringBoot.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
