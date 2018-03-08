package kr.or.dgit.it_3st_3team.ui.admin.software;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import kr.or.dgit.it_3st_3team.dto.Software;
import kr.or.dgit.it_3st_3team.dto.SoftwareGroup;
import kr.or.dgit.it_3st_3team.dto.User;
import kr.or.dgit.it_3st_3team.service.SoftwareGroupService;
import kr.or.dgit.it_3st_3team.service.SoftwareService;
import kr.or.dgit.it_3st_3team.service.UserService;
import kr.or.dgit.it_3st_3team.type.UserGroup;
import kr.or.dgit.it_3st_3team.ui.SoftwareGroupUI;
import kr.or.dgit.it_3st_3team.ui.component.ImageComp;
import kr.or.dgit.it_3st_3team.ui.component.LblCmbSoftwareGroupComp;
import kr.or.dgit.it_3st_3team.ui.component.LblCmbUserComp;
import kr.or.dgit.it_3st_3team.ui.component.LblSpinnerComp;
import kr.or.dgit.it_3st_3team.ui.component.LblTfComp;
import kr.or.dgit.it_3st_3team.utils.CommonUtil;
import kr.or.dgit.it_3st_3team.utils.DefineUtil;


@SuppressWarnings("serial")
public class AdminSoftwareRegister extends JPanel implements ActionListener {
	private JFileChooser chooser;
	private JButton btnSubmitCF;
	private LblCmbSoftwareGroupComp pSWsort;
	private LblCmbUserComp pCompany;
	private LblTfComp pSWName;
	//private LblTfComp pSupplyPrice;

	private JButton btnRegister;
	private JButton btnCancel;
	
	private AdminSoftwareContent ac;
	private JTextField upNum;
	private ImageComp pSwRegisterImg;
	private LblSpinnerComp pCount;
	private LblSpinnerComp pSalePrice;
	private LblSpinnerComp pSupplyPrice;
	
	
	


	public AdminSoftwareRegister() {

		initComponents();
	}

