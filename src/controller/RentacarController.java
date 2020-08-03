/**
 * 
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;

import model.Rentacar;
import model.Rentacar;
import model.Voiture;
import view.AjoutVoitureVue;
import view.ConnexionVue;
import view.RentacarVue;

/**
 * Cette classe permet d'appeler les méthodes du model lorsqu'elle sont appelées par la vue
 * @author Ambroise Mostin
 *
 */
public class RentacarController {
	//Catalogue model; 
	Rentacar model;
	RentacarVue vue;
	AjoutVoitureVue ajoutVoitureVue;
	/**
	 * Cette méthode permet de lier le model au controller dans RentacarMVC
	 * @param model la classe Rentacar
	 * @see rentacar.RentacarMVC#RentacarMVC()
	 * @see model.Rentacar#Rentacar()
	 */
	public RentacarController(Rentacar model) {
		this.model = model;
	}
	/**
	 * Cette méthode permet d'ajouter la vue dans RentacarMVC
	 * @param gui la classe RentacarVue
	 * @see rentacar.RentacarMVC#RentacarMVC()
	 */
	public void addView(RentacarVue gui) {
		this.vue = gui;
	}	
	/**
	 * Cette méthode permet d'appeler la méthode d'ajout de véhicule dans le model
	 * @param nomVoiture le nom de la voiture au format "nomVoiture_numero"
	 * @param voiture la voiture
	 * @see model.Rentacar#addVoiture(String, Voiture)
	 */
	public void ajoutVoiture(String nomVoiture, Voiture voiture) {
		model.addVoiture(nomVoiture, voiture);
	}
	/**
	 * Cette méthode permet d'appeler la méthode de changement d'état du véhicule dans le model
	 * @param numVehicule le numéro du véhicule à supprimer
	 * @see model.Rentacar#changEtat(int, String)
	 */
	public void supprimeVehicule(int numVehicule) {
		model.changEtat(numVehicule, "Supprimé");
	}
	/**
	 * Cette méthode permet d'appeler la méthode de changement d'état du véhicule dans le model
	 * @param numVehiculeRepa le numéro du véhicule à réparer
	 * @see model.Rentacar#changEtat(int, String)
	 */
	public void repaVehicule(int numVehiculeRepa) {
		model.changEtat(numVehiculeRepa, "En réparation");
	}
	/**
	 * Cette méthode permet d'appeler la méthode de changement d'état du véhicule dans le model
	 * @param numVehiculeEntr le numéro du véhicule à entretenir
	 * @see model.Rentacar#changEtat(int, String)
	 */
	public void entrVehicule(int numVehiculeEntr) {
		model.changEtat(numVehiculeEntr, "En entretien");
	}
	/**
	 * Cette méthode permet d'appeler la méthode de changement d'état du véhicule dans le model
	 * @param numVehiculeReser le numéro du véhicule à réserver
	 * @see model.Rentacar#changEtat(int, String)
	 */
	public void reserveVehicule(int numVehiculeReser) {
		model.changEtat(numVehiculeReser, "Réservé");
	}
	/**
	 * Cette méthode permet d'appeler la méthode de filtre du catalogue
	 * @param marqueFiltre le filtre choisi pour la marque (tout ou une des marques présente dans le catalogue)
	 * @param puisMinFiltre le filtre choisi pour la puissance (tout ou une des puissances présente dans le catalogue)
	 * @param bvaFiltre le filtre choisi pour la boite de vitesse automatique (tout ou oui ou non)
	 * @param gpsFiltre le filtre choisi pour le gps (tout ou oui ou non)
	 * @param porteFiltre le filtre choisi pour le nombre de porte (tout ou 3 ou 5)
	 * @param climFiltre le filtre choisi pour la clim (tout ou oui ou non)
	 * @param prixFiltre le filtre choisi pour le prix (tout ou un des prix présent dans le catalogue)
	 * @param prixKmFiltre le filtre choisi pour l'amende au Km (tout ou une des amendes au Km présente dans le catalogue)
	 * @param amendeFiltre le filtre choisi pour l'amende journalière (tout ou une des amendes journalière présente dans le catalogue)
	 * @see model.Rentacar#filtre(Object, Object, Object, Object, Object, Object, Object, Object, Object)
	 */
	public void filtre(Object marqueFiltre, Object puisMinFiltre, Object bvaFiltre,
			Object gpsFiltre, Object porteFiltre, Object climFiltre, Object prixFiltre, Object prixKmFiltre, Object amendeFiltre) {
		model.filtre(marqueFiltre, puisMinFiltre, bvaFiltre,
				gpsFiltre, porteFiltre, climFiltre, prixFiltre, prixKmFiltre, amendeFiltre);
	}
	/**
	 * Cette méthode permet d'appeler la méthode de modification du montant des formules de tarif
	 * @param jourFormuleTextField le montant de la formule par jour
	 * @param weFormuleTextField le montant de la formule par weekend
	 * @param weekFormuleTextField le montant de la formule par semaine
	 * @see model.Rentacar#modifFormule(String, String, String)
	 */
	public void modifFormule(String jourFormuleTextField, String weFormuleTextField, String weekFormuleTextField) {
		model.modifFormule(jourFormuleTextField, weFormuleTextField, weekFormuleTextField);
	}
	/**
	 * Cette méthode permet d'appeler la méthode de tri dans le model
	 * @return arraylist contenant le catalogue trié
	 * @see model.Rentacar#tri()
	 * @see Voiture#tri(ArrayList)
	 */
	public ArrayList<Voiture> tri() {
		return model.tri();
	}
	/**
	 * Cette méthode permet d'appeler la méthode pour lire dans le fichier clients, écrire dedans si le client est nouveau et écrire la réservation
	 * @param idReservationLabel identifiant de la commande (le chiffre doit correspondre à une voiture du catalogue)
	 * @param nomClientTextField nom du client pour la commande 
	 * @param dateDebutTextField date de début de la réservation
	 * @param dateFinTextField date de fin de la réservation
	 * @param formuleCombo formule de tarif choisie
	 * @exception IOException si il y a un probléme lors de la manipulation du fichier
	 * @see Rentacar#ajoutReservation(String, String, String, String, String)
	 */
	public void ajoutReservation(String idReservationLabel, String nomClientTextField, String dateDebutTextField, String dateFinTextField, String formuleCombo) {
		model.ajoutReservation(idReservationLabel, nomClientTextField, dateDebutTextField, dateFinTextField, formuleCombo);
	}
	/**
	 * Cette méthode permet d'appeler la méthode qui permet d'écrire dans le fichier locations
	 * @param idLocationTextField identifiant de la commande (le chiffre doit correspondre à une voiture du catalogue)
	 * @param nomClientTextField nom du client pour la commande 
	 * @param dateDebutTextField date de début de la réservation
	 * @param dateFinTextField date de fin de la réservation
	 * @param kmTextField kilométrage courant ou prix facture
	 * @see Rentacar#ajoutLocation(String, String, String, String, String)
	 */
	public void ajoutLocation(String idReservationTextField, String nomClientTextField, String dateDebutTextField, String dateFinTextField, String kmTextField) {
		model.ajoutLocation(idReservationTextField, nomClientTextField, dateDebutTextField, dateFinTextField, kmTextField);
	}
	/**
	 * Cette méthode permet d'appeler la méthode pour écrire dans le fichier restitutions
	 * @param idLocationTextField identifiant de la commande (le chiffre doit correspondre à une voiture du catalogue)
	 * @param nomClientTextField nom du client pour la commande 
	 * @param dateDebutTextField date de début de la réservation
	 * @param dateFinTextField date de fin de la réservation
	 * @param kmTextField kilométrage courant ou prix facture
	 * @see Rentacar#ajoutRestitution(String, String, String, String, String)
	 */
	public void ajoutRestitution(String idLocationTextField, String nomClientTextField, String dateDebutTextField, String dateFinTextField, String kmTextField) {
		model.ajoutRestitution(idLocationTextField, nomClientTextField, dateDebutTextField, dateFinTextField, kmTextField);		
	}
	/**
	 * Cette méthode permet d'appeler la méthode pour écrire et calculer la facture en tenant compte des amendes
	 * @param idRestitutionTextField identifiant de la commande (le chiffre doit correspondre à une voiture du catalogue)
	 * @param nomClientTextField nom du client pour la commande 
	 * @param dateDebutTextField date de début de la réservation
	 * @param dateFinTextField date de fin de la restitution
	 * @see Rentacar#ajoutFacture(String, String, String, String)
	 */
	public void ajoutFacture(String idRestitutionTextField, String nomClientTextField, String dateDebutTextField, String dateFinTextField) {
		model.ajoutFacture(idRestitutionTextField, nomClientTextField, dateDebutTextField, dateFinTextField);		
	}
	/**
	 * Cette méthode permet d'appeler la méthode pour lire dans le fichier reservations
	 * @param idReservationTextField identifiant de la commande (le chiffre doit correspondre à une voiture du catalogue)
	 * @param nomClientTextField nom du client 
	 * @return <code>true</code> si l'identifiant et le nom correspondent bien à une commande
	 * @see Rentacar#verifReser(String, String)
	 */
	public boolean verifReser(String idReservationTextField, String nomClientTextField) {
		return model.verifReser(idReservationTextField, nomClientTextField);
	}
	/**
	 * Cette méthode permet d'appeler la méthode pour lire dans le fichier locations
	 * @param idReservationTextField identifiant de la commande (le chiffre doit correspondre à une voiture du catalogue)
	 * @param nomClientTextField nom du client 
	 * @return <code>true</code> si l'identifiant et le nom correspondent bien à une commande
	 * @see Rentacar#verifLoc(String, String)
	 */
	public boolean verifLoc(String idLocationTextField, String nomClientTextField) {
		return model.verifLoc(idLocationTextField, nomClientTextField);
	}
	/**
	 * Cette méthode permet d'appeler la méthode pour lire dans le fichier restitutions
	 * @param idReservationTextField identifiant de la commande (le chiffre doit correspondre à une voiture du catalogue)
	 * @param nomClientTextField nom du client 
	 * @return <code>true</code> si l'identifiant et le nom correspondent bien à une commande
	 * @see Rentacar#verifRestitution(String, String)
	 */
	public boolean verifRestitution(String idRestitutionTextField, String nomClientTextField) {
		return model.verifRestitution(idRestitutionTextField, nomClientTextField);
	}
}
