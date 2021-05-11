package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Baglanti {
	protected PreparedStatement ps=null;
	
	Statement stmt;
	protected ResultSet rs;
	private final String base="test";
	private final String user="root";

	private final String password="samet";

	private final String url="jdbc:mysql://localhost:3306/"+base;
    protected Connection con = null;
    public Connection getBaglanti() {
    	
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(this.url,this.user,this.password);
			
		} catch (Exception e) {
			System.err.println(e);
		}
		return con;
    }
    public ResultSet result(String query) {
		try {
			getBaglanti();
			stmt=getBaglanti().createStatement();  
			rs=stmt.executeQuery(query);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	

}
