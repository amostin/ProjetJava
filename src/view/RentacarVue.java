/**
 * 
 */
package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Moi
 *
 */
public class RentacarVue implements ActionListener {

	private JFrame rentacarJFrame;
	private JPanel textContent = new JPanel();
	private JLabel message = new JLabel("Bienvenue chez Rentacar");
	private JTextField pseudo = new JTextField();
	private JTextField mdp = new JTextField();
	private JButton connexion = new JButton("Connexion");

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
		
		JPanel panelbuttons = new JPanel();
		panelbuttons.add(connexion);
		rentacarJFrame.add(panelbuttons, BorderLayout.SOUTH);

		rentacarJFrame.pack();
		rentacarJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		rentacarJFrame.setSize(500, 400);
		rentacarJFrame.setLocation(300, 400);
		rentacarJFrame.setVisible(true);
		
		connexion.addActionListener(this);
		rentacarJFrame.pack();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//Object source = e.getSource();
		//System.out.println(source);
		rentacarJFrame.setVisible(false);
		
		new GerantVue();
	}

}
