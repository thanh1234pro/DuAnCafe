package D3;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JToggleButton;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JProgressBar;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class douong extends JPanel {
	private JTextField txtGiatien;
	private JTextField txtNgaykm;
	private JTable table2;
	private List<Table2> listTable2 = new ArrayList<Table2>();
	private DefaultTableModel dfModel;
	private JTextField txtTendouong;
	private JTextField txtNgayhetkm;
	private int myindex;
	/**S
	 * Create the panel.
	 */
	public douong() {
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 153, 153)));
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel quanlydouong = new JLabel("QUẢN LÝ ĐỒ UỐNG");
		quanlydouong.setIcon(new ImageIcon("E:\\Java Desktop\\IM CAFE\\soda-can-icon.png"));
		quanlydouong.setBounds(82, 37, 263, 57);
		quanlydouong.setHorizontalAlignment(SwingConstants.CENTER);
		quanlydouong.setFont(new Font("Times New Roman", Font.BOLD, 18));
		add(quanlydouong);
		
		JLabel giatien = new JLabel("Giá tiền:");
		giatien.setBounds(40, 148, 105, 36);
		giatien.setFont(new Font("Times New Roman", Font.BOLD, 16));
		add(giatien);
		
		JLabel ngaykhuyenmai = new JLabel("Ngày khuyến mãi :");
		ngaykhuyenmai.setBounds(40, 194, 129, 36);
		ngaykhuyenmai.setFont(new Font("Times New Roman", Font.BOLD, 16));
		add(ngaykhuyenmai);
		
		txtGiatien = new JTextField();
		txtGiatien.setBorder(new MatteBorder(2, 1, 1, 15, (Color) new Color(0, 153, 153)));
		txtGiatien.setBounds(193, 153, 183, 29);
		add(txtGiatien);
		txtGiatien.setColumns(10);
		
		txtNgaykm = new JTextField();
		txtNgaykm.setBorder(new MatteBorder(2, 1, 1, 15, (Color) new Color(0, 153, 153)));
		txtNgaykm.setBounds(193, 201, 183, 29);
		txtNgaykm.setColumns(10);
		add(txtNgaykm);
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 153, 153)));
		scrollPane2.setBounds(413, 37, 602, 221);
		add(scrollPane2);
		
		table2 = new JTable();
		table2.setGridColor(new Color(255, 255, 255));
		table2.setForeground(new Color(255, 255, 255));
		table2.setBackground(new Color(255, 102, 51));
		table2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 153, 153)));
		table2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		table2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int myindex = table2.getSelectedRow();
				txtTendouong.setText(table2.getValueAt(myindex, 1).toString());
				txtGiatien.setText(table2.getValueAt(myindex, 2).toString());
				txtNgaykm.setText(table2.getValueAt(myindex, 3).toString());
				txtNgayhetkm.setText(table2.getValueAt(myindex, 4).toString());
			}
		});
		table2.setModel(new DefaultTableModel(
				
			new Object[][] {
			},
			new String[] {
				"STT", "Tên sản phẩm", "Gia bán", "Ngày khuyến mãi", "Ngày hết KM"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class
			};
			boolean[] columnEditables = new boolean[] {
				false, true, true, true
			};
		});
		scrollPane2.setViewportView(table2);
		
		JButton themban = new JButton(" Th\u00EAm b\u00E0n");
		themban.setBorder(new MatteBorder(1, 8, 1, 8, (Color) new Color(51, 204, 102)));
		themban.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tensanpham = txtTendouong.getText();
				String giaban = txtGiatien.getText();
				String ngaykm = txtNgaykm.getText();
				String ngayhetkm = txtNgayhetkm.getText();
				
				Table2 douong = new Table2(tensanpham,giaban,ngaykm,ngayhetkm);
				TableThaoTac2.insert(douong);
				
				ShowTable2();
			}
		});
		themban.setBackground(new Color(255, 255, 255));
		themban.setIcon(new ImageIcon("E:\\Java Desktop\\IM CAFE\\add-1-icon.png"));
		themban.setFont(new Font("Times New Roman", Font.BOLD, 14));
		themban.setBounds(60, 318, 127, 45);
		add(themban);
		
		JButton xoaban = new JButton(" X\u00F3a b\u00E0n");
		xoaban.setBorder(new MatteBorder(1, 8, 1, 8, (Color) new Color(255, 51, 0)));
		xoaban.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = table2.getSelectedRow();
				if(selectedIndex >=0) {
					Table2 dou = listTable2.get(selectedIndex);
					int option = JOptionPane.showConfirmDialog(getRootPane(), "Bạn có muốn xóa không ?");
				if(option == 0) {
					TableThaoTac2.delete(dou.getSttsp());
					ShowTable2();
				}
			}
			}
		});
		xoaban.setBackground(new Color(255, 255, 255));
		xoaban.setIcon(new ImageIcon("E:\\Java Desktop\\IM CAFE\\Actions-button-cancel-icon.png"));
		xoaban.setFont(new Font("Times New Roman", Font.BOLD, 14));
		xoaban.setBounds(231, 383, 127, 45);
		add(xoaban);
		
		txtTendouong = new JTextField();
		txtTendouong.setBorder(new MatteBorder(2, 1, 1, 15, (Color) new Color(0, 153, 153)));
		txtTendouong.setColumns(10);
		txtTendouong.setBounds(193, 104, 183, 29);
		add(txtTendouong);
		
		txtNgayhetkm = new JTextField();
		txtNgayhetkm.setBorder(new MatteBorder(2, 1, 1, 15, (Color) new Color(255, 102, 0)));
		txtNgayhetkm.setColumns(10);
		txtNgayhetkm.setBounds(193, 250, 183, 29);
		add(txtNgayhetkm);
		
		JLabel douong = new JLabel("Tên đồ uống :");
		douong.setFont(new Font("Times New Roman", Font.BOLD, 16));
		douong.setBounds(40, 104, 105, 36);
		add(douong);
		
		JLabel ngayhetkhuyenmai = new JLabel("Ngày hết KM :");
		ngayhetkhuyenmai.setFont(new Font("Times New Roman", Font.BOLD, 16));
		ngayhetkhuyenmai.setBounds(40, 245, 105, 36);
		add(ngayhetkhuyenmai);
		
		JButton btnSaBn = new JButton("Sửa bàn");
		btnSaBn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtTendouong.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Lỗi");
				} else {
					String tensanpham = txtTendouong.getText();
					String giaban = txtGiatien.getText();
					String ngaykm = txtNgaykm.getText();
					String ngayhetkm = txtNgayhetkm.getText();
					Table2 dou = new Table2(myindex +1,tensanpham,giaban,ngaykm,ngayhetkm);
					TableThaoTac2.update(dou);
					;
					ShowTable2();
				}
			}
		});
		btnSaBn.setBorder(new MatteBorder(1, 8, 1, 8, (Color) new Color(255, 204, 0)));
		btnSaBn.setIcon(new ImageIcon("E:\\Java Desktop\\IM CAFE\\document-edit-icon.png"));
		btnSaBn.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnSaBn.setBackground(new Color(255, 255, 255));
		btnSaBn.setBounds(60, 383, 127, 45);
		add(btnSaBn);
		
		JButton lammoi = new JButton("Làm mới");
		lammoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTendouong.setText("");
				txtGiatien.setText("");
				txtNgaykm.setText("");
				txtNgayhetkm.setText("");
			}
		});
		lammoi.setIcon(new ImageIcon("E:\\Java Desktop\\IM CAFE\\system-software-update-icon (1).png"));
		lammoi.setBorder(new MatteBorder(1, 8, 1, 8, (Color) new Color(255, 102, 0)));
		lammoi.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lammoi.setBackground(new Color(255, 255, 255));
		lammoi.setBounds(231, 318, 127, 45);
		add(lammoi);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("E:\\Java Desktop\\IM CAFE\\Untitled-2.png"));
		lblNewLabel.setBounds(413, 287, 272, 190);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\Java Desktop\\IM CAFE\\Untitled-3.png"));
		lblNewLabel_1.setBounds(743, 287, 272, 190);
		add(lblNewLabel_1);
		
		dfModel = (DefaultTableModel) table2.getModel();
		ShowTable2();
		
	}
	private void ShowTable2(){
		listTable2 = TableThaoTac2.findAll();
		dfModel.setRowCount(0);
		for (Table2 table2 : listTable2){
			dfModel.addRow(new Object[]{
					table2.getSttsp(), table2.getTensanpham(), table2.getGiaban(),table2.getNgaykm(),table2.getNgayhetkm()});
		}
	}
}
