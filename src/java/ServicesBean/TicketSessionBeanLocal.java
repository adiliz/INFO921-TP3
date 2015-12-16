/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServicesBean;

import INFO921_TP3.Entities.Backlog;
import INFO921_TP3.Entities.Ticket;
import java.util.Collection;

/**
 *
 * @author francoiscaillet
 */
public interface TicketSessionBeanLocal {
    void saveTicket(Ticket ticket);
    Ticket findTicketById(Long id);
    void deleteTicket(Ticket ticket);
    Collection<Ticket> getAllByBacklogId(Backlog b);
}
