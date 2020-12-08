package D4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import D2.Table;
import D3.Table2;
public class TableThaoTac3 {
		public static List<Table3> findAll() {
			List<Table3> listTable = new ArrayList<Table3>();
			try {
				String dbURL = "jdbc:sqlserver://localhost;databaseName=QLcafe;user=sa;password=101101";
				Connection conn = DriverManager.getConnection(dbURL);
	
				String sql = "Select * from CHITIETHOADON";
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(sql);
				while (rs.next()) {
					Table3 table3 = new Table3(rs.getInt("sttcthd"),rs.getString("tensanpham"),
							rs.getInt("giaban"), rs.getInt("soluong"), rs.getInt("thanhtien"));
					listTable.add(table3);
				}
				rs.close();
				st.close();
				conn.close();
	
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			return listTable;
		}

	public static ArrayList<String> LoadDataCombobox() {
			ArrayList<String> list = new ArrayList<String>();
			Connection conn = null;
			ResultSet result = null;
			try {
			} catch (Exception e) {
			}
			return list;
		}
	public static void insert(Table3 std) {
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			String dbURL = "jdbc:sqlserver://localhost;databaseName=QLcafe;user=sa;password=101101";
			conn = DriverManager.getConnection(dbURL);
	        
	        String sql = "INSERT INTO CHITIETHOADON(tensanpham,giaban,soluong,thanhtien) VALUES(?,?,?,?)";
	        
	        statement = conn.prepareCall(sql);
	        statement.setString(1,std.getTensanpham());
	        statement.setInt(2,std.getGiaban());
	        statement.setInt(3,std.getSoluong());
	        statement.setInt(4,std.getThanhtien());
	      
	        statement.execute();
	        statement.close();
	        conn.close();
	        
		}catch (SQLException ex) {
			JOptionPane.showInternalMessageDialog(null, ex.getMessage());
		}
		
		}
	public static void insert(Table2 dou) {
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			String dbURL = "jdbc:sqlserver://localhost;databaseName=QLcafe;user=sa;password=101101";
			conn = DriverManager.getConnection(dbURL);
	        
	        String sql = "INSERT INTO SANPHAM(tensanpham,giaban,ngaykm,ngayhetkm) VALUES(?,?,?,?)";
	        
	        statement = conn.prepareCall(sql);
	        statement.setString(1,dou.getTensanpham());
	        statement.setString(2,dou.getGiaban());
	        statement.setString(3,dou.getNgaykm());
	        statement.setString(4,dou.getNgayhetkm());
	      
	        statement.execute();
	        statement.close();
	        conn.close();
	        
		}catch (SQLException ex) {
			JOptionPane.showInternalMessageDialog(null, ex.getMessage());
		}
		
		}
	public static void delete(int dou) {
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			String dbURL = "jdbc:sqlserver://localhost;databaseName=QLcafe;user=sa;password=101101";
			conn = DriverManager.getConnection(dbURL);
	        
			String sql = "delete from SANPHAM where stt=?";
			 statement = conn.prepareCall(sql);
			 statement.setInt(1, dou);
			 
			 statement.execute();
		     statement.close();
		     conn.close();
	        
		}catch (SQLException ex) {
			JOptionPane.showInternalMessageDialog(null, ex.getMessage());
		}
		
		}
	public static void update(Table3 ble) {
		
		System.out.println(ble.getSttcthd());
		Connection conn = null;
		PreparedStatement dou = null;
		
		try {
			String dbURL = "jdbc:sqlserver://localhost;databaseName=QLcafe;user=sa;password=101101";
			conn = DriverManager.getConnection(dbURL);
			String sql = "update SANPHAM set tensanpham=?, giaban=?, ngaykm=?, ngayhetkm=? WHERE stt=?";
			dou = conn.prepareCall(sql);
			dou.setString(1,ble.getTensanpham());
			dou.setInt(2,ble.getGiaban());
			dou.setInt(5,ble.getSttcthd());
			dou.executeUpdate();
			 
			dou.close();
		     conn.close();
	        
		}catch (SQLException ex) {
			JOptionPane.showInternalMessageDialog(null, ex.getMessage());
		}
		}
}
