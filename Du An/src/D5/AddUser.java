package D5;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import D2.Table;
import D2.TableThaoTac;
import D3.Table2;
import D3.TableThaoTac2;

import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

public class AddUser extends JFrame {
	private List<Table4> listTable4 = new ArrayList<Table4>();
	private DefaultTableModel dfModel;
	private JPanel contentPane;
	private JTextField txtTaikhoan;
	private JTable table;
	private JButton btThem;
	private JTextField txtTen;
	private JLabel lblName;
	private JLabel lblXcNhnMt;
	private JButton btXoa;
	private JLabel lblNewLabel_1;
	private JPasswordField txtXacnhanpass;
	private JPasswordField txtMatkhau;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		AddUser AddUser = new AddUser();
		AddUser.setLocationRelativeTo(null);
		AddUser.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public AddUser() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 720, 411);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(51, 153, 153)));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtTaikhoan = new JTextField();
		txtTaikhoan.setBorder(new MatteBorder(2, 5, 2, 15, (Color) new Color(51, 153, 153)));
		txtTaikhoan.setBounds(190, 119, 152, 27);
		contentPane.add(txtTaikhoan);
		txtTaikhoan.setColumns(10);

		JLabel lblNewLabel = new JLabel("Tài khoản:");
		lblNewLabel.setBounds(36, 118, 98, 27);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		contentPane.add(lblNewLabel);

		JLabel lblPassword = new JLabel("Mật khẩu:");
		lblPassword.setBounds(36, 155, 98, 27);
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 16));
		contentPane.add(lblPassword);

		JScrollPane txtTableLogin = new JScrollPane();
		txtTableLogin.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(51, 153, 153)));
		txtTableLogin.setBounds(377, 60, 300, 224);
		contentPane.add(txtTableLogin);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Stt", "Tên", "Tài khoản" }));
		txtTableLogin.setViewportView(table);

		btThem = new JButton("Thêm mới");
		btThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtTen.getText();
				String username = txtTaikhoan.getText();
				String password = txtMatkhau.getText();
				String comfirmpass = txtXacnhanpass.getText();

				Table4 ban = new Table4(name, username, password, comfirmpass);

				TableThaoTac4.insert(ban);

				ShowTable4();
			}
		});
		btThem.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btThem.setBorder(new MatteBorder(1, 8, 1, 8, (Color) new Color(0, 102, 204)));
		btThem.setBackground(Color.WHITE);
		btThem.setBounds(89, 290, 91, 35);
		contentPane.add(btThem);

		txtTen = new JTextField();
		txtTen.setColumns(10);
		txtTen.setBorder(new MatteBorder(2, 5, 2, 15, (Color) new Color(51, 153, 153)));
		txtTen.setBounds(190, 82, 152, 27);
		contentPane.add(txtTen);

		lblName = new JLabel("Tên:");
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblName.setBounds(36, 81, 98, 27);
		contentPane.add(lblName);

		lblXcNhnMt = new JLabel("Xác nhận mật khẩu:");
		lblXcNhnMt.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblXcNhnMt.setBounds(36, 192, 144, 27);
		contentPane.add(lblXcNhnMt);

		btXoa = new JButton("Xóa ");
		btXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = table.getSelectedRow();
				if (selectedIndex >= 0) {
					Table4 stt = listTable4.get(selectedIndex);
					int option = JOptionPane.showConfirmDialog(getRootPane(), "Bạn có muốn xóa không ?");
					if (option == 0) {
						TableThaoTac4.delete(stt.getStt());
						ShowTable4();
					}
				}

			}
		});
		btXoa.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btXoa.setBorder(new MatteBorder(1, 8, 1, 8, (Color) new Color(255, 0, 51)));
		btXoa.setBackground(Color.WHITE);
		btXoa.setBounds(206, 290, 91, 35);
		contentPane.add(btXoa);

		lblNewLabel_1 = new JLabel("QUẢN LÝ TÀI KHOẢN");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\Java Desktop\\IM CAFE\\Administrator-icon (1).png"));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(223, 15, 263, 35);
		contentPane.add(lblNewLabel_1);

		txtXacnhanpass = new JPasswordField();
		txtXacnhanpass.setBorder(new MatteBorder(2, 5, 2, 15, (Color) new Color(51, 153, 153)));
		txtXacnhanpass.setBounds(190, 193, 152, 27);
		contentPane.add(txtXacnhanpass);

		txtMatkhau = new JPasswordField();
		txtMatkhau.setBorder(new MatteBorder(2, 5, 2, 15, (Color) new Color(51, 153, 153)));
		txtMatkhau.setBounds(190, 156, 152, 27);
		contentPane.add(txtMatkhau);

		dfModel = (DefaultTableModel) table.getModel();
		ShowTable4();

	}

	private void ShowTable4() {
		listTable4 = TableThaoTac4.findAll();
		dfModel.setRowCount(0);
		for (Table4 table4 : listTable4) {
			dfModel.addRow(new Object[] { table4.getStt(), table4.getName(), table4.getUsername() });
		}
	}
}
