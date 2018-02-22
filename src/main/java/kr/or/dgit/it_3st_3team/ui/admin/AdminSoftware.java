package kr.or.dgit.it_3st_3team.ui.admin;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import java.awt.Rectangle;
import kr.or.dgit.it_3st_3team.ui.component.PagingComponent;

public class AdminSoftware extends JPanel {

	/**
	 * Create the panel.
	 */
	public AdminSoftware() {

		initComponents();
	}
	private void initComponents() {
		setBounds(new Rectangle(0, 0, 1200, 850));
		setLayout(null);
		
		AdminSoftwareRegister pRegister = new AdminSoftwareRegister();
		pRegister.setBounds(0, 0, 1190, 183);
		add(pRegister);
		
		AdminSoftwareSearch pSearch = new AdminSoftwareSearch();
		pSearch.setBounds(0, 193, 1190, 43);
		add(pSearch);
		
		AdminSoftwareTable pTable = new AdminSoftwareTable();
		pTable.setBackground(Color.WHITE);
		pTable.setBounds(0, 242, 1190, 562);
		add(pTable);
		
		PagingComponent pPageing = new PagingComponent();
		pPageing.setBackground(Color.WHITE);
		pPageing.setBounds(0, 814, 1190, 39);
		add(pPageing);
	}
}