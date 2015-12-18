/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServicesBean;


import INFO921_TP3.Entities.Backlog;
import INFO921_TP3.Entities.Comment;
import INFO921_TP3.Entities.Ticket;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author francoiscaillet
 */
@Stateless
public class TicketSessionBean implements TicketSessionBeanLocal {

    @PersistenceContext
    protected EntityManager entityManager;
    
    @Override
    public void saveTicket(Ticket ticket) {
         if (ticket.getId() == null) {
            entityManager.persist(ticket);
        }else {
            entityManager.merge(ticket);
        }
    }

    @Override
    public Ticket findTicketById(Long id) {
         return entityManager.find(Ticket.class, id);
    }

    @Override
    public void deleteTicket(Ticket ticket) {
        entityManager.refresh(entityManager.merge(ticket));
        entityManager.remove(entityManager.merge(ticket));
    }

    @Override
    public Collection<Ticket> getAllByBacklogId(Backlog b) {
        Collection<Ticket> ticketsList = null;
        try {
            ticketsList = entityManager.createNamedQuery(Ticket.GET_TICKET_BY_BACKLOG_ID, Ticket.class)
                    .setParameter("curBacklog", b).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ticketsList;
    }
    
    @Override
    public void saveComment(Comment comment) {
       entityManager.persist(comment);
    }

    
}
