/**
 * 
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.RentacarController;
import model.Rentacar;
import model.Voiture;

/**
 * Cette classe permet d'afficher un formulaire de gestion des formules de tarif
 * @author Ambroise Mostin
 *
 */
public class ModifFormule extends RentacarVue implements ActionListener {
	private JFrame frame;
	
	private JLabel jourFormuleLabel = new JLabel("Formule par jour: ");
	private JLabel weFormuleLabel = new JLabel("Formule par we: ");
	private JLabel weekFormuleLabel = new JLabel("Formule par week: ");
	
	private JTextField jourFormuleTextField = new JTextField("1.1 fois le prix");
	private JTextField weFormuleTextField = new JTextField("2.1 fois le prix");
	private JTextField weekFormuleTextField = new JTextField("3.1 fois le prix");
	
	private JButton modifFormule = new JButton("Modifier formule");
	private JButton retour = new JButton("retour");
	private JLabel message = new JLabel("Bienvenue chez Rentacar");
	
	/**
	 * Ce constructeur affiche la page pour un gérant avec la possibilité d'ajouter une voiture au catalogue
	 */
	public ModifFormule(Rentacar model, RentacarController controller) {
		super(model, controller);

		frame = new JFrame("Rentacar");
		
		Box jourBox = Box.createHorizontalBox();
		jourBox.add(jourFormuleLabel);
		jourBox.add(jourFormuleTextField);
		
		Box weBox = Box.createHorizontalBox();
		weBox.add(weFormuleLabel);
		weBox.add(weFormuleTextField);
		
		Box weekBox = Box.createHorizontalBox();
		weekBox.add(weekFormuleLabel);
		weekBox.add(weekFormuleTextField);
		
		Box messageBox = Box.createHorizontalBox();
		messageBox.add(message);
		
		Box buttonBox = Box.createHorizontalBox();
		buttonBox.add(modifFormule);
		buttonBox.add(retour);
		
		Box panelBox = Box.createVerticalBox();
		panelBox.add(jourBox);
		panelBox.add(weBox);
		panelBox.add(weekBox);
		panelBox.add(messageBox);
		panelBox.add(buttonBox);
		frame.setContentPane(panelBox);

		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900, 600);
		frame.setLocation(1000, 50);
		frame.setVisible(true);
		
		//modifMdp.addActionListener(this);
		modifFormule.addActionListener(this);
		retour.addActionListener(this);
	}
	
	/**
	 * Cette méthode permet de changer de vue si le bouton "retour" est clické;
	 *  Si c'est le bouton "Modifier formule" alors elle appelle la méthode dans le controller
	 *  @see controller.RentacarController#modifFormule(String, String, String)
	 *  @see GerantVue
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		
		case "Modifier formule":
			
			controller.modifFormule(jourFormuleTextField.getText(), weFormuleTextField.getText(), weFormuleTextField.getText());
			affiche("Formules modifiées");
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
