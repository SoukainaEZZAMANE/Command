/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Commande;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Soukaina
 */
public class CommandeDao {
    public static List<Commande> load(String requette) throws SQLException{
        ResultSet resultSet=Connect.load(requette);
         List<Commande> commandes = new ArrayList<>();
        while(resultSet.next()){
            Commande commande= new Commande();
            commande.setId(resultSet.getInt("id"));
            commande.setDateCommande(resultSet.getString("dateCommande"));
            commande.setDateEcheance(resultSet.getString("dateEcheance"));
            commande.setMontant(resultSet.getDouble("montant"));
            commande.setPaiementActuel(resultSet.getDouble("paiementActuel"));
            commande.getClient().setId(resultSet.getInt("id_client"));
            commandes.add(commande);
        }
        if(commandes.isEmpty())
            return null;
        return commandes;
    }
    public  Commande findById(int id) throws SQLException{
        String requette ="SELECT * FROM commande WHERE id="+id;
        List<Commande> commandes= load(requette);
        if(commandes!=null){
            return commandes.get(0);
        }
        return null;
    }
    public static int save(Commande commande) throws SQLException{
        String requette ="INSERT INTO commande VALUES(NULL,'"+commande.getDateCommande()+"','"+commande.getDateEcheance()+"',"+commande.getMontant()+","+commande.getPaiementActuel()+","+commande.getClient().getId()+")";
        return Connect.exec(requette);
    }
    public int update(Commande commande) throws SQLException{
          String requette ="UPDATE commande SET montant ="+commande.getMontant()+" where id="+commande.getId();
          return Connect.exec(requette);
      }
    public int update1(Commande commande) throws SQLException{
          String requette ="UPDATE commande SET paiementActuel ="+commande.getPaiementActuel()+" where id="+commande.getId();
          return Connect.exec(requette);
      }
    public List<Commande> findAll() throws SQLException{
        String requette ="SELECT * FROM commande";
        return load(requette);
    }
}
