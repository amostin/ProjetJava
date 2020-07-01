/**
 * 
 */
package view;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Moi
 *
 */
public class RentacarVue {

	private JFrame rentacarJFrame;
	private JPanel textContent = new JPanel();
	private JLabel message = new JLabel("Bienvenue chez Rentacar");
	private JTextField pseudo = new JTextField();
	private JTextField mdp = new JTextField();

	//private JTable table;
	/**
	 * 
	 */
	public RentacarVue() {
		rentacarJFrame = new JFrame("Rentacar");
		textContent.setLayout(new BoxLayout(textContent, BoxLayout.Y_AXIS));
		textContent.add(message);
		
		rentacarJFrame.add(textContent, BorderLayout.NORTH);
		
		JPanel fieldZone = new JPanel();
		fieldZone.setLayout(new BoxLayout(fieldZone, BoxLayout.X_AXIS));
		JLabel pseudoLabel = new JLabel("pseudo : ");
		fieldZone.add(pseudoLabel);
		fieldZone.add(pseudo);
		JLabel mdpLabel = new JLabel("mdp : ");
		fieldZone.add(mdpLabel);
		fieldZone.add(mdp);
		rentacarJFrame.add(fieldZone, BorderLayout.CENTER);
		
		rentacarJFrame.pack();
		rentacarJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		rentacarJFrame.setSize(500, 400);
		rentacarJFrame.setLocation(300, 400);
		rentacarJFrame.setVisible(true);
	}

}
