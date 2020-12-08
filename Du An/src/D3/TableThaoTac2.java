package D3;

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
public class TableThaoTac2 {
	public static List<Table2> findAll() {
		List<Table2> listTable = new ArrayList<Table2>();
		try {
			String dbURL = "jdbc:sqlserver://localhost;databaseName=QLcafe;user=sa;password=101101";
			Connection conn = DriverManager.getConnection(dbURL);

			String sql = "Select * from SANPHAM";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				Table2 table2 = new Table2(rs.getInt("sttsp"),rs.getString("tensanpham"), rs.getString("giaban"), rs.getString("ngaykm"),
						rs.getString("ngayhetkm"));
				listTable.add(table2);
			}
			rs.close();
			st.close();
			conn.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return listTable;
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
	        
			String sql = "delete from SANPHAM where sttsp=?";
			 statement = conn.prepareCall(sql);
			 statement.setInt(1, dou);
			 statement.execute();
		     statement.close();
		     conn.close();
	        
		}catch (SQLException ex) {
			JOptionPane.showInternalMessageDialog(null, ex.getMessage());
		}
		
		}
	public static void update(Table2 ble) {
		System.out.println(ble.getSttsp());
		Connection conn = null;
		PreparedStatement dou = null;
		
		try {
			String dbURL = "jdbc:sqlserver://localhost;databaseName=QLcafe;user=sa;password=101101";
			conn = DriverManager.getConnection(dbURL);
			String sql = "update SANPHAM set tensanpham=?, giaban=?, ngaykm=?, ngayhetkm=? WHERE sttsp=?";
			dou = conn.prepareCall(sql);
			dou.setString(1,ble.getTensanpham());
			dou.setString(2,ble.getGiaban());
			dou.setString(3,ble.getNgaykm());
			dou.setString(4,ble.getNgayhetkm());
			dou.setInt(5,ble.getSttsp());
			dou.executeUpdate();
			 
			dou.close();
		     conn.close();
	        
		}catch (SQLException ex) {
			JOptionPane.showInternalMessageDialog(null, ex.getMessage());
		}
		}
}
