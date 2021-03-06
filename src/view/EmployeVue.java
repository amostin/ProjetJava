/**
 * 
 */
package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Observable;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import controller.RentacarController;
import model.Rentacar;
import model.Voiture;

/**
 * Cette classe permet d'afficher l'application avec seulement les fonctionnalit�s utiles � un employ�
 * @author Ambroise Mostin
 */
public class EmployeVue extends RentacarVue {
	private JFrame employeFrame;
	private JTable table;
	private JLabel message = new JLabel("Bienvenue chez Rentacar");

	/**
	 * Ce constructeur affiche la page pour un employ� (catalogue)
	 */
	public EmployeVue(Rentacar model, RentacarController controller) {
		super(model, controller);
		
		employeFrame = new JFrame("Rentacar");
		
		updateTable();
		
		Box headBox = Box.createHorizontalBox();
		headBox.add(table.getTableHeader());
		
		Box tableBox = Box.createHorizontalBox();
		tableBox.add(table);
		
		Box messageBox = Box.createHorizontalBox();
		messageBox.add(message);
		
		Box panelBox = Box.createVerticalBox();
		panelBox.add(headBox);
		panelBox.add(tableBox);
		panelBox.add(messageBox);
		employeFrame.setContentPane(panelBox);
		
		employeFrame.pack();
		employeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension tailleEcran = Toolkit.getDefaultToolkit().getScreenSize();
		int height = tailleEcran.height;
		int width = tailleEcran.width;
		employeFrame.setSize((int) (width*0.75), (int) (height*0.75));
		employeFrame.setLocationRelativeTo(null);
		employeFrame.setVisible(true);

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
}
