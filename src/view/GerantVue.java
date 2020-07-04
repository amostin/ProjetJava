/**
 * 
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.GenericArrayType;
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
 * @author Moi
 *
 */
public class GerantVue extends RentacarVue implements ActionListener{
	private JFrame frame;
	private JTable table;
	
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
	
	private JLabel message = new JLabel("Bienvenue chez Rentacar");
	
	private JButton ajoutVehicule = new JButton("Ajouter un véhicule");
	private JButton modifMdp = new JButton("Modifier mot de passe");
	private JButton modifFormule = new JButton("Modifier formule");

	
	private Box panelBox = Box.createVerticalBox();
	Box tableBox = Box.createHorizontalBox();

	//private int[] pasFiltre = {22, 22, 22, 22, 22, 22, 22, 22, 22, 22};


	/**
	 * Ce constructeur affiche la page pour un employé (catalogue)
	 */
	public GerantVue(Rentacar model, RentacarController controller) {
		super(model, controller);
		
		frame = new JFrame("Rentacar");
		
		updateTable();
		
		Box headBox = Box.createHorizontalBox();
		headBox.add(table.getTableHeader());
		
		tableBox.add(table);
		
		Box formuleJourBox = Box.createHorizontalBox();
		formuleJourBox.add(jourFormuleLabel);
		formuleJourBox.add(jourFormule);
		
		Box formuleWeBox = Box.createHorizontalBox();
		formuleWeBox.add(weFormuleLabel);
		formuleWeBox.add(weFormule);
		
		Box formuleWeekBox = Box.createHorizontalBox();
		formuleWeekBox.add(weekFormuleLabel);
		formuleWeekBox.add(weekFormule);
		
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
		
		Box buttonBox = Box.createHorizontalBox();
		buttonBox.add(modifFormule);
		buttonBox.add(ajoutVehicule);
		buttonBox.add(modifMdp);
		
		
		panelBox.add(headBox);
		panelBox.add(tableBox);
		panelBox.add(formuleJourBox);
		panelBox.add(formuleWeBox);
		panelBox.add(formuleWeekBox);
		panelBox.add(filtreBox);
		panelBox.add(suppBox);
		panelBox.add(repaBox);
		panelBox.add(entrBox);
		panelBox.add(messageBox);
		panelBox.add(buttonBox);
		frame.setContentPane(panelBox);
		
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900, 600);
		frame.setLocation(1000, 50);
		frame.setVisible(true);

		modifFormule.addActionListener(this);
		modifMdp.addActionListener(this);
		ajoutVehicule.addActionListener(this);
		supprimerVehicule.addActionListener(this);
		repaVehicule.addActionListener(this);
		entrVehicule.addActionListener(this);
		filtrer.addActionListener(this);
	}
	/**
	 * Cette méthode est utile à construire le tableau affichant le catalogue
	 */
	private void updateTable() {
		HashMap<String, Voiture> catalogue = model.getCatalogue();
		Object [][] data = new Object[catalogue.size()][11];

		for(int i=0; i<catalogue.size(); i++){
			
			//for(int j = 0; j < catalogue.size(); j++) {
				if(i != model.getPasFiltre()[i]) {
					System.out.println(model.getPasFiltre()[i]+"vue if "+i);

					//i++;
				}
				else {
					System.out.println(model.getPasFiltre()[i]+"vue else");

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
			//}
			System.out.println(model.getPasFiltre()[i]+"vue for "+i);

		}
		
		String[] head = {"N°", "Marque", "Puissance", "Bva", "Gps", "Porte", "Clim", "état", "prix", "prixKm", "amende"};
		table = new JTable(data, head);
	}
	/**
	 * Cette méthode est utile à afficher un message (surtout pour afficher un changement)
	 */
	public void affiche(String msg){
		message.setText(msg);
	}
	/**
	 * Cette méthode est utile à mettre à jour le tableau ?
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		updateTable();
		panelBox.remove(tableBox);
		panelBox.add(tableBox);
	}
	
	/**
	 * Cette méthode permet de changer de vue si le bouton "modifier mdp" est clické. Si c'est le bouton "Ajouter un véhicule" alors elle ajoute un véhicule dans le catalogue
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
			
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
			int numVehicule = getNumeroVehicule();   
			if(numVehicule < 0 || numVehicule > model.getCatalogue().size()){
				affiche("Erreur, ceci n'est pas un numéro de véhicule valide ");
				return;
			}
			controller.supprimeVehicule(numVehicule);
			frame.setVisible(false);
			new GerantVue(model, controller);
			//affiche("véhicule supprimé");
			break;
			
		case "Reparation":
			int numVehiculeRepa = getNumeroVehiculeRepa();   
			if(numVehiculeRepa < 0 || numVehiculeRepa > model.getCatalogue().size()){
				affiche("Erreur, ceci n'est pas un numéro de véhicule valide ");
				return;
			}
			controller.repaVehicule(numVehiculeRepa);
			frame.setVisible(false);
			new GerantVue(model, controller);
			//affiche("véhicule supprimé");
			break;
			
		case "Entretien":
			int numVehiculeEntr = getNumeroVehiculeEntr();   
			if(numVehiculeEntr < 0 || numVehiculeEntr > model.getCatalogue().size()){
				affiche("Erreur, ceci n'est pas un numéro de véhicule valide ");
				return;
			}
			controller.entrVehicule(numVehiculeEntr);
			frame.setVisible(false);
			new GerantVue(model, controller);
			//affiche("véhicule supprimé");
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
	
	public int getNumeroVehicule() {
		int result = 0;
		try {
			result = Integer.valueOf(idVehiculeSupp.getText()).intValue();
		}
		catch (NumberFormatException e){
			result = -1;
		}
		return result;
	}
	
	public int getNumeroVehiculeRepa() {
		int result = 0;
		try {
			result = Integer.valueOf(idVehiculeRepa.getText()).intValue();
		}
		catch (NumberFormatException e){
			result = -1;
		}
		return result;
	}
	
	public int getNumeroVehiculeEntr() {
		int result = 0;
		try {
			result = Integer.valueOf(idVehiculeEntr.getText()).intValue();
		}
		catch (NumberFormatException e){
			result = -1;
		}
		return result;
	}
/*
	@Override
	public void actionPerformed(ActionEvent arg0) {
		frame.setVisible(false);
		ModifierMdpVue m = new ModifierMdpVue();		
	}
	
*/
}
