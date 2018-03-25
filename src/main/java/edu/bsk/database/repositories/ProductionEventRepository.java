package edu.bsk.database.repositories;

import edu.bsk.database.entities.ProductionEvent;
import org.springframework.data.repository.CrudRepository;

public interface ProductionEventRepository extends CrudRepository<ProductionEvent, Integer>
{
}
