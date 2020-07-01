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
		this.prenom = "méca";
		this.nom = "nicien";
		this.mdp = "mec";
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
