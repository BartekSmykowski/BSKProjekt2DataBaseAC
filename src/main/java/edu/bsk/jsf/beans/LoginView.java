package edu.bsk.jsf.beans;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.util.Map;

@ViewScoped
@ManagedBean
public class LoginView
{
	public void initErrorMessage()
	{
		if (errorOccured())
			showErrorMessage();
	}

	private boolean errorOccured()
	{
		Map<String, String> requestParameterMap = FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap();
		return requestParameterMap.get("error") != null;
	}

	private void showErrorMessage()
	{
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Username, role or password is invalid!",
						"(or user is already logged in)"));
	}
}
