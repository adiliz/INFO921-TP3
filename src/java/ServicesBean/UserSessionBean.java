/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServicesBean;

import INFO921_TP3.Entities.User;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Anthony
 */
@Stateless
public class UserSessionBean implements UserSessionBeanLocal {
    private Logger logger = Logger.getLogger(getClass().getName());


    @PersistenceContext
    protected EntityManager entityManager;

    public void saveUser(User user) {
        logger.info("Enregistrement du user : " + user.toString());
        if (user.getId() == null) {
            logger.info("In save new user");
            entityManager.persist(user);
        }else {
            logger.info("In update user");
            entityManager.merge(user);
        }
    }

    public User findUserById(Long id) {
        return entityManager.find(User.class, id);
    }


    public void deleteUser(User user) {
        entityManager.remove(user);
    }
}
