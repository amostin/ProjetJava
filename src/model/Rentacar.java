/**
 * 
 */
package model;

import java.util.HashMap;
import java.util.Observable;

/**
 * Cette classe est utile � cr�er automatiquement un catalogue au lancement de l'application
 * @author Ambroise Mostin
 *
 */
public class Rentacar extends Observable{

	private HashMap<String, Voiture> catalogue = new HashMap<>();
	private String[] nomVoitures = new String[10];
	private Voiture[] voitures = new Voiture[10];
	//private int nbVoitures = 10;
	/**
	 * Ce constructeur permet de cr�er un catalogue avec 10 noms de voiture et 10 voitures
	 */
	public Rentacar() {
		createNomVoitures();
		createVoitures();
		addVoitures(nomVoitures, voitures);
	}
	/**
	 * Ce constructeur permet d'acc�der aux methodes (surtout addVoitures) pour gerer les catalogue
	 */
	public Rentacar(boolean faux) {
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
	public String[] createNomVoitures() {
		for(int i = 0; i<10; i++) {
			nomVoitures[i] = new String("nomVoiture_"+i);
		}
		return nomVoitures;
	}
	/**
	 * Cette m�thode permet de cr�er des valeurs pour hashmap (rempli tableau voitures)
	 */
	public Voiture[] createVoitures() {
		for(int i = 0; i<10; i++) {
			voitures[i] = new Voiture();
		}
		return voitures;
	}
	/**
	 * Cette m�thode permet de cr�er un catalogue a partir des nomvoiture et des voitures
	 */
	public HashMap<String, Voiture> addVoitures(String[] nomVoitures, Voiture[] voitures) {
		for(int i = 0; i<10; i++) {
			catalogue.put(nomVoitures[i], voitures[i]);
		}
		return catalogue;
	}
	/**
	 * Cette m�thode permet d'ajouter une voiture au catalogue
	 */
	public boolean addVoiture(String nomVoiture, Voiture voiture) {
		try {
			catalogue.put(nomVoiture, voiture);
			setChanged();
			notifyObservers();
			return true;
		} catch (NullPointerException e) {
			throw new IllegalStateException("nomVoiture ou voiture pointe sur null", e);
		}
	}
	
	public void supprimeVehicule(int numVehicule) {
		try {
			catalogue.remove("nomVoiture_" + numVehicule);
			setChanged();
			notifyObservers();
			System.out.println("ok supp");
		} catch (NullPointerException e) {
			throw new IllegalStateException("numVehicule pas bon", e);
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
