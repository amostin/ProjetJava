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
public class GerantVue {

	/**
	 * 
	 */
	public GerantVue() {
		JFrame gerantFrame;
		JPanel gerantTextContent = new JPanel();
		JLabel gerantMessage = new JLabel("Bienvenue Gérant");
		
		gerantFrame = new JFrame("Rentacar");
		gerantTextContent.setLayout(new BoxLayout(gerantTextContent, BoxLayout.Y_AXIS));
		gerantTextContent.add(gerantMessage);
		
		gerantFrame.add(gerantTextContent, BorderLayout.NORTH);
		
		gerantFrame.pack();
		gerantFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gerantFrame.setSize(500, 400);
		gerantFrame.setLocation(300, 400);
		gerantFrame.setVisible(true);
	}

}
