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
 * @author Moi
 *
 */
public class ModifierMdpVue implements ActionListener {
	private JFrame modifMdpFrame;
	private JPanel modifMdpTextContent = new JPanel();
	private JTextField mdp = new JTextField();
	private JButton enregistrer = new JButton("Enregistrer");
	private JComboBox<String> userType;
	/**
	 * 
	 */
	public ModifierMdpVue() {
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
		modifMdpFrame.add(panelbuttons, BorderLayout.SOUTH);
		
		modifMdpFrame.pack();
		modifMdpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		modifMdpFrame.setSize(500, 400);
		modifMdpFrame.setLocation(300, 400);
		modifMdpFrame.setVisible(true);
		
		enregistrer.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (userType.getSelectedItem().equals("gérant")) {
			modifMdpGerant();
		} 
		else if (userType.getSelectedItem().equals("employé")) {
			modifMdpEmploye();
		}
		else {
			modifMdpMecanicien();
		}
	}
	
	public boolean modifMdpGerant() {
		Gerant g = new Gerant();
		g.setMdp(mdp.getText());
		return true;
	}
	
	public boolean modifMdpEmploye() {
		Employe e = new Employe();
		e.setMdp(mdp.getText());
		return true;
	}
	
	public boolean modifMdpMecanicien() {
		Mecanicien m = new Mecanicien();
		m.setMdp(mdp.getText());
		return true;
	}

}
