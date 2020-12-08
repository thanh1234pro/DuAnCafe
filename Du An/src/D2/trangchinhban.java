package D2;

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

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Closeable;
import java.awt.event.ActionEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.DebugGraphics;
import java.awt.ComponentOrientation;
import java.awt.Rectangle;

public class trangchinhban extends JPanel {
	private JTextField txtTenban;
	private JTextField txtGhichu;
	private JTable table;
	private List<Table> listTable = new ArrayList<Table>();
	private DefaultTableModel dfModel;
	private int myindex;
	JComboBox txtTrangthai = new JComboBox();
	/**S
	 * Create the panel.
	 */
	public trangchinhban() {
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 153, 153)));
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("QU\u1EA2N L\u00DD B\u00C0N");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\Java Desktop\\IM CAFE\\Apps-Google-Drive-Fusion-Tables-icon.png"));
		lblNewLabel_1.setBounds(117, 35, 211, 57);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên Bàn :");
		lblNewLabel_1_1.setBounds(27, 121, 80, 36);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Ghi Ch\u00FA :");
		lblNewLabel_1_1_1.setBounds(27, 228, 80, 36);
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		add(lblNewLabel_1_1_1);
		
		txtTenban = new JTextField();
		txtTenban.setBackground(new Color(255, 255, 255));
		txtTenban.setBorder(new MatteBorder(2, 1, 2, 15, (Color) new Color(0, 153, 153)));
		txtTenban.setCaretColor(new Color(0, 153, 153));
		txtTenban.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		txtTenban.setBounds(117, 126, 246, 29);
		add(txtTenban);
		
		txtGhichu = new JTextField();
		txtGhichu.setBorder(new MatteBorder(2, 1, 2, 15, (Color) new Color(255, 102, 0)));
		txtGhichu.setBounds(117, 233, 246, 29);
		txtGhichu.setColumns(10);
		add(txtGhichu);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Times New Roman", Font.BOLD, 14));
		scrollPane.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 153, 153)));
		scrollPane.setBackground(new Color(0, 153, 153));
		scrollPane.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		scrollPane.setBounds(411, 35, 612, 227);
		add(scrollPane);
		
		table = new JTable();
		table.setGridColor(new Color(255, 255, 255));
		table.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 153, 153)));
		table.setForeground(new Color(255, 255, 255));
		table.setBackground(new Color(255, 102, 51));
		table.setFont(new Font("Times New Roman", Font.BOLD, 12));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myindex = table.getSelectedRow();
				txtTenban.setText(table.getValueAt(myindex, 1).toString());
				txtTrangthai.setSelectedItem(table.getValueAt(myindex, 2).toString());
				txtGhichu.setText(table.getValueAt(myindex, 3).toString());
			}
		});
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
		
		JButton themban = new JButton(" Th\u00EAm b\u00E0n");
		themban.setBorder(new MatteBorder(2, 8, 2, 8, (Color) new Color(51, 204, 102)));
		themban.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tenban = txtTenban.getText();
				String trangthai = txtTrangthai.getSelectedItem().toString();
				String ghichu = txtGhichu.getText();
				
				Table ban = new Table(tenban,trangthai,ghichu);
				
				TableThaoTac.insert(ban);
				
				ShowTable();
			}
		});
		themban.setBackground(new Color(255, 255, 255));
		themban.setIcon(new ImageIcon("E:\\Java Desktop\\IM CAFE\\add-1-icon.png"));
		themban.setFont(new Font("Times New Roman", Font.BOLD, 14));
		themban.setBounds(64, 295, 127, 45);
		add(themban);
		
		JButton xoaban = new JButton(" X\u00F3a b\u00E0n");
		xoaban.setBorder(new MatteBorder(1, 8, 1, 8, (Color) new Color(255, 51, 0)));
		xoaban.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = table.getSelectedRow();
				if(selectedIndex >=0) {
					Table stt = listTable.get(selectedIndex);
					int option = JOptionPane.showConfirmDialog(getRootPane(), "Bạn có muốn xóa không ?");
				if(option == 0) {
					TableThaoTac.delete(stt.getSttban());
					ShowTable();
				}
			}
			}
		});
		xoaban.setBackground(new Color(255, 255, 255));
		xoaban.setIcon(new ImageIcon("E:\\Java Desktop\\IM CAFE\\Actions-button-cancel-icon.png"));
		xoaban.setFont(new Font("Times New Roman", Font.BOLD, 14));
		xoaban.setBounds(231, 362, 127, 45);
		add(xoaban);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Trạng thái :");
		lblNewLabel_1_1_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_1_2.setBounds(27, 172, 80, 36);
		add(lblNewLabel_1_1_2);
		txtTrangthai.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
		txtTrangthai.setEditable(true);
		txtTrangthai.setFocusCycleRoot(true);
		txtTrangthai.setForeground(new Color(0, 0, 0));
		txtTrangthai.setBackground(new Color(255, 255, 255));
		txtTrangthai.setBorder(new MatteBorder(2, 1, 2, 15, (Color) new Color(0, 153, 153)));
		txtTrangthai.setModel(new DefaultComboBoxModel(new String[] {"Còn trống", "Hết chỗ", "Đã đặt"}));
		txtTrangthai.setBounds(117, 177, 246, 29);
		add(txtTrangthai);
		
		JButton suaban = new JButton("Sửa bàn");
		suaban.setBorder(new MatteBorder(1, 8, 1, 8, (Color) new Color(255, 204, 0)));
		suaban.setIcon(new ImageIcon("E:\\Java Desktop\\IM CAFE\\document-edit-icon.png"));
		suaban.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtTenban.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Lỗi");
				} else {
					String tenban = txtTenban.getText();
					String trangthai = txtTrangthai.getSelectedItem().toString();
					String ghichu = txtGhichu.getText();
					Table ban = new Table(myindex +1,tenban,trangthai,ghichu);
					TableThaoTac.update(ban);
					;
					ShowTable();
				}
			}
		});
		
		suaban.setFont(new Font("Times New Roman", Font.BOLD, 14));
		suaban.setBackground(new Color(255, 255, 255));
		suaban.setBounds(64, 362, 127, 45);
		add(suaban);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("E:\\Java Desktop\\IM CAFE\\Hình To Cafe.png"));
		lblNewLabel.setBounds(459, 272, 255, 220);
		add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("E:\\Java Desktop\\IM CAFE\\Hình To Cafe hh.png"));
		lblNewLabel_2.setBounds(754, 297, 211, 160);
		add(lblNewLabel_2);
		
		JButton lammoi = new JButton("Làm mới");
		lammoi.setBorder(new MatteBorder(1, 8, 1, 8, (Color) new Color(255, 102, 0)));
		lammoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTenban.setText("");
				txtTrangthai.setSelectedIndex(0);
				txtGhichu.setText("");
			}
		});
		lammoi.setIcon(new ImageIcon("E:\\Java Desktop\\IM CAFE\\system-software-update-icon (1).png"));
		lammoi.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lammoi.setBackground(new Color(255, 255, 255));
		lammoi.setBounds(231, 295, 127, 45);
		add(lammoi);
		
		dfModel = (DefaultTableModel) table.getModel();
		ShowTable();
		
	}
	protected void Close() {
		
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
