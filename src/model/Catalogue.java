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
	private String[] nomVoiture = new String[10];
	private Voiture[] voitures = new Voiture[10];
	/**
	 * 
	 */
	public Catalogue() {
		//création des clés pour hashmap (rempli tableau nomVoiture)
		for(int i = 0; i<10; i++) {
			nomVoiture[i] = new String("nomVoiture_"+i);
		}
		
		//création des valeurs pour hashmap (rempli tableau voitures)
		for(int i = 0; i<10; i++) {
			voitures[i] = new Voiture();
		}
		
		//création du catalogue a partir des nomvoiture et des voitures
		for(int i = 0; i<10; i++) {
			catalogue.put(nomVoiture[i], voitures[i]);
		}
	}
	
	public static void main(String[] args) {
		Catalogue c = new Catalogue();
		for (String i : c.catalogue.keySet()) {
			  System.out.println("key: " + i + " value: " + c.catalogue.get(i).toString());
			}
	}

}
