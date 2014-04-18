/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Paiement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Soukaina
 */
public class PaiementDao {
    public  int save(Paiement paiement) throws SQLException{
        String requette ="INSERT INTO paiement VALUES(NULL,'"+paiement.getDatePaiement()+"',"+paiement.getMontant()+","+paiement.getCommande().getId()+")";
        return Connect.exec(requette);
    }
    
    public static List<Paiement> load(String requette) throws SQLException{
        ResultSet resultSet=Connect.load(requette);
         List<Paiement> paiements = new ArrayList<>();
        while(resultSet.next()){
            Paiement paiement= new Paiement();
            paiement.setId(resultSet.getInt("id"));
            paiement.setDatePaiement(resultSet.getString("datePaiement"));
            paiement.setMontant(resultSet.getDouble("montant"));
            paiement.getCommande().setId(resultSet.getInt("id_commande"));
            paiements.add(paiement);
        }
        if(paiements.isEmpty())
            return null;
        return paiements;
    }
    
    public List<Paiement> findByIdCommande(int idCommande) throws SQLException {
       
         String requtte ="SELECT * FROM paiement WHERE id_commande="+idCommande;
         return load(requtte);
     }
}
