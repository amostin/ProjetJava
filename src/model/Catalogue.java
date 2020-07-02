/**
 * 
 */
package model;

import java.util.HashMap;

/**
 * @author Moi
 *
 */
public class Catalogue {

	private HashMap<String, Voiture> catalogue = new HashMap<>();
	private String[] nomVoitures = new String[10];
	private Voiture[] voitures = new Voiture[10];
	/**
	 * 
	 */
	public Catalogue() {
		//création des clés pour hashmap (rempli tableau nomVoiture)
		for(int i = 0; i<10; i++) {
			nomVoitures[i] = new String("nomVoiture_"+i);
		}
		
		//création des valeurs pour hashmap (rempli tableau voitures)
		for(int i = 0; i<10; i++) {
			voitures[i] = new Voiture();
		}
		
		addVoitures(nomVoitures, voitures);
		
	}
	
	public Catalogue(boolean faux) {
		
	}
	
	public HashMap<String, Voiture> getCatalogue() {
		return catalogue;
	}
	public void setCatalogue(HashMap<String, Voiture> catalogue) {
		this.catalogue = catalogue;
	}
	
	
	public void addVoitures(String[] nomVoitures, Voiture[] voitures) {
		//création du catalogue a partir des nomvoiture et des voitures
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
