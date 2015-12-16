/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServicesBean;

import INFO921_TP3.Entities.Backlog;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author francoiscaillet
 */
@Stateless
public class BacklogSessionBean implements BacklogSessionBeanLocal {
    
    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public Backlog findBacklogById(Long id) {
        return entityManager.find(Backlog.class, id);
    }

}
