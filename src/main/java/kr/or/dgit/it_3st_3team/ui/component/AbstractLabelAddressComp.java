package kr.or.dgit.it_3st_3team.ui.component;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public abstract class AbstractLabelAddressComp<T> extends JPanel {
	private JTextField tfAddress1;
	private JTextField tfAddress2;
	private JLabel lblAdd;
	private JPanel panel;

	public AbstractLabelAddressComp(String label) {
		lblAdd = new JLabel(label);
		initComponents();
	}

	private void initComponents() {
		setLayout(new BorderLayout(0, 0));

		JPanel pAddress = new JPanel();
		add(pAddress, BorderLayout.CENTER);
		pAddress.setLayout(new BorderLayout(0, 0));

		JPanel pSpace = new JPanel();
		pAddress.add(pSpace, BorderLayout.CENTER);
		pSpace.setLayout(new GridLayout(2, 0, 5, 5));

		tfAddress1 = new JTextField();
		tfAddress1.setColumns(10);
		tfAddress1.setEditable(false);
		pSpace.add(tfAddress1);

		tfAddress2 = new JTextField();
		pSpace.add(tfAddress2);
		tfAddress2.setColumns(10);

		panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 0, 20));
		pAddress.add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		lblAdd.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAdd.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblAdd);
	}

	public void setTfAddress1(String text) {
		tfAddress1.setText(text);
	}

	public String getTfAddress1() {
		return tfAddress1.getText();
	}

	public void setTfAddress2(String text) {
		tfAddress2.setText(text);
	}

	public String getTfAddress2() {
		return tfAddress2.getText();
	}

	public void resetTfAddress() {
		tfAddress1.setText("");
		tfAddress2.setText("");
	}
}
