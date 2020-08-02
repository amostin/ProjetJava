/**
 * 
 */
package model;

import java.awt.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

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
	
	public boolean verifReser(String idReservationTextField, String nomClientTextField) {
		String[] tabAllReservations = new String[20];
		String[] tabUneReservation = new String[20];
		try {
			File reservations = new File("D:\\3ti2deSess\\java\\reservations.txt");
			Scanner myReader = new Scanner(reservations);
			int i = 0;
		    while (myReader.hasNextLine()) {
		    	String data = myReader.nextLine();
		    	tabAllReservations[i] = data;
		    	i++;
		    	//System.out.println(data);
		    }
		    //tabAllClients = allClients.split("\\;");
		    for(int j = 0; j < tabAllReservations.length; j++) {
		    	try {
			    	tabUneReservation = tabAllReservations[j].split("\\;");
				} catch (NullPointerException e) {
					//ça passe mais faut vraiment que j'arrete de predefinir la taille des tableaux quand je sais pas ce qui aura dedans
					System.out.println("le pointer pointe sur: " + j);
				}

		    	if(tabUneReservation[0].equals(nomClientTextField) && tabUneReservation[1].equals(idReservationTextField)) {
		    		myReader.close();
		    		return true;
		    	}
		    }
		    myReader.close();
		    return false;
		} catch (IOException ioe) {
			System.out.println("An error occurred.");
	        ioe.printStackTrace();
	        return false;
		}
	}
	
	public boolean verifLoc(String idLocationTextField, String nomClientTextField) {
		String[] tabAllLocations = new String[20];
		String[] tabUneLocation = new String[20];
		try {
			File locations = new File("D:\\3ti2deSess\\java\\locations.txt");
			Scanner myReader = new Scanner(locations);
			int i = 0;
		    while (myReader.hasNextLine()) {
		    	String data = myReader.nextLine();
		    	tabAllLocations[i] = data;
		    	i++;
		    	//System.out.println(data);
		    }
		    //tabAllClients = allClients.split("\\;");
		    for(int j = 0; j < tabAllLocations.length; j++) {
		    	try {
			    	tabUneLocation = tabAllLocations[j].split("\\;");
				} catch (NullPointerException e) {
					//ça passe mais faut vraiment que j'arrete de predefinir la taille des tableaux quand je sais pas ce qui aura dedans
					System.out.println("le pointer pointe sur: " + j);
				}

		    	if(tabUneLocation[0].equals(nomClientTextField) && tabUneLocation[1].equals(idLocationTextField)) {
		    		myReader.close();
		    		return true;
		    	}
		    }
		    myReader.close();
		    return false;
		} catch (IOException ioe) {
			System.out.println("An error occurred.");
	        ioe.printStackTrace();
	        return false;
		}
	}
	
	public boolean verifRestitution(String idRestitutionTextField, String nomClientTextField) {
		String[] tabAllRestitutions = new String[20];
		String[] tabUneRestitution = new String[20];
		try {
			File restitutions = new File("D:\\3ti2deSess\\java\\restitutions.txt");
			Scanner myReader = new Scanner(restitutions);
			int i = 0;
		    while (myReader.hasNextLine()) {
		    	String data = myReader.nextLine();
		    	tabAllRestitutions[i] = data;
		    	i++;
		    	//System.out.println(data);
		    }
		    //tabAllClients = allClients.split("\\;");
		    for(int j = 0; j < tabAllRestitutions.length; j++) {
		    	try {
		    		tabUneRestitution = tabAllRestitutions[j].split("\\;");
				} catch (NullPointerException e) {
					//ça passe mais faut vraiment que j'arrete de predefinir la taille des tableaux quand je sais pas ce qui aura dedans
					System.out.println("le pointer pointe sur: " + j);
				}

		    	if(tabUneRestitution[0].equals(nomClientTextField) && tabUneRestitution[1].equals(idRestitutionTextField)) {
		    		myReader.close();
		    		return true;
		    	}
		    }
		    myReader.close();
		    return false;
		} catch (IOException ioe) {
			System.out.println("An error occurred.");
	        ioe.printStackTrace();
	        return false;
		}
	}
	
	public void ajoutFacture(String idRestitutionTextField, String nomClientTextField, String dateDebutTextField,
			String dateFinTextField){
		String debutReser = null;
		String finReser = null;
		String debutLoc = null;
		String finRestit = null;
		double prixSansAmende = 0;
		double prixAvecAmende = 0;
		double prixAvecKm = 0;
		double nbKm = 0;
		
		try {
			File factures = new File("D:\\3ti2deSess\\java\\factures.txt");
		    FileWriter myWriter = new FileWriter(factures, true);
		    Voiture v = catalogue.get("nomVoiture_"+idRestitutionTextField);
		    String prix = v.getPrix();
		    String amende = v.getAmende();
		    String prixKm = v.getPrixKm();
		    String[] tabAllReservations = new String[20];
			String[] tabUneReservation = new String[20];
			try {
				File reservations = new File("D:\\3ti2deSess\\java\\reservations.txt");
				Scanner myReader = new Scanner(reservations);
				int i = 0;
			    while (myReader.hasNextLine()) {
			    	String data = myReader.nextLine();
			    	tabAllReservations[i] = data;
			    	i++;
			    	//System.out.println(data);
			    }
			    //tabAllClients = allClients.split("\\;");
			    for(int j = 0; j < tabAllReservations.length; j++) {
			    	try {
				    	tabUneReservation = tabAllReservations[j].split("\\;");
					} catch (NullPointerException e) {
						//ça passe mais faut vraiment que j'arrete de predefinir la taille des tableaux quand je sais pas ce qui aura dedans
						System.out.println("le pointer pointe sur: " + j);
					}

			    	debutReser = tabUneReservation[2];
			    	finReser = tabUneReservation[3];
			    	System.out.println(debutReser + "\nfinreser " + finReser);
			    	myReader.close();
			    		//return true;
			    }
			} catch (IOException ioe) {
				System.out.println("An error occurred.");
		        ioe.printStackTrace();
		        //return false;
			}
			
			String[] tabAllLocations = new String[20];
			String[] tabUneLocation = new String[20];
			try {
				File locations = new File("D:\\3ti2deSess\\java\\locations.txt");
				Scanner myReader = new Scanner(locations);
				int i = 0;
			    while (myReader.hasNextLine()) {
			    	String data = myReader.nextLine();
			    	tabAllLocations[i] = data;
			    	i++;
			    	//System.out.println(data);
			    }
			    //tabAllClients = allClients.split("\\;");
			    for(int j = 0; j < tabAllLocations.length; j++) {
			    	try {
				    	tabUneLocation = tabAllLocations[j].split("\\;");
					} catch (NullPointerException e) {
						//ça passe mais faut vraiment que j'arrete de predefinir la taille des tableaux quand je sais pas ce qui aura dedans
						System.out.println("le pointer pointe sur: " + j);
					}

			    	debutLoc = tabUneLocation[2];
			    	String finLoc = tabUneLocation[3];
			    	System.out.println(debutLoc + "\nfinLoc " + finLoc);
			    	myReader.close();
			    	
			    }
			    myReader.close();
			} catch (IOException ioe) {
				System.out.println("An error occurred.");
		        ioe.printStackTrace();
			}
			
			String[] tabAllRestitutions = new String[20];
			String[] tabUneRestitution = new String[20];
			try {
				File restitutions = new File("D:\\3ti2deSess\\java\\restitutions.txt");
				Scanner myReader = new Scanner(restitutions);
				int i = 0;
			    while (myReader.hasNextLine()) {
			    	String data = myReader.nextLine();
			    	tabAllRestitutions[i] = data;
			    	i++;
			    	//System.out.println(data);
			    }
			    //tabAllClients = allClients.split("\\;");
			    for(int j = 0; j < tabAllRestitutions.length; j++) {
			    	try {
			    		tabUneRestitution = tabAllRestitutions[j].split("\\;");
					} catch (NullPointerException e) {
						//ça passe mais faut vraiment que j'arrete de predefinir la taille des tableaux quand je sais pas ce qui aura dedans
						System.out.println("le pointer pointe sur: " + j);
					}

			    	String debutRestit = tabUneRestitution[2];
			    	finRestit = tabUneRestitution[3];
			    	nbKm = Double.parseDouble(tabUneRestitution[4]);
			    	System.out.println(debutRestit + "\nfinRestit " + finRestit);
			    	myReader.close();
			    }
			    myReader.close();
			} catch (IOException ioe) {
				System.out.println("An error occurred.");
		        ioe.printStackTrace();
			}
			
			if(debutReser.equals(debutLoc) && finReser.equals(finRestit)) {
				System.out.println("date ok");
			    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			    java.util.Date firstDate = null;
				try {
					firstDate = sdf.parse(debutLoc);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    java.util.Date secondDate = null;
				try {
					secondDate = sdf.parse(finRestit);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 
			    long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
			    long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
			    
			    prixSansAmende = Integer.parseInt(prix)*diff;
			    if(nbKm>100) {
			    	prixAvecKm = Double.parseDouble(prixKm)*(nbKm-100);
			    }
			    
			    myWriter.write(nomClientTextField + ";" + idRestitutionTextField + ";" + dateDebutTextField + ";" + dateFinTextField + ";" + (prixSansAmende+prixAvecKm) + "\n");
			    myWriter.close();
			    System.out.println("Successfully wrote to the facture.");
			}
			else {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			    java.util.Date firstDate = null;
				try {
					firstDate = sdf.parse(debutReser);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    java.util.Date secondDate = null;
				try {
					secondDate = sdf.parse(finReser);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				java.util.Date firstDateAmende = null;
				try {
					firstDateAmende = sdf.parse(finReser);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    java.util.Date secondDateAmende = null;
				try {
					secondDateAmende = sdf.parse(finRestit);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
			    long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
			 
			    long diffInMilliesAmende = Math.abs(secondDateAmende.getTime() - firstDateAmende.getTime());
			    long diffAmende = TimeUnit.DAYS.convert(diffInMilliesAmende, TimeUnit.MILLISECONDS);
			    
			    prixAvecAmende = (Integer.parseInt(prix)*diff+Double.parseDouble(amende)*diffAmende);
			    if(nbKm>100) {
			    	prixAvecKm = Double.parseDouble(prixKm)*(nbKm-100);
			    }
			    myWriter.write(nomClientTextField + ";" + idRestitutionTextField + ";" + dateDebutTextField + ";" + dateFinTextField + ";" + (prixAvecAmende+prixAvecKm) + "\n");
			    myWriter.close();
			    System.out.println("Successfully wrote to the facture.");
			}
			
		    
		} catch (IOException ioe) {
			System.out.println("An error occurred.");
	        ioe.printStackTrace();
		}
		
	}
	
	public String calculDate(String dateDebut, String dateFin) {
		return "prendre le prix voiture, multiplier par le nombre de jour, calculer difference fin et debut, verifier si ça correspond à la restitution, faire de meme pour km (ajouter km forfaitaire sur chaque voiture, ajouter amende si il faut, puis afficher total";
	}

	public void ajoutRestitution(String idLocationTextField, String nomClientTextField, String dateDebutTextField, String dateFinTextField, String kmTextField) {
		try {
			File restitutions = new File("D:\\3ti2deSess\\java\\restitutions.txt");
		    FileWriter myWriter = new FileWriter(restitutions, true);
		    myWriter.write(nomClientTextField + ";" + idLocationTextField + ";" + dateDebutTextField + ";" + dateFinTextField + ";" + kmTextField + "\n");
		    myWriter.close();
		    System.out.println("Successfully wrote to the restitution.");
		} catch (IOException ioe) {
			System.out.println("An error occurred.");
	        ioe.printStackTrace();
		}
	}

	public void ajoutLocation(String idReservationTextField, String nomClientTextField, String dateDebutTextField, String dateFinTextField, String kmTextField) {
		try {
			File locations = new File("D:\\3ti2deSess\\java\\locations.txt");
		    FileWriter myWriter = new FileWriter(locations, true);
		    myWriter.write(nomClientTextField + ";" + idReservationTextField + ";" + dateDebutTextField + ";" + dateFinTextField + ";" + kmTextField + "\n");
		    myWriter.close();
		    System.out.println("Successfully wrote to the location.");
		} catch (IOException ioe) {
			System.out.println("An error occurred.");
	        ioe.printStackTrace();
		}
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
		    		break;
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
