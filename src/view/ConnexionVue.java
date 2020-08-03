/**
 * 
 */
package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.RentacarController;
import model.Employe;
import model.Gerant;
import model.Mecanicien;
import model.Rentacar;

/**
 * Cette classe permet l'affichage d'un formulaire de connexion
 * @author Ambroise Mostin
 *
 */
public class ConnexionVue extends RentacarVue implements ActionListener {

	private JFrame connexionJFrame;
	private JPanel textContent = new JPanel();
	private JLabel message = new JLabel("Bienvenue chez Rentacar");
	private JTextField mdp = new JTextField();
	private JButton connexion = new JButton("Connexion");
	private JComboBox<String> userType;
	/**
	 * Ce constructeur permet d'afficher la page de connexion avec le titre de la page, un message, une liste déroulante, un label, un champs de texte et un bouton.
	 */
	public ConnexionVue(Rentacar model, RentacarController controller) {
		super(model, controller);
		connexionJFrame = new JFrame("Rentacar");
		textContent.setLayout(new BoxLayout(textContent, BoxLayout.Y_AXIS));
		textContent.add(message);
		
		connexionJFrame.add(textContent, BorderLayout.NORTH);
		
		JPanel fieldZone = new JPanel();
		fieldZone.setLayout(new BoxLayout(fieldZone, BoxLayout.X_AXIS));
		String[] roles = {"gérant", "employé", "mécanicien"};
		userType = new JComboBox<>(roles);
		fieldZone.add(userType);
		JLabel mdpLabel = new JLabel("mdp : ");
		fieldZone.add(mdpLabel);
		fieldZone.add(mdp);
		connexionJFrame.add(fieldZone, BorderLayout.CENTER);
		
		JPanel panelbuttons = new JPanel();
		panelbuttons.add(connexion);
		connexionJFrame.add(panelbuttons, BorderLayout.SOUTH);

		connexionJFrame.pack();
		connexionJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		connexionJFrame.setSize(900, 600);
		connexionJFrame.setLocation(1000, 50);
		connexionJFrame.setVisible(true);
		
		connexion.addActionListener(this);
	}
	/**
	 * Cette méthode permet d'afficher la vue correspondante au gérant, l'employé ou le mécanicien si le mdp correspond
	 * @see Gerant#getMdp()
	 * @see Employe#getMdp()
	 * @see Mecanicien#getMdp()
	 * @see GerantVue
	 * @see EmployeVue
	 * @see MecanicienVue
	 * @see ConnexionVue#isMdpCorrect(String, String)
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		connexionJFrame.setVisible(false);
		
		Gerant g = new Gerant();
		Employe e = new Employe();
		Mecanicien m =new Mecanicien();
		
		if (userType.getSelectedItem().equals("gérant") && isMdpCorrect(g.getMdp(), mdp.getText())) {
			new GerantVue(model, controller);
		} 
		else if (userType.getSelectedItem().equals("employé") && isMdpCorrect(e.getMdp(), mdp.getText())) {
			new EmployeVue(model, controller);
		}
		else if (userType.getSelectedItem().equals("mécanicien") && isMdpCorrect(m.getMdp(), mdp.getText())) {
			new MecanicienVue(model, controller);
		}
		
	}
	
	/**
	 * Cette méthode vérifie si le mot de passe entré correspond bien au mot de passe enregistré;
	 *  Si oui, elle affiche la page du gérant; Si non elle affiche denouveau la page de connexion.
	 * @param mdpShouldBe le mot de passe enregistré
	 * @param mdpIs le mot de passe entré
	 * @see ConnexionVue#ConnexionVue(Rentacar, RentacarController)
	 */
	public boolean isMdpCorrect(String mdpShouldBe, String mdpIs) {
		if(mdpShouldBe.equals(mdpIs)) {
			return true;
		}
		else {
			new ConnexionVue(model, controller);
			return false;
		}
	}
	/**
	 * Cette méthode est utile à afficher un message (surtout pour afficher un changement)
	 */
	public void affiche(String msg){
		message.setText(msg);
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

}
