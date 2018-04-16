package edu.bsk.jsf.beans.resource;

import edu.bsk.database.entities.Resource;
import edu.bsk.database.repositories.ResourceRepository;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@ManagedBean
@ViewScoped
public class ResourcesCreateView
{
	protected Resource resource = new Resource();

	protected final ResourceRepository resourceRepository;

	@Inject
	public ResourcesCreateView(ResourceRepository resourceRepository)
	{
		this.resourceRepository = resourceRepository;
	}

	public Resource getResource()
	{
		return resource;
	}

	public void save()
	{
		resourceRepository.save(resource);
	}
}
