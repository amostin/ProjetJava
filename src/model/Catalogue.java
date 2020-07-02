/**
 * 
 */
package model;

import java.util.HashMap;

/**
 * Cette classe est utile � cr�er automatiquement un catalogue au lancement de l'application
 * @author Ambroise Mostin
 *
 */
public class Catalogue {

	private HashMap<String, Voiture> catalogue = new HashMap<>();
	private String[] nomVoitures = new String[10];
	private Voiture[] voitures = new Voiture[10];
	private int nbVoitures = 10;
	/**
	 * Ce constructeur permet de cr�er un catalogue avec 10 noms de voiture et 10 voitures
	 */
	public Catalogue() {
		createNomVoitures(nbVoitures);
		createVoitures(nbVoitures);
		addVoitures(nomVoitures, voitures);
	}
	/**
	 * Ce constructeur permet d'acc�der aux methodes (surtout addVoitures) pour gerer les catalogue
	 */
	public Catalogue(boolean faux) {
		//acc�s au catalogue sans en cr�er un
	}
	
	public HashMap<String, Voiture> getCatalogue() {
		return catalogue;
	}
	public void setCatalogue(HashMap<String, Voiture> catalogue) {
		this.catalogue = catalogue;
	}
	/**
	 * Cette m�thode permet de cr�er des cl�s pour hashmap (rempli tableau nomVoiture)
	 */
	public void createNomVoitures(int nbVoitures) {
		for(int i = 0; i<nbVoitures; i++) {
			nomVoitures[i] = new String("nomVoiture_"+i);
		}
	}
	/**
	 * Cette m�thode permet de cr�er des valeurs pour hashmap (rempli tableau voitures)
	 */
	public void createVoitures(int nbVoitures) {
		for(int i = 0; i<nbVoitures; i++) {
			voitures[i] = new Voiture();
		}
	}
	/**
	 * Cette m�thode permet de cr�er un catalogue a partir des nomvoiture et des voitures
	 */
	public void addVoitures(String[] nomVoitures, Voiture[] voitures) {
		for(int i = 0; i<10; i++) {
			catalogue.put(nomVoitures[i], voitures[i]);
		}
	}
	
	/*
	public static void main(String[] args) {
		Catalogue c = new Catalogue();
		for (String i : c.catalogue.keySet()) {
			  System.out.println("key: " + i + " value: " + c.catalogue.get(i).toString());
			}
	}
	*/
}
