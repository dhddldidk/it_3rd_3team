package kr.or.dgit.it_3st_3team.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import kr.or.dgit.it_3st_3team.ui.admin.customer.AdminCustomerContent;
import kr.or.dgit.it_3st_3team.ui.admin.software.AdminSoftware;

@SuppressWarnings("serial")
public class UserCustomerUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnSWRegister;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserCustomerUI frame = new UserCustomerUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserCustomerUI() {
		initComponents();
	}

	private void initComponents() {
		setTitle("소프트웨어 - 고객 ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		JPanel pImg = new JPanel();
		pImg.setLayout(null);
		pImg.setBackground(new Color(51, 153, 204));
		pImg.setBounds(0, 0, 300, 231);
		contentPane.add(pImg);
		
		JLabel lblImg = new JLabel("");
		lblImg.setIcon(new ImageIcon("C:\\Users\\SCARLETT\\Desktop\\ppt이용 이미지\\pg IMg\\add-user-interface-outlined-symbol.png"));
		lblImg.setBounds(85, 38, 128, 128);
		pImg.add(lblImg);
		
		JLabel lblName = new JLabel("재밌는 게임방님 환영합니다.");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("나눔바른고딕", Font.PLAIN, 15));
		lblName.setBounds(30, 188, 228, 33);
		pImg.add(lblName);
		
		JPanel pMenu = new JPanel();
		pMenu.setBackground(new Color(51, 153, 204));
		pMenu.setBounds(0, 230, 300, 631);
		contentPane.add(pMenu);
		pMenu.setLayout(new GridLayout(6, 1, 0, 0));
		
		JLabel lblEmpty = new JLabel("");
		pMenu.add(lblEmpty);
		
		btnSWRegister = new JButton("소프트웨어 주문");
		btnSWRegister.setBounds(0, 105, 298, 105);
		btnSWRegister.addActionListener(this);
		btnSWRegister.setForeground(Color.DARK_GRAY);
		btnSWRegister.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		btnSWRegister.setBackground(new Color(51, 153, 204));
		pMenu.add(btnSWRegister);
		
		JButton btnSupplyStatus = new JButton("소프트웨어 주문현황");
		btnSupplyStatus.setBounds(0, 210, 298, 105);
		btnSupplyStatus.setForeground(Color.DARK_GRAY);
		btnSupplyStatus.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		btnSupplyStatus.setBackground(new Color(51, 153, 204));
		pMenu.add(btnSupplyStatus);
		
		JButton btnSupplyStatusGraph = new JButton("소프트웨어 주문현황(그래프)");
		btnSupplyStatusGraph.setBounds(0, 315, 298, 105);
		btnSupplyStatusGraph.setForeground(Color.DARK_GRAY);
		btnSupplyStatusGraph.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		btnSupplyStatusGraph.setBackground(new Color(51, 153, 204));
		pMenu.add(btnSupplyStatusGraph);
		
		JButton btnModify = new JButton("회원정보 수정");
		btnModify.setBounds(0, 420, 298, 105);
		btnModify.setForeground(Color.DARK_GRAY);
		btnModify.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		btnModify.setBackground(new Color(51, 153, 204));
		pMenu.add(btnModify);
		
		JPanel pContent = new JPanel();
		pContent.setBounds(298, 0, 1186, 861);
		contentPane.add(pContent);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSWRegister) {
			actionPerformedButton(e);
		}
	}
	protected void actionPerformedButton(ActionEvent e) {
		
	}
}