/**
 * 
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Observable;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.RentacarController;
import model.Rentacar;
import model.Voiture;

/**
 * @author Moi
 *
 */
public class RestitutionVue extends RentacarVue implements ActionListener {
	private JFrame frame;
	
	private JLabel idLocationLabel = new JLabel("Entrer le numero pour verifier si il est loué");
	private JLabel nomClientLabel = new JLabel("Entrer le Nom du client pour verifier si il a loué");
	private JLabel kmLabel = new JLabel("Entrer le kilométrage courant");

	private JTextField idReservationTextField = new JTextField("5");
	private JTextField nomClientTextField = new JTextField("amb mos");	
	private JTextField kmTextField = new JTextField("85");
	
	private JButton verifIdClient = new JButton("Vérifier id et client");

	private JLabel message = new JLabel("Bienvenue chez Rentacar");
	
	private JButton imprimer = new JButton("Imprimer bon de Restitution");
	private JButton retour = new JButton("retour");

	
	/**
	 * Ce constructeur affiche la page pour un gérant avec la possibilité d'ajouter une voiture au catalogue
	 */
	public RestitutionVue(Rentacar model, RentacarController controller) {
		super(model, controller);

		frame = new JFrame("Rentacar");
		
		Box idBox = Box.createHorizontalBox();
		idBox.add(idLocationLabel);
		idBox.add(idReservationTextField);

		Box nomClientBox = Box.createHorizontalBox();
		nomClientBox.add(nomClientLabel);
		nomClientBox.add(nomClientTextField);
		
		Box kmBox = Box.createHorizontalBox();
		kmBox.add(kmLabel);
		kmBox.add(kmTextField);

		Box messageBox = Box.createHorizontalBox();
		messageBox.add(message);
		
		Box buttonBox = Box.createHorizontalBox();
		buttonBox.add(verifIdClient);
		buttonBox.add(imprimer);
		buttonBox.add(retour);
		
		Box panelBox = Box.createVerticalBox();
		panelBox.add(idBox);
		panelBox.add(nomClientBox);
		panelBox.add(kmBox);
		panelBox.add(messageBox);
		panelBox.add(buttonBox);
		frame.setContentPane(panelBox);

		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900, 600);
		frame.setLocation(1000, 50);
		frame.setVisible(true);
		
		//modifMdp.addActionListener(this);
		imprimer.setEnabled(false);
		imprimer.addActionListener(this);
		retour.addActionListener(this);
		verifIdClient.addActionListener(this);
	}
	
	/**
	 * Cette méthode permet de changer de vue si le bouton "modifier mdp" est clické. Si c'est le bouton "Ajouter un véhicule" alors elle ajoute un véhicule dans le catalogue
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		
		case "Vérifier id et client":
			/*
			if(controller.verifReser(idReservationTextField.getText(), nomClientTextField.getText())) {
				affiche("la réservation est bien pour ce véhicule et ce client");
				imprimer.setEnabled(true);
			}
			else {
				affiche("erreur client et/ou id");
			}
			
			break;
		
		case "Imprimer bon de Location":
			controller.ajoutReser(idReservationTextField.getText(), nomClientTextField.getText(), kmTextField.getText());
			frame.setVisible(false);
			new GerantVue(model, controller);
			break;
*/
		case "retour":
			frame.setVisible(false);
			new GerantVue(model, controller);
			break;
			
		default:
			break;
		}	
	}
	/**
	 * Cette méthode est utile à afficher un message (surtout pour afficher un changement)
	 */
	public void affiche(String msg){
		message.setText(msg);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
	}
	
	
}