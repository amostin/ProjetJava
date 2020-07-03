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
	
	private JLabel choixVehiculeSupp = new JLabel("Entrer le numero du véhicule ");
	private JTextField idVehiculeSupp = new JTextField();
	private JButton supprimerVehicule = new JButton("supprimer");
	
	private JLabel choixVehiculeRepa = new JLabel("Entrer le numero du véhicule ");
	private JTextField idVehiculeRepa = new JTextField();
	private JButton repaVehicule = new JButton("reparation");
	
	private JLabel choixVehiculeEntr = new JLabel("Entrer le numero du véhicule ");
	private JTextField idVehiculeEntr = new JTextField();
	private JButton entrVehicule = new JButton("entretien");
	
	private JLabel message = new JLabel("Bienvenue chez Rentacar");
	
	private JButton ajoutVehicule = new JButton("Ajouter un véhicule");
	private JButton modifMdp = new JButton("Modifier mot de passe");
	
	private Box panelBox = Box.createVerticalBox();
	Box tableBox = Box.createHorizontalBox();



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
	 * Cette méthode est utile à construire le tableau affichant le catalogue
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
		
		String[] head = {"N°", "Marque", "Puissance", "Bva", "Gps", "Porte", "Clim", "état"};
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
			
		case "supprimer":
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
			
		case "reparation":
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
			
		case "entretien":
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
