/**
 * 
 */
package view;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Moi
 *
 */
public class GerantVue {
	private JFrame gerantFrame;
	private JPanel gerantTextContent = new JPanel();
	private JLabel gerantMessage = new JLabel("Bienvenue Gérant");
	private JButton nouvelEmploye = new JButton("Ajouter un employé");

	private JTextField mdp = new JTextField();
	private JButton connexion = new JButton("Connexion");
	private JComboBox<String> userType;
	/**
	 * 
	 */
	public GerantVue() {

		
		gerantFrame = new JFrame("Rentacar");
		gerantTextContent.setLayout(new BoxLayout(gerantTextContent, BoxLayout.Y_AXIS));
		gerantTextContent.add(gerantMessage);
		
		gerantFrame.add(gerantTextContent, BorderLayout.NORTH);
		/*
		JPanel fieldZone = new JPanel();
		fieldZone.setLayout(new BoxLayout(fieldZone, BoxLayout.X_AXIS));
		String[] roles = {"employé", "mécanicien"};
		userType = new JComboBox<>(roles);
		fieldZone.add(userType);
		JLabel mdpLabel = new JLabel("mdp : ");
		fieldZone.add(mdpLabel);
		fieldZone.add(mdp);
		gerantFrame.add(fieldZone, BorderLayout.CENTER);
		*/
		
		JPanel panelbuttons = new JPanel();
		panelbuttons.add(nouvelEmploye);
		gerantFrame.add(panelbuttons, BorderLayout.SOUTH);
		
		gerantFrame.pack();
		gerantFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gerantFrame.setSize(500, 400);
		gerantFrame.setLocation(300, 400);
		gerantFrame.setVisible(true);
	}

}
