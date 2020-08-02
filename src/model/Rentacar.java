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
 * Cette classe est utile � cr�er automatiquement un catalogue au lancement de l'application
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
	 * Ce constructeur permet de cr�er un catalogue avec 10 noms de voiture et 10 voitures
	 */
	public Rentacar() {
		createNomVoitures();
		createVoitures();
		addVoitures(nomVoitures, voitures);
		this.formules = getFormules();
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
			voitures[i] = new Voiture(i);
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
		Voiture vehiculeSupp = catalogue.get("nomVoiture_"+numVehicule);
		vehiculeSupp.setEtat("Supprim�");
		setChanged();
		notifyObservers();
	}
	public void repaVehicule(int numVehiculeRepa) {
		Voiture vehiculeRepa = catalogue.get("nomVoiture_"+numVehiculeRepa);
		vehiculeRepa.setEtat("En r�paration");
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
		vehiculeReser.setEtat("R�serv�");
		setChanged();
		notifyObservers();
		
	}
	
	public boolean verif(String nomFichier, String idReservationTextField, String nomClientTextField) {
		String[] tabAllReservations = new String[20];
		String[] tabUneReservation = new String[20];
		try {
			File reservations = new File("D:\\3ti2deSess\\java\\"+ nomFichier +".txt");
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
					//�a passe mais faut vraiment que j'arrete de predefinir la taille des tableaux quand je sais pas ce qui aura dedans
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
	
	public boolean verifReser(String idReservationTextField, String nomClientTextField) {
		return verif("reservations", idReservationTextField, nomClientTextField);
	}
	
	public boolean verifLoc(String idLocationTextField, String nomClientTextField) {
		return verif("locations", idLocationTextField, nomClientTextField);
	}
	
	public boolean verifRestitution(String idRestitutionTextField, String nomClientTextField) {
		return verif("restitutions", idRestitutionTextField, nomClientTextField);
	}
	
	public double verifKm(double nbKm, String prixKm) {
	    if(nbKm>100) {
	    	return Double.parseDouble(prixKm)*(nbKm-100);
	    }
		return 0.0;
	}
	
	public long[] verifDate(String debutReser, String finReser, String finRestit) {
		long[] diffEtDiffAmende = new long[2];
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
	    diffEtDiffAmende[0] = diff;
	    long diffInMilliesAmende = Math.abs(secondDateAmende.getTime() - firstDateAmende.getTime());
	    long diffAmende = TimeUnit.DAYS.convert(diffInMilliesAmende, TimeUnit.MILLISECONDS);
	    diffEtDiffAmende[1] = diffAmende;
	    return diffEtDiffAmende;
	}
	
	public void lire(String nomFichier, String idTextField, String nomClientTextField, String dateDebutTextField,
			String dateFinTextField, String formuleCombo) {
		String allClients = "";
		String[] tabAllClients = new String[20];
		try {
			File clients = new File("D:\\3ti2deSess\\java\\"+ nomFichier +".txt");
			Scanner myReader = new Scanner(clients);
		    while (myReader.hasNextLine()) {
		    	String data = myReader.nextLine();
		    	allClients += data + ";";
		    	//System.out.println(data);
		    }
		    tabAllClients = allClients.split("\\;");
		    for(int i = 0; i < tabAllClients.length; i++) {
		    	if(tabAllClients[i].equals(nomClientTextField)) {
		    		System.out.println("client fid�le");
		    		break;
		    	}
		    	else {
		    		if(i == tabAllClients.length-1) ecrire("clients", "", nomClientTextField, "", "", "");
				}
		    }
		    myReader.close();
			ecrire("reservations", idTextField, nomClientTextField, dateDebutTextField, dateFinTextField, formuleCombo);
		} catch (IOException ioe) {
			System.out.println("An error occurred.");
	        ioe.printStackTrace();
		}
	}
	
	public String lireDate(String nomFichier, int index) {
		String[] tabAllReservations = new String[20];
		String[] tabUneReservation = new String[20];
		try {
			File reservations = new File("D:\\3ti2deSess\\java\\"+nomFichier+".txt");
			Scanner myReader = new Scanner(reservations);
			int i = 0;
		    while (myReader.hasNextLine()) {
		    	String data = myReader.nextLine();
		    	tabAllReservations[i] = data;
		    	i++;
		    }
		    myReader.close();
		    for(int j = 0; j < tabAllReservations.length; j++) {
		    	try {
			    	tabUneReservation = tabAllReservations[j].split("\\;");
				} catch (NullPointerException e) {
					//�a passe mais faut vraiment que j'arrete de predefinir la taille des tableaux quand je sais pas ce qui aura dedans
					System.out.println("le pointer pointe sur: " + j);
				}
		    	switch (index) {
				case 2:
					return tabUneReservation[2];
				case 3:
					return tabUneReservation[3];
				default:
					return tabUneReservation[4];
				}
		    }
		} catch (IOException ioe) {
			System.out.println("An error occurred.");
		    ioe.printStackTrace();
		}
		return "An error occurred.";
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
		
		Voiture v = catalogue.get("nomVoiture_"+idRestitutionTextField);
		String prix = v.getPrix();
		String amende = v.getAmende();
		String prixKm = v.getPrixKm();
		
		debutReser = lireDate("reservations", 2);
		finReser = lireDate("reservations", 3);
		debutLoc = lireDate("locations", 2);
		finRestit = lireDate("restitutions", 3);
		nbKm = Double.parseDouble(lireDate("restitutions", 4));
		if(debutReser.equals(debutLoc) && finReser.equals(finRestit)) {
		    prixSansAmende = Integer.parseInt(prix)*verifDate(debutReser, finReser, finRestit)[0];
		    prixAvecKm = verifKm(nbKm, prixKm);
		    ecrire("factures", idRestitutionTextField, nomClientTextField, dateDebutTextField, dateFinTextField, String.valueOf(prixSansAmende+prixAvecKm));
		}
		else {
		    prixAvecAmende = (Integer.parseInt(prix)*verifDate(debutReser, finReser, finRestit)[0]+Double.parseDouble(amende)*verifDate(debutReser, finReser, finRestit)[1]);
		    prixAvecKm = verifKm(nbKm, prixKm);
		    ecrire("factures", idRestitutionTextField, nomClientTextField, dateDebutTextField, dateFinTextField, String.valueOf(prixAvecAmende+prixAvecKm));
		}
		
	}
	
	public void ecrire(String nomFichier, String idTextField, String nomClientTextField, String dateDebutTextField, String dateFinTextField, String kmTextField) {
		try {
			File fichier = new File("D:\\3ti2deSess\\java\\"+nomFichier+".txt");
		    FileWriter myWriter = new FileWriter(fichier, true);
		    myWriter.write(nomClientTextField + ";" + idTextField + ";" + dateDebutTextField + ";" + dateFinTextField + ";" + kmTextField + "\n");
		    myWriter.close();
		    System.out.println("Successfully wrote to the "+ fichier +".");
		} catch (IOException ioe) {
			System.out.println("An error occurred.");
	        ioe.printStackTrace();
		}
	}

	public void ajoutRestitution(String idLocationTextField, String nomClientTextField, String dateDebutTextField, String dateFinTextField, String kmTextField) {
		ecrire("restitutions", idLocationTextField, nomClientTextField, dateDebutTextField, dateFinTextField, kmTextField);
	}

	public void ajoutLocation(String idReservationTextField, String nomClientTextField, String dateDebutTextField, String dateFinTextField, String kmTextField) {
		ecrire("locations", idReservationTextField, nomClientTextField, dateDebutTextField, dateFinTextField, kmTextField);
	}


	
	public void ajoutReservation(String idReservationLabel, String nomClientTextField, String dateDebutTextField, String dateFinTextField,
			String formuleCombo) {
		lire("clients", idReservationLabel, nomClientTextField, dateDebutTextField, dateFinTextField, formuleCombo);
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
	    	System.out.println(n.getMarque().charAt(7) + "�me " + n);
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
