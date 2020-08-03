/**
 * 
 */
package model;

/**
 * Cette classe permet d'accorder l'accès à la vue via le mdp pour le gérant
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
