package edu.bsk.database.repositories;

import edu.bsk.database.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer>
{
}
