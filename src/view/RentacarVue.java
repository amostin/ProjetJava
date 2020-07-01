/**
 * 
 */
package view;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Moi
 *
 */
public class RentacarVue {

	private JFrame rentacarJFrame;
	JPanel textContent = new JPanel();
	private JLabel message = new JLabel("Bienvenue chez Rentacar");
	//private JTable table;
	/**
	 * 
	 */
	public RentacarVue() {
		rentacarJFrame = new JFrame("Rentacar");
		textContent.setLayout(new BoxLayout(textContent, BoxLayout.Y_AXIS));
		textContent.add(message);
		
		rentacarJFrame.add(textContent, BorderLayout.NORTH);
		
		rentacarJFrame.pack();
		rentacarJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		rentacarJFrame.setSize(500, 400);
		rentacarJFrame.setLocation(300, 400);
		rentacarJFrame.setVisible(true);
	}

}
