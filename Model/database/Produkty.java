package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

/**
 * 
 */
public class Produkty extends Magazyn {

    /**
     * Default constructor
     */
    public Produkty() {
    }

    /**
     * 
     */
    public String nazwa;

    /**
     * 
     */
    public Integer dawka;

    /**
     * 
     */
    public String typ;

    /**
     * 
     */
    public Integer id;
    
    public int ilosc;

	public int getIlosc() {
		return ilosc;
	}

	public void setIlosc(int ilosc) {
		this.ilosc = ilosc;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public Integer getDawka() {
		return dawka;
	}

	public void setDawka(Integer dawka) {
		this.dawka = dawka;
	}

	public String getTyp() {
		return typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setCurrentId() throws Exception {
		Statement st = ConnectToDB.con.createStatement();
		ResultSet rs2 = st.executeQuery("select * from produkty");
		while (rs2.next()) {
			this.id++;
		}
	}

    
}