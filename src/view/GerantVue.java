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
	private JLabel gerantMessage = new JLabel("Bienvenue G�rant");
	private JButton nouvelEmploye = new JButton("Ajouter un employ�");


	/**
	 * 
	 */
	public GerantVue() {

		
		gerantFrame = new JFrame("Rentacar");
		gerantTextContent.setLayout(new BoxLayout(gerantTextContent, BoxLayout.Y_AXIS));
		gerantTextContent.add(gerantMessage);
		
		gerantFrame.add(gerantTextContent, BorderLayout.NORTH);
		
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