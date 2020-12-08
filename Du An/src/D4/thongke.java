package D4;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import D2.Table;
import D2.TableThaoTac;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class thongke extends JPanel {
	private static JTable table3;
	private List<Table> listTable = new ArrayList<Table>();
	private List<Table3> listTable3 = new ArrayList<Table3>();
	private DefaultTableModel dfModel;
	private JTextField textField_1;
	private JTable table;
	private JTextField txtSoluong;
	protected static int myindex;
	JComboBox comboBox = new JComboBox();
	protected Object item;
	private JTextField txtGia;
	/**S
	 * Create the panel.
	 */
	public thongke() {
		addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		setForeground(new Color(0, 0, 0));
		setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 153, 153)));
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("QUẢN LÝ BÁN HÀNG");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\Java Desktop\\IM CAFE\\shop-icon.png"));
		lblNewLabel_1.setBounds(374, 25, 263, 57);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tổng tiền:");
		lblNewLabel_1_1.setBounds(860, 191, 105, 36);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		add(lblNewLabel_1_1);
		
		JScrollPane scrollPane3 = new JScrollPane();
		scrollPane3.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		scrollPane3.setBounds(427, 191, 423, 266);
		add(scrollPane3);	
		table3 = new JTable();
		table3.setFont(new Font("Times New Roman", Font.BOLD, 12));
		table3.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "Tên sản phẩm", "Gia bán", "Số lượng", "Thành tiền"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class
			};
			boolean[] columnEditables = new boolean[] {
				false, true, true, true
			};
		});
		scrollPane3.setViewportView(table3);
		
		JButton themban = new JButton(" Thêm đồ uống");
		themban.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int  giaban,soluong,thanhtien;
				String tensanpham = comboBox.getSelectedItem().toString();
				giaban = Integer.parseInt(txtGia.getText());
				soluong = Integer.parseInt(txtSoluong.getText());
				thanhtien = giaban*soluong;
				
				Table3 ban = new Table3(tensanpham,giaban,soluong,thanhtien);
				
				TableThaoTac3.insert(ban);
				
				ShowTable3();
			}
		});
		themban.setBackground(new Color(248, 248, 255));
		themban.setIcon(new ImageIcon("E:\\Java Desktop\\IM CAFE\\add-1-icon.png"));
		themban.setFont(new Font("Times New Roman", Font.BOLD, 14));
		themban.setBounds(692, 102, 158, 64);
		add(themban);
		
		JButton xoaban = new JButton("Thanh toán");
		xoaban.setBackground(new Color(255, 240, 245));
		xoaban.setIcon(new ImageIcon("E:\\Java Desktop\\IM CAFE\\money-icon (1).png"));
		xoaban.setFont(new Font("Times New Roman", Font.BOLD, 14));
		xoaban.setBounds(860, 102, 158, 64);
		add(xoaban);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(860, 234, 166, 29);
		add(textField_1);
		
	
		ArrayList<String> lish  = TableThaoTac3.LoadDataCombobox();
		for (String item: lish){
			comboBox.addItem(item.toString());
			
		}
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setBorder(new MatteBorder(3, 5, 4, 15, (Color) new Color(0, 153, 255)));
		comboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		comboBox.setBounds(427, 102, 210, 29);
		add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 191, 382, 266);
		add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.BOLD, 12));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "Tên bàn", "Trạng thái", "Ghi chú"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		txtSoluong = new JTextField();
		txtSoluong.setBorder(new MatteBorder(2, 5, 2, 15, (Color) new Color(0, 153, 204)));
		txtSoluong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				myindex = table3.getSelectedRow();
				table3.setValueAt(txtSoluong.getText().toString(), myindex,3);
			}
		});
		txtSoluong.setBounds(524, 141, 113, 29);
		add(txtSoluong);
		txtSoluong.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Số lượng:");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(427, 141, 92, 29);
		add(lblNewLabel_1_1_1);
		
		txtGia = new JTextField();
		txtGia.setBounds(541, 68, 96, 19);
		add(txtGia);
		txtGia.setColumns(10);
		
		
		dfModel = (DefaultTableModel) table3.getModel();
		ShowTable3();
		dfModel = (DefaultTableModel) table.getModel();
		ShowTable();
		}

	private void ShowTable3(){
		
		listTable3 = TableThaoTac3.findAll();
		dfModel.setRowCount(0);
		for (Table3 table3 : listTable3){
			dfModel.addRow(new Object[]{
					table3.getSttcthd(), table3.getTensanpham(), table3.getGiaban(),table3.getSoluong(),table3.getThanhtien()});
		}
	}
	private void ShowTable(){
		listTable = TableThaoTac.findAll();
		dfModel.setRowCount(0);
		for (Table table : listTable){
			dfModel.addRow(new Object[]{
					table.getSttban(), table.getTenban(), table.getTrangthai(),table.getGhichu()});
		}
	}
}
