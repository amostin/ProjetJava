/**
 * 
 */
package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

import controller.RentacarController;
import model.Rentacar;
import model.Voiture;

/**
 * Cette classe permet d'afficher le catalogue filtré et trié, avec un formulaire de gestion pour le gérant
 * @author Ambroise Mostin
 *
 */
public class GerantVue extends RentacarVue implements ActionListener{
	private JFrame frame;
	private JTable table;
	
	private JButton tri = new JButton("Trier du moins cher au plus cher");
	
	private JLabel jourFormuleLabel = new JLabel("Formule par jour: ");
	private JLabel jourFormule = new JLabel("1 fois le prix");
	private JLabel weFormuleLabel = new JLabel("Formule par we: ");
	private JLabel weFormule = new JLabel("2 fois le prix");
	private JLabel weekFormuleLabel = new JLabel("Formule par week: ");
	private JLabel weekFormule = new JLabel("3 fois le prix");
	
	private JLabel filtre = new JLabel("Selectionner les caractéristiques désirées ");
	private JComboBox<String> marqueFiltre;
	private JComboBox<String> puisMinFiltre;
	private JComboBox<String> bvaFiltre;
	private JComboBox<String> gpsFiltre;
	private JComboBox<String> porteFiltre;
	private JComboBox<String> climFiltre;
	private JComboBox<String> prixFiltre;
	private JComboBox<String> prixKmFiltre;
	private JComboBox<String> amendeFiltre;
	private JButton filtrer = new JButton("Filtrer");
	
	private JLabel choixVehiculeSupp = new JLabel("Entrer le numero du véhicule ");
	private JTextField idVehiculeSupp = new JTextField();
	private JButton supprimerVehicule = new JButton("Supprimer");
	
	private JLabel choixVehiculeRepa = new JLabel("Entrer le numero du véhicule ");
	private JTextField idVehiculeRepa = new JTextField();
	private JButton repaVehicule = new JButton("Reparation");
	
	private JLabel choixVehiculeEntr = new JLabel("Entrer le numero du véhicule ");
	private JTextField idVehiculeEntr = new JTextField();
	private JButton entrVehicule = new JButton("Entretien");
	
	private JLabel choixVehiculeReser = new JLabel("Entrer le numero du véhicule ");
	private JTextField idVehiculeReser = new JTextField();
	private JButton reserVehicule = new JButton("Réserver");
	
	private JLabel message = new JLabel("Bienvenue chez Rentacar");
	
	private JButton ajoutVehicule = new JButton("Ajouter un véhicule");
	private JButton modifMdp = new JButton("Modifier mot de passe");
	private JButton modifFormule = new JButton("Modifier formule");
	private JButton louerVehicule = new JButton("Louer");
	private JButton restituerVehicule = new JButton("Restituer");
	private JButton facturer = new JButton("Facture");

