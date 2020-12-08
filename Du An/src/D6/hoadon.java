package D6;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class hoadon extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public hoadon() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 1033, 164);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Stt", "Tên bàn", "Tổng tiền", "Ngày mua"
			}
		));
		scrollPane.setViewportView(table);

	}
}
