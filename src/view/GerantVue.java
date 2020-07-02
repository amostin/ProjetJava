/**
 * 
 */
package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Gerant;

/**
 * Cette classe sert à afficher la version avec toute les fonctionnalités disponible (employé et mécanicien inclus)
 * @author Ambroise Mostin
 */
public class GerantVue implements ActionListener {
	private JFrame gerantFrame;
	//private JPanel gerantTextContent = new JPanel();
	//private JLabel gerantMessage = new JLabel("Bienvenue Gérant");
	
	private JLabel marqueAjoutLabel = new JLabel("marque");
	private JLabel typeAjoutLabel = new JLabel("type");
	private JLabel puissanceAjoutLabel = new JLabel("puissance");
	private JLabel bvaAjoutLabel = new JLabel("bva");
	private JLabel gpsAjoutLabel = new JLabel("gps");
	private JLabel porteAjoutLabel = new JLabel("porte");
	private JLabel climAjoutLabel = new JLabel("clim");

	private JTextField marqueAjoutTextField = new JTextField("marque");
	private JTextField typeAjoutTextField = new JTextField("type");
	private JTextField puissanceAjoutTextField = new JTextField("puissance");
	private JTextField bvaAjoutTextField = new JTextField("bva");
	private JTextField gpsAjoutTextField = new JTextField("gps");
	private JTextField porteAjoutTextField = new JTextField("porte");
	private JTextField climAjoutTextField = new JTextField("clim");
	
	private JButton ajoutVehicule = new JButton("Ajouter un véhicule");
	private JButton modifMdp = new JButton("Modifier mot de passe");


	/**
	 * Ce constructeur affiche la page pour un gérant
	 */
	public GerantVue() {

		
		gerantFrame = new JFrame("Rentacar");
		
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
		bvaBox.add(bvaAjoutTextField);
		
		Box gpsBox = Box.createHorizontalBox();
		gpsBox.add(gpsAjoutLabel);
		gpsBox.add(gpsAjoutTextField);
		
		Box porteBox = Box.createHorizontalBox();
		porteBox.add(porteAjoutLabel);
		porteBox.add(porteAjoutTextField);
		
		Box climBox = Box.createHorizontalBox();
		climBox.add(climAjoutLabel);
		climBox.add(climAjoutTextField);
		
		Box buttonBox = Box.createHorizontalBox();
		buttonBox.add(ajoutVehicule);
		buttonBox.add(modifMdp);
		
		Box panelBox = Box.createVerticalBox();
		panelBox.add(marqueBox);
		panelBox.add(typeBox);
		panelBox.add(puissanceBox);
		panelBox.add(bvaBox);
		panelBox.add(gpsBox);
		panelBox.add(porteBox);
		panelBox.add(climBox);
		panelBox.add(buttonBox);
		gerantFrame.setContentPane(panelBox);
		/*
		JPanel panelbuttons = new JPanel();
		panelbuttons.add(modifMdp);
		gerantFrame.add(panelbuttons, BorderLayout.SOUTH);
		*/
		gerantFrame.pack();
		gerantFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gerantFrame.setSize(500, 400);
		gerantFrame.setLocation(300, 400);
		gerantFrame.setVisible(true);
		
		modifMdp.addActionListener(this);
		//gerantFrame.pack();
	}

	/**
	 * Cette méthode permet de changer de vue
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		gerantFrame.setVisible(false);
		ModifierMdpVue m = new ModifierMdpVue();		
	}

}
