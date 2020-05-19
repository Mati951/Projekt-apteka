package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

/**
 * 
 */
public class Kasa extends Apteka {

    /**
     * Default constructor
     */
    public Kasa() {
    }

    /**
     * 
     */
    public Boolean stanKasy;

    /**
     * 
     */
    protected Double pieniadze;

    /**
     * 
     */
    public Date data = new Date();

    /**
     * 
     */
    public List<Dzien> dzien = new ArrayList<Dzien>();


    /**
     * @param stanKasy 
     * @param dzien 
     * @return
     */
    public Date otworzZamknijKase(Boolean stanKasy) {
    	String str = "Kasa zostala ";
        if(!stanKasy) {
        	this.stanKasy = true;
        	str += "Otwarta";
        }else {
        	this.stanKasy = false;
        	str += "Zamknieta";
        }
        
        System.out.println(str);
        return data;
    }

	public Boolean getStanKasy() {
		return stanKasy;
	}

	public void setStanKasy(Boolean stanKasy) {
		this.stanKasy = stanKasy;
	}

	public Double getPieniadze() {
		return pieniadze;
	}

	public void setPieniadze(Double double1) {
		this.pieniadze = double1;
	}
	
	public void dodajPieniadze(Double double1) {
		this.pieniadze += double1;
	}
	
	public void odejmijPieniadze(Double double1) {
		this.pieniadze -= double1;
	}
	
	

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	public void setCurrentPieniadze() throws Exception {
		Statement st = ConnectToDB.con.createStatement();
		ResultSet rs2 = st.executeQuery("select pieniadze from kasa");
		while (rs2.next()) {
			this.pieniadze = rs2.getDouble(1);
		}
	}
    
}