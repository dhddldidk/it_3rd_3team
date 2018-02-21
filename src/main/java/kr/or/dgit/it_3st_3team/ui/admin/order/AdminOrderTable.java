package kr.or.dgit.it_3st_3team.ui.admin.order;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;

public class AdminOrderTable extends JPanel {
	private JTable TblOrder;

	/**
	 * Create the panel.
	 */
	public AdminOrderTable() {

		initComponents();
	}
	private void initComponents() {
		setLayout(null);
		
		JPanel pOrderTable = new JPanel();
		pOrderTable.setBackground(Color.WHITE);
		pOrderTable.setBounds(0, 0, 877, 271);
		add(pOrderTable);
		pOrderTable.setLayout(null);
		
		JLabel btnPrev = new JLabel("");
		btnPrev.setIcon(new ImageIcon("C:\\Users\\SCARLETT\\Desktop\\ppt이용 이미지\\pg IMg\\back.png"));
		btnPrev.setHorizontalAlignment(SwingConstants.CENTER);
		btnPrev.setBounds(400, 244, 17, 17);
		pOrderTable.add(btnPrev);
		
		JLabel btnNext = new JLabel("");
		btnNext.setIcon(new ImageIcon("C:\\Users\\SCARLETT\\Desktop\\ppt이용 이미지\\pg IMg\\next.png"));
		btnNext.setHorizontalAlignment(SwingConstants.CENTER);
		btnNext.setBounds(467, 244, 17, 17);
		pOrderTable.add(btnNext);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 853, 231);
		pOrderTable.add(scrollPane);
		
		TblOrder = new JTable();
		TblOrder.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"\uC8FC\uBB38\uBC88\uD638", "\uC8FC\uBB38\uC77C\uC790", "\uBD84\uB958", "\uD488\uBAA9\uBA85", "\uC8FC\uBB38\uC218\uB7C9", "\uACE0\uAC1D\uBA85", "\uACB0\uC81C\uC218\uB2E8", "\uB2F4\uB2F9\uC790", "\uACF5\uAE09\uD68C\uC0AC", "\uC218\uC815/\uC0AD\uC81C"
			}
		));
		scrollPane.setViewportView(TblOrder);
	}

}