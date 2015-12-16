/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package INFO921_TP3.Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Anthony
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "findByBacklogId", query = "SELECT t FROM Ticket t WHERE t.backlog = :curBacklog")
}) 
public class Ticket implements Serializable, Comparable<Ticket> {

    public Ticket() {
        this.creation_date = new Date();
    }
    
    public static final String GET_TICKET_BY_BACKLOG_ID = "findByBacklogId";

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Date creation_date;
    private Integer priority;
    private Integer estimation;
    private String description;
    @OneToMany(mappedBy="ticket", fetch = FetchType.LAZY)
    private List<Comment> commentsList;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="BACKLOG_ID")
    private Backlog backlog;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public Integer getEstimation() {
        return estimation;
    }

    public void setEstimation(Integer estimation) {
        this.estimation = estimation;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Comment> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(List<Comment> commentsList) {
        this.commentsList = commentsList;
    }

    public Backlog getBacklog() {
        return backlog;
    }

    public void setBacklog(Backlog backlog) {
        this.backlog = backlog;
    }
    
      public void addComment(Comment comment) {
        this.commentsList.add(comment);
        if (comment.getTicket()!= this) {
            comment.setTicket(this);
        }
    }
   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ticket)) {
            return false;
        }
        Ticket other = (Ticket) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "INFO921_TP3.Entities.Ticket[ id=" + id + " ]";
    }

    @Override
    public int compareTo(Ticket o) {
        return (this.priority).compareTo(o.priority);
    }
    
}
