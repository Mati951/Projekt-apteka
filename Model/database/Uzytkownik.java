package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

/**
 * 
 */
public class Uzytkownik {

	public Statement st;
	public ResultSet rs;

	public String getNazwaU() {
		return nazwaU;
	}

	public void setNazwaU(String nazwaU) {
		this.nazwaU = nazwaU;
	}

	public char[] getHaslo() {
		return haslo;
	}

	public void setHaslo(char[] haslo) {
		this.haslo = haslo;
	}

	public Typ getTyp() {
		return typ;
	}

	public void setTyp(Typ typ) {
		this.typ = typ;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getWiek() {
		return wiek;
	}

	public void setWiek(Integer wiek) {
		this.wiek = wiek;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	/**
	 * Default constructor
	 */
	public Uzytkownik() {
	}

	/**
	 * 
	 */
	protected String nazwaU;

	/**
	 * 
	 */
	protected char[] haslo;

	/**
	 * 
	 */
	protected Typ typ;

	/**
	 * 
	 */

	protected String imie;

	/**
	 * 
	 */
	public Integer id;

	/**
	 * 
	 */
	protected Integer wiek;

	/**
	 * 
	 */
	protected String nazwisko;

	public void dodajUzytkownikaDB() throws Exception {
		ConnectToDB.polacz();
		String hasloDB = new String(this.haslo);
		st = ConnectToDB.con.createStatement();
		rs = st.executeQuery("Insert into uzytkownik(id_uzytkownik,nazwau,haslo,imie,wiek,nazwisko,typ) values(" + this.id
				+ "," + this.nazwaU + "," + hasloDB + ","+ this.imie + ","  + this.wiek + "," + this.nazwisko + ",NULL)");
		ConnectToDB.rozlacz();
	}
	public void setIdFromDB() throws Exception {
		st = ConnectToDB.con.createStatement();
		ResultSet rs2 = st.executeQuery("Select id_uzytkownik from uzytkownik");
		while (rs2.next()) {
			this.id++;
		}
	}

}