/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Commande;
import bean.Paiement;
import dao.CommandeDao;
import dao.PaiementDao;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Soukaina
 */
public class PaiementService {
             PaiementDao paiementDao = new PaiementDao();
             CommandeDao commandeDao = new CommandeDao();
        public int savePaiement(Paiement paiement) throws SQLException {
            
              Commande commande = commandeDao.findById(paiement.getCommande().getId());
                   if (commande != null) {                      
                        paiement.setCommande(commande);
                            if (paiement.getMontant() > 0)
                            {
                                  Double nvPaiement = paiement.getCommande().getPaiementActuel() + paiement.getMontant();
                                  paiement.getCommande().setPaiementActuel(nvPaiement);
                                  commandeDao.update1(commande);
                                  paiementDao.save(paiement);

                            }
                   }
            return -1;
        }
        
       public List<Paiement> findByIdCommande(int idCommande) throws SQLException {
        return paiementDao.findByIdCommande(idCommande);
    }
}
