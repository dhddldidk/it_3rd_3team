package kr.or.dgit.it_3st_3team.ui.admin;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.JScrollPane;

public class AdminSoftwareTable extends JPanel {
	private JTable SWTable;

	/**
	 * Create the panel.
	 */
	public AdminSoftwareTable() {

		initComponents();
	}
	private void initComponents() {
		setLayout(null);
		
		JPanel pSWTable = new JPanel();
		pSWTable.setBackground(Color.WHITE);
		pSWTable.setBounds(0, 0, 1191, 603);
		add(pSWTable);
		pSWTable.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(12, 10, 1155, 583);
		pSWTable.add(scrollPane);
		
		SWTable = new JTable();
		SWTable.setBackground(Color.WHITE);
		SWTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"\uD488\uBAA9\uBC88\uD638", "\uBD84\uB958", "\uD488\uBAA9\uBA85", "\uACF5\uAE09\uAC00\uACA9", "\uD310\uB9E4\uAC00\uACA9", "\uACF5\uAE09\uD68C\uC0AC", "\uC218\uC815/\uC0AD\uC81C"
			}
		));
		scrollPane.setViewportView(SWTable);
	}
}