	private void initComponents() {
		setLayout(null);

		JPanel pRegister = new JPanel();
		pRegister.setBounds(0, 0, 1364, 296);
		add(pRegister);
		pRegister.setLayout(null);

		btnSubmitCF = new JButton("분류등록");
		btnSubmitCF.addActionListener(this);
		btnSubmitCF.setBounds(779, 29, 97, 23);
		pRegister.add(btnSubmitCF);
		
		
		List<User> lists1 = UserService.getInstance().listUserAllByUserGroup(UserGroup.COMPANY);	
		User[] usDatas = lists1.toArray(new User[lists1.size()]);

		pCompany = new LblCmbUserComp("공급회사");
		pCompany.setBorder(null);
		pCompany.setBounds(238, 27, 243, 30);
		pCompany.loadData(usDatas);
		pRegister.add(pCompany);

		List<SoftwareGroup> lists = SoftwareGroupService.getInstance().selectSoftwareGroupByAll();
		SoftwareGroup[] sgDatas = lists.toArray(new SoftwareGroup[lists.size()]);

		pSWsort = new LblCmbSoftwareGroupComp("분류");
		pSWsort.setBounds(556, 27, 183, 30);
		pSWsort.loadData(sgDatas);
		pRegister.add(pSWsort);

		pSwRegisterImg = new ImageComp();
		pSwRegisterImg.setBounds(25, 0, 183, 214);
		pRegister.add(pSwRegisterImg);

		pSWName = new LblTfComp("품목 명");
		pSWName.setBounds(541, 73, 340, 30);
		pRegister.add(pSWName);

		btnCancel = new JButton("취소");
		btnCancel.setBounds(1045, 168, 97, 23);
		pRegister.add(btnCancel);	
		btnCancel.addActionListener(this);
		
		btnRegister = new JButton("등록");
		btnRegister.setBounds(929, 168, 97, 23);
		pRegister.add(btnRegister);
		
		pCount = new LblSpinnerComp("수량");
		pCount.setIntSpinner(1, 1, 999, 1);
		pCount.setBounds(556, 120, 126, 30);
		pRegister.add(pCount);
		
		pSalePrice = new LblSpinnerComp("판매가격");
		pSalePrice.setIntSpinner(0, 0, 9999999, 1000);
		pSalePrice.setBounds(238, 73, 243, 30);
		pRegister.add(pSalePrice);
		
		pSupplyPrice = new LblSpinnerComp("공급가격");
		pSupplyPrice.setIntSpinner(0, 0, 9999999, 1000);
		pSupplyPrice.setBounds(238, 120, 243, 30);
		pRegister.add(pSupplyPrice);
		btnRegister.addActionListener(this);
		
		upNum = new JTextField();
		upNum.setBounds(708, 129, 116, 21);
		upNum.setColumns(10);
		
	}
	
	
	

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSubmitCF) {
			actionPerformedBtnSubmitCF(e);
		}if(e.getSource()==btnRegister) {
			actionPerformedBtnRegister(e);
		}if(e.getSource()==btnCancel) {
			actionPerformedBtnCancel(e);
		}
	}

	private void actionPerformedBtnCancel(ActionEvent e) {
		resetDate();
		
	}

	private void actionPerformedBtnRegister(ActionEvent e) {
		if(pSWName.isTfEmpty("품목명을 입력해주세요")) {
			return;
		}
		
		
		User Company = (User) pCompany.getCmbSelectItem();
		SoftwareGroup swGroup = (SoftwareGroup) pSWsort.getCmbSelectItem();
		int salePrice = pSalePrice.getSpnValue();
		int supplyPrice = pSupplyPrice.getSpnValue();
		String swName = pSWName.getTfText().trim();
		int swNo = 0;
		if(!upNum.getText().equals("")) {
			swNo = Integer.parseInt(upNum.getText());
		}
		int count = pCount.getSpnValue();
		
		
		Software inputSw = new Software();
		inputSw.setSwGroup(swGroup);
		inputSw.setSwName(swName);
		inputSw.setSwNo(swNo);
		inputSw.setUserNo(Company);
		inputSw.setSwSellPrice(salePrice);
		inputSw.setSwSupplyPrice(supplyPrice);
		inputSw.setSwQuantity(count);
		
		
		String softwareImgFullPath = pSwRegisterImg.getImageIcon().toString();
		String imgName = CommonUtil.getInstance().createRndImgName(softwareImgFullPath, String.format("software%04d", inputSw.getSwNo()));
		inputSw.setSwCoverImg(imgName);
		/*System.out.println(softwareImgFullPath);
		System.out.println(new File(softwareImgFullPath).getName());*/

		
		String commandType = e.getActionCommand();
		String commandMessage = String.format("사용자 %s", commandType);
		int result = JOptionPane.showConfirmDialog(null, String.format("%s을 하시겠습니까?", commandMessage),commandMessage,JOptionPane.YES_NO_OPTION);
		if(result == JOptionPane.CANCEL_OPTION || result == JOptionPane.NO_OPTION) {
			return;
		}
		CommonUtil.getInstance().userImgSave(softwareImgFullPath, imgName);
		
		if(commandType.equals("등록")) {
			result = SoftwareService.getInstance().insertSoftware(inputSw);
		}else {
			SoftwareService.getInstance().updateSoftware(inputSw);
			btnRegister.setText("등록");		
		}
		ac.reFreshList();
		resetDate();
	
	}

	protected void actionPerformedBtnSubmitCF(ActionEvent e) {
		SoftwareGroupUI softwareGroupUI = new SoftwareGroupUI();
		softwareGroupUI.setParentUI(this);
		softwareGroupUI.setVisible(true);
	}

	public LblCmbSoftwareGroupComp getpSWsort() {
		return pSWsort;
	}
	
	public void setSoftwareData(Software sw) {
		if(sw.getSwCoverImg() != null && !sw.getSwCoverImg().equals("")) {
			pSwRegisterImg.setImageIcon(sw.getSwCoverImg());
		}else {
			pSwRegisterImg.setImageIcon(DefineUtil.DEFAULT_USER_IMG);
		}
		
		pCompany.setCmbSelectItem(sw.getUserNo());
		pSWsort.setCmbSelectItem(sw.getSwGroup());
		pCount.setSpnValue(sw.getSwQuantity());
		pSalePrice.setSpnValue(sw.getSwSellPrice());
		pSupplyPrice.setSpnValue(sw.getSwSupplyPrice());
		pSWName.setTfText(sw.getSwName());
		upNum.setText(Integer.toString(sw.getSwNo()));

		btnRegister.setText("수정");
	}
	
	
	
	private void resetDate() {
		pSwRegisterImg.setImageIcon("nobody.png");
		pCompany.setCmbSelectIndex(0);
		pSalePrice.setSpnValue(1000);
		pCount.setSpnValue(1);
		pSupplyPrice.setSpnValue(1000);
		pSWName.setTfText("");
		pSWsort.setCmbSelectIndex(0);
		upNum.setText("");

	}

	
	public void setAc(AdminSoftwareContent ac) {
		this.ac = ac;
	}
}
