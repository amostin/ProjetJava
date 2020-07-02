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
public class GerantVue extends RentacarVue implements ActionListener {
	private JFrame gerantFrame;
	
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
	private JButton ajoutVehicule = new JButton("Ajouter un véhicule");
	private JButton modifMdp = new JButton("Modifier mot de passe");
	private JLabel message = new JLabel("Bienvenue chez Rentacar");



	/**
	 * Ce constructeur affiche la page pour un gérant avec la possibilité d'ajouter une voiture au catalogue
	 */
	public GerantVue(Rentacar model, RentacarController controller) {
		super(model, controller);
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

		gerantFrame.pack();
		gerantFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gerantFrame.setSize(900, 600);
		gerantFrame.setLocation(1000, 50);
		gerantFrame.setVisible(true);
		
		modifMdp.addActionListener(this);
		ajoutVehicule.addActionListener(this);
		//gerantFrame.pack();
	}

	/**
	 * Cette méthode permet de changer de vue si le bouton "modifier mdp" est clické. Si c'est le bouton "Ajouter un véhicule" alors elle ajoute un véhicule dans le catalogue
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		
		case "Modifier mot de passe":
			gerantFrame.setVisible(false);
			new ModifierMdpVue(model, controller);	
			break;
		
		case "Ajouter un véhicule":
			Voiture voitureAjoutee = new Voiture(marqueAjoutTextField.getText(), typeAjoutTextField.getText(), puissanceAjoutTextField.getSelectedItem().toString(), bvaBg.getSelection().getActionCommand(), gpsBg.getSelection().getActionCommand(), porteAjoutTextField.getSelectedItem().toString(), climBg.getSelection().getActionCommand());
			Rentacar c = new Rentacar(false);
			
			c.addVoiture("nomVoiture_"+voitureAjoutee.getI(), voitureAjoutee);

			for (String i : c.getCatalogue().keySet()) {
				System.out.println("key: " + i + " value: " + c.getCatalogue().get(i).toString());
			}

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
