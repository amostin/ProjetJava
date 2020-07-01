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
 * Cette classe sert à afficher la version qui n'a accès qu'au fonctionnalités utiles à un mécanicien
 * @author Ambroise Mostin
 */
public class MecanicienVue {
	private JFrame mecanicienFrame;
	private JPanel mecanicienTextContent = new JPanel();
	private JLabel mecanicienMessage = new JLabel("Bienvenue Gérant");
	//private JButton modifMdp = new JButton("Modifier mot de passe");


	/**
	 * Ce constructeur affiche la page pour un mécanicien
	 */
	public MecanicienVue() {

		
		mecanicienFrame = new JFrame("Rentacar");
		mecanicienTextContent.setLayout(new BoxLayout(mecanicienTextContent, BoxLayout.Y_AXIS));
		mecanicienTextContent.add(mecanicienMessage);
		
		mecanicienFrame.add(mecanicienTextContent, BorderLayout.NORTH);
		/*
		JPanel panelbuttons = new JPanel();
		panelbuttons.add(modifMdp);
		mecanicienFrame.add(panelbuttons, BorderLayout.SOUTH);
		*/
		mecanicienFrame.pack();
		mecanicienFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mecanicienFrame.setSize(500, 400);
		mecanicienFrame.setLocation(300, 400);
		mecanicienFrame.setVisible(true);
		
		//modifMdp.addActionListener(this);
		//mecanicienFrame.pack();
	}

	/*
	@Override
	public void actionPerformed(ActionEvent arg0) {
		mecanicienFrame.setVisible(false);
		ModifierMdpVue m = new ModifierMdpVue();		
	}
	*/
}
