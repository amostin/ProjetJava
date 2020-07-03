/**
 * 
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	
	private JLabel filtre = new JLabel("Selectionner les caract�ristiques d�sir�es ");
	private JComboBox<String> marqueFiltre;
	private JComboBox<String> puisMinFiltre;
	private JComboBox<String> puisMaxFiltre;
	private JComboBox<String> bvaFiltre;
	private JComboBox<String> gpsFiltre;
	private JComboBox<String> porteFiltre;
	private JComboBox<String> climFiltre;
	private JButton filtrer = new JButton("Filtrer");
	
	private JLabel choixVehiculeSupp = new JLabel("Entrer le numero du v�hicule ");
	private JTextField idVehiculeSupp = new JTextField();
	private JButton supprimerVehicule = new JButton("supprimer");
	
	private JLabel choixVehiculeRepa = new JLabel("Entrer le numero du v�hicule ");
	private JTextField idVehiculeRepa = new JTextField();
	private JButton repaVehicule = new JButton("reparation");
	
	private JLabel choixVehiculeEntr = new JLabel("Entrer le numero du v�hicule ");
	private JTextField idVehiculeEntr = new JTextField();
	private JButton entrVehicule = new JButton("entretien");
	
	private JLabel message = new JLabel("Bienvenue chez Rentacar");
	
	private JButton ajoutVehicule = new JButton("Ajouter un v�hicule");
	private JButton modifMdp = new JButton("Modifier mot de passe");
	
	private Box panelBox = Box.createVerticalBox();
	Box tableBox = Box.createHorizontalBox();



	/**
	 * Ce constructeur affiche la page pour un employ� (catalogue)
	 */
	public GerantVue(Rentacar model, RentacarController controller) {
		super(model, controller);
		
		frame = new JFrame("Rentacar");
		
		updateTable();
		
		Box headBox = Box.createHorizontalBox();
		headBox.add(table.getTableHeader());
		
		tableBox.add(table);
		
		Box filtreBox = Box.createHorizontalBox();
		HashMap<String, Voiture> catalogue = model.getCatalogue();
		String[] marques = new String[catalogue.size()];
		for(int i=0; i<catalogue.size(); i++){
			marques[i] = catalogue.get("nomVoiture_"+i).getMarque();
		}
		marqueFiltre = new JComboBox<>(marques);
		
		String[] puisMin = new String[catalogue.size()];
		for(int i=0; i<catalogue.size(); i++){
			puisMin[i] = catalogue.get("nomVoiture_"+i).getPuissance();
		}
		puisMinFiltre = new JComboBox<>(puisMin);
		
		String[] puisMax = new String[catalogue.size()];
		for(int i=0; i<catalogue.size(); i++){
			puisMax[i] = catalogue.get("nomVoiture_"+i).getPuissance();
		}
		puisMaxFiltre = new JComboBox<>(puisMax);
		
		String[] bva = new String[catalogue.size()];
		for(int i=0; i<catalogue.size(); i++){
			bva[i] = catalogue.get("nomVoiture_"+i).getBva();
		}
		bvaFiltre = new JComboBox<>(bva);
		
		String[] gps = new String[catalogue.size()];
		for(int i=0; i<catalogue.size(); i++){
			gps[i] = catalogue.get("nomVoiture_"+i).getGps();
		}
		gpsFiltre = new JComboBox<>(gps);
		
		String[] porte = new String[catalogue.size()];
		for(int i=0; i<catalogue.size(); i++){
			porte[i] = catalogue.get("nomVoiture_"+i).getPorte();
		}
		porteFiltre = new JComboBox<>(porte);
		
		String[] clim = new String[catalogue.size()];
		for(int i=0; i<catalogue.size(); i++){
			clim[i] = catalogue.get("nomVoiture_"+i).getClim();
		}
		climFiltre = new JComboBox<>(clim);
		
		filtreBox.add(filtre);
		filtreBox.add(marqueFiltre);
		filtreBox.add(puisMinFiltre);
		filtreBox.add(puisMaxFiltre);
		filtreBox.add(bvaFiltre);
		filtreBox.add(gpsFiltre);
		filtreBox.add(porteFiltre);
		filtreBox.add(climFiltre);
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
		buttonBox.add(ajoutVehicule);
		buttonBox.add(modifMdp);
		
		
		panelBox.add(headBox);
		panelBox.add(tableBox);
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

		modifMdp.addActionListener(this);
		ajoutVehicule.addActionListener(this);
		supprimerVehicule.addActionListener(this);
		repaVehicule.addActionListener(this);
		entrVehicule.addActionListener(this);
	}
	/**
	 * Cette m�thode est utile � construire le tableau affichant le catalogue
	 */
	private void updateTable() {
		HashMap<String, Voiture> catalogue = model.getCatalogue();
		Object [][] data = new Object[catalogue.size()][8];

		for(int i=0; i<catalogue.size(); i++){
			data[i][0] = i;
			data[i][1] = catalogue.get("nomVoiture_"+i).getMarque();
			data[i][2] = catalogue.get("nomVoiture_"+i).getPuissance();
			data[i][3] = catalogue.get("nomVoiture_"+i).getBva();
			data[i][4] = catalogue.get("nomVoiture_"+i).getGps();
			data[i][5] = catalogue.get("nomVoiture_"+i).getPorte();
			data[i][6] = catalogue.get("nomVoiture_"+i).getClim();
			data[i][7] = catalogue.get("nomVoiture_"+i).getEtat();
		}
		
		String[] head = {"N�", "Marque", "Puissance", "Bva", "Gps", "Porte", "Clim", "�tat"};
		table = new JTable(data, head);
	}
	/**
	 * Cette m�thode est utile � afficher un message (surtout pour afficher un changement)
	 */
	public void affiche(String msg){
		message.setText(msg);
	}
	/**
	 * Cette m�thode est utile � mettre � jour le tableau ?
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		updateTable();
		panelBox.remove(tableBox);
		panelBox.add(tableBox);
	}
	
	/**
	 * Cette m�thode permet de changer de vue si le bouton "modifier mdp" est click�. Si c'est le bouton "Ajouter un v�hicule" alors elle ajoute un v�hicule dans le catalogue
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
			
		case "supprimer":
			int numVehicule = getNumeroVehicule();   
			if(numVehicule < 0 || numVehicule > model.getCatalogue().size()){
				affiche("Erreur, ceci n'est pas un num�ro de v�hicule valide ");
				return;
			}
			controller.supprimeVehicule(numVehicule);
			frame.setVisible(false);
			new GerantVue(model, controller);
			//affiche("v�hicule supprim�");
			break;
			
		case "reparation":
			int numVehiculeRepa = getNumeroVehiculeRepa();   
			if(numVehiculeRepa < 0 || numVehiculeRepa > model.getCatalogue().size()){
				affiche("Erreur, ceci n'est pas un num�ro de v�hicule valide ");
				return;
			}
			controller.repaVehicule(numVehiculeRepa);
			frame.setVisible(false);
			new GerantVue(model, controller);
			//affiche("v�hicule supprim�");
			break;
			
		case "entretien":
			int numVehiculeEntr = getNumeroVehiculeEntr();   
			if(numVehiculeEntr < 0 || numVehiculeEntr > model.getCatalogue().size()){
				affiche("Erreur, ceci n'est pas un num�ro de v�hicule valide ");
				return;
			}
			controller.entrVehicule(numVehiculeEntr);
			frame.setVisible(false);
			new GerantVue(model, controller);
			//affiche("v�hicule supprim�");
			break;

		case "Modifier mot de passe":
			frame.setVisible(false);
			new ModifierMdpVue(model, controller);	
			break;
		
		case "Ajouter un v�hicule":
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
