package D1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.border.MatteBorder;

import D5.AddUser;
import D5.ChangesUser;
import D5.Login;

import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.ComponentOrientation;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;


public class MainFrame extends JFrame {

	private static final JPanel PanelView = null;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		MainFrame MainFrame = new MainFrame();
		MainFrame.setLocationRelativeTo(null);
		MainFrame.setVisible(true);
	}
	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1266, 629);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(51, 153, 153)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_menu = new JPanel();
		panel_menu.setBorder(new MatteBorder(2, 2, 2, 10, (Color) new Color(51, 153, 153)));
		panel_menu.setBackground(new Color(255, 255, 255));
		panel_menu.setBounds(10, 10, 176, 571);
		contentPane.add(panel_menu);
		panel_menu.setLayout(null);
		
		JPanel panel_MANHINHCHINH = new JPanel();
		panel_MANHINHCHINH.addMouseMotionListener(new MouseMotionAdapter() {
			
		});
		panel_MANHINHCHINH.setBackground(new Color(255, 255, 255));
		panel_MANHINHCHINH.setBounds(20, 192, 135, 58);
		panel_menu.add(panel_MANHINHCHINH);
		panel_MANHINHCHINH.setLayout(null);
		
		JPanel panel_manhinh = new JPanel();
		panel_manhinh.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		panel_manhinh.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 153, 153)));
		panel_manhinh.setForeground(new Color(0, 0, 0));
		panel_manhinh.setBounds(196, 65, 1046, 517);
		contentPane.add(panel_manhinh);
		panel_manhinh.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(51, 153, 153));
        panel.setBounds(0, 192, 10, 58);
        panel_menu.add(panel);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(51, 153, 153));
        panel_1.setBounds(0, 284, 10, 58);
        panel_menu.add(panel_1);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(51, 153, 153));
        panel_2.setBounds(0, 374, 10, 58);
        panel_menu.add(panel_2);
        
        JPanel panel_3 = new JPanel();
        panel_3.setBackground(new Color(51, 153, 153));
        panel_3.setBounds(0, 460, 10, 58);
        panel_menu.add(panel_3);
        
        JMenuBar menuBar = new JMenuBar();
        menuBar.setForeground(new Color(255, 255, 255));
        menuBar.setBackground(new Color(32, 178, 170));
        menuBar.setFont(new Font("Times New Roman", Font.BOLD, 14));
        menuBar.setBounds(0, 0, 68, 22);
        panel_menu.add(menuBar);
        
        JMenu panel_taikhoan = new JMenu("T\u00E0i kho\u1EA3n");
        panel_taikhoan.setHorizontalAlignment(SwingConstants.CENTER);
        panel_taikhoan.setBackground(new Color(255, 255, 255));
        panel_taikhoan.setForeground(new Color(255, 255, 255));
        menuBar.add(panel_taikhoan);
        
        JMenuItem lbl_themtaikhoan = new JMenuItem("Th\u00EAm t\u00E0i kho\u1EA3n");
        lbl_themtaikhoan.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		AddUser ad = new AddUser();
				ad.setVisible(true);
        	}
        });
        lbl_themtaikhoan.setForeground(new Color(32, 178, 170));
        lbl_themtaikhoan.setBackground(new Color(255, 255, 255));
        panel_taikhoan.add(lbl_themtaikhoan);
        
        JMenuItem doimatkhau = new JMenuItem("\u0110\u1ED5i m\u1EADt kh\u1EA9u");
        doimatkhau.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ChangesUser ch = new ChangesUser();
				ch.setVisible(true);
        	}
        });
        doimatkhau.setForeground(new Color(32, 178, 170));
        doimatkhau.setSelected(true);
        doimatkhau.setBackground(new Color(255, 255, 255));
        panel_taikhoan.add(doimatkhau);
        
        JMenuItem dangxuat = new JMenuItem("\u0110\u0103ng xu\u1EA5t");
        dangxuat.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.exit(0);
        	}
        });
        dangxuat.setForeground(new Color(32, 178, 170));
        dangxuat.setSelected(true);
        dangxuat.setBackground(new Color(255, 255, 255));
        panel_taikhoan.add(dangxuat);
        
        JLabel lbl_manhinhchinh = new JLabel("Bàn");
        lbl_manhinhchinh.setBounds(0, 0, 135, 58);
        panel_MANHINHCHINH.add(lbl_manhinhchinh);
        lbl_manhinhchinh.setBackground(new Color(255, 255, 255));
        lbl_manhinhchinh.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_manhinhchinh.setIcon(new ImageIcon(""));
        lbl_manhinhchinh.setForeground(new Color(0, 0, 0));
        lbl_manhinhchinh.setFont(new Font("Times New Roman", Font.BOLD, 18));
           
           
           JPanel panel_DOUONG = new JPanel();
           panel_DOUONG.setLayout(null);
           panel_DOUONG.setBackground(Color.WHITE);
           panel_DOUONG.setBounds(20, 284, 135, 58);
           panel_menu.add(panel_DOUONG);
           
           JPanel panel_THONGKE = new JPanel();
           panel_THONGKE.setLayout(null);
           panel_THONGKE.setBackground(Color.WHITE);
           panel_THONGKE.setBounds(20, 374, 135, 58);
           panel_menu.add(panel_THONGKE);
           
           JLabel lbl_hoadon = new JLabel("Thống kê");
           lbl_hoadon.setHorizontalAlignment(SwingConstants.CENTER);
           lbl_hoadon.setForeground(Color.BLACK);
           lbl_hoadon.setFont(new Font("Times New Roman", Font.BOLD, 18));
           lbl_hoadon.setBounds(0, 0, 135, 58);
           panel_THONGKE.add(lbl_hoadon);
           
           JLabel lbl_douong = new JLabel("Đồ uống");
           lbl_douong.setBounds(0, 0, 135, 58);
           panel_DOUONG.add(lbl_douong);
           lbl_douong.setHorizontalAlignment(SwingConstants.CENTER);
           lbl_douong.setForeground(Color.BLACK);
           lbl_douong.setFont(new Font("Times New Roman", Font.BOLD, 18));
           JPanel panel_HOADON = new JPanel();
           panel_HOADON.setLayout(null);
           panel_HOADON.setBackground(Color.WHITE);
           panel_HOADON.setBounds(20, 460, 135, 58);
           panel_menu.add(panel_HOADON);
           
           JLabel lbl_hoadon1 = new JLabel("Hóa đơn");
           lbl_hoadon1.setHorizontalAlignment(SwingConstants.CENTER);
           lbl_hoadon1.setForeground(Color.BLACK);
           lbl_hoadon1.setFont(new Font("Times New Roman", Font.BOLD, 18));
           lbl_hoadon1.setBounds(0, 0, 135, 58);
           panel_HOADON.add(lbl_hoadon1);
           
        // Gọi Mục Chuyển
           
           List<danhmuc> listDanhMuc = new ArrayList<>();
           listDanhMuc.add(new danhmuc("trangchinh", panel_MANHINHCHINH, lbl_manhinhchinh));
           listDanhMuc.add(new danhmuc("thongke", panel_THONGKE, lbl_hoadon));
           listDanhMuc.add(new danhmuc("douong", panel_DOUONG, lbl_douong));
           listDanhMuc.add(new danhmuc("hoadon", panel_HOADON, lbl_hoadon1));
   
           chuyenmanhinh controller = new chuyenmanhinh(panel_manhinh);
           panel_manhinh.setLayout(null);
           controller.setView(panel_MANHINHCHINH, lbl_manhinhchinh);
           
          
           
           JButton btnNewButton = new JButton("Quay lại");
           btnNewButton.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
           btnNewButton.setContentAreaFilled(false);
           btnNewButton.setBorder(new MatteBorder(0, 0, 0, 0, (Color) null));
           btnNewButton.addActionListener(new ActionListener() {
           	public void actionPerformed(ActionEvent e) {
           		Login frame = new Login();
				frame.setVisible(true);
				dispose();
           	}
           });
           btnNewButton.setIcon(new ImageIcon("E:\\Java Desktop\\IM CAFE\\arrow-back-icon.png"));
           btnNewButton.setForeground(Color.BLACK);
           btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
           btnNewButton.setBackground(new Color(255, 255, 255));
           btnNewButton.setBounds(196, 10, 118, 45);
           contentPane.add(btnNewButton);
           
           JPanel panel_QLCAFE = new JPanel();
           panel_QLCAFE.setBounds(631, 10, 176, 68);
           contentPane.add(panel_QLCAFE);
           panel_QLCAFE.setBorder(new MatteBorder(4, 1, 1, 1, (Color) new Color(32, 178, 170)));
           panel_QLCAFE.setBackground(new Color(255, 255, 255));
           panel_QLCAFE.setLayout(null);
           
           JLabel quanlychung = new JLabel("QU\u1EA2N L\u00DD CHUNG");
           quanlychung.setBounds(0, 0, 176, 68);
           panel_QLCAFE.add(quanlychung);
           quanlychung.setHorizontalAlignment(SwingConstants.CENTER);
           quanlychung.setFont(new Font("Times New Roman", Font.BOLD, 16));
           quanlychung.setIcon(new ImageIcon(""));
           quanlychung.setForeground(new Color(0, 0, 0));
           
           JButton thoat = new JButton("Thoát");
           thoat.setIcon(new ImageIcon("E:\\Java Desktop\\IM CAFE\\Actions-button-cancel-icon.png"));
           thoat.setForeground(Color.BLACK);
           thoat.setFont(new Font("Times New Roman", Font.BOLD, 14));
           thoat.setContentAreaFilled(false);
           thoat.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
           thoat.setBorder(new MatteBorder(0, 0, 0, 0, (Color) null));
           thoat.setBackground(Color.WHITE);
           thoat.setBounds(1124, 10, 118, 45);
           contentPane.add(thoat);
           controller.setEvent(listDanhMuc);
        //
   
        
	}
}
