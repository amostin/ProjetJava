/**
 * 
 */
package model;

import java.awt.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Scanner;
import java.util.Stack;

/**
 * Cette classe est utile à créer automatiquement un catalogue au lancement de l'application
 * @author Ambroise Mostin
 *
 */
public class Rentacar extends Observable{

	private HashMap<String, Voiture> catalogue = new HashMap<>();
	private String[] nomVoitures = new String[10];
	private Voiture[] voitures = new Voiture[10];
	private String[] formules = {"1 fois le prix", "2 fois le prix", "3 fois le prix"};
	//private int[] pasFiltre = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17};
	private int[] pasFiltre = {22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22};
	private ArrayList<Voiture> voitureParPrix = new ArrayList<>(catalogue.values());
	/**
	 * Ce constructeur permet de créer un catalogue avec 10 noms de voiture et 10 voitures
	 */
	public Rentacar() {
		createNomVoitures();
		createVoitures();
		addVoitures(nomVoitures, voitures);
		this.formules = getFormules();
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
	public String[] getFormules() {
		return formules;
	}
	public void setFormules(String[] formules) {
		this.formules = formules;
	}
	public ArrayList<Voiture> getVoitureParPrix() {
		return voitureParPrix;
	}
	public void setVoitureParPrix(ArrayList<Voiture> voitureParPrix) {
		this.voitureParPrix = voitureParPrix;
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
	public void reserveVehicule(int numVehiculeReser) {
		Voiture vehiculeReser = catalogue.get("nomVoiture_"+numVehiculeReser);
		vehiculeReser.setEtat("Réservé");
		setChanged();
		notifyObservers();
		
	}
	public void ajoutReservation(String idReservationLabel, String nomClientTextField, String dateDebutTextField, String dateFinTextField,
			String formuleCombo) {
		String allClients = "";
		String[] tabAllClients = new String[20];
		try {
			File clients = new File("D:\\3ti2deSess\\java\\clients.txt");
			Scanner myReader = new Scanner(clients);
		    while (myReader.hasNextLine()) {
		    	String data = myReader.nextLine();
		    	allClients += data + ";";
		    	//System.out.println(data);
		    }
		    tabAllClients = allClients.split("\\;");
		    for(int i = 0; i < tabAllClients.length; i++) {
		    	if(tabAllClients[i].equals(nomClientTextField)) {
		    		System.out.println("client fidèle");
		    	}
		    	else {
		    		FileWriter myWriter = new FileWriter(clients, true);
				    myWriter.write(nomClientTextField + "\n");
				    myWriter.close();
				    System.out.println("Successfully wrote to the client.");
				}
		    }
		    myReader.close();
			
			File reservations = new File("D:\\3ti2deSess\\java\\reservations.txt");
		    FileWriter myWriter = new FileWriter(reservations, true);
		    myWriter.write(nomClientTextField + ";" + idReservationLabel + ";" + dateDebutTextField + ";" + dateFinTextField + ";" + formuleCombo + "\n");
		    myWriter.close();
		    System.out.println("Successfully wrote to the reservation.");
		} catch (IOException ioe) {
			System.out.println("An error occurred.");
	        ioe.printStackTrace();
		}
	}
	public void modifFormule(String jourFormuleTextField, String weFormuleTextField, String weekFormuleTextField) {
		// faudra que le catalogue contienne les formules pour calculer la facture
		//Voiture vehiculeEntr = catalogue.get("nomVoiture_"+numVehiculeEntr);
		//vehiculeEntr.setEtat("En entretien");
		formules[0] = jourFormuleTextField;
		formules[1] = weFormuleTextField;
		formules[2] = weekFormuleTextField;
		setChanged();
		notifyObservers();		
	}
	public ArrayList<Voiture> tri() {
		ArrayList<Voiture> voitureParPrix = new ArrayList<>(catalogue.values());
		ArrayList<Voiture> voitureTrie = Voiture.tri(voitureParPrix);
		HashMap<String, Voiture> catalogueTrie = new HashMap<>();
	    for(Voiture n : voitureParPrix) {
	    	System.out.println(n.getMarque().charAt(7) + "ème " + n);
	    	catalogueTrie.put("nomVoiture_" + n.getMarque().charAt(7), n);
	    }
	    setCatalogue(catalogueTrie);

		return voitureTrie;

		//setChanged();
		//notifyObservers();	
	}
	
	public void filtre(Object marqueFiltre, Object puisMinFiltre, Object bvaFiltre,
			Object gpsFiltre, Object porteFiltre, Object climFiltre, Object prixFiltre, Object prixKmFiltre, Object amendeFiltre) {
		int[] resetPasFiltre = {22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22};
		setPasFiltre(resetPasFiltre);
		if(marqueFiltre.equals("tout") && puisMinFiltre.equals("tout") && bvaFiltre.equals("tout") 
				&& gpsFiltre.equals("tout") && porteFiltre.equals("tout") && climFiltre.equals("tout") 
				&& prixFiltre.equals("tout") && prixKmFiltre.equals("tout") && amendeFiltre.equals("tout")) {
			for(int i = 0; i < catalogue.size(); i++) {
				pasFiltre[i] = i;
			}
		}
		else {
			for(int i = 0; i<catalogue.size();i++) { //filtre principalement marque
				if(marqueFiltre.equals("marque_"+i) && puisMinFiltre.equals("tout") && bvaFiltre.equals("tout") 
						&& gpsFiltre.equals("tout") && porteFiltre.equals("tout") && climFiltre.equals("tout") 
						&& prixFiltre.equals("tout") && prixKmFiltre.equals("tout") && amendeFiltre.equals("tout")) {
					pasFiltre[i] = i;
					//break;
				}
				else {
					if(marqueFiltre.equals("tout") && puisMinFiltre.equals(catalogue.get("nomVoiture_"+i).getPuissance()) && bvaFiltre.equals("tout") 
						&& gpsFiltre.equals("tout") && porteFiltre.equals("tout") && climFiltre.equals("tout") 
						&& prixFiltre.equals("tout") && prixKmFiltre.equals("tout") && amendeFiltre.equals("tout")) {
						pasFiltre[i] = i;
						//break;
					}
					else {
						if(marqueFiltre.equals("tout") && puisMinFiltre.equals("tout") && bvaFiltre.equals(catalogue.get("nomVoiture_"+i).getBva()) 
							&& gpsFiltre.equals("tout") && porteFiltre.equals("tout") && climFiltre.equals("tout") 
							&& prixFiltre.equals("tout") && prixKmFiltre.equals("tout") && amendeFiltre.equals("tout")) {
							pasFiltre[i] = i;
							//break;
						}
						else {
							if(marqueFiltre.equals("tout") && puisMinFiltre.equals("tout") && bvaFiltre.equals("tout") 
								&& gpsFiltre.equals(catalogue.get("nomVoiture_"+i).getGps()) && porteFiltre.equals("tout") && climFiltre.equals("tout") 
								&& prixFiltre.equals("tout") && prixKmFiltre.equals("tout") && amendeFiltre.equals("tout")) {
								pasFiltre[i] = i;
								//break;
							}
							else {
								if(marqueFiltre.equals("tout") && puisMinFiltre.equals("tout") && bvaFiltre.equals("tout") 
									&& gpsFiltre.equals("tout") && porteFiltre.equals(catalogue.get("nomVoiture_"+i).getPorte()) && climFiltre.equals("tout") 
									&& prixFiltre.equals("tout") && prixKmFiltre.equals("tout") && amendeFiltre.equals("tout")) {
									pasFiltre[i] = i;
									//break;
								}
								else {
									if(marqueFiltre.equals("tout") && puisMinFiltre.equals("tout") && bvaFiltre.equals("tout") 
										&& gpsFiltre.equals("tout") && porteFiltre.equals("tout") && climFiltre.equals(catalogue.get("nomVoiture_"+i).getClim()) 
										&& prixFiltre.equals("tout") && prixKmFiltre.equals("tout") && amendeFiltre.equals("tout")) {
										pasFiltre[i] = i;
										//break;
									}
									else {
										if(marqueFiltre.equals("tout") && puisMinFiltre.equals("tout") && bvaFiltre.equals("tout") 
											&& gpsFiltre.equals("tout") && porteFiltre.equals("tout") && climFiltre.equals("tout") 
											&& prixFiltre.equals(catalogue.get("nomVoiture_"+i).getPrix()) && prixKmFiltre.equals("tout") && amendeFiltre.equals("tout")) {
											pasFiltre[i] = i;
											//break;
										}
										else {
											if(marqueFiltre.equals("tout") && puisMinFiltre.equals("tout") && bvaFiltre.equals("tout") 
												&& gpsFiltre.equals("tout") && porteFiltre.equals("tout") && climFiltre.equals("tout") 
												&& prixFiltre.equals("tout") && prixKmFiltre.equals(catalogue.get("nomVoiture_"+i).getPrixKm()) && amendeFiltre.equals("tout")) {
												pasFiltre[i] = i;
												//break;
											}
											else {
												if(marqueFiltre.equals("tout") && puisMinFiltre.equals("tout") && bvaFiltre.equals("tout") 
														&& gpsFiltre.equals("tout") && porteFiltre.equals("tout") && climFiltre.equals("tout") 
														&& prixFiltre.equals("tout") && prixKmFiltre.equals("tout") && amendeFiltre.equals(catalogue.get("nomVoiture_"+i).getAmende())) {
														pasFiltre[i] = i;
														//break;
													}
													else {
														pasFiltre[i] = 25;
													}
											}
										}
									}
								}
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
