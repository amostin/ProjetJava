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
	private String etat;
	private String prix;
	private String prixKm;
	private String amende;
	private static int i = 0;
	/**
	 * Ce constructeur permet de créer une voiture automatiquement
	 */
	public Voiture(int variete) {
		switch (variete) {
		case 0:
			this.marque = "marque_"+i;
			this.type = "type_"+i;
			this.puissance = "2000";
			this.bva = "oui";
			this.gps = "oui";
			this.porte = "3";
			this.clim = "oui";
			this.prix = "100.0";
			this.prixKm = "5.0";
			this.amende = "50.0";
			this.etat = "disponible";
			i++;
			break;
			
		case 1:
			this.marque = "marque_"+i;
			this.type = "type_"+i;
			this.puissance = "1800";
			this.bva = "non";
			this.gps = "oui";
			this.porte = "3";
			this.clim = "oui";
			this.prix = "90.0";
			this.prixKm = "4.5";
			this.amende = "45.0";
			this.etat = "disponible";
			i++;
			break;
			
		case 2:
			this.marque = "marque_"+i;
			this.type = "type_"+i;
			this.puissance = "1600";
			this.bva = "oui";
			this.gps = "non";
			this.porte = "3";
			this.clim = "non";
			this.prix = "80.0";
			this.prixKm = "4.0";
			this.amende = "40.0";
			this.etat = "disponible";
			i++;
			break;
			
		case 3:
			this.marque = "marque_"+i;
			this.type = "type_"+i;
			this.puissance = "1500";
			this.bva = "non";
			this.gps = "oui";
			this.porte = "5";
			this.clim = "oui";
			this.prix = "70.0";
			this.prixKm = "3.5";
			this.amende = "35.0";
			this.etat = "disponible";
			i++;
			break;
			
		case 4:
			this.marque = "marque_"+i;
			this.type = "type_"+i;
			this.puissance = "1400";
			this.bva = "oui";
			this.gps = "non";
			this.porte = "5";
			this.clim = "non";
			this.prix = "60.0";
			this.prixKm = "3.0";
			this.amende = "30.0";
			this.etat = "disponible";
			i++;
			break;
			
		case 5:
			this.marque = "marque_"+i;
			this.type = "type_"+i;
			this.puissance = "1300";
			this.bva = "non";
			this.gps = "non";
			this.porte = "3";
			this.clim = "non";
			this.prix = "50.0";
			this.prixKm = "2.5";
			this.amende = "25.0";
			this.etat = "disponible";
			i++;
			break;
			
		case 6:
			this.marque = "marque_"+i;
			this.type = "type_"+i;
			this.puissance = "1200";
			this.bva = "non";
			this.gps = "non";
			this.porte = "5";
			this.clim = "oui";
			this.prix = "40.0";
			this.prixKm = "2.0";
			this.amende = "20.0";
			this.etat = "disponible";
			i++;
			break;
			
		case 7:
			this.marque = "marque_"+i;
			this.type = "type_"+i;
			this.puissance = "1100";
			this.bva = "oui";
			this.gps = "oui";
			this.porte = "5";
			this.clim = "non";
			this.prix = "30.0";
			this.prixKm = "1.5";
			this.amende = "15.0";
			this.etat = "disponible";
			i++;
			break;
			
		case 8:
			this.marque = "marque_"+i;
			this.type = "type_"+i;
			this.puissance = "1000";
			this.bva = "non";
			this.gps = "oui";
			this.porte = "5";
			this.clim = "non";
			this.prix = "20.0";
			this.prixKm = "1.0";
			this.amende = "10.0";
			this.etat = "disponible";
			i++;
			break;
			
		case 9:
			this.marque = "marque_"+i;
			this.type = "type_"+i;
			this.puissance = "800";
			this.bva = "oui";
			this.gps = "non";
			this.porte = "5";
			this.clim = "oui";
			this.prix = "15.0";
			this.prixKm = "0.75";
			this.amende = "7.5";
			this.etat = "disponible";
			i++;
			break;
			
		

		default:
			break;
		}

	}
	/**
	 * Ce constructeur permet de créer une voiture selon les caractéristiques choisies
	 */
	public Voiture(String marque, String type, String puissance, String bva, String gps, String porte, String clim, String prix, String prixKm, String amende) {
		this.marque = marque + '_' + i;
		this.type = type + '_' + i;
		this.puissance = puissance;
		this.bva = bva;
		this.gps = gps;
		this.porte = porte;
		this.clim = clim;
		this.prix = prix;
		this.prixKm = prixKm;
		this.amende = amende;
		this.etat = "disponible";
		i++;
	}
	@Override
	public String toString() {
		return "marque=" + marque + ", type=" + type + ", puissance=" + puissance + ", bva=" + bva + ", gps="
				+ gps + ", porte=" + porte + ", clim=" + clim + ", etat=" + etat + ", prix=" + prix + ", prixKm=" + prixKm + ", amende=" + amende;
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
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	
	

}
