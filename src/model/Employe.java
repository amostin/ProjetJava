/**
 * 
 */
package model;

/**
 * @author Moi
 *
 */
public class Employe {
	private String prenom;
	private String nom;
	private String mdp;
	/**
	 * Ce contructeur permet d'attribuer des valeurs aux variables d'instance
	 */
	public Employe() {
		this.prenom = "emp";
		this.nom = "loy�";
		this.mdp = "emp";
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
