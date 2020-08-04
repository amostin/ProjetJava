/**
 * 
 */
package view;

import java.awt.Dimension;
import java.awt.Toolkit;
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
 * Cette classe permet d'afficher un formulaire de gestion des locations
 * @author Ambroise Mostin
 *
 */
public class LocationVue extends RentacarVue implements ActionListener {
	private JFrame frame;
	
	private JLabel idReservationLabel = new JLabel("Entrer le numero pour verifier si il est réservé");
	private JLabel nomClientLabel = new JLabel("Entrer le Nom du client pour verifier si il a réservé");
	private JLabel dateDebutLabel = new JLabel("Date de retrait ");
	private JLabel dateFinLabel = new JLabel("Date de restitution ");
	private JLabel kmLabel = new JLabel("Entrer le kilométrage courant");

	private JTextField idReservationTextField = new JTextField("5");
	private JTextField nomClientTextField = new JTextField("amb mos");
	private JTextField dateDebutTextField = new JTextField("10/9/2020");
	private JTextField dateFinTextField = new JTextField("15/9/2020");
	private JTextField kmTextField = new JTextField("0");
	
	private JButton verifIdClient = new JButton("Vérifier id et client");

	private JLabel message = new JLabel("Bienvenue chez Rentacar");
	
	private JButton imprimer = new JButton("Imprimer bon de Location");
	private JButton retour = new JButton("retour");

	
	/**
	 * Ce constructeur affiche la page pour un gérant avec la possibilité d'ajouter une voiture au catalogue
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
		
		Box dateDebutBox = Box.createHorizontalBox();
		dateDebutBox.add(dateDebutLabel);
		dateDebutBox.add(dateDebutTextField);
		
		Box dateFinBox = Box.createHorizontalBox();
		dateFinBox.add(dateFinLabel);
		dateFinBox.add(dateFinTextField);
		
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
		panelBox.add(dateDebutBox);
		panelBox.add(dateFinBox);
		panelBox.add(kmBox);
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
		
		//modifMdp.addActionListener(this);
		imprimer.setEnabled(false);
		imprimer.addActionListener(this);
		retour.addActionListener(this);
		verifIdClient.addActionListener(this);
	}
	
	/**
	 * Cette méthode permet de changer de vue si le bouton "retour" est clické;
	 * Si c'est le bouton "Vérifier id et client" alors elle verifie le fichier de réservation;
	 * Si c'est le bouton "Imprimer bon de Location" alors elle appelle la méthode du controller
	 * @see controller.RentacarController#verifReser(String, String)
	 * @see controller.RentacarController#ajoutLocation(String, String, String, String, String)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		
		case "Vérifier id et client":
			
			if(controller.verifReser(idReservationTextField.getText(), nomClientTextField.getText())) {
				affiche("la réservation est bien pour ce véhicule et ce client");
				imprimer.setEnabled(true);
			}
			else {
				affiche("erreur client et/ou id");
			}
			
			break;
		
		case "Imprimer bon de Location":
			controller.ajoutLocation(idReservationTextField.getText(), nomClientTextField.getText(), dateDebutTextField.getText(), dateFinTextField.getText(), kmTextField.getText());
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