package edu.bsk.jsf.beans.production.events;

import edu.bsk.database.entities.ProductionEvent;
import edu.bsk.database.repositories.ProductionEventRepository;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@ManagedBean
@ViewScoped
public class ProductionEventsMainView
{
	private final ProductionEventRepository productionEventRepository;

	@Inject
	public ProductionEventsMainView(ProductionEventRepository productionEventRepository)
	{
		this.productionEventRepository = productionEventRepository;
	}

	public Iterable<ProductionEvent> getAll()
	{
		return productionEventRepository.findAll();
	}
}
