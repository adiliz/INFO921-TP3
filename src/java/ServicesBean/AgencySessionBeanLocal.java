/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServicesBean;

import INFO921_TP3.Entities.Agency;
import java.util.Collection;
import javax.ejb.Local;


/**
 *
 * @author francoiscaillet
 */
@Local
public interface AgencySessionBeanLocal {
    void saveAgency(Agency agency);
    Agency findAgencyById(Long id);
    void deleteAgency(Agency agency);
    Collection<Agency> getAll();
}
