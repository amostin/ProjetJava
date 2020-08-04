/**
 * 
 */
package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
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
 * Cette classe permet d'afficher un formulaire de gestion des mots de passe pour le gérant
 * @author Ambroise Mostin
 *
 */
public class ModifierMdpVue extends RentacarVue implements ActionListener {
	private JFrame modifMdpFrame;
	private JPanel modifMdpTextContent = new JPanel();
	private JTextField mdp = new JTextField();
	private JButton enregistrer = new JButton("Enregistrer");
	private JButton retourCo = new JButton("Retour à la connexion");
	private JComboBox<String> userType;
	private JLabel message = new JLabel("Bienvenue chez Rentacar");

	/**
	 * Ce constructeur affiche une liste qui permet de choisir un role et definir un mot de passe ou retourner à l'écran de connexion
	 */
	public ModifierMdpVue(Rentacar model, RentacarController controller) {
		super(model, controller);
		modifMdpFrame = new JFrame("Rentacar");
		modifMdpTextContent.setLayout(new BoxLayout(modifMdpTextContent, BoxLayout.Y_AXIS));
		
		modifMdpFrame.add(modifMdpTextContent, BorderLayout.NORTH);
		
		JPanel fieldZone = new JPanel();
		fieldZone.setLayout(new BoxLayout(fieldZone, BoxLayout.X_AXIS));
		String[] roles = {"gérant", "employé", "mécanicien"};
		userType = new JComboBox<>(roles);
		fieldZone.add(userType);
		JLabel mdpLabel = new JLabel("mdp : ");
		fieldZone.add(mdpLabel);
		fieldZone.add(mdp);
		modifMdpFrame.add(fieldZone, BorderLayout.CENTER);
		
		JPanel panelbuttons = new JPanel();
		panelbuttons.add(enregistrer);
		panelbuttons.add(retourCo);
		modifMdpFrame.add(panelbuttons, BorderLayout.SOUTH);
		
		modifMdpFrame.pack();
		modifMdpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension tailleEcran = Toolkit.getDefaultToolkit().getScreenSize();
		int height = tailleEcran.height;
		int width = tailleEcran.width;
		modifMdpFrame.setSize((int) (width*0.75), (int) (height*0.75));
		modifMdpFrame.setLocationRelativeTo(null);
		modifMdpFrame.setVisible(true);
		
		enregistrer.addActionListener(this);
		retourCo.addActionListener(this);
	}
	/**
	 * Cette méthode permet de changer de vue si le bouton "retour à la connexion" est clické;
	 *  Si c'est le bouton "Enregistrer" alors elle appelle la méthode modifMdp
	 *  @see ConnexionVue
	 *  @see ModifierMdpVue#modifMdp(String)
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		switch(ae.getActionCommand()) {

		case "Enregistrer":
			if (userType.getSelectedItem().equals("gérant")) {
				modifMdp("g");
			} 
			else if (userType.getSelectedItem().equals("employé")) {
				modifMdp("e");
			}
			else {
				modifMdp("m");
			}
			break;
			
		case "Retour à la connexion":
			modifMdpFrame.setVisible(false);
			new ConnexionVue(model, controller);
			break;
		}
	}
	/**
	 * Cette méthode modifie le mot de passe du gérant mais indique que cette fonctionnalité n'est pas encore completement fonctiennelle
	 * @param type donne le role pour lequel il faut changer le mot de passe
	 * @return true toujours car cette méthode n'est pas vraiment fonctionnelle
	 * @see Gerant#setMdp(String)
	 * @see Employe#setMdp(String)
	 * @see Mecanicien#setMdp(String)
	 */
	public boolean modifMdp(String type) {
		switch (type) {
		case "g":
			Gerant g = new Gerant();
			g.setMdp(mdp.getText());
			mdp.setText("pas de base de donnée donc ça va pas changer grand chose pour le moment...");
			return true;

		case "e":
			Employe e = new Employe();
			e.setMdp(mdp.getText());
			mdp.setText("pas de base de donnée donc ça va pas changer grand chose pour le moment...");
			return true;
			
		case "m":
			Mecanicien m = new Mecanicien();
			m.setMdp(mdp.getText());
			mdp.setText("pas de base de donnée donc ça va pas changer grand chose pour le moment...");
			return true;
			
		default:
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
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	
}