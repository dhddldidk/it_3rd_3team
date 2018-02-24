package kr.or.dgit.it_3st_3team.ui.table;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class AdminSalesStatusLists extends JPanel {
	protected JTable table;
	
	public AdminSalesStatusLists() {

		initComponents();
	}

	private void initComponents() {
		setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		loadDatas();
		scrollPane.setViewportView(table);
	}

	private void loadDatas() {
		NonEditableModel model = new NonEditableModel(getRows(), getColumNames());
		table.setModel(model);
		setAlignWidth();

	}

	private Object[][] getRows() {
		return new Object[][] {
			{"1", "재밌는PC방", "게임", "오버워치", "3", "120,000원","150,000원","계좌이체","100,000원","2018-02-23","알럽소프트","100,000원","□□" },
			{"2", "재밌는PC방", "게임", "오버워치", "3", "120,000원","150,000원","계좌이체","100,000원","2018-02-23","알럽소프트","100,000원","□□" },
			{"3", "재밌는PC방", "게임", "오버워치", "3", "120,000원","150,000원","계좌이체","100,000원","2018-02-23","알럽소프트","100,000원","□□" }
		};
	}

	public String[] getColumNames() {

		return new String[] { "번호", "상호명", "분류", "품목명", "주문수량", "공급가격","판매가격","결제수단","매출금","날짜","공급회사명","판매이윤","수정/삭제" };
	}

	private void setAlignWidth() {
		// 셀의 너비와 정렬
		tableCellAlign(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5, 6,7,8,9,10,11,12);

		tableCellWidth(200, 500, 300, 500, 200, 500, 500, 500, 500, 500, 500, 500,500);

	}
	protected void tableCellWidth(int... width) {
		TableColumnModel model = table.getColumnModel();
		for (int i = 0; i < width.length; i++) {
			model.getColumn(i).setPreferredWidth(width[i]);
		}

	}

	protected void tableCellAlign(int align, int... idx) {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);

		TableColumnModel model = table.getColumnModel();
		for (int i = 0; i < idx.length; i++) {
			model.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}

	// 테이블 내용을 수정하지 못하게 하는 클래스
	class NonEditableModel extends DefaultTableModel {
		public NonEditableModel(Object[][] data, Object[] columnNames) {
			super(data, columnNames);
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	}

}