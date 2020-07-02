/**
 * 
 */
package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Observable;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import controller.RentacarController;
import model.Rentacar;

/**
 * Cette classe sert à afficher la version qui n'a accès qu'au fonctionnalités utiles à un employé
 * @author Ambroise Mostin
 */
public class EmployeVue extends RentacarVue {
	private JFrame employeFrame;
	private JTable table;
	private JLabel message = new JLabel("Bienvenue chez Rentacar");

	/**
	 * Ce constructeur affiche la page pour un employé
	 */
	public EmployeVue(Rentacar model, RentacarController controller) {
		super(model, controller);
		employeFrame = new JFrame("Rentacar");
		
		updateTable();
		
		employeFrame.pack();
		employeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		employeFrame.setSize(500, 400);
		employeFrame.setLocation(300, 400);
		employeFrame.setVisible(true);

	}
	
	private void updateTable() {
		//HashMap<String, Voiture> catalogue = model.get
	}

	public void affiche(String msg){
		message.setText(msg);
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
/*
	@Override
	public void actionPerformed(ActionEvent arg0) {
		employeFrame.setVisible(false);
		ModifierMdpVue m = new ModifierMdpVue();		
	}
*/
}
