package kr.or.dgit.it_3st_3team.ui.component;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JOptionPane;

import kr.or.dgit.it_3st_3team.dto.SoftwareGroup;
import kr.or.dgit.it_3st_3team.service.SoftwareGroupService;
import kr.or.dgit.it_3st_3team.ui.SoftwareGroupUI;
import kr.or.dgit.it_3st_3team.ui.table.AdminSoftwareGroupTable;

@SuppressWarnings("serial")
public class LblTfBtnSGRegisterComp extends AbstractLblTfBtnComp {

	private SoftwareGroupUI ui;
	
	/**
	 * Create the panel.
	 */
	public LblTfBtnSGRegisterComp(String title, String btnName) {
		super(title, btnName);
	}

	@Override
	protected void actionPerformedBtn(ActionEvent e) {
		
		String tfSgName = getTfText();
		
		if(e.getActionCommand() == "등록") {
			if(tfSgName.equals("")) {
				JOptionPane.showMessageDialog(null, "분류명을 입력해주세요.");
				return;
			}
			
			SoftwareGroupService.getInstance().insertSoftwareGroup(new SoftwareGroup(tfSgName));
			
			
			
		}else {
			
			//SoftwareGroupService.getInstance().updateSoftwareGroup();
			setBtnTitle("등록");
		}
		List<SoftwareGroup> lists = SoftwareGroupService.getInstance().selectSoftwareGroupByAll();
		ui.getpSgTable().loadTableDatas(lists);
		setTfText("");
		
		SoftwareGroup[] sgDatas = lists.toArray(new SoftwareGroup[lists.size()]);
		ui.getParentUi().getpSWsort().loadData(sgDatas);
		
		
		
		
		
	}
	
	public void setUI(SoftwareGroupUI ui) {
		this.ui = ui;
	}

}
