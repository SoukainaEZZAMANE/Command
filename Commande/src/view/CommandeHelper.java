/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.Commande;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Soukaina
 */
public class CommandeHelper extends AbstractTableModel {
    private String[] titles = {"ID", "DATE COMMANDE","DATE ECHEANCE","MONTANT","PAIEMENT ACTUEL","ID CLIENT"};
    private List<Commande> commandes = new ArrayList<>();

    @Override
    public int getRowCount() {
        return commandes.size();
    }

    @Override
    public int getColumnCount() {
        return titles.length;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(commandes!=null){
        if (rowIndex < commandes.size()) {
            switch (columnIndex) {
                case 0:
                    return commandes.get(rowIndex).getId();
                case 1:
                    return commandes.get(rowIndex).getDateCommande();
                case 2:
                    return commandes.get(rowIndex).getDateEcheance();
                case 3:
                    return commandes.get(rowIndex).getMontant();
                case 4:
                    return commandes.get(rowIndex).getPaiementActuel();
                case 5:
                    return commandes.get(rowIndex).getClient().getId();
                default:
                    return null;
            }
        }}
        return null;
    }
    public Commande getValueAt(int rowIndex) {
        if (rowIndex < commandes.size()) {
            return commandes.get(rowIndex);
        }
        return null;
    }

    public String[] getTitles() {
        return titles;
    }

    public void setTitles(String[] titles) {
        this.titles = titles;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }
    @Override
    public String getColumnName(int column) {
        return titles[column];
    }
    
}
