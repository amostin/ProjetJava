/**
 * 
 */
package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import model.Gerant;

/**
 * Cette classe sert � afficher la version avec toute les fonctionnalit�s disponible (employ� et m�canicien inclus)
 * @author Ambroise Mostin
 */
public class GerantVue implements ActionListener {
	private JFrame gerantFrame;
	//private JPanel gerantTextContent = new JPanel();
	//private JLabel gerantMessage = new JLabel("Bienvenue G�rant");
	
	private JLabel marqueAjoutLabel = new JLabel("marque");
	private JLabel typeAjoutLabel = new JLabel("type");
	private JLabel puissanceAjoutLabel = new JLabel("puissance");
	private JLabel bvaAjoutLabel = new JLabel("bva");
	private JLabel gpsAjoutLabel = new JLabel("gps");
	private JLabel porteAjoutLabel = new JLabel("porte");
	private JLabel climAjoutLabel = new JLabel("clim");

	private JTextField marqueAjoutTextField = new JTextField("marque");
	private JTextField typeAjoutTextField = new JTextField("type");
	private Integer[] puissances = {500, 600, 700, 800, 900, 1000};
	private JComboBox<Integer> puissanceAjoutTextField = new JComboBox<>(puissances);
	private JRadioButton bvaOui = new JRadioButton("oui");
	private JRadioButton bvaNon = new JRadioButton("non");
	private JRadioButton gpsOui = new JRadioButton("oui");
	private JRadioButton gpsNon = new JRadioButton("non");
	private JRadioButton climOui = new JRadioButton("oui");
	private JRadioButton climNon = new JRadioButton("non");
	private ButtonGroup bvaBg = new ButtonGroup();
	private ButtonGroup gpsBg = new ButtonGroup();
	private ButtonGroup climBg = new ButtonGroup();
	private Integer[] portes = {3, 5};
	private JComboBox<Integer> porteAjoutTextField = new JComboBox<>(portes);
	private JButton ajoutVehicule = new JButton("Ajouter un v�hicule");
	private JButton modifMdp = new JButton("Modifier mot de passe");


	/**
	 * Ce constructeur affiche la page pour un g�rant
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
		bvaBg.add(bvaOui);
		bvaBg.add(bvaNon);
		bvaBox.add(bvaOui);
		bvaBox.add(bvaNon);
		
		Box gpsBox = Box.createHorizontalBox();
		gpsBox.add(gpsAjoutLabel);
		gpsBg.add(gpsOui);
		gpsBg.add(gpsNon);
		gpsBox.add(gpsOui);
		gpsBox.add(gpsNon);
		
		Box porteBox = Box.createHorizontalBox();
		porteBox.add(porteAjoutLabel);
		porteBox.add(porteAjoutTextField);
		
		Box climBox = Box.createHorizontalBox();
		climBox.add(climAjoutLabel);
		climBg.add(climOui);
		climBg.add(climNon);
		climBox.add(climOui);
		climBox.add(climNon);
		
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
	 * Cette m�thode permet de changer de vue
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		gerantFrame.setVisible(false);
		ModifierMdpVue m = new ModifierMdpVue();		
	}

}
