/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServicesBean;

import INFO921_TP3.Entities.Comment;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author francoiscaillet
 */
@Stateless
public class CommentSessionBean implements CommentSessionBeanLocal {
    
        
    @PersistenceContext
    protected EntityManager entityManager;


    @Override
    public void saveComment(Comment comment) {
       entityManager.persist(comment);
    }

    
}