package edu.bsk.jsf.beans.resource;

import edu.bsk.database.entities.ProductionEvent;
import edu.bsk.database.entities.Resource;
import edu.bsk.database.repositories.ProductionEventRepository;
import edu.bsk.database.repositories.ResourceRepository;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@ManagedBean
@ViewScoped
public class ResourcesMainView
{
	private final ResourceRepository resourceRepository;

	@Inject
	public ResourcesMainView(ResourceRepository resourceRepository)
	{
		this.resourceRepository = resourceRepository;
	}

	public Iterable<Resource> getAll()
	{
		return resourceRepository.findAll();
	}
}
