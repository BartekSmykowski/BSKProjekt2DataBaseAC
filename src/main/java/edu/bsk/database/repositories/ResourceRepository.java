package edu.bsk.database.repositories;

import edu.bsk.database.entities.Resource;
import org.springframework.data.repository.CrudRepository;

public interface ResourceRepository extends CrudRepository<Resource, Integer>
{
}
