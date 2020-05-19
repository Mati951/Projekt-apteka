package database;

import java.util.*;

/**
 * 
 */
public class Dzien {

    /**
     * Default constructor
     */
    public Dzien() {
    }

    /**
     * 
     */
    public Float pieniadze;

    /**
     * 
     */
    public Integer iloscSprzedanychProduktow;

    /**
     * @param pieniadze 
     * @param iloscSprzedanychProduktow
     */
    public void odnotujSprzedaz(Float pieniadze, Integer iloscSprzedanychProduktow) {
        // TODO implement here
    }

	public Float getPieniadze() {
		return pieniadze;
	}

	public void setPieniadze(Float pieniadze) {
		this.pieniadze = pieniadze;
	}

	public Integer getIloscSprzedanychProduktow() {
		return iloscSprzedanychProduktow;
	}

	public void setIloscSprzedanychProduktow(Integer iloscSprzedanychProduktow) {
		this.iloscSprzedanychProduktow = iloscSprzedanychProduktow;
	}
    
}