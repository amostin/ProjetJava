/**
 * 
 */
package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.RentacarController;
import model.Rentacar;

/**
 * Cette classe permet d'afficher l'application avec seulement les fonctionnalités utiles à un mécanicien
 * @author Ambroise Mostin
 */
public class MecanicienVue extends RentacarVue {
	private JFrame mecanicienFrame;
	private JPanel mecanicienTextContent = new JPanel();
	private JLabel mecanicienMessage = new JLabel("Bienvenue Gérant");
	private JLabel message = new JLabel("Bienvenue chez Rentacar");

	//private JButton modifMdp = new JButton("Modifier mot de passe");


	/**
	 * Ce constructeur affiche la page pour un mécanicien
	 */
	public MecanicienVue(Rentacar model, RentacarController controller) {
		super(model, controller);

		
		mecanicienFrame = new JFrame("Rentacar");
		mecanicienTextContent.setLayout(new BoxLayout(mecanicienTextContent, BoxLayout.Y_AXIS));
		mecanicienTextContent.add(mecanicienMessage);
		
		mecanicienFrame.add(mecanicienTextContent, BorderLayout.NORTH);
		mecanicienFrame.pack();
		mecanicienFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension tailleEcran = Toolkit.getDefaultToolkit().getScreenSize();
		int height = tailleEcran.height;
		int width = tailleEcran.width;
		mecanicienFrame.setSize((int) (width*0.75), (int) (height*0.75));
		mecanicienFrame.setLocationRelativeTo(null);
		mecanicienFrame.setVisible(true);
	}
	/**
	 * Cette méthode est utile à afficher un message (surtout pour afficher un changement)
	 */
	public void affiche(String msg){
		message.setText(msg);
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
}
