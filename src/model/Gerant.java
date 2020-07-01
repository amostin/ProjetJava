/**
 * 
 */
package model;

/**
 * @author Moi
 *
 */
public class Gerant {

	private String prenom = "Gerant";
	private String nom = "Rentacar";
	private String mdp = "mdp";
	/**
	 * 
	 */
	public Gerant() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Gerant(String prenom, String nom, String mdp) {
		this.prenom = prenom;
		this.nom = nom;
		this.mdp = mdp;
	}



	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

}
