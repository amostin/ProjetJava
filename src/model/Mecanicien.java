/**
 * 
 */
package model;

/**
 * @author Moi
 *
 */
public class Mecanicien {

	private String prenom;
	private String nom;
	private String mdp;
	/**
	 * Ce contructeur permet d'attribuer des valeurs aux variables d'instance
	 */
	public Mecanicien() {
		this.prenom = "m�ca";
		this.nom = "nicien";
		this.mdp = "mec";
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
