/**
 * 
 */
package model;

/**
 * @author Moi
 *
 */
public class Voiture {

	private String marque;
	private String type;
	private int puissance;
	private boolean bva;
	private boolean gps;
	private int porte;
	private boolean clim;
	private static int i = 1;
	/**
	 * 
	 */
	public Voiture() {
		this.marque = "marque_"+i;
		this.type = "type_"+i;
		this.puissance = 600;
		this.bva = true;
		this.gps = true;
		this.porte = 2;
		this.clim = true;
		i++;
	}
	public Voiture(String marque, String type, int puissance, boolean bva, boolean gps, int porte, boolean clim) {
		this.marque = marque;
		this.type = type;
		this.puissance = puissance;
		this.bva = bva;
		this.gps = gps;
		this.porte = porte;
		this.clim = clim;
	}
	@Override
	public String toString() {
		return "marque=" + marque + ", type=" + type + ", puissance=" + puissance + ", bva=" + bva + ", gps="
				+ gps + ", porte=" + porte + ", clim=" + clim;
	}
	
	

}
