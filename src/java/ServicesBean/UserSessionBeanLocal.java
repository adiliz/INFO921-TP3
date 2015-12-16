/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServicesBean;

import INFO921_TP3.Entities.User;
import javax.ejb.Local;


/**
 *
 * @author Anthony
 */
@Local
public interface UserSessionBeanLocal {
    void saveUser(User user);
    User findUserById(Long id);
    void deleteUser(User user);
}
