/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Produit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Soukaina
 */
public class ProduitDao {
    
    public static List<Produit> load(String requette) throws SQLException{
        ResultSet resultSet=Connect.load(requette);
         List<Produit> produits = new ArrayList<>();
        while(resultSet.next()){
            Produit produit= new Produit();
            produit.setId(resultSet.getInt("id"));
            produit.setLibelle(resultSet.getString("libelle"));
            produit.setStock(resultSet.getDouble("stock"));
            produits.add(produit);
        }
        if(produits.isEmpty())
            return null;
        return produits;
    }
    public  Produit findById(int id) throws SQLException{
        String requette ="SELECT * FROM produit WHERE id="+id;
        List<Produit> produits= load(requette);
        if(produits!=null){
            return produits.get(0);
        }
        return null;
    }
    
    
    public int update(Produit produit) throws SQLException{
          String requette ="UPDATE produit SET stock ="+produit.getStock()+" where id="+produit.getId();
          return Connect.exec(requette);
      }
    public List<Produit> findAll() throws SQLException{
        String requette ="SELECT * FROM produit";
        return load(requette);
    }
}
