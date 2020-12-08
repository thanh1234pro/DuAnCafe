package D5;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;
import D1.MainFrame;
import D1.danhmuc;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
public class Login extends JFrame {
	

	protected static final JTextComponent PasswordField = null;
	private JTextField tendangnhap;
	private JPasswordField matkhau;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Login Login = new Login();
		Login.setLocationRelativeTo(null);
		Login.setVisible(true);
		
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 597, 376);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.setBounds(0, 0, 271, 339);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("E:\\Java Desktop\\IM CAFE\\thanhanh.png"));
		lblNewLabel.setBounds(0, 0, 584, 339);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 153, 153));
		panel_1.setBounds(0, 0, 583, 339);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("LOGIN");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel_1.setBounds(277, 10, 296, 52);
		panel_1.add(lblNewLabel_1);
		
		tendangnhap = new JTextField();
		tendangnhap.setFont(new Font("Times New Roman", Font.BOLD, 16));
		tendangnhap.setBounds(421, 93, 152, 34);
		panel_1.add(tendangnhap);
		tendangnhap.setColumns(10);
		
		JButton btnNewButton = new JButton("ĐĂNG NHẬP");
		btnNewButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
			
					try {
						String dbURL = "jdbc:sqlserver://localhost;databaseName=QLcafe;user=sa;password=101101";
			            Connection conn = DriverManager.getConnection(dbURL);
			            String sql = "Select * from NGUOIDUNG where username=? and password=?";
			            
						PreparedStatement prst = conn.prepareStatement(sql);
						prst.setString(1, tendangnhap.getText());
						prst.setString(2, matkhau.getText());
						
						ResultSet rs = prst.executeQuery();
						if(rs.next()) {
							MainFrame std = new MainFrame();
							std.setVisible(true);
							danhmuc frmSV = new danhmuc();
							JOptionPane.showMessageDialog(rootPane, "Đăng nhập thành công !");
						}
						else {
							JOptionPane.showMessageDialog(rootPane, "KIEM TRA LAI username hoac password");
							tendangnhap.setText("");
							matkhau.setText("");
							
						}
						rs.close();
						prst.close();
						conn.close();
						
					}catch (Exception ex) {
						JOptionPane.showMessageDialog(rootPane, ex.getMessage());
					}
					
				}
				
			});
		btnNewButton.setBackground(new Color(245, 255, 250));
		btnNewButton.setForeground(new Color(0, 153, 153));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(360, 214, 142, 41);
		panel_1.add(btnNewButton);
		
		JLabel username = new JLabel("Tên đăng nhập:");
		username.setFont(new Font("Times New Roman", Font.BOLD, 17));
		username.setForeground(new Color(255, 255, 255));
		username.setBounds(302, 91, 116, 34);
		panel_1.add(username);
		
		JLabel password = new JLabel("Mật khẩu:");
		password.setForeground(Color.WHITE);
		password.setFont(new Font("Times New Roman", Font.BOLD, 17));
		password.setBounds(302, 148, 98, 34);
		panel_1.add(password);
		
		matkhau = new JPasswordField();
		matkhau.setFont(new Font("Times New Roman", Font.BOLD, 16));
		matkhau.setBounds(421, 151, 152, 34);
		panel_1.add(matkhau);
		
		JButton thoat = new JButton("Thoát");
		thoat.setHorizontalAlignment(SwingConstants.LEADING);
		thoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		thoat.setForeground(new Color(255, 255, 255));
		thoat.setFont(new Font("Times New Roman", Font.BOLD, 14));
		thoat.setIcon(new ImageIcon("E:\\Java Desktop\\IM CAFE\\Actions-button-cancel-icon.png"));
		thoat.setBackground(new Color(0, 153, 153));
		thoat.setBounds(467, 290, 116, 34);
		panel_1.add(thoat);
	}
}
