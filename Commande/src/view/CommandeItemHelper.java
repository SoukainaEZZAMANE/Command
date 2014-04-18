/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.CommandeItem;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Soukaina
 */
public class CommandeItemHelper extends AbstractTableModel{
    private String[] titles = {"ID", "PRIX","QUANTITE","ID PRODUIT"};
    private List<CommandeItem> commandeItems = new ArrayList<>();

    @Override
    public int getRowCount() {
        return commandeItems.size();
    }

    @Override
    public int getColumnCount() {
        return titles.length;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(commandeItems!=null){
        if (rowIndex < commandeItems.size()) {
            switch (columnIndex) {
                case 0:
                    return commandeItems.get(rowIndex).getId();
                case 1:
                    return commandeItems.get(rowIndex).getPrix();
                case 2:
                    return commandeItems.get(rowIndex).getQuantite();
                case 3:
                    return commandeItems.get(rowIndex).getProduit().getId();
                default:
                    return null;
            }
        }}
        return null;
    }
    public CommandeItem getValueAt(int rowIndex) {
        if (rowIndex < commandeItems.size()) {
            return commandeItems.get(rowIndex);
        }
        return null;
    }

    public String[] getTitles() {
        return titles;
    }

    public void setTitles(String[] titles) {
        this.titles = titles;
    }

    public List<CommandeItem> getCommandeItems() {
        return commandeItems;
    }

    public void setCommandeItems(List<CommandeItem> commandeItems) {
        this.commandeItems = commandeItems;
    }
    
    @Override
    public String getColumnName(int column) {
        return titles[column];
    }
}
