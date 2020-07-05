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
public class LocationVue extends RentacarVue implements ActionListener {
	private JFrame frame;
	
	private JLabel idReservationLabel = new JLabel("Entrer le numero pour verifier si il est r�serv�");
	private JLabel nomClientLabel = new JLabel("Entrer le Nom du client pour verifier si il a r�serv�");

	private JTextField idReservationTextField = new JTextField("5");
	private JTextField nomClientTextField = new JTextField("amb mos");	
	
	private JButton verifIdClient = new JButton("V�rifier id et client");

	private JLabel message = new JLabel("Bienvenue chez Rentacar");
	
	private JButton imprimer = new JButton("Imprimer bon de Location");
	private JButton retour = new JButton("retour");

	
	/**
	 * Ce constructeur affiche la page pour un g�rant avec la possibilit� d'ajouter une voiture au catalogue
	 */
	public LocationVue(Rentacar model, RentacarController controller) {
		super(model, controller);

		frame = new JFrame("Rentacar");
		
		Box idBox = Box.createHorizontalBox();
		idBox.add(idReservationLabel);
		idBox.add(idReservationTextField);

		Box nomClientBox = Box.createHorizontalBox();
		nomClientBox.add(nomClientLabel);
		nomClientBox.add(nomClientTextField);

		Box messageBox = Box.createHorizontalBox();
		messageBox.add(message);
		
		Box buttonBox = Box.createHorizontalBox();
		buttonBox.add(verifIdClient);
		buttonBox.add(imprimer);
		buttonBox.add(retour);
		
		Box panelBox = Box.createVerticalBox();
		panelBox.add(idBox);
		panelBox.add(nomClientBox);
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
	 * Cette m�thode permet de changer de vue si le bouton "modifier mdp" est click�. Si c'est le bouton "Ajouter un v�hicule" alors elle ajoute un v�hicule dans le catalogue
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		
		case "V�rifier id et client":
			
			if(controller.verifReser(idReservationTextField.getText(), nomClientTextField.getText())) {
				affiche("la r�servation est bien pour ce v�hicule et ce client");
				imprimer.setEnabled(true);
			}
			else {
				affiche("erreur client et/ou id");
			}
			
			break;
		
		case "Imprimer bon de Location":
			//controller.ajoutReservation(idReservationLabel.getText(), nomClientTextField.getText(), dateDebutTextField.getText(), dateFinTextField.getText(), (String) formuleCombo.getSelectedItem());
			
			
			//controller.modifFormule(jourFormuleTextField.getText(), weFormuleTextField.getText(), weFormuleTextField.getText());
			//affiche("le fichier � imprimer se trouve dans fichier.getAbsolutePath()");
			frame.setVisible(false);
			new GerantVue(model, controller);
			break;

		case "retour":
			frame.setVisible(false);
			new GerantVue(model, controller);
			break;
			
		default:
			break;
		}	
	}
	/**
	 * Cette m�thode est utile � afficher un message (surtout pour afficher un changement)
	 */
	public void affiche(String msg){
		message.setText(msg);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
	}
	
	
}