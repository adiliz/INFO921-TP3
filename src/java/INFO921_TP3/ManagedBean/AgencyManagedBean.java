/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package INFO921_TP3.ManagedBean;

import INFO921_TP3.Entities.Agency;
import ServicesBean.AgencySessionBeanLocal;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;

/**
 *
 * @author francoiscaillet
 */
@Named(value = "agencyManagedBean")
@RequestScoped
public class AgencyManagedBean implements Serializable {
    
    @EJB
    private AgencySessionBeanLocal agencyDAO;
    
   private Collection<Agency> agencies;
   private Agency agency;



   @PostConstruct
   public void init() {
       this.agencies = agencyDAO.getAll();
    }

    /**
     * Creates a new instance of AgencyManagedBean
     */
    public AgencyManagedBean(){ 
        this.agency = new Agency();
    }
   
    
    public void newAgency(){
        agencyDAO.saveAgency(this.agency);
    }
   
    public Collection<Agency> getAgencies() {
        return agencies;
    }

    public void setAgencies(Collection<Agency> agencies) {
        this.agencies = agencies;
    }
    
    
    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }
    
    
    
}
