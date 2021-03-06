package kr.or.dgit.it_3st_3team.ui.table;

import java.util.List;

import javax.swing.SwingConstants;

import kr.or.dgit.it_3st_3team.dto.SaleOrder;
import kr.or.dgit.it_3st_3team.ui.component.AbtractTableComp;

@SuppressWarnings("serial")
public class AdminSalesStatusLists extends AbtractTableComp<SaleOrder> {

	@Override
	public void setTableAlignWidth() {
		// 셀의 너비와 정렬
		setTableCellAlign(SwingConstants.CENTER, 0, 1, 2, 3, 4, 9, 10, 11);
		setTableCellAlign(SwingConstants.RIGHT, 5, 6, 7, 8);
		setTableRowHeight(40);

		setTableCellWidth(250, 600, 250, 500, 250, 500, 500, 500, 500, 500, 500, 500);
	}

	@Override
	public Object[] getColumnNames() {
		return new String[] { "주문번호", "고객명", "분류", "품목명", "주문수량", "공급금액", "판매금액", "부가세액", "판매이윤", "결제수단", "공급회사명",
				"날짜" };

	}

	@Override
	public Object[][] getRows(List<SaleOrder> list) {
		Object[][] rows = null;
		rows = new Object[list.size()][];
		for (int i = 0; i < list.size(); i++) {
			rows[i] = list.get(i).toArraySalesLists();
		}
		return rows;
	}

}
