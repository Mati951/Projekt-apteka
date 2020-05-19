package database;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

/**
 * 
 */
public class Kierownik extends Uzytkownik {

	/**
	 * Default constructor
	 */
	public Kierownik() {
	}

	/**
	 * @param Farmaceuta
	 *            farmaceuta
	 */
	public void podsumowanieZmiany(Farmaceuta farmaceuta) {
		// TODO implement here
	}

	/**
	 * @throws Exception
	 * 
	 */
	public void podsumowanie() throws Exception {
		ConnectToDB.polacz();
		Kasa kasa = new Kasa();

		Statement st = ConnectToDB.con.createStatement();

		if (kasa.getStanKasy()) {
			ResultSet rs = st.executeQuery("insert into dzien");
			kasa.getPieniadze();
			kasa.setPieniadze(0.0);
		}

		ConnectToDB.rozlacz();
	}

	/**
	 * @param farmaceuta
	 */
	public void zatrudnijFarmaceute(Farmaceuta farmaceuta) {
		// TODO implement here
	}

	/**
	 * @param farmaceuta
	 */
	public void zwolnijFaremaceute(Farmaceuta farmaceuta) {
		// TODO implement here
	}

	/**
	 * @param farmaceuta
	 */
	public void modyfikujFaremaceute(Farmaceuta farmaceuta) {
		// TODO implement here
	}

	/**
	 * @param zamowienie
	 * @throws Exception 
	 */
	public String zlozZamowienie(String lines[]) throws Exception {
		Zamowienie zamow = new Zamowienie();
		Produkty produkt = new Produkty();
		Magazyn mag = new Magazyn();
		String str = "";
		ConnectToDB.polacz();
		Boolean canI = false;
		st = ConnectToDB.con.createStatement();
		ResultSet rs = st.executeQuery("Select \"id_produkty\", nazwa, ilosc from produkty");
		ResultSet rs2;
		mag.sprawdzIlosc();
		while (rs.next()) {
			produkt.setId(rs.getInt(1));
			produkt.setNazwa(rs.getString(2));
			produkt.setIlosc(rs.getInt(3));
			if ( lines[0].equals(produkt.getNazwa()) && mag.getWolneMiejsca() >= Integer.parseInt(lines[1])) {
				//produkt.setIlosc(produkt.getIlosc() + Integer.parseInt(lines[1]));
				/*System.out.println("update produkty set ilosc =" + produkt.getIlosc() + " where nazwa =' "
						+ produkt.getNazwa() + "'");
				rs = st.executeQuery("update produkty set ilosc =" + produkt.getIlosc() + "where nazwa = '"
						+ produkt.getNazwa() + "'");*/
				zamow.setCurrentId();
				System.out.println(
						"insert into zamowienie(id_zamowienia,rodzaj,stan,ilosc,klient_id_klient,produkty_id_produkty) values("
								+ zamow.getIdZamowienia() + ",'SKLEP','false'," + Integer.parseInt(lines[1]) + ", NULL ,"
								+ produkt.getId() + ")");
				rs2 = st.executeQuery(
						"insert into zamowienie(id_zamowienia,rodzaj,stan,ilosc,klient_id_klient,produkty_id_produkty) values("
								+ zamow.getIdZamowienia() + ",'SKLEP','false'," + Integer.parseInt(lines[1]) + ", NULL ,"
								+ produkt.getId() + ")");

				 str = "Zamowiles " + produkt.getNazwa() + " do sklepu, w ilosci: " +
				 Integer.parseInt(lines[1]) + ". ID twojego zamowienia to: "+
				 zamow.getIdZamowienia() +". Podaj je w kasie.\n";
				 canI = true;
				break;
			}
		} if (mag.getWolneMiejsca() >= Integer.parseInt(lines[1]) && !canI) {
			produkt.setCurrentId();
			zamow.setCurrentId();
			System.out.println("insert into produkty(\"id_produkty\",koszt,nazwa,dawka,typ,ilosc,MAGAZYN_ID_MAGAZYN) values(" + produkt.getId() + "," + Double.parseDouble(lines[2]) + ",'" + lines[0]+ "','" + lines[3] + "','" + lines[4] + "',0,0)");
			System.out.println("insert into zamowienie(id_zamowienia,rodzaj,stan,ilosc,klient_id_klient,produkty_id_produkty) values("
					+ zamow.getIdZamowienia() + ",'SKLEP','false'," + Integer.parseInt(lines[1]) + ", NULL ,"
					+ produkt.getId() + ")"); 
			ResultSet rs3 = st.executeQuery("insert into produkty(\"id_produkty\",koszt,nazwa,dawka,typ,ilosc,MAGAZYN_ID_MAGAZYN) values(" + produkt.getId() + "," + Double.parseDouble(lines[2]) + ",'" + lines[0]+ "','" + lines[3] + "','" + lines[4] + "',0,0)"); 
			rs3 = st.executeQuery("insert into zamowienie(id_zamowienia,rodzaj,stan,ilosc,klient_id_klient,produkty_id_produkty) values("
					+ zamow.getIdZamowienia() + ",'SKLEP','false'," + Integer.parseInt(lines[1]) + ", NULL ,"
					+ produkt.getId() + ")");
		}else if(mag.getWolneMiejsca() < Integer.parseInt(lines[1])){
			str = "Nie mamy wystarczajacej ilosci miejsc w magazynie";
		}

		ConnectToDB.rozlacz();
		return str;
	}

}