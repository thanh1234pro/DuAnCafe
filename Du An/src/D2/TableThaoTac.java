package D2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
public class TableThaoTac {
	public static List<Table> findAll() {
		List<Table> listTable = new ArrayList<Table>();
		try {
			String dbURL = "jdbc:sqlserver://localhost;databaseName=QLcafe;user=sa;password=101101";
			Connection conn = DriverManager.getConnection(dbURL);

			String sql = "Select * from BAN";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				Table table = new Table(rs.getInt("sttban"), rs.getString("tenban"), rs.getString("trangthai"),
						rs.getString("ghichu"));
				listTable.add(table);
			}
			rs.close();
			st.close();
			conn.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return listTable;
}
	public static void insert(Table std) {
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			String dbURL = "jdbc:sqlserver://localhost;databaseName=QLcafe;user=sa;password=101101";
			conn = DriverManager.getConnection(dbURL);
	        
	        String sql = "INSERT INTO BAN(tenban,trangthai,ghichu) VALUES(?,?,?)";
	        
	        statement = conn.prepareCall(sql);
	        statement.setString(1,std.getTenban());
	        statement.setString(2,std.getTrangthai());
	        statement.setString(3,std.getGhichu());
	      
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
	        
			String sql = "delete from BAN where sttban=?";
			 statement = conn.prepareCall(sql);
			 statement.setInt(1, stt);
			 
			 statement.execute();
		     statement.close();
		     conn.close();
	        
		}catch (SQLException ex) {
			JOptionPane.showInternalMessageDialog(null, ex.getMessage());
		}
		
		}
	
	public static void update(Table table) {
		System.out.println(table.getGhichu());
		System.out.println(table.getSttban());
		Connection conn = null;
		PreparedStatement statement = null;
		
		try {
			String dbURL = "jdbc:sqlserver://localhost;databaseName=QLcafe;user=sa;password=101101";
			conn = DriverManager.getConnection(dbURL);
			String sql = "update BAN set tenban=?, trangthai=?, ghichu=? WHERE sttban=?";
			statement = conn.prepareCall(sql);
			statement.setString(1, table.getTenban());
			statement.setString(2, table.getTrangthai());
			statement.setString(3, table.getGhichu());
			statement.setInt(4, table.getSttban());
		     statement.executeUpdate();
			 
		     statement.close();
		     conn.close();
	        
		}catch (SQLException ex) {
			JOptionPane.showInternalMessageDialog(null, ex.getMessage());
		}
		}
}
