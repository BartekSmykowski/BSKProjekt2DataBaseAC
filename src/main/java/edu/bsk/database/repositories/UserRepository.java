package edu.bsk.database.repositories;

import edu.bsk.database.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer>
{
	User findByNickname(String nickname);
}