	private Box panelBox = Box.createVerticalBox();
	Box tableBox = Box.createHorizontalBox();
	Box formuleJourBox = Box.createHorizontalBox();
	Box formuleWeBox = Box.createHorizontalBox();
	Box formuleWeekBox = Box.createHorizontalBox();
	/**
	 * Ce constructeur affiche la page pour le gérant (catalogue)
	 */
	public GerantVue(Rentacar model, RentacarController controller) {
		super(model, controller);
		
		frame = new JFrame("Rentacar");
		
		updateTable();
		
		Box headBox = Box.createHorizontalBox();
		headBox.add(table.getTableHeader());
		
		tableBox.add(table);
		
		Rentacar rentacar = model;
		updateFormules(rentacar.getFormules()[0], rentacar.getFormules()[1], rentacar.getFormules()[2]);
		
		formuleJourBox.add(jourFormuleLabel);
		formuleJourBox.add(jourFormule);
		
		formuleWeBox.add(weFormuleLabel);
		formuleWeBox.add(weFormule);
		
		formuleWeekBox.add(weekFormuleLabel);
		formuleWeekBox.add(weekFormule);
		
		Box triBox = Box.createHorizontalBox();
		triBox.add(tri);
		
		Box filtreBox = Box.createHorizontalBox();
		HashMap<String, Voiture> catalogue = model.getCatalogue();
		
		String[] marques = new String[catalogue.size()+1];
		marques[0] = "tout";
		for(int i=1; i<catalogue.size()+1; i++){
			marques[i] = catalogue.get("nomVoiture_"+(i-1)).getMarque();
		}
		marqueFiltre = new JComboBox<>(marques);
		
		String[] puisMin = new String[catalogue.size()+1];
		puisMin[0] = "tout";
		for(int i=1; i<catalogue.size()+1; i++){
			puisMin[i] = catalogue.get("nomVoiture_"+(i-1)).getPuissance();
		}
		puisMinFiltre = new JComboBox<>(puisMin);
		
		String[] bva = {"tout", "oui", "non"};
		bvaFiltre = new JComboBox<>(bva);
		
		String[] gps = {"tout", "oui", "non"};
		gpsFiltre = new JComboBox<>(gps);
		
		String[] porte = {"tout", "3", "5"};
		porteFiltre = new JComboBox<>(porte);
		
		String[] clim = {"tout", "oui", "non"};
		climFiltre = new JComboBox<>(clim);
		
		String[] prix = new String[catalogue.size()+1];
		prix[0] = "tout";
		for(int i=1; i<catalogue.size()+1; i++){
			prix[i] = catalogue.get("nomVoiture_"+(i-1)).getPrix();
		}
		prixFiltre = new JComboBox<>(prix);
		
		String[] prixKm = new String[catalogue.size()+1];
		prixKm[0] = "tout";
		for(int i=1; i<catalogue.size()+1; i++){
			prixKm[i] = catalogue.get("nomVoiture_"+(i-1)).getPrixKm();
		}
		prixKmFiltre = new JComboBox<>(prixKm);
		
		String[] amendes = new String[catalogue.size()+1];
		amendes[0] = "tout";
		for(int i=1; i<catalogue.size()+1; i++){
			amendes[i] = catalogue.get("nomVoiture_"+(i-1)).getAmende();
		}
		amendeFiltre = new JComboBox<>(amendes);
		
		filtreBox.add(filtre);
		filtreBox.add(marqueFiltre);
		filtreBox.add(puisMinFiltre);
		filtreBox.add(bvaFiltre);
		filtreBox.add(gpsFiltre);
		filtreBox.add(porteFiltre);
		filtreBox.add(climFiltre);
		filtreBox.add(prixFiltre);
		filtreBox.add(prixKmFiltre);
		filtreBox.add(amendeFiltre);
		filtreBox.add(filtrer);
		
		Box messageBox = Box.createHorizontalBox();
		messageBox.add(message);
		
		Box suppBox = Box.createHorizontalBox();
		suppBox.add(choixVehiculeSupp);
		suppBox.add(idVehiculeSupp);
		suppBox.add(supprimerVehicule);
		
		Box repaBox = Box.createHorizontalBox();
		repaBox.add(choixVehiculeRepa);
		repaBox.add(idVehiculeRepa);
		repaBox.add(repaVehicule);
		
		Box entrBox = Box.createHorizontalBox();
		entrBox.add(choixVehiculeEntr);
		entrBox.add(idVehiculeEntr);
		entrBox.add(entrVehicule);
		
		Box reserBox = Box.createHorizontalBox();
		reserBox.add(choixVehiculeReser);
		reserBox.add(idVehiculeReser);
		reserBox.add(reserVehicule);
		
		Box buttonBox = Box.createHorizontalBox();
		buttonBox.add(modifFormule);
		buttonBox.add(ajoutVehicule);
		buttonBox.add(modifMdp);
		buttonBox.add(louerVehicule);
		buttonBox.add(restituerVehicule);
		buttonBox.add(facturer);

		panelBox.add(headBox);
		panelBox.add(tableBox);
		panelBox.add(formuleJourBox);
		panelBox.add(formuleWeBox);
		panelBox.add(formuleWeekBox);
		panelBox.add(triBox);
		panelBox.add(filtreBox);
		panelBox.add(suppBox);
		panelBox.add(repaBox);
		panelBox.add(entrBox);
		panelBox.add(reserBox);
		panelBox.add(messageBox);
		panelBox.add(buttonBox);
		frame.setContentPane(panelBox);
		
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension tailleEcran = Toolkit.getDefaultToolkit().getScreenSize();
		int height = tailleEcran.height;
		int width = tailleEcran.width;
		frame.setSize((int) (width*0.75), (int) (height*0.75));
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		modifFormule.addActionListener(this);
		modifMdp.addActionListener(this);
		ajoutVehicule.addActionListener(this);
		supprimerVehicule.addActionListener(this);
		repaVehicule.addActionListener(this);
		entrVehicule.addActionListener(this);
		filtrer.addActionListener(this);
		tri.addActionListener(this);
		reserVehicule.addActionListener(this);
		louerVehicule.addActionListener(this);
		restituerVehicule.addActionListener(this);
		facturer.addActionListener(this);
	}
	/**
	 * Cette méthode est utile à construire le tableau affichant le catalogue
	 * @see Rentacar#getCatalogue()
	 * @see Voiture#getAmende()
	 * @see Voiture#getBva()
	 * @see Voiture#getClim()
	 * @see Voiture#getEtat()
	 * @see Voiture#getGps()
	 * @see Voiture#getMarque()
	 * @see Voiture#getPorte()
	 * @see Voiture#getPrix()
	 * @see Voiture#getPrixKm()
	 * @see Voiture#getType()
	 */
	private void updateTable() {
		HashMap<String, Voiture> catalogue = model.getCatalogue();
		Object [][] data = new Object[catalogue.size()][11];

		for(int i=0; i<catalogue.size(); i++){
				if(i != model.getPasFiltre()[i]) {}
				else {
					data[i][0] = i;
					data[i][1] = catalogue.get("nomVoiture_"+i).getMarque();
					data[i][2] = catalogue.get("nomVoiture_"+i).getPuissance();
					data[i][3] = catalogue.get("nomVoiture_"+i).getBva();
					data[i][4] = catalogue.get("nomVoiture_"+i).getGps();
					data[i][5] = catalogue.get("nomVoiture_"+i).getPorte();
					data[i][6] = catalogue.get("nomVoiture_"+i).getClim();
					data[i][7] = catalogue.get("nomVoiture_"+i).getEtat();
					data[i][8] = catalogue.get("nomVoiture_"+i).getPrix();
					data[i][9] = catalogue.get("nomVoiture_"+i).getPrixKm();
					data[i][10] = catalogue.get("nomVoiture_"+i).getAmende();
				}
		}
		String[] head = {"N°", "Marque", "Puissance", "Bva", "Gps", "Porte", "Clim", "état", "prix", "prixKm", "amende"};
		table = new JTable(data, head);
	}
	/**
	 * Cette méthode est appelée lors du update, quand le model effectue un changement de formule, pour changer l'affichage des formules
	 * @param jourFormuleCatalogue le montant de la formule par jour
	 * @param weFormuleCatalogue le montant de la formule par weekend
	 * @param weekFormuleCatalogue le montant de la formule par semaine
	 * @see model.Rentacar#modifFormule(String, String, String)
	 * @see GerantVue#update(Observable, Object)
	 */
	public void updateFormules(String jourFormuleCatalogue, String weFormuleCatalogue, String weekFormuleCatalogue){
		jourFormule.setText(jourFormuleCatalogue);
		weFormule.setText(weFormuleCatalogue);
		weekFormule.setText(weekFormuleCatalogue);
	}
	/**
	 * Cette méthode est utile à afficher un message (surtout pour afficher un changement)
	 */
	public void affiche(String msg){
		message.setText(msg);
	}
	/**
	 * Cette méthode est utile à mettre à jour le tableau et le formule quand il y a un changement dans le model
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		updateTable();
		panelBox.remove(tableBox);
		panelBox.add(tableBox);
		
		Rentacar rentacar = model;
		updateFormules(rentacar.getFormules()[0], rentacar.getFormules()[1], rentacar.getFormules()[2]);
		panelBox.remove(formuleJourBox);
		panelBox.remove(formuleWeBox);
		panelBox.remove(formuleWeekBox);
		panelBox.add(formuleJourBox);
		panelBox.add(formuleWeBox);
		panelBox.add(formuleWeekBox);
	}
	
	/**
	 * Cette méthode permet de changer de vue si le bouton "Facture" est clické,
	 * ou si le bouton "Restituer" est clické,
	 * ou encore si le bouton "Louer" est clické;
	 * Si c'est le bouton "Réserver" alors elle verifie que le numero du véhicule est bien dans le catalogue, 
	 * puis appelle le controller pour changer l'état du véhicule et enfin change de vue;
	 * Si c'est le bouton "Trier du moins cher au plus cher" alors elle appelle le controller pour trier le catalogue puis change de vue;
	 * Si c'est le bouton "Modifier formule" alors elle change de vue;
	 * Si c'est le bouton "Filtrer" alors elle appelle le controller pour filtrer le catalogue puis change de vue;
	 * Si c'est le bouton "Supprimer" alors elle verifie que le numero du véhicule est bien dans le catalogue, 
	 * puis appelle le controller pour changer l'état du véhicule et enfin change de vue;
	 * Si c'est le bouton "Reparation" alors elle verifie que le numero du véhicule est bien dans le catalogue, 
	 * puis appelle le controller pour changer l'état du véhicule et enfin change de vue;
	 * Si c'est le bouton "Entretien" alors elle verifie que le numero du véhicule est bien dans le catalogue, 
	 * puis appelle le controller pour changer l'état du véhicule et enfin change de vue;
	 * Si c'est le bouton "Modifier mot de passe" alors elle change de vue;
	 * Si c'est le bouton "Ajouter un véhicule" alors elle change de vue;
	 * @see FactureVue
	 * @see RestitutionVue
	 * @see LocationVue
	 * @see ReservationVue
	 * @see GerantVue
	 * @see ModifFormule
	 * @see ModifierMdpVue
	 * @see AjoutVoitureVue
	 * @see GerantVue#getNumeroVehiculeReser()
	 * @see GerantVue#getNumeroVehicule()
	 * @see GerantVue#getNumeroVehiculeRepa()
	 * @see GerantVue#getNumeroVehiculeEntr()
	 * @see Rentacar#getCatalogue()
	 * @see RentacarController#reserveVehicule(int)
	 * @see RentacarController#tri()
	 * @see RentacarController#filtre(Object, Object, Object, Object, Object, Object, Object, Object, Object)
	 * @see RentacarController#supprimeVehicule(int)
	 * @see RentacarController#entrVehicule(int)
	 * @see RentacarController#repaVehicule(int)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		
		case "Facture":
			frame.setVisible(false);
			new FactureVue(model, controller);
			break;
		
		case "Restituer":
			frame.setVisible(false);
			new RestitutionVue(model, controller);
			break;
		
		case "Louer":
			frame.setVisible(false);
			new LocationVue(model, controller);
			break;
			
		case "Réserver":
			int numVehiculeReser = getNumeroVehicule(idVehiculeReser);   
			if(numVehiculeReser < 0 || numVehiculeReser > model.getCatalogue().size()){
				affiche("Erreur, ceci n'est pas un numéro de véhicule valide ");
				return;
			}
			controller.reserveVehicule(numVehiculeReser);
			frame.setVisible(false);
			new ReservationVue(model, controller, idVehiculeReser.getText());
			break;
		
		case "Trier du moins cher au plus cher":
			controller.tri();
			frame.setVisible(false);
			new GerantVue(model, controller);
			break;
		
		case "Modifier formule":
			frame.setVisible(false);
			new ModifFormule(model, controller);
			break;
			
		case "Filtrer":
			controller.filtre(marqueFiltre.getSelectedItem(), puisMinFiltre.getSelectedItem(), bvaFiltre.getSelectedItem(), gpsFiltre.getSelectedItem(), porteFiltre.getSelectedItem(), climFiltre.getSelectedItem(), prixFiltre.getSelectedItem(), prixKmFiltre.getSelectedItem(), amendeFiltre.getSelectedItem());
			frame.setVisible(false);
			new GerantVue(model, controller);
			break;
		
		case "Supprimer":
			int numVehicule = getNumeroVehicule(idVehiculeSupp);   
			if(numVehicule < 0 || numVehicule > model.getCatalogue().size()){
				affiche("Erreur, ceci n'est pas un numéro de véhicule valide ");
				return;
			}
			controller.supprimeVehicule(numVehicule);
			frame.setVisible(false);
			new GerantVue(model, controller);
			break;
			
		case "Reparation":
			int numVehiculeRepa = getNumeroVehicule(idVehiculeRepa);   
			if(numVehiculeRepa < 0 || numVehiculeRepa > model.getCatalogue().size()){
				affiche("Erreur, ceci n'est pas un numéro de véhicule valide ");
				return;
			}
			controller.repaVehicule(numVehiculeRepa);
			frame.setVisible(false);
			new GerantVue(model, controller);
			break;
			
		case "Entretien":
			int numVehiculeEntr = getNumeroVehicule(idVehiculeEntr);   
			if(numVehiculeEntr < 0 || numVehiculeEntr > model.getCatalogue().size()){
				affiche("Erreur, ceci n'est pas un numéro de véhicule valide ");
				return;
			}
			controller.entrVehicule(numVehiculeEntr);
			frame.setVisible(false);
			new GerantVue(model, controller);
			break;

		case "Modifier mot de passe":
			frame.setVisible(false);
			new ModifierMdpVue(model, controller);	
			break;
		
		case "Ajouter un véhicule":
			frame.setVisible(false);
			new AjoutVoitureVue(model, controller);
			break;
			
		default:
			break;
		}	
	}
	/**
	 * Cette méthode permet de changer le type JTextField en int pour pouvoir comparer lors du click sur "entretient" ou "supprimer" ou "reparation" ou "réservation"
	 * @param idVehicule le numéro contenu dans le JTextField
	 * @return le numéro contenu dans le JTextField
	 * @exception NumberFormatException si il est impossible de convertir le contenu du JTextField
	 */
	public int getNumeroVehicule(JTextField idVehicule) {
		int result = 0;
		try {
			result = Integer.valueOf(idVehicule.getText()).intValue();
		}
		catch (NumberFormatException e){
			result = -1;
		}
		return result;
	}
}
