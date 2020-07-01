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
		this.nom = "loyé";
		this.mdp = "emp";
	}
	/**
	 * Cette méthode est utile à récupérer le mdp pour le comparer à celui rentré
	 */
	public String getMdp() {
		return mdp;
	}
	/**
	 * Cette méthode est utile à modifier le mot de passe
	 */
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
}
