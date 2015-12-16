/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package INFO921_TP3.ManagedBean;

import INFO921_TP3.Entities.Comment;
import INFO921_TP3.Entities.Ticket;
import INFO921_TP3.Entities.User;
import ServicesBean.CommentSessionBeanLocal;
import ServicesBean.UserSessionBeanLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author francoiscaillet
 */
@Named(value = "userManagedBean")
@ManagedBean
@SessionScoped
public class UserManagedBean implements Serializable {
    
    private User user;
    
    @EJB
    private UserSessionBeanLocal userDAO;
    
    @EJB
    private CommentSessionBeanLocal commentDAO;
    
    private Comment comment;
    
    

    public String signIn(){
        String page="agencies?faces-redirect=true";
        userDAO.saveUser(user);
        return page;
    }
    
     public void initComment(Ticket t){
         this.comment = new Comment();
        this.comment.setOwner(user);
        this.comment.setTicket(t);
        
    }
    public void addComment(){
        user.getCommentsList().add(comment);
        commentDAO.saveComment(comment);
        comment.getTicket().addComment(comment);
        setComment(null);
        
    }
    
    /**
     * Creates a new instance of UserManagedBean
     */
    public UserManagedBean() {
        this.user = new User(); 
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }
}