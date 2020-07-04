/**
 * 
 */
package model;

import java.util.HashMap;
import java.util.Observable;

/**
 * Cette classe est utile à créer automatiquement un catalogue au lancement de l'application
 * @author Ambroise Mostin
 *
 */
public class Rentacar extends Observable{

	private HashMap<String, Voiture> catalogue = new HashMap<>();
	private String[] nomVoitures = new String[10];
	private Voiture[] voitures = new Voiture[10];
	//private int[] pasFiltre = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17};
	private int[] pasFiltre = {22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22};
	/**
	 * Ce constructeur permet de créer un catalogue avec 10 noms de voiture et 10 voitures
	 */
	public Rentacar() {
		createNomVoitures();
		createVoitures();
		addVoitures(nomVoitures, voitures);
	}
	/**
	 * Ce constructeur permet d'accéder aux methodes (surtout addVoitures) pour gerer les catalogue
	 */
	public Rentacar(boolean faux) {
		//accès au catalogue sans en créer un
	}
	
	public HashMap<String, Voiture> getCatalogue() {
		return catalogue;
	}
	public void setCatalogue(HashMap<String, Voiture> catalogue) {
		this.catalogue = catalogue;
	}
	public int[] getPasFiltre() {
		return pasFiltre;
	}
	public void setPasFiltre(int[] pasFiltre) {
		this.pasFiltre = pasFiltre;
	}
	/**
	 * Cette méthode permet de créer des clés pour hashmap (rempli tableau nomVoiture)
	 */
	public String[] createNomVoitures() {
		for(int i = 0; i<10; i++) {
			nomVoitures[i] = new String("nomVoiture_"+i);
		}
		return nomVoitures;
	}
	/**
	 * Cette méthode permet de créer des valeurs pour hashmap (rempli tableau voitures)
	 */
	public Voiture[] createVoitures() {
		for(int i = 0; i<10; i++) {
			voitures[i] = new Voiture(i);
		}
		return voitures;
	}
	/**
	 * Cette méthode permet de créer un catalogue a partir des nomvoiture et des voitures
	 */
	public HashMap<String, Voiture> addVoitures(String[] nomVoitures, Voiture[] voitures) {
		for(int i = 0; i<10; i++) {
			catalogue.put(nomVoitures[i], voitures[i]);
		}
		return catalogue;
	}
	/**
	 * Cette méthode permet d'ajouter une voiture au catalogue
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
		Voiture vehiculeSupp = catalogue.get("nomVoiture_"+numVehicule);
		vehiculeSupp.setEtat("Supprimé");
		setChanged();
		notifyObservers();
	}
	public void repaVehicule(int numVehiculeRepa) {
		Voiture vehiculeRepa = catalogue.get("nomVoiture_"+numVehiculeRepa);
		vehiculeRepa.setEtat("En réparation");
		setChanged();
		notifyObservers();
	}
	
	public void entrVehicule(int numVehiculeEntr) {
		Voiture vehiculeEntr = catalogue.get("nomVoiture_"+numVehiculeEntr);
		vehiculeEntr.setEtat("En entretien");
		setChanged();
		notifyObservers();
	}
	
	public void filtre(Object marqueFiltre, Object puisMinFiltre, Object bvaFiltre,
			Object gpsFiltre, Object porteFiltre, Object climFiltre) {
		int[] resetPasFiltre = {22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22};
		setPasFiltre(resetPasFiltre);
		if(marqueFiltre.equals("tout") && puisMinFiltre.equals("tout") && bvaFiltre.equals("tout") 
				&& gpsFiltre.equals("tout") && porteFiltre.equals("tout") && puisMinFiltre.equals("tout") ) {
			for(int i = 0; i < catalogue.size(); i++) {
				pasFiltre[i] = i;
			}
		}
		else {
			for(int i = 0; i<catalogue.size();i++) { //le ou ne fonctionne pas bizarrement.. 
				if((marqueFiltre.equals("marque_"+i) && ((puisMinFiltre.equals("tout")) || (puisMinFiltre.equals(catalogue.get("nomVoiture_"+i).getPuissance())))) && bvaFiltre.equals("tout") 
						&& gpsFiltre.equals("tout") && porteFiltre.equals("tout") && puisMinFiltre.equals("tout") ) {
					pasFiltre[i] = i;
					break;
				}
				else {
					if(marqueFiltre.equals("tout") && puisMinFiltre.equals(catalogue.get("nomVoiture_"+i).getPuissance()) && bvaFiltre.equals("tout") 
						&& gpsFiltre.equals("tout") && porteFiltre.equals("tout") && climFiltre.equals("tout") ) {
						pasFiltre[i] = i;
						break;
					}
					else {
						if(marqueFiltre.equals("tout") && puisMinFiltre.equals("tout") && bvaFiltre.equals(catalogue.get("nomVoiture_"+i).getBva()) 
							&& gpsFiltre.equals("tout") && porteFiltre.equals("tout") && climFiltre.equals("tout") ) {
							pasFiltre[i] = i;
							//break;
						}
						else {
							if(marqueFiltre.equals("tout") && puisMinFiltre.equals("tout") && bvaFiltre.equals("tout") 
								&& gpsFiltre.equals(catalogue.get("nomVoiture_"+i).getGps()) && porteFiltre.equals("tout") && climFiltre.equals("tout") ) {
								pasFiltre[i] = i;
								//break;
							}
							else {
								pasFiltre[i] = 25;
							}
						}
					}
				}
			}/*
			else {
				for(int i = 0; i < catalogue.size(); i++) {
					pasFiltre[i] = 25;
				}
			}*/
		}
		
		/*
		for(int i = 0; i < catalogue.size(); i++) {
			if(marqueFiltre.equals("tout")) {
				pasFiltre[i] = i;
				System.out.println(pasFiltre[i]);
			}
			else {
				pasFiltre[i] = 20;
				System.out.println(pasFiltre[i]);
			}
		}
		
		for(int i = 0; i < catalogue.size(); i++) {
			
			if(marqueFiltre.equals(catalogue.get("nomVoiture_"+i).getMarque())) {
				pasFiltre[i] = i;
				System.out.println(i);
			}
			else pasFiltre[i] = 20;
		}
		*/
		
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
