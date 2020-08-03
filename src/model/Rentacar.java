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
 * Cette classe permet de créer et gérer le catalogue
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
	 * Ce constructeur permet de créer un catalogue par défaut ainsi qu'à afficher les formules de tarif par défaut
	 */
	public Rentacar() {
		addVoitures();
		this.formules = getFormules();
	}
	/**
	 * Cette méthode permet d'obtenir le catalogue
	 */
	public HashMap<String, Voiture> getCatalogue() {
		return catalogue;
	}
	/**
	 * Cette méthode permet de modifier le catalogue
	 * @param catalogue
	 */
	public void setCatalogue(HashMap<String, Voiture> catalogue) {
		this.catalogue = catalogue;
	}
	/**
	 * Cette méthode permet d'obtenir le tableau utile au filtre
	 * @see Rentacar#filtre(Object, Object, Object, Object, Object, Object, Object, Object, Object)
	 */
	public int[] getPasFiltre() {
		return pasFiltre;
	}
	/**
	 * Cette méthode permet de modifier tableau utile au filtre
	 * @param pasFiltre tableau utile au filtre
	 */
	public void setPasFiltre(int[] pasFiltre) {
		this.pasFiltre = pasFiltre;
	}
	/**
	 * Cette méthode permet d'obtenir les formules de tarif
	 */
	public String[] getFormules() {
		return formules;
	}
	/**
	 * Cette méthode permet de modifier les formules de tarif
	 * @param formules les formules de tarif
	 */
	public void setFormules(String[] formules) {
		this.formules = formules;
	}
	/**
	 * Cette méthode permet d'obtenir la liste des voitures triées
	 */
	public ArrayList<Voiture> getVoitureParPrix() {
		return voitureParPrix;
	}
	/**
	 * Cette méthode permet de modifier la liste des voitures triées
	 * @param voitureParPrix la liste des voitures triées
	 */
	public void setVoitureParPrix(ArrayList<Voiture> voitureParPrix) {
		this.voitureParPrix = voitureParPrix;
	}
	/**
	 * Cette méthode permet de créer un catalogue avec 10 noms de voiture et 10 voitures
	 * @return le catalogue par défaut
	 */
	public HashMap<String, Voiture> addVoitures() {
		for(int i = 0; i<10; i++) {
			nomVoitures[i] = new String("nomVoiture_"+i);
			voitures[i] = new Voiture(i);
			catalogue.put(nomVoitures[i], voitures[i]);
		}
		return catalogue;
	}
	/**
	 * Cette méthode permet d'ajouter une voiture au catalogue et notifier la vue du changement
	 * @param nomVoiture le nom de la voiture qui sert de clé dans la hashmap catalogue
	 * @param voiture la voiture qui est la valeur correspondante à la clé dans la hashmap catalogue
	 * @return <code>true</code> si la voiture à bien été ajoutée au catalogue 
	 * @exception NullPointerException si l'écriture se passe mal
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
	/**
	 * Cette méthode permet de changer l'état d'une voiture et notifier la vue du changement
	 * @param numVehicule le numéro du véhicule à modifier
	 * @param etat le nouvel état du véhicule
	 * @see Voiture#setEtat(String)
	 */
	public void changEtat(int numVehicule, String etat) {
		Voiture vehiculeSupp = catalogue.get("nomVoiture_"+numVehicule);
		vehiculeSupp.setEtat(etat);
		setChanged();
		notifyObservers();
	}
	/**
	 * Cette méthode permet de lire dans un des fichiers (reservations, locations ou restitutions) pour voir si la location correspond bien à 
	 * une réservation, une restitution à une location ou une facture à une restitution
	 * @param nomFichier le nom du fichier à comparer (reservations, locations ou restitutions)
	 * @param idReservationTextField identifiant de la commande (le chiffre doit correspondre à une voiture du catalogue)
	 * @param nomClientTextField nom du client 
	 * @return <code>true</code> si l'identifiant et le nom correspondent bien à une commande
	 * @exception NullPointerException si on lis null dans les tableaux
	 * @exception IOException si il y a un probléme lors de la lecture du fichier
	 */
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
		    }
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
	/**
	 * Cette méthode permet de lire dans le fichier reservations
	 * @param idReservationTextField identifiant de la commande (le chiffre doit correspondre à une voiture du catalogue)
	 * @param nomClientTextField nom du client 
	 * @return <code>true</code> si l'identifiant et le nom correspondent bien à une commande
	 * @see Rentacar#verif(String, String, String)
	 */
	public boolean verifReser(String idReservationTextField, String nomClientTextField) {
		return verif("reservations", idReservationTextField, nomClientTextField);
	}
	/**
	 * Cette méthode permet de lire dans le fichier locations
	 * @param idLocationTextField identifiant de la commande (le chiffre doit correspondre à une voiture du catalogue)
	 * @param nomClientTextField nom du client 
	 * @return <code>true</code> si l'identifiant et le nom correspondent bien à une commande
	 * @see Rentacar#verif(String, String, String)
	 */
	public boolean verifLoc(String idLocationTextField, String nomClientTextField) {
		return verif("locations", idLocationTextField, nomClientTextField);
	}
	/**
	 * Cette méthode permet de lire dans le fichier restitutions
	 * @param idRestitutionTextField identifiant de la commande (le chiffre doit correspondre à une voiture du catalogue)
	 * @param nomClientTextField nom du client 
	 * @return <code>true</code> si l'identifiant et le nom correspondent bien à une commande
	 * @see Rentacar#verif(String, String, String)
	 */
	public boolean verifRestitution(String idRestitutionTextField, String nomClientTextField) {
		return verif("restitutions", idRestitutionTextField, nomClientTextField);
	}
	/**
	 * Cette méthode permet de vérifier si le kilométrage dépasse le forfait de 100km
	 * @param nbKm le kilométrage courant
	 * @param prixKm montant de l'amende qui sera multipliée par le nombre de kilomètre dépassé
	 * @return <code>0.0</code> si le kilométrage ne dépasse pas le forfait de 100km sinon <code>le montant de l'amende</code>
	 */
	public double verifKm(double nbKm, String prixKm) {
	    if(nbKm>100) {
	    	return Double.parseDouble(prixKm)*(nbKm-100);
	    }
		return 0.0;
	}
	/**
	 * Cette méthode permet de calculer le nombre de jour à payer en comptant le montant de l'amende
	 * @param debutReser la date de début de la réservation
	 * @param finReser la date de fin de la réservation
	 * @param finRestit la date de fin effective
	 * @return un tableau contenant le montant à payer pour la location et le montant de l'amende
	 * @exception ParseException si la date entrée est impossible à convertir
	 */
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
	/**
	 * Cette méthode permet de lire dans le fichier clients, écrire dedans si le client est nouveau et écrire la réservation
	 * @param nomFichier le nom du fichier à comparer (clients)
	 * @param idTextField identifiant de la commande (le chiffre doit correspondre à une voiture du catalogue)
	 * @param nomClientTextField nom du client pour la commande 
	 * @param dateDebutTextField date de début de la réservation
	 * @param dateFinTextField date de fin de la réservation
	 * @param formuleCombo formule de tarif choisie
	 * @exception IOException si il y a un probléme lors de la manipulation du fichier
	 * @see Rentacar#ecrire(String, String, String, String, String, String)
	 */
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
		    		System.out.println("client fidèle");
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
	/**
	 * Cette méthode permet de lire dans un des fichiers (reservations, locations ou restitutions) pour récuerer les dates et le kilométrage
	 * @param nomFichier le nom du fichier à inspecter (reservations, locations ou restitutions)
	 * @param index le numero de la colonne dans le fichier contenant l'info utile
	 * @exception IOException si il y a un probléme lors de la manipulation du fichier
	 */
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
					//ça passe mais faut vraiment que j'arrete de predefinir la taille des tableaux quand je sais pas ce qui aura dedans
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
	/**
	 * Cette méthode permet d'écrire et calculer la facture en tenant compte des amendes
	 * @param idRestitutionTextField identifiant de la commande (le chiffre doit correspondre à une voiture du catalogue)
	 * @param nomClientTextField nom du client pour la commande 
	 * @param dateDebutTextField date de début de la réservation
	 * @param dateFinTextField date de fin de la restitution
	 * @see Voiture#getPrix()
	 * @see Voiture#getAmende()
	 * @see Voiture#getPrixKm()
	 * @see Rentacar#ecrire(String, String, String, String, String, String)
	 * @see Rentacar#lireDate(String, int)
	 * @see Rentacar#verifDate(String, String, String)
	 * @see Rentacar#verifKm(double, String)
	 */
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
	/**
	 * Cette méthode permet d'écrire dans un des fichiers (reservations, locations ou restitutions)
	 * @param nomFichier le nom du fichier à comparer (clients)
	 * @param idTextField identifiant de la commande (le chiffre doit correspondre à une voiture du catalogue)
	 * @param nomClientTextField nom du client pour la commande 
	 * @param dateDebutTextField date de début de la réservation
	 * @param dateFinTextField date de fin de la réservation
	 * @param kmTextField kilométrage courant ou prix facture
	 * @exception IOException si il y a un probléme lors de la manipulation du fichier
	 */
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
	/**
	 * Cette méthode permet d'écrire dans le fichier restitutions
	 * @param idLocationTextField identifiant de la commande (le chiffre doit correspondre à une voiture du catalogue)
	 * @param nomClientTextField nom du client pour la commande 
	 * @param dateDebutTextField date de début de la réservation
	 * @param dateFinTextField date de fin de la réservation
	 * @param kmTextField kilométrage courant ou prix facture
	 */
	public void ajoutRestitution(String idLocationTextField, String nomClientTextField, String dateDebutTextField, String dateFinTextField, String kmTextField) {
		ecrire("restitutions", idLocationTextField, nomClientTextField, dateDebutTextField, dateFinTextField, kmTextField);
	}
	/**
	 * Cette méthode permet d'écrire dans le fichier locations
	 * @param idLocationTextField identifiant de la commande (le chiffre doit correspondre à une voiture du catalogue)
	 * @param nomClientTextField nom du client pour la commande 
	 * @param dateDebutTextField date de début de la réservation
	 * @param dateFinTextField date de fin de la réservation
	 * @param kmTextField kilométrage courant ou prix facture
	 */
	public void ajoutLocation(String idReservationTextField, String nomClientTextField, String dateDebutTextField, String dateFinTextField, String kmTextField) {
		ecrire("locations", idReservationTextField, nomClientTextField, dateDebutTextField, dateFinTextField, kmTextField);
	}
	/**
	 * Cette méthode permet de lire dans le fichier clients, écrire dedans si le client est nouveau et écrire la réservation
	 * @param idReservationLabel identifiant de la commande (le chiffre doit correspondre à une voiture du catalogue)
	 * @param nomClientTextField nom du client pour la commande 
	 * @param dateDebutTextField date de début de la réservation
	 * @param dateFinTextField date de fin de la réservation
	 * @param formuleCombo formule de tarif choisie
	 * @exception IOException si il y a un probléme lors de la manipulation du fichier
	 * @see Rentacar#lire(String, String, String, String, String, String)
	 */
	public void ajoutReservation(String idReservationLabel, String nomClientTextField, String dateDebutTextField, String dateFinTextField,
			String formuleCombo) {
		lire("clients", idReservationLabel, nomClientTextField, dateDebutTextField, dateFinTextField, formuleCombo);
	}
	/**
	 * Cette méthode permet de modifier le montant des formules de tarif et notifier la vue du changement
	 * @param jourFormuleTextField le montant de la formule par jour
	 * @param weFormuleTextField le montant de la formule par weekend
	 * @param weekFormuleTextField le montant de la formule par semaine
	 */
	public void modifFormule(String jourFormuleTextField, String weFormuleTextField, String weekFormuleTextField) {
		formules[0] = jourFormuleTextField;
		formules[1] = weFormuleTextField;
		formules[2] = weekFormuleTextField;
		setChanged();
		notifyObservers();		
	}
	/**
	 * Cette méthode permet de trier le catalogue de façon descandante (9, 8, 7... au lieu de 0, 1, 2...)
	 * @return arraylist contenant le catalogue trié
	 * @see Voiture#tri(ArrayList)
	 */
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
	}
	/**
	 * Cette méthode permet de filtrer le catalogue selon une caractéristique choisie
	 * @param marqueFiltre le filtre choisi pour la marque (tout ou une des marques présente dans le catalogue)
	 * @param puisMinFiltre le filtre choisi pour la puissance (tout ou une des puissances présente dans le catalogue)
	 * @param bvaFiltre le filtre choisi pour la boite de vitesse automatique (tout ou oui ou non)
	 * @param gpsFiltre le filtre choisi pour le gps (tout ou oui ou non)
	 * @param porteFiltre le filtre choisi pour le nombre de porte (tout ou 3 ou 5)
	 * @param climFiltre le filtre choisi pour la clim (tout ou oui ou non)
	 * @param prixFiltre le filtre choisi pour le prix (tout ou un des prix présent dans le catalogue)
	 * @param prixKmFiltre le filtre choisi pour l'amende au Km (tout ou une des amendes au Km présente dans le catalogue)
	 * @param amendeFiltre le filtre choisi pour l'amende journalière (tout ou une des amendes journalière présente dans le catalogue)
	 */
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
			}
		}
	}
}
