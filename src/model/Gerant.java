/**
 * 
 */
package model;

/**
 * Cette classe sert � contenir les infos relative au g�rant
 * @author Ambroise Mostin
 *
 */
public class Gerant {

	private String prenom;
	private String nom;
	private String mdp;
	/**
	 * Ce contructeur permet d'attribuer des valeurs aux variables d'instance
	 */
	public Gerant() {
		this.prenom = "Gerant";
		this.nom = "Rentacar";
		this.mdp = "mdp";
	}
	/**
	 * Cette m�thode est utile � r�cup�rer le mdp pour le comparer � celui rentr�
	 */
	public String getMdp() {
		return mdp;
	}
	/**
	 * Cette m�thode est utile � modifier le mot de passe
	 */
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

}
