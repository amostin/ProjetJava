/**
 * 
 */
package model;

/**
 * Cette classe permet d'accorder l'acc�s � la vue via le mdp pour un employ�
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
		this.nom = "loy�";
		this.mdp = "emp";
	}
	/**
	 * Cette m�thode permet de r�cup�rer le mdp pour le comparer � celui rentr�
	 * @return le mot de passe
	 */
	public String getMdp() {
		return mdp;
	}
	/**
	 * Cette m�thode permet de modifier le mot de passe
	 * @param mdp le mot de passe
	 */
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
}
