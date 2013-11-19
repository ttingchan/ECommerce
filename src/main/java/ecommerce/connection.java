package ecommerce;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;

public class connection {
	
	private Connection connect = null;
	private String url = "jdbc:mysql://localhost:8088//cd";
	private String usr = "root";
	private String pwd = "";
	public connection()throws Exception{
		try{
			connect = DriverManager.getConnection(url, usr, pwd);
		}catch (SQLException e){
			System.out.println("SQLException:" + e.getMessage());
			System.out.println("SQLState" + e.getSQLState());
			System.out.println("VendoError:" + e.getErrorCode());
		}finally {
			close();
		}
	}

	private void close() {
		// TODO Auto-generated method stub
		
	}

	
	
}
