package D5;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  try {
	            String dbURL = "jdbc:sqlserver://LAPTOP-MAPRODR3\\SQLEXPRESS;databaseName=QLcafe;user=sa;password=101101";
	            Connection conn = DriverManager.getConnection(dbURL);
	            if (conn != null) {
	            	System.out.println("Connerted");
	                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
	                System.out.println("Driver name: " + dm.getDriverName());
	                System.out.println("Driver version: " + dm.getDriverVersion());
	                System.out.println("Product name: " + dm.getDatabaseProductName());
	                System.out.println("Product version: " + dm.getDatabaseProductVersion());
	            }
	 
	        } catch (SQLException ex) {
	        	System.err.println("Database đã bị lỗi HiHi !" + ex);
	        } 
	}

}
