package edu.bsk.database.repositories;

import edu.bsk.database.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Integer>
{
	User findByNickname(String nickname);

	@Query("SELECT u FROM User u JOIN FETCH u.roles WHERE u.nickname = :nickname")
	User findUserWithRoles(@Param("nickname") String nickname);
}
