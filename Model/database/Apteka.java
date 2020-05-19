package database;

import java.util.*;

/**
 * 
 */
public class Apteka {

    /**
     * Default constructor
     */
    public Apteka() {
    }

    /**
     * 
     */
    public String nazwa;

	/**
     * 
     */
    public String adres;

    /**
     * 
     */
    public String telefon;

    /**
     * 
     */
    public String adressWWW;

    public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getAdressWWW() {
		return adressWWW;
	}

	public void setAdressWWW(String adressWWW) {
		this.adressWWW = adressWWW;
	}


}