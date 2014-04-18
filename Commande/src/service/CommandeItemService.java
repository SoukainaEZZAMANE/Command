/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Client;
import bean.Commande;
import bean.CommandeItem;
import bean.Produit;
import dao.ClientDao;
import dao.CommandeDao;
import dao.CommandeItemDao;
import dao.ProduitDao;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Soukaina
 */
public class CommandeItemService {
    ProduitDao produitDao = new ProduitDao();
        ClientDao clientDao = new ClientDao();
         CommandeItemDao commandeItemDao = new CommandeItemDao();
         CommandeDao commandeDao = new CommandeDao();
         
    public int saveCommandeItem(CommandeItem commandeItem) throws SQLException {
        
        Produit produit = produitDao.findById(commandeItem.getProduit().getId());
         Commande commande = commandeDao.findById(commandeItem.getCommande().getId());
         Client client = clientDao.findById(commande.getClient().getId());
        
        if (produit != null ) {
            commandeItem.setProduit(produit);
            commandeItem.setCommande(commande);
            commandeItem.getCommande().setClient(client);
            
            
                if (commandeItem.getQuantite() <= commandeItem.getProduit().getStock())
                    {
                    Double nvStock = commandeItem.getProduit().getStock() - commandeItem.getQuantite();
                   Double nvSolde = commandeItem.getCommande().getClient().getSolde() + (commandeItem.getPrix()*commandeItem.getQuantite());
                    Double nvMontant = commandeItem.getCommande().getMontant() + (commandeItem.getPrix()*commandeItem.getQuantite());

                    commandeItem.getProduit().setStock(nvStock);
                    commandeItem.getCommande().getClient().setSolde(nvSolde);
                    commandeItem.getCommande().setMontant(nvMontant);
                    produitDao.update(produit);
                   clientDao.update(client);
                    commandeDao.update(commande);
                    commandeItemDao.save(commandeItem);

                    }
                else 
                    JOptionPane.showMessageDialog(null,"Votre stock n'est pas suffisant pour effectuer la commande","Echec",JOptionPane.ERROR_MESSAGE);
               } 
        
        return -1;
    }
    
    public List<Commande> findAll() throws SQLException{
        return commandeDao.findAll();
    }
    public List<CommandeItem> findByIdCommande(int idCommande) throws SQLException {
        return commandeItemDao.findByIdCommande(idCommande);
    }
}
