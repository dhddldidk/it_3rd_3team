package kr.or.dgit.it_3st_3team.ui.admin.report;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.it_3st_3team.dto.AdminGroup;
import kr.or.dgit.it_3st_3team.dto.SoftwareGroup;
import kr.or.dgit.it_3st_3team.dto.User;
import kr.or.dgit.it_3st_3team.type.AdminGroupAuth;
import kr.or.dgit.it_3st_3team.ui.component.CmbAdminGroupComp;
import kr.or.dgit.it_3st_3team.ui.component.CmbSoftwareGroupComp;
import kr.or.dgit.it_3st_3team.ui.component.CmbUserComp;
import kr.or.dgit.it_3st_3team.ui.component.StartAndEndDate;

import kr.or.dgit.it_3st_3team.ui.component.TfBtnSearchPrintComp;
import java.awt.Color;

public class AdminStatusSearch extends JPanel {
	private CmbSoftwareGroupComp pSoftwareGroup;
	private CmbAdminGroupComp pAdminGroup;
	private StatusSearchComboboxBottom pStatusSearch;

	public AdminStatusSearch() {

		initComponents();
	}

	private void initComponents() {
		setBackground(new Color(255, 255, 255));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);

		pSoftwareGroup = new CmbSoftwareGroupComp();
		pSoftwareGroup.setBounds(11, 10, 125, 30);

		add(pSoftwareGroup);

		pAdminGroup = new CmbAdminGroupComp();
		pAdminGroup.setBounds(148, 10, 125, 30);

		add(pAdminGroup);

		StartAndEndDate pCalendar = new StartAndEndDate();

		pCalendar.setBounds(712, -3, 441, 43);

		add(pCalendar);


		setSoftwareGroupData();
		setAdminGroupData();

		
		pStatusSearch = new StatusSearchComboboxBottom();
		pStatusSearch.setBackground(new Color(255, 255, 255));
		pStatusSearch.setBounds(12, 56, 1141, 44);
		add(pStatusSearch);
	}

	public void setSoftwareGroupData() {
		SoftwareGroup[] software = { new SoftwareGroup(1, "게임"), new SoftwareGroup(2, "사무") };
		pSoftwareGroup.loadData(software);
	}

	public void setAdminGroupData() {
		AdminGroup[] admin = { new AdminGroup(1, "영업1팀", AdminGroupAuth.SALESMAN),
				new AdminGroup(1, "영업2팀", AdminGroupAuth.SALESMAN) };
		pAdminGroup.loadData(admin);
	}

}
