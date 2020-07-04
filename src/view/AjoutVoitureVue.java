/**
 * 
 */
package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.RentacarController;
import model.Rentacar;
import model.Gerant;
import model.Voiture;

/**
 * Cette classe sert à afficher la version avec toute les fonctionnalités disponible (employé et mécanicien inclus)
 * @author Ambroise Mostin
 */
public class AjoutVoitureVue extends RentacarVue implements ActionListener {
	private JFrame frame;
	
	private JLabel marqueAjoutLabel = new JLabel("marque");
	private JLabel typeAjoutLabel = new JLabel("type");
	private JLabel puissanceAjoutLabel = new JLabel("puissance");
	private JLabel bvaAjoutLabel = new JLabel("bva");
	private JLabel gpsAjoutLabel = new JLabel("gps");
	private JLabel porteAjoutLabel = new JLabel("porte");
	private JLabel climAjoutLabel = new JLabel("clim");
	private JLabel prixAjoutLabel = new JLabel("prix");
	private JLabel prixKmAjoutLabel = new JLabel("prixKm");
	private JLabel amendeAjoutLabel = new JLabel("amende");

	private JTextField marqueAjoutTextField = new JTextField("marque");
	private JTextField typeAjoutTextField = new JTextField("type");
	private JTextField prixAjoutTextField = new JTextField("10.0");
	private JTextField prixKmAjoutTextField = new JTextField("0.5");
	private JTextField amendeAjoutTextField = new JTextField("5.0");
	private Integer[] puissances = {500, 600, 700, 800, 900, 1000};
	private JComboBox<Integer> puissanceAjoutTextField = new JComboBox<>(puissances);
	private JRadioButton bvaOui = new JRadioButton("oui");
	private JRadioButton bvaNon = new JRadioButton("non", true);
	private JRadioButton gpsOui = new JRadioButton("oui");
	private JRadioButton gpsNon = new JRadioButton("non", true);
	private JRadioButton climOui = new JRadioButton("oui");
	private JRadioButton climNon = new JRadioButton("non", true);
	private ButtonGroup bvaBg = new ButtonGroup();
	private ButtonGroup gpsBg = new ButtonGroup();
	private ButtonGroup climBg = new ButtonGroup();
	private Integer[] portes = {3, 5};
	private JComboBox<Integer> porteAjoutTextField = new JComboBox<>(portes);
	private JButton ajoutVehicule = new JButton("Ajouter un véhicule");
	private JButton retour = new JButton("retour");
	private JLabel message = new JLabel("Bienvenue chez Rentacar");
	private static int i = 10;



	/**
	 * Ce constructeur affiche la page pour un gérant avec la possibilité d'ajouter une voiture au catalogue
	 */
	public AjoutVoitureVue(Rentacar model, RentacarController controller) {
		super(model, controller);
		frame = new JFrame("Rentacar");
		
		Box marqueBox = Box.createHorizontalBox();
		marqueBox.add(marqueAjoutLabel);
		marqueBox.add(marqueAjoutTextField);
		
		Box typeBox = Box.createHorizontalBox();
		typeBox.add(typeAjoutLabel);
		typeBox.add(typeAjoutTextField);
		
		Box puissanceBox = Box.createHorizontalBox();
		puissanceBox.add(puissanceAjoutLabel);
		puissanceBox.add(puissanceAjoutTextField);
		
		Box bvaBox = Box.createHorizontalBox();
		bvaBox.add(bvaAjoutLabel);
		bvaOui.setActionCommand(bvaOui.getText());
		bvaNon.setActionCommand(bvaNon.getText());
		bvaBg.add(bvaOui);
		bvaBg.add(bvaNon);
		bvaBox.add(bvaOui);
		bvaBox.add(bvaNon);
		
		Box gpsBox = Box.createHorizontalBox();
		gpsBox.add(gpsAjoutLabel);
		gpsOui.setActionCommand(bvaOui.getText());
		gpsNon.setActionCommand(bvaNon.getText());
		gpsBg.add(gpsOui);
		gpsBg.add(gpsNon);
		gpsBox.add(gpsOui);
		gpsBox.add(gpsNon);
		
		Box porteBox = Box.createHorizontalBox();
		porteBox.add(porteAjoutLabel);
		porteBox.add(porteAjoutTextField);
		
		Box climBox = Box.createHorizontalBox();
		climBox.add(climAjoutLabel);
		climOui.setActionCommand(bvaOui.getText());
		climNon.setActionCommand(bvaNon.getText());
		climBg.add(climOui);
		climBg.add(climNon);
		climBox.add(climOui);
		climBox.add(climNon);
		
		Box prixBox = Box.createHorizontalBox();
		prixBox.add(prixAjoutLabel);
		prixBox.add(prixAjoutTextField);
		
		Box prixKmBox = Box.createHorizontalBox();
		prixKmBox.add(prixKmAjoutLabel);
		prixKmBox.add(prixKmAjoutTextField);
		
		Box amendeBox = Box.createHorizontalBox();
		amendeBox.add(amendeAjoutLabel);
		amendeBox.add(amendeAjoutTextField);
		
		Box messageBox = Box.createHorizontalBox();
		messageBox.add(message);
		
		Box buttonBox = Box.createHorizontalBox();
		buttonBox.add(ajoutVehicule);
		buttonBox.add(retour);
		
		Box panelBox = Box.createVerticalBox();
		panelBox.add(marqueBox);
		panelBox.add(typeBox);
		panelBox.add(puissanceBox);
		panelBox.add(bvaBox);
		panelBox.add(gpsBox);
		panelBox.add(porteBox);
		panelBox.add(climBox);
		panelBox.add(prixBox);
		panelBox.add(prixKmBox);
		panelBox.add(amendeBox);
		panelBox.add(messageBox);
		panelBox.add(buttonBox);
		frame.setContentPane(panelBox);

		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900, 600);
		frame.setLocation(1000, 50);
		frame.setVisible(true);
		
		//modifMdp.addActionListener(this);
		ajoutVehicule.addActionListener(this);
		retour.addActionListener(this);
		//frame.pack();
	}

	/**
	 * Cette méthode permet de changer de vue si le bouton "modifier mdp" est clické. Si c'est le bouton "Ajouter un véhicule" alors elle ajoute un véhicule dans le catalogue
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		
		case "Ajouter un véhicule":
			Voiture voitureAjoutee = new Voiture(marqueAjoutTextField.getText(), typeAjoutTextField.getText(), puissanceAjoutTextField.getSelectedItem().toString(), bvaBg.getSelection().getActionCommand(), gpsBg.getSelection().getActionCommand(), porteAjoutTextField.getSelectedItem().toString(), climBg.getSelection().getActionCommand(), prixAjoutTextField.getText(), prixKmAjoutTextField.getText(), amendeAjoutTextField.getText());
			/*
			Rentacar c = new Rentacar(false);
			c.addVoiture("nomVoiture_"+Voiture.getI(), voitureAjoutee);
			*/
			//System.out.println("nomVoiture_"+i);
			controller.ajoutVoiture("nomVoiture_"+i, voitureAjoutee);
			//System.out.println("nomVoiture_"+i);
			i++;
			//System.out.println("nomVoiture_"+i);
			//test voir catalogue
			//Rentacar c = new Rentacar(false);
			for (String i : model.getCatalogue().keySet()) {
				System.out.println("key: " + i + " value: " + model.getCatalogue().get(i).toString());
			}
			
			affiche("véhicule ajouté");
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
