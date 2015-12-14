/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package INFO921_TP3.ManagedBean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author francoiscaillet
 */
@Named(value = "backlogManagedBean")
@ManagedBean
@SessionScoped
public class BacklogManagedBean implements Serializable {
     
    private String message = "Hello";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Creates a new instance of BacklogManagedBean
     */
    public BacklogManagedBean() {
        System.out.println("BacklogManagedBean started!");
    }
    
}
