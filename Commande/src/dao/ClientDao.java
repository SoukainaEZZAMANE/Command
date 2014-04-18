/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Client;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Soukaina
 */
public class ClientDao {
     public static List<Client> load(String requette) throws SQLException{
        ResultSet resultSet=Connect.load(requette);
         List<Client> clients = new ArrayList<>();
        while(resultSet.next()){
            Client client= new Client();
            client.setId(resultSet.getInt("id"));
            client.setNom(resultSet.getString("nom"));
            client.setSolde(resultSet.getDouble("solde"));
            clients.add(client);
        }
        if(clients.isEmpty())
            return null;
        return clients;
    }
    public  Client findById(int id) throws SQLException{
        String requette ="SELECT * FROM client WHERE id="+id;
        List<Client> clients= load(requette);
        if(clients!=null){
            return clients.get(0);
        }
        return null;
    }
    
    public int update(Client client) throws SQLException{
          String requette ="UPDATE client SET solde ="+client.getSolde()+" where id="+client.getId();
          return Connect.exec(requette);
      }
    public List<Client> findAll() throws SQLException{
        String requette ="SELECT * FROM client";
        return load(requette);
    }
}
