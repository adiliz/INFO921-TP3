/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServicesBean;

import INFO921_TP3.Entities.Agency;
import INFO921_TP3.Entities.Backlog;
import java.util.Collection;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author francoiscaillet
 */
@Stateless
public class AgencySessionBean implements AgencySessionBeanLocal {

    private Logger logger = Logger.getLogger(getClass().getName());
    
    @PersistenceContext
    protected EntityManager entityManager;

    public void saveAgency(Agency agency) {
        logger.info("Enregistrement de agence : " + agency.toString());
        if (agency.getId() == null) {
            Backlog myBacklog = new Backlog(agency.getName()+ "Backlog");
            entityManager.persist(myBacklog);
            logger.info("In save new agency");
            agency.setMyBacklog(myBacklog);
            entityManager.persist(agency);
        }else {
            logger.info("In update agency");
            entityManager.merge(agency);
        }
    }

    public Agency findAgencyById(Long id) {
        return entityManager.find(Agency.class, id);
    }


    public void deleteAgency(Agency agency) {
        entityManager.remove(agency);
    }

    public Collection<Agency> getAll() {
       Collection<Agency> agenciesList = null;
        try {
            agenciesList = entityManager.createNamedQuery(Agency.GET_ALL_AGENCY, Agency.class).getResultList();
        } catch (Exception e) {
            logger.info(e.toString());
            e.printStackTrace();
        }
        return agenciesList;
    }
}

