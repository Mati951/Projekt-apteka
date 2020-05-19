package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

/**
 * 
 */
public class Magazyn {

	/**
	 * Default constructor
	 */
	public Magazyn() {
	}

	/**
	 * 
	 */
	protected static final Integer iloscMiejsc = 2000;

	protected Integer wolneMiejsca;

	public Integer getWolneMiejsca() {
		return wolneMiejsca;
	}

	public void setWolneMiejsca(Integer wolneMiejsca) {
		this.wolneMiejsca = wolneMiejsca;
	}

	public Integer getIloscmiejsc() {
		return iloscMiejsc;
	}

	/**
	 * @param nazwa
	 */
	public void przeszukaj(Produkty nazwa) {
		// TODO implement here
	}

	/**
	 * @param nazwa
	 * @throws Exception 
	 */
	public void sprawdzIlosc() throws Exception {
		Statement st = ConnectToDB.con.createStatement();
		ResultSet rs2 = st.executeQuery("select ilosc_wolnych_miejsc from magazyn where \"id_magazyn\" = 0");
		while (rs2.next()) {
			this.wolneMiejsca = rs2.getInt(1);
			System.out.println(wolneMiejsca);
		}
	}

}