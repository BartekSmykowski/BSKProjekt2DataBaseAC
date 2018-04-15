package edu.bsk.database.repositories;

import edu.bsk.database.entities.ProductResource;
import org.springframework.data.repository.CrudRepository;

public interface ProductResourceRepository extends CrudRepository<ProductResource, Integer>
{
}
