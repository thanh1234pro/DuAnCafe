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
import D5.Table4;
public class TableThaoTac5 {
		public static List<Table4> findAll() {
			List<Table4> listTable = new ArrayList<Table4>();
			try {
				String dbURL = "jdbc:sqlserver://localhost;databaseName=QLcafe;user=sa;password=101101";
				Connection conn = DriverManager.getConnection(dbURL);
	
				String sql = "Select * from CHITIETHOADON";
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(sql);
				while (rs.next()) {
					Table5 table3 = new Table5(rs.getInt("stthd"),rs.getString("tensanpham"),
							rs.getInt("tongtien"), rs.getString("ngaymua"));
					listTable.addAll(table3);
				}
				rs.close();
				st.close();
				conn.close();
	
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			return listTable;
		}
}