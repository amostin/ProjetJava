/**
 * 
 */
package model;

/**
 * Cette classe est utile à créer des voitures
 * @author Ambroise Mostin
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
	 * Ce constructeur permet de créer une voiture automatiquement
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
	/**
	 * Ce constructeur permet de créer une voiture selon les caractéristiques choisies
	 */
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
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPuissance() {
		return puissance;
	}
	public void setPuissance(String puissance) {
		this.puissance = puissance;
	}
	public String getBva() {
		return bva;
	}
	public void setBva(String bva) {
		this.bva = bva;
	}
	public String getGps() {
		return gps;
	}
	public void setGps(String gps) {
		this.gps = gps;
	}
	public String getPorte() {
		return porte;
	}
	public void setPorte(String porte) {
		this.porte = porte;
	}
	public String getClim() {
		return clim;
	}
	public void setClim(String clim) {
		this.clim = clim;
	}
	
	

}
