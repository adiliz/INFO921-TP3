/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServicesBean;

import INFO921_TP3.Entities.Backlog;
import javax.ejb.Local;

/**
 *
 * @author francoiscaillet
 */
@Local
public interface BacklogSessionBeanLocal {
    Backlog findBacklogById(Long id);
}
