package edu.bsk.jsf.beans;

import edu.bsk.Roles;
import lombok.Data;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;
import java.util.List;

@ManagedBean
@ViewScoped
@Data
public class RolesData {

    private List<String> roles;

    public RolesData(){
        this.roles = Roles.getRoles();
    }

}
