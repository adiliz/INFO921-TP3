/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package INFO921_TP3.ManagedBean;

import INFO921_TP3.Entities.Backlog;
import INFO921_TP3.Entities.Comment;
import INFO921_TP3.Entities.Ticket;
import ServicesBean.BacklogSessionBeanLocal;
import ServicesBean.TicketSessionBeanLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author francoiscaillet
 */
@Named(value = "backlogManagedBean")
@ManagedBean
@SessionScoped
public class BacklogManagedBean implements Serializable {
    
    @EJB
    private BacklogSessionBeanLocal backlogDAO;
    
    @EJB
    private TicketSessionBeanLocal ticketDAO;
    
    
    private Backlog backlog;

    private Collection<Ticket> tickets;
    
    private Ticket ticket;
    
    private Ticket editTicket;
    
    private Collection<Comment> displayedComments;

    /**
     * Creates a new instance of BacklogManagedBean
     */
    public BacklogManagedBean() {
        Comment comment = new Comment();
        this.ticket = new Ticket();
    }
    
    public void sortByPriority(){
        List list = new ArrayList(tickets);
        Collections.sort(list);
        setTickets(list);
    }
    
    public void edit(Ticket t){
        this.editTicket = t;
    }
    
     public void delete(Ticket t){
         this.tickets.remove(t);
        ticketDAO.deleteTicket(t);
    }
    
    
    public void newTicket(){
        ticket.setBacklog(backlog);
        backlog.addTicket(ticket);
        ticketDAO.saveTicket(ticket);
        this.tickets.add(ticket);
        setTicket(null);
        this.ticket = new Ticket();
         sortByPriority();
    }
    
     public void updateTicket(){
        ticketDAO.saveTicket(this.editTicket);
        this.setEditTicket(null);
         sortByPriority();
    }
     
    public void diplayTicketComments(Ticket t){
        displayedComments = t.getCommentsList();
    }
    
    public void undiplayTicketComments(){
        displayedComments = null;
    }
    
    public String goToEditPage(Backlog b){
        this.backlog = b;
        this.tickets = ticketDAO.getAllByBacklogId(this.backlog);
        sortByPriority(); 
        return "backlog?faces-redirect=true";
    }
    
    public Backlog getBacklog() {
        return backlog;
    }

    public void setBacklog(Backlog backlog) {
        this.backlog = backlog;
    }
    
    public Collection<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Collection<Ticket> tickets) {
        this.tickets = tickets;
    }
    
    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Ticket getEditTicket() {
        return editTicket;
    }

    public void setEditTicket(Ticket editTicket) {
        this.editTicket = editTicket;
    }
    
    
    public Collection<Comment> getDisplayedComments() {
        return displayedComments;
    }

    public void setDisplayedComments(Collection<Comment> displayedComments) {
        this.displayedComments = displayedComments;
    }

    

    
    
}
