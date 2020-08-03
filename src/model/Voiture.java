/**
 * 
 */
package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Cette classe permet de créer des voitures
 * @author Ambroise Mostin
 *
 */
public class Voiture implements Comparable<Voiture>{

	private String marque;
	private String type;
	private String puissance;
	private String bva;
	private String gps;
	private String porte;
	private String clim;
	private String etat;
	private String prix;
	private String prixKm;
	private String amende;
	private static int i = 0;
	/**
	 * Ce constructeur permet de créer une voiture automatiquement
	 * @param variete le numero correspond à un type de voiture
	 */
	public Voiture(int variete) {
		switch (variete) {
		case 0:
			this.marque = "marque_"+i;
			this.type = "type_"+i;
			this.puissance = "2000";
			this.bva = "oui";
			this.gps = "oui";
			this.porte = "3";
			this.clim = "oui";
			this.prix = "100";
			this.prixKm = "5.0";
			this.amende = "50.0";
			this.etat = "disponible";
			i++;
			break;
			
		case 1:
			this.marque = "marque_"+i;
			this.type = "type_"+i;
			this.puissance = "1800";
			this.bva = "non";
			this.gps = "oui";
			this.porte = "3";
			this.clim = "oui";
			this.prix = "90";
			this.prixKm = "4.5";
			this.amende = "45.0";
			this.etat = "disponible";
			i++;
			break;
			
		case 2:
			this.marque = "marque_"+i;
			this.type = "type_"+i;
			this.puissance = "1600";
			this.bva = "oui";
			this.gps = "non";
			this.porte = "3";
			this.clim = "non";
			this.prix = "80";
			this.prixKm = "4.0";
			this.amende = "40.0";
			this.etat = "disponible";
			i++;
			break;
			
		case 3:
			this.marque = "marque_"+i;
			this.type = "type_"+i;
			this.puissance = "1500";
			this.bva = "non";
			this.gps = "oui";
			this.porte = "5";
			this.clim = "oui";
			this.prix = "70";
			this.prixKm = "3.5";
			this.amende = "35.0";
			this.etat = "disponible";
			i++;
			break;
			
		case 4:
			this.marque = "marque_"+i;
			this.type = "type_"+i;
			this.puissance = "1400";
			this.bva = "oui";
			this.gps = "non";
			this.porte = "5";
			this.clim = "non";
			this.prix = "60";
			this.prixKm = "3.0";
			this.amende = "30.0";
			this.etat = "disponible";
			i++;
			break;
			
		case 5:
			this.marque = "marque_"+i;
			this.type = "type_"+i;
			this.puissance = "1300";
			this.bva = "non";
			this.gps = "non";
			this.porte = "3";
			this.clim = "non";
			this.prix = "50";
			this.prixKm = "2.5";
			this.amende = "25.0";
			this.etat = "disponible";
			i++;
			break;
			
		case 6:
			this.marque = "marque_"+i;
			this.type = "type_"+i;
			this.puissance = "1200";
			this.bva = "non";
			this.gps = "non";
			this.porte = "5";
			this.clim = "oui";
			this.prix = "40";
			this.prixKm = "2.0";
			this.amende = "20.0";
			this.etat = "disponible";
			i++;
			break;
			
		case 7:
			this.marque = "marque_"+i;
			this.type = "type_"+i;
			this.puissance = "1100";
			this.bva = "oui";
			this.gps = "oui";
			this.porte = "5";
			this.clim = "non";
			this.prix = "30";
			this.prixKm = "1.5";
			this.amende = "15.0";
			this.etat = "disponible";
			i++;
			break;
			
		case 8:
			this.marque = "marque_"+i;
			this.type = "type_"+i;
			this.puissance = "1000";
			this.bva = "non";
			this.gps = "oui";
			this.porte = "5";
			this.clim = "non";
			this.prix = "20";
			this.prixKm = "1.0";
			this.amende = "10.0";
			this.etat = "disponible";
			i++;
			break;
			
		case 9:
			this.marque = "marque_"+i;
			this.type = "type_"+i;
			this.puissance = "800";
			this.bva = "oui";
			this.gps = "non";
			this.porte = "5";
			this.clim = "oui";
			this.prix = "15";
			this.prixKm = "0.75";
			this.amende = "7.5";
			this.etat = "disponible";
			i++;
			break;
			
		

		default:
			break;
		}

	}
	/**
	 * Ce constructeur permet de créer une voiture selon les caractéristiques choisies
	 * @param marque marque de la voiture 
	 * @param type type de la voiture 
	 * @param puissance puissance de la voiture 
	 * @param bva boite de vitesse de la voiture 
	 * @param gps gps de la voiture 
	 * @param porte porte de la voiture 
	 * @param clim clim de la voiture 
	 * @param prix prix de la voiture 
	 * @param prixKm prixKm de la voiture 
	 * @param amende amende de la voiture 
	 */
	public Voiture(String marque, String type, String puissance, String bva, String gps, String porte, String clim, String prix, String prixKm, String amende) {
		this.marque = marque + '_' + i;
		this.type = type + '_' + i;
		this.puissance = puissance;
		this.bva = bva;
		this.gps = gps;
		this.porte = porte;
		this.clim = clim;
		this.prix = prix;
		this.prixKm = prixKm;
		this.amende = amende;
		this.etat = "disponible";
		i++;
	}
	@Override
	/**
	 * Cette méthode permet d'afficher les caractéristiques de la voiture
	 */
	public String toString() {
		return "marque=" + marque + ", type=" + type + ", puissance=" + puissance + ", bva=" + bva + ", gps="
				+ gps + ", porte=" + porte + ", clim=" + clim + ", etat=" + etat + ", prix=" + prix + ", prixKm=" + prixKm + ", amende=" + amende;
	}
	/**
	 * Cette méthode permet d'obtenir un identifant unique
	 */
	public static int getI() {
		return i;
	}
	/**
	 * Cette méthode permet de modifier l'identifant unique
	 */
	public static void setI(int i) {
		Voiture.i = i;
	}
	/**
	 * Cette méthode permet d'obtenir la marque
	 */
	public String getMarque() {
		return marque;
	}
	/**
	 * Cette méthode permet de modifier la marque
	 * @param marque la marque
	 */
	public void setMarque(String marque) {
		this.marque = marque;
	}
	/**
	 * Cette méthode permet d'obtenir le type
	 */
	public String getType() {
		return type;
	}
	/**
	 * Cette méthode permet de modifier le type
	 * @param type le type
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * Cette méthode permet d'obtenir la puissance
	 */
	public String getPuissance() {
		return puissance;
	}
	/**
	 * Cette méthode permet de modifier la puissance
	 * @param puissance la puissance
	 */
	public void setPuissance(String puissance) {
		this.puissance = puissance;
	}
	/**
	 * Cette méthode permet d'obtenir la boite de vitesse
	 */
	public String getBva() {
		return bva;
	}
	/**
	 * Cette méthode permet de modifier la boite de vitesse
	 * @param bva la boite de vitesse
	 */
	public void setBva(String bva) {
		this.bva = bva;
	}
	/**
	 * Cette méthode permet d'obtenir le gps
	 */
	public String getGps() {
		return gps;
	}
	/**
	 * Cette méthode permet de modifier le gps
	 * @param gps le gps
	 */
	public void setGps(String gps) {
		this.gps = gps;
	}
	/**
	 * Cette méthode permet d'obtenir le nombre de porte
	 */
	public String getPorte() {
		return porte;
	}
	/**
	 * Cette méthode permet de modifier le nombre de porte
	 * @param porte le nombre de porte
	 */
	public void setPorte(String porte) {
		this.porte = porte;
	}
	/**
	 * Cette méthode permet d'obtenir la clim
	 */
	public String getClim() {
		return clim;
	}
	/**
	 * Cette méthode permet de modifier la clim
	 * @param clim la clim
	 */
	public void setClim(String clim) {
		this.clim = clim;
	}
	/**
	 * Cette méthode permet d'obtenir l'état
	 */
	public String getEtat() {
		return etat;
	}
	/**
	 * Cette méthode permet de modifier l'état
	 * @param etat l'état de la voiture
	 */
	public void setEtat(String etat) {
		this.etat = etat;
	}
	/**
	 * Cette méthode permet d'obtenir le prix
	 */
	public String getPrix() {
		return prix;
	}
	/**
	 * Cette méthode permet de modifier le prix
	 * @param prix le prix
	 */
	public void setPrix(String prix) {
		this.prix = prix;
	}
	/**
	 * Cette méthode permet d'obtenir le prix au km
	 */
	public String getPrixKm() {
		return prixKm;
	}
	/**
	 * Cette méthode permet de modifier le prix au km
	 * @param prixKm le prix au km
	 */
	public void setPrixKm(String prixKm) {
		this.prixKm = prixKm;
	}
	/**
	 * Cette méthode permet d'obtenir l'amende
	 */
	public String getAmende() {
		return amende;
	}
	/**
	 * Cette méthode permet de modifier l'amende
	 * @param amende le montant de l'amende
	 */
	public void setAmende(String amende) {
		this.amende = amende;
	}

	@Override
	/**
	 * Cette méthode permet de comparer chaque voiture en fonction du prix
	 * @param voiture la voiture avec laquelle comparer
	 */
	public int compareTo(Voiture voiture) {
		return (int)(Integer.parseInt(this.prix) - Integer.parseInt(voiture.getPrix()));
	}
	/**
	 * Cette méthode permet de trier chaque voiture en fonction du prix
	 * @param voitureParPrix la liste des voitures par prix
	 */
	public static ArrayList<Voiture> tri(ArrayList<Voiture> voitureParPrix){
		Collections.sort(voitureParPrix);
		return voitureParPrix;
	}

}
