/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.CommandeItem;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Soukaina
 */
public class CommandeItemDao {
    public  int save(CommandeItem commandeItem) throws SQLException{
        String requette ="INSERT INTO commandeitem VALUES(NULL,"+commandeItem.getPrix()+","+commandeItem.getQuantite()+","+commandeItem.getProduit().getId()+","+commandeItem.getCommande().getId()+")";
        return Connect.exec(requette);
    }
    
     public static List<CommandeItem> load(String requette) throws SQLException{
        ResultSet resultSet=Connect.load(requette);
         List<CommandeItem> commandeItems = new ArrayList<>();
        while(resultSet.next()){
            CommandeItem commandeItem= new CommandeItem();
            commandeItem.setId(resultSet.getInt("id"));
            commandeItem.setPrix(resultSet.getDouble("prix"));
            commandeItem.setQuantite(resultSet.getDouble("quantite"));
            commandeItem.getProduit().setId(resultSet.getInt("id_produit"));
            commandeItem.getCommande().setId(resultSet.getInt("id_commande"));
            commandeItems.add(commandeItem);
        }
        if(commandeItems.isEmpty())
            return null;
        return commandeItems;
    }
    public List<CommandeItem> findByIdCommande(int idCommande) throws SQLException {
       
         String requtte ="SELECT * FROM commandeitem WHERE id_commande="+idCommande;
         return load(requtte);
     }
     
}
