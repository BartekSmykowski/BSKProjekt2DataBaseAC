package edu.bsk.jsf.beans.resource;

import edu.bsk.database.repositories.ResourceRepository;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@ManagedBean
@ViewScoped
public class ResourceEditView extends ResourcesCreateView
{
	@Inject
	public ResourceEditView(ResourceRepository resourceRepository)
	{
		super(resourceRepository);
	}

	public void initialize(Integer resourceId)
	{
		this.resource = resourceRepository.findById(resourceId).get();
	}
}
