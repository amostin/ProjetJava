/**
 * 
 */
package model;

/**
 * Cette classe permet d'accorder l'accès à la vue via le mdp pour un employé
 * @author Ambroise Mostin
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
	 * Cette méthode permet de récupérer le mdp pour le comparer à celui rentré
	 * @return le mot de passe
	 */
	public String getMdp() {
		return mdp;
	}
	/**
	 * Cette méthode permet de modifier le mot de passe
	 * @param mdp le mot de passe
	 */
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
}
