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

import model.Gerant;

/**
 * @author Moi
 *
 */
public class GerantVue implements ActionListener {
	private JFrame gerantFrame;
	private JPanel gerantTextContent = new JPanel();
	private JLabel gerantMessage = new JLabel("Bienvenue Gérant");
	private JButton modifMdp = new JButton("Modifier mot de passe");


	/**
	 * 
	 */
	public GerantVue() {

		
		gerantFrame = new JFrame("Rentacar");
		gerantTextContent.setLayout(new BoxLayout(gerantTextContent, BoxLayout.Y_AXIS));
		gerantTextContent.add(gerantMessage);
		
		gerantFrame.add(gerantTextContent, BorderLayout.NORTH);
		
		JPanel panelbuttons = new JPanel();
		panelbuttons.add(modifMdp);
		gerantFrame.add(panelbuttons, BorderLayout.SOUTH);
		
		gerantFrame.pack();
		gerantFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gerantFrame.setSize(500, 400);
		gerantFrame.setLocation(300, 400);
		gerantFrame.setVisible(true);
		
		modifMdp.addActionListener(this);
		//gerantFrame.pack();
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		gerantFrame.setVisible(false);
		ModifierMdpVue m = new ModifierMdpVue();		
	}

}
