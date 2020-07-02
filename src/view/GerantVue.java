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
	private JLabel message = new JLabel("Bienvenue chez Rentacar");
	private JButton ajoutVehicule = new JButton("Ajouter un v�hicule");
	private JButton modifMdp = new JButton("Modifier mot de passe");

	/**
	 * Ce constructeur affiche la page pour un employ� (catalogue)
	 */
	public GerantVue(Rentacar model, RentacarController controller) {
		super(model, controller);
		
		frame = new JFrame("Rentacar");
		
		updateTable();
		
		Box headBox = Box.createHorizontalBox();
		headBox.add(table.getTableHeader());
		
		Box tableBox = Box.createHorizontalBox();
		tableBox.add(table);
		
		Box messageBox = Box.createHorizontalBox();
		messageBox.add(message);
		
		Box buttonBox = Box.createHorizontalBox();
		buttonBox.add(ajoutVehicule);
		buttonBox.add(modifMdp);
		
		Box panelBox = Box.createVerticalBox();
		panelBox.add(headBox);
		panelBox.add(tableBox);
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
	}
	/**
	 * Cette m�thode est utile � construire le tableau affichant le catalogue
	 */
	private void updateTable() {
		HashMap<String, Voiture> catalogue = model.getCatalogue();
		Object [][] data = new Object[catalogue.size()][7];

		for(int i=0; i<catalogue.size(); i++){
			data[i][0] = i;
			data[i][1] = catalogue.get("nomVoiture_"+i).getMarque();
			data[i][2] = catalogue.get("nomVoiture_"+i).getPuissance();
			data[i][3] = catalogue.get("nomVoiture_"+i).getBva();
			data[i][4] = catalogue.get("nomVoiture_"+i).getGps();
			data[i][5] = catalogue.get("nomVoiture_"+i).getPorte();
			data[i][6] = catalogue.get("nomVoiture_"+i).getClim();
		}
		
		String[] head = {"N�", "Marque", "Puissance", "Bva", "Gps", "Porte", "Clim"};
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
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Cette m�thode permet de changer de vue si le bouton "modifier mdp" est click�. Si c'est le bouton "Ajouter un v�hicule" alors elle ajoute un v�hicule dans le catalogue
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		
		case "Modifier mot de passe":
			frame.setVisible(false);
			new ModifierMdpVue(model, controller);	
			break;
		
		case "Ajouter un v�hicule":
			frame.setVisible(false);
			new AjoutVoitureVue(model, controller);

		default:
			break;
		}	
	}
	
/*
	@Override
	public void actionPerformed(ActionEvent arg0) {
		frame.setVisible(false);
		ModifierMdpVue m = new ModifierMdpVue();		
	}
*/
}
