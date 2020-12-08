package D5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
public class TableThaoTac4 {
	public static List<Table4> findAll() {
		List<Table4> listTable = new ArrayList<Table4>();
		try {
			String dbURL = "jdbc:sqlserver://localhost;databaseName=QLcafe;user=sa;password=101101";
			Connection conn = DriverManager.getConnection(dbURL);

			String sql = "Select * from NGUOIDUNG";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Table4 table4 = new Table4(rs.getInt("stt"), rs.getString("name"), 
						rs.getString("username"),  rs.getString("password"),  rs.getString("comfirmpass"));
				listTable.add(table4);
			}
			rs.close();
			st.close();
			conn.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return listTable;
	}
	public static void insert(Table4 use) {
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			String dbURL = "jdbc:sqlserver://localhost;databaseName=QLcafe;user=sa;password=101101";
			conn = DriverManager.getConnection(dbURL);
	        
	        String sql = "INSERT INTO NGUOIDUNG(name,username,password,comfirmpass) VALUES(?,?,?,?)";
	        
	        statement = conn.prepareCall(sql);
	        statement.setString(1,use.getName());
	        statement.setString(2,use.getUsername());
	        statement.setString(3,use.getPassword());
	        statement.setString(4,use.getComfirmpass());
	      
	        statement.execute();
	        statement.close();
	        conn.close();
	        
		}catch (SQLException ex) {
			JOptionPane.showInternalMessageDialog(null, ex.getMessage());
		}
		
	}
	public static void delete(int stt) {
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			String dbURL = "jdbc:sqlserver://localhost;databaseName=QLcafe;user=sa;password=101101";
			conn = DriverManager.getConnection(dbURL);
	        
			String sql = "delete from NGUOIDUNG where stt=?";
			 statement = conn.prepareCall(sql);
			 statement.setInt(1, stt);
			 
			 statement.execute();
		     statement.close();
		     conn.close();
	        
		}catch (SQLException ex) {
			JOptionPane.showInternalMessageDialog(null, ex.getMessage());
		}
		
		}

}
