/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.Paiement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Soukaina
 */
public class PaiementHelper extends AbstractTableModel{
    
     private String[] titles = {"ID", "Date Paiement","Montant"};
    private List<Paiement> paiements = new ArrayList<>();

    @Override
    public int getRowCount() {
        return paiements.size();
    }

    @Override
    public int getColumnCount() {
        return titles.length;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(paiements!=null){
        if (rowIndex < paiements.size()) {
            switch (columnIndex) {
                case 0:
                    return paiements.get(rowIndex).getId();
                case 1:
                    return paiements.get(rowIndex).getDatePaiement();
                case 2:
                    return paiements.get(rowIndex).getMontant();
                default:
                    return null;
            }
        }}
        return null;
    }
    public Paiement getValueAt(int rowIndex) {
        if (rowIndex < paiements.size()) {
            return paiements.get(rowIndex);
        }
        return null;
    }

    public String[] getTitles() {
        return titles;
    }

    public void setTitles(String[] titles) {
        this.titles = titles;
    }

    public List<Paiement> getPaiements() {
        return paiements;
    }

    public void setPaiements(List<Paiement> paiements) {
        this.paiements = paiements;
    }
    
    @Override
    public String getColumnName(int column) {
        return titles[column];
    }
    
}
