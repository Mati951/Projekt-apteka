package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

/**
 * 
 */
public class Rachunki extends Kasa {

    /**
     * Default constructor
     */
    public Rachunki() {
    }

    /**
     * 
     */
    public Integer seria = 0;
    
    public Double kwotaRachunku;

    public Integer getSeria() {
		return seria;
	}

	public void setSeria(Integer seria) {
		this.seria = seria;
	}

	public Double getKwotaRachunku() {
		return kwotaRachunku;
	}

	public void setKwotaRachunku(Double kwotaRachunku) {
		this.kwotaRachunku = kwotaRachunku;
	}

	public void setCurrentId() throws Exception {
    	Statement st = ConnectToDB.con.createStatement();
		ResultSet rs2 = st.executeQuery("select seria from rachunki");
		while (rs2.next()) {
			this.seria++;
		}
    }

}