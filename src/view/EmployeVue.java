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

/**
 * Cette classe sert à afficher la version qui n'a accès qu'au fonctionnalités utiles à un employé
 * @author Ambroise Mostin
 */
public class EmployeVue {
	private JFrame employeFrame;
	private JPanel employeTextContent = new JPanel();
	private JLabel employeMessage = new JLabel("Bienvenue Employé");
	//private JButton modifMdp = new JButton("Modifier mot de passe");


	/**
	 * Ce constructeur affiche la page pour un employé
	 */
	public EmployeVue() {

		
		employeFrame = new JFrame("Rentacar");
		employeTextContent.setLayout(new BoxLayout(employeTextContent, BoxLayout.Y_AXIS));
		employeTextContent.add(employeMessage);
		
		employeFrame.add(employeTextContent, BorderLayout.NORTH);
		/*
		JPanel panelbuttons = new JPanel();
		panelbuttons.add(modifMdp);
		employeFrame.add(panelbuttons, BorderLayout.SOUTH);
		*/
		employeFrame.pack();
		employeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		employeFrame.setSize(500, 400);
		employeFrame.setLocation(300, 400);
		employeFrame.setVisible(true);
		
		//modifMdp.addActionListener(this);
		//employeFrame.pack();
	}

/*
	@Override
	public void actionPerformed(ActionEvent arg0) {
		employeFrame.setVisible(false);
		ModifierMdpVue m = new ModifierMdpVue();		
	}
*/
}
