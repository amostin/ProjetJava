/**
 * 
 */
package model;

/**
 * Cette classe sert à contenir les infos relative au gérant
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
