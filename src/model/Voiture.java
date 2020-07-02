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
	private String puissance;
	private String bva;
	private String gps;
	private String porte;
	private String clim;
	private static int i = 0;
	/**
	 * 
	 */
	public Voiture() {
		this.marque = "marque_"+i;
		this.type = "type_"+i;
		this.puissance = "600";
		this.bva = "oui";
		this.gps = "oui";
		this.porte = "3";
		this.clim = "oui";
		i++;
	}
	public Voiture(String marque, String type, String puissance, String bva, String gps, String porte, String clim) {
		this.marque = marque + '_' + i;
		this.type = type + '_' + i;
		this.puissance = puissance;
		this.bva = bva;
		this.gps = gps;
		this.porte = porte;
		this.clim = clim;
		i++;
	}
	@Override
	public String toString() {
		return "marque=" + marque + ", type=" + type + ", puissance=" + puissance + ", bva=" + bva + ", gps="
				+ gps + ", porte=" + porte + ", clim=" + clim;
	}
	public static int getI() {
		return i;
	}
	public static void setI(int i) {
		Voiture.i = i;
	}
	
	

}
