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
 * Cette classe permet d'appeler les m�thodes du model lorsqu'elle sont appel�es par la vue
 * @author Ambroise Mostin
 *
 */
public class RentacarController {
	//Catalogue model; 
	Rentacar model;
	RentacarVue vue;
	AjoutVoitureVue ajoutVoitureVue;
	/**
	 * Cette m�thode permet de lier le model au controller dans RentacarMVC
	 * @param model la classe Rentacar
	 * @see rentacar.RentacarMVC#RentacarMVC()
	 * @see model.Rentacar#Rentacar()
	 */
	public RentacarController(Rentacar model) {
		this.model = model;
	}
	/**
	 * Cette m�thode permet d'ajouter la vue dans RentacarMVC
	 * @param gui la classe RentacarVue
	 * @see rentacar.RentacarMVC#RentacarMVC()
	 */
	public void addView(RentacarVue gui) {
		this.vue = gui;
	}	
	/**
	 * Cette m�thode permet d'appeler la m�thode d'ajout de v�hicule dans le model
	 * @param nomVoiture le nom de la voiture au format "nomVoiture_numero"
	 * @param voiture la voiture
	 * @see model.Rentacar#addVoiture(String, Voiture)
	 */
	public void ajoutVoiture(String nomVoiture, Voiture voiture) {
		model.addVoiture(nomVoiture, voiture);
	}
	/**
	 * Cette m�thode permet d'appeler la m�thode de changement d'�tat du v�hicule dans le model
	 * @param numVehicule le num�ro du v�hicule � supprimer
	 * @see model.Rentacar#changEtat(int, String)
	 */
	public void supprimeVehicule(int numVehicule) {
		model.changEtat(numVehicule, "Supprim�");
	}
	/**
	 * Cette m�thode permet d'appeler la m�thode de changement d'�tat du v�hicule dans le model
	 * @param numVehiculeRepa le num�ro du v�hicule � r�parer
	 * @see model.Rentacar#changEtat(int, String)
	 */
	public void repaVehicule(int numVehiculeRepa) {
		model.changEtat(numVehiculeRepa, "En r�paration");
	}
	/**
	 * Cette m�thode permet d'appeler la m�thode de changement d'�tat du v�hicule dans le model
	 * @param numVehiculeEntr le num�ro du v�hicule � entretenir
	 * @see model.Rentacar#changEtat(int, String)
	 */
	public void entrVehicule(int numVehiculeEntr) {
		model.changEtat(numVehiculeEntr, "En entretien");
	}
	/**
	 * Cette m�thode permet d'appeler la m�thode de changement d'�tat du v�hicule dans le model
	 * @param numVehiculeReser le num�ro du v�hicule � r�server
	 * @see model.Rentacar#changEtat(int, String)
	 */
	public void reserveVehicule(int numVehiculeReser) {
		model.changEtat(numVehiculeReser, "R�serv�");
	}
	/**
	 * Cette m�thode permet d'appeler la m�thode de filtre du catalogue
	 * @param marqueFiltre le filtre choisi pour la marque (tout ou une des marques pr�sente dans le catalogue)
	 * @param puisMinFiltre le filtre choisi pour la puissance (tout ou une des puissances pr�sente dans le catalogue)
	 * @param bvaFiltre le filtre choisi pour la boite de vitesse automatique (tout ou oui ou non)
	 * @param gpsFiltre le filtre choisi pour le gps (tout ou oui ou non)
	 * @param porteFiltre le filtre choisi pour le nombre de porte (tout ou 3 ou 5)
	 * @param climFiltre le filtre choisi pour la clim (tout ou oui ou non)
	 * @param prixFiltre le filtre choisi pour le prix (tout ou un des prix pr�sent dans le catalogue)
	 * @param prixKmFiltre le filtre choisi pour l'amende au Km (tout ou une des amendes au Km pr�sente dans le catalogue)
	 * @param amendeFiltre le filtre choisi pour l'amende journali�re (tout ou une des amendes journali�re pr�sente dans le catalogue)
	 * @see model.Rentacar#filtre(Object, Object, Object, Object, Object, Object, Object, Object, Object)
	 */
	public void filtre(Object marqueFiltre, Object puisMinFiltre, Object bvaFiltre,
			Object gpsFiltre, Object porteFiltre, Object climFiltre, Object prixFiltre, Object prixKmFiltre, Object amendeFiltre) {
		model.filtre(marqueFiltre, puisMinFiltre, bvaFiltre,
				gpsFiltre, porteFiltre, climFiltre, prixFiltre, prixKmFiltre, amendeFiltre);
	}
	/**
	 * Cette m�thode permet d'appeler la m�thode de modification du montant des formules de tarif
	 * @param jourFormuleTextField le montant de la formule par jour
	 * @param weFormuleTextField le montant de la formule par weekend
	 * @param weekFormuleTextField le montant de la formule par semaine
	 * @see model.Rentacar#modifFormule(String, String, String)
	 */
	public void modifFormule(String jourFormuleTextField, String weFormuleTextField, String weekFormuleTextField) {
		model.modifFormule(jourFormuleTextField, weFormuleTextField, weekFormuleTextField);
	}
	/**
	 * Cette m�thode permet d'appeler la m�thode de tri dans le model
	 * @return arraylist contenant le catalogue tri�
	 * @see model.Rentacar#tri()
	 * @see Voiture#tri(ArrayList)
	 */
	public ArrayList<Voiture> tri() {
		return model.tri();
	}
	/**
	 * Cette m�thode permet d'appeler la m�thode pour lire dans le fichier clients, �crire dedans si le client est nouveau et �crire la r�servation
	 * @param idReservationLabel identifiant de la commande (le chiffre doit correspondre � une voiture du catalogue)
	 * @param nomClientTextField nom du client pour la commande 
	 * @param dateDebutTextField date de d�but de la r�servation
	 * @param dateFinTextField date de fin de la r�servation
	 * @param formuleCombo formule de tarif choisie
	 * @exception IOException si il y a un probl�me lors de la manipulation du fichier
	 * @see Rentacar#ajoutReservation(String, String, String, String, String)
	 */
	public void ajoutReservation(String idReservationLabel, String nomClientTextField, String dateDebutTextField, String dateFinTextField, String formuleCombo) {
		model.ajoutReservation(idReservationLabel, nomClientTextField, dateDebutTextField, dateFinTextField, formuleCombo);
	}
	/**
	 * Cette m�thode permet d'appeler la m�thode qui permet d'�crire dans le fichier locations
	 * @param idLocationTextField identifiant de la commande (le chiffre doit correspondre � une voiture du catalogue)
	 * @param nomClientTextField nom du client pour la commande 
	 * @param dateDebutTextField date de d�but de la r�servation
	 * @param dateFinTextField date de fin de la r�servation
	 * @param kmTextField kilom�trage courant ou prix facture
	 * @see Rentacar#ajoutLocation(String, String, String, String, String)
	 */
	public void ajoutLocation(String idReservationTextField, String nomClientTextField, String dateDebutTextField, String dateFinTextField, String kmTextField) {
		model.ajoutLocation(idReservationTextField, nomClientTextField, dateDebutTextField, dateFinTextField, kmTextField);
	}
	/**
	 * Cette m�thode permet d'appeler la m�thode pour �crire dans le fichier restitutions
	 * @param idLocationTextField identifiant de la commande (le chiffre doit correspondre � une voiture du catalogue)
	 * @param nomClientTextField nom du client pour la commande 
	 * @param dateDebutTextField date de d�but de la r�servation
	 * @param dateFinTextField date de fin de la r�servation
	 * @param kmTextField kilom�trage courant ou prix facture
	 * @see Rentacar#ajoutRestitution(String, String, String, String, String)
	 */
	public void ajoutRestitution(String idLocationTextField, String nomClientTextField, String dateDebutTextField, String dateFinTextField, String kmTextField) {
		model.ajoutRestitution(idLocationTextField, nomClientTextField, dateDebutTextField, dateFinTextField, kmTextField);		
	}
	/**
	 * Cette m�thode permet d'appeler la m�thode pour �crire et calculer la facture en tenant compte des amendes
	 * @param idRestitutionTextField identifiant de la commande (le chiffre doit correspondre � une voiture du catalogue)
	 * @param nomClientTextField nom du client pour la commande 
	 * @param dateDebutTextField date de d�but de la r�servation
	 * @param dateFinTextField date de fin de la restitution
	 * @see Rentacar#ajoutFacture(String, String, String, String)
	 */
	public void ajoutFacture(String idRestitutionTextField, String nomClientTextField, String dateDebutTextField, String dateFinTextField) {
		model.ajoutFacture(idRestitutionTextField, nomClientTextField, dateDebutTextField, dateFinTextField);		
	}
	/**
	 * Cette m�thode permet d'appeler la m�thode pour lire dans le fichier reservations
	 * @param idReservationTextField identifiant de la commande (le chiffre doit correspondre � une voiture du catalogue)
	 * @param nomClientTextField nom du client 
	 * @return <code>true</code> si l'identifiant et le nom correspondent bien � une commande
	 * @see Rentacar#verifReser(String, String)
	 */
	public boolean verifReser(String idReservationTextField, String nomClientTextField) {
		return model.verifReser(idReservationTextField, nomClientTextField);
	}
	/**
	 * Cette m�thode permet d'appeler la m�thode pour lire dans le fichier locations
	 * @param idReservationTextField identifiant de la commande (le chiffre doit correspondre � une voiture du catalogue)
	 * @param nomClientTextField nom du client 
	 * @return <code>true</code> si l'identifiant et le nom correspondent bien � une commande
	 * @see Rentacar#verifLoc(String, String)
	 */
	public boolean verifLoc(String idLocationTextField, String nomClientTextField) {
		return model.verifLoc(idLocationTextField, nomClientTextField);
	}
	/**
	 * Cette m�thode permet d'appeler la m�thode pour lire dans le fichier restitutions
	 * @param idReservationTextField identifiant de la commande (le chiffre doit correspondre � une voiture du catalogue)
	 * @param nomClientTextField nom du client 
	 * @return <code>true</code> si l'identifiant et le nom correspondent bien � une commande
	 * @see Rentacar#verifRestitution(String, String)
	 */
	public boolean verifRestitution(String idRestitutionTextField, String nomClientTextField) {
		return model.verifRestitution(idRestitutionTextField, nomClientTextField);
	}
}
