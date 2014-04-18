/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Soukaina
 */
public class Commande {
    private Integer id;
    private String DateCommande;
    private String DateEcheance;
    private Double montant;
    private Double paiementActuel;
    private Client client= new Client();
    private List<CommandeItem> commandeItems = new ArrayList<>();
    private List<Paiement> paiements = new ArrayList<>();

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<CommandeItem> getCommandeItems() {
        return commandeItems;
    }

    public void setCommandeItems(List<CommandeItem> commandeItems) {
        this.commandeItems = commandeItems;
    }

    public List<Paiement> getPaiements() {
        return paiements;
    }

    public void setPaiements(List<Paiement> paiements) {
        this.paiements = paiements;
    }


    public String getDateCommande() {
        return DateCommande;
    }

    public void setDateCommande(String DateCommande) {
        this.DateCommande = DateCommande;
    }

    public String getDateEcheance() {
        return DateEcheance;
    }

    public void setDateEcheance(String DateEcheance) {
        this.DateEcheance = DateEcheance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public Double getPaiementActuel() {
        return paiementActuel;
    }

    public void setPaiementActuel(Double paiementActuel) {
        this.paiementActuel = paiementActuel;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Commande other = (Commande) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public String toString() {
        return "Commande{" + "id=" + id + ", DateCommande=" + DateCommande + ", DateEcheance=" + DateEcheance + ", montant=" + montant + ", paiementActuel=" + paiementActuel + ", client=" + client + ", commandeItems=" + commandeItems + ", paiements=" + paiements + '}';
    }

   
    
}
