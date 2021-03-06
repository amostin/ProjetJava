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
 * Cette classe permet d'afficher un formulaire de gestion des r�servations
 * @author Ambroise Mostin
 *
 */
public class ReservationVue extends RentacarVue implements ActionListener {
	private JFrame frame;
	
	private JLabel idReservationLabel = new JLabel("5");
	private JLabel nomClientLabel = new JLabel("Nom du client ");
	private JLabel dateDebutLabel = new JLabel("Date de retrait ");
	private JLabel dateFinLabel = new JLabel("Date de restitution ");
	private JLabel formuleLabel = new JLabel("Entrer la formule d�sir�e ");
	
	private JTextField nomClientTextField = new JTextField("amb mos");	
	private JTextField dateDebutTextField = new JTextField("10/9/2020");
	private JTextField dateFinTextField = new JTextField("15/9/2020");
	private String[] formules = {"jour", "weekend", "semaine"};
	private JComboBox<String> formuleCombo;
	private JLabel message = new JLabel("Bienvenue chez Rentacar");
	
	private JButton imprimer = new JButton("Imprimer");
	private JButton retour = new JButton("retour");

	
	/**
	 * Ce constructeur affiche la page pour un g�rant avec la possibilit� d'ajouter une voiture au catalogue
	 */
	public ReservationVue(Rentacar model, RentacarController controller, String id) {
		super(model, controller);

		frame = new JFrame("Rentacar");
		
		Box idBox = Box.createHorizontalBox();
		setIdReservationLabel(new JLabel(id));
		idBox.add(idReservationLabel);
		
		Box nomClientBox = Box.createHorizontalBox();
		nomClientBox.add(nomClientLabel);
		nomClientBox.add(nomClientTextField);
		
		Box dateDebutBox = Box.createHorizontalBox();
		dateDebutBox.add(dateDebutLabel);
		dateDebutBox.add(dateDebutTextField);
		
		Box dateFinBox = Box.createHorizontalBox();
		dateFinBox.add(dateFinLabel);
		dateFinBox.add(dateFinTextField);
		
		Box formuleBox = Box.createHorizontalBox();
		formuleBox.add(formuleLabel);
		formuleCombo = new JComboBox<String>(formules);
		formuleBox.add(formuleCombo);
		
		Box messageBox = Box.createHorizontalBox();
		messageBox.add(message);
		
		Box buttonBox = Box.createHorizontalBox();
		buttonBox.add(imprimer);
		buttonBox.add(retour);
		
		Box panelBox = Box.createVerticalBox();
		panelBox.add(idBox);
		panelBox.add(nomClientBox);
		panelBox.add(dateDebutBox);
		panelBox.add(dateFinBox);
		panelBox.add(formuleBox);
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
		
		imprimer.addActionListener(this);
		retour.addActionListener(this);
	}
	/**
	 * Cette m�thode permet de changer de vue si le bouton "retour" est click�;
	 * Si c'est le bouton "Imprimer" alors elle appelle la m�thode dans le controller
	 * @see controller.RentacarController#ajoutReservation(String, String, String, String, String)
	 * @see GerantVue
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		
		case "Imprimer":
			controller.ajoutReservation(idReservationLabel.getText(), nomClientTextField.getText(), dateDebutTextField.getText(), dateFinTextField.getText(), (String) formuleCombo.getSelectedItem());
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

	public JLabel getIdReservationLabel() {
		return idReservationLabel;
	}

	public void setIdReservationLabel(JLabel idReservationLabel) {
		this.idReservationLabel = idReservationLabel;
	}
	
	
}
