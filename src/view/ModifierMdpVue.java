/**
 * 
 */
package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Employe;
import model.Gerant;
import model.Mecanicien;

/**
 * Cette classe sert � afficher une vue accessible seulement par le g�rant et lui permettre de changer un mot de passe
 * @author Ambroise Mostin
 */
public class ModifierMdpVue implements ActionListener {
	private JFrame modifMdpFrame;
	private JPanel modifMdpTextContent = new JPanel();
	private JTextField mdp = new JTextField();
	private JButton enregistrer = new JButton("Enregistrer");
	private JButton retourCo = new JButton("Retour � la connexion");
	private JComboBox<String> userType;
	/**
	 * Ce constructeur affiche une liste qui permet de choisir un role et definir un mot de passe ou retourner � l'�cran de connexion
	 */
	public ModifierMdpVue() {
		modifMdpFrame = new JFrame("Rentacar");
		modifMdpTextContent.setLayout(new BoxLayout(modifMdpTextContent, BoxLayout.Y_AXIS));
		
		modifMdpFrame.add(modifMdpTextContent, BorderLayout.NORTH);
		
		JPanel fieldZone = new JPanel();
		fieldZone.setLayout(new BoxLayout(fieldZone, BoxLayout.X_AXIS));
		String[] roles = {"g�rant", "employ�", "m�canicien"};
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
		modifMdpFrame.setSize(500, 400);
		modifMdpFrame.setLocation(300, 400);
		modifMdpFrame.setVisible(true);
		
		enregistrer.addActionListener(this);
		retourCo.addActionListener(this);
	}
	/**
	 * Cette m�thode permet de modifier le mot de passe selon le role choisi et de retourner � la page de connexion
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		switch(ae.getActionCommand()) {

		case "Enregistrer":
			if (userType.getSelectedItem().equals("g�rant")) {
				modifMdpGerant();
			} 
			else if (userType.getSelectedItem().equals("employ�")) {
				modifMdpEmploye();
			}
			else {
				modifMdpMecanicien();
			}
			break;
			
		case "Retour � la connexion":
			modifMdpFrame.setVisible(false);
			new RentacarVue();
			break;
		}
	}
	/**
	 * Cette m�thode modifie le mot de passe du g�rant mais indique que cette fonctionnalit� n'est pas encoore completement fonctiennelle
	 * @return true toujours car cette m�thode n'est pas vraiment fonctionnelle
	 */
	public boolean modifMdpGerant() {
		Gerant g = new Gerant();
		g.setMdp(mdp.getText());
		mdp.setText("pas de base de donn�e donc �a va pas changer grand chose pour le moment...");
		return true;
	}
	/**
	 * Cette m�thode modifie le mot de passe de l'employ� mais indique que cette fonctionnalit� n'est pas encoore completement fonctiennelle
	 * @return true toujours car cette m�thode n'est pas vraiment fonctionnelle
	 */
	public boolean modifMdpEmploye() {
		Employe e = new Employe();
		e.setMdp(mdp.getText());
		mdp.setText("pas de base de donn�e donc �a va pas changer grand chose pour le moment...");
		return true;
	}
	/**
	 * Cette m�thode modifie le mot de passe du m�canicien mais indique que cette fonctionnalit� n'est pas encoore completement fonctiennelle
	 * @return true toujours car cette m�thode n'est pas vraiment fonctionnelle
	 */
	public boolean modifMdpMecanicien() {
		Mecanicien m = new Mecanicien();
		m.setMdp(mdp.getText());
		mdp.setText("pas de base de donn�e donc �a va pas changer grand chose pour le moment...");
		return true;
	}

}
