import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.MatteBorder;




public class Appointment extends JFrame {
	
	private JPanel contentPane;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private ButtonGroup BG;
	private JButton btnNewButton;
	private JPanel panel_8;
	private JRadioButton AM;
	private JRadioButton PM;
	
	public JRadioButton getAM() {
		return AM;
	}


	public void setAM(JRadioButton aM) {
		AM = aM;
	}


	public JRadioButton getPM() {
		return PM;
	}


	public void setPM(JRadioButton pM) {
		PM = pM;
	}


	public JPanel getPanel_8() {
		return panel_8;
	}


	public void setPanel_8(JPanel panel_8) {
		this.panel_8 = panel_8;
	}


	public JComboBox getComboBox() {
		return comboBox;
	}


	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}


	public JComboBox getComboBox_1() {
		return comboBox_1;
	}


	public void setComboBox_1(JComboBox comboBox_1) {
		this.comboBox_1 = comboBox_1;
	}


	public ButtonGroup getBG() {
		return BG;
	}


	public void setBG(ButtonGroup bG) {
		BG = bG;
	}


	public JButton getBtnNewButton() {
		return btnNewButton;
	}


	public void setBtnNewButton(JButton btnNewButton) {
		this.btnNewButton = btnNewButton;
	}


	public Appointment(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3,0));
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0,3));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(224, 255, 255));
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DOCTOR");
		lblNewLabel.setBackground(new Color(224, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(34, 24, 110, 39);
		panel_3.add(lblNewLabel);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(230, 230, 250));
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("SPECIALITY");
		lblNewLabel_1.setBackground(new Color(245, 222, 179));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(20, 26, 124, 35);
		panel_4.add(lblNewLabel_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 228, 225));
		panel_1.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("AVAILIBILITY");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(10, 31, 124, 26);
		panel_5.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(0,3));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(224, 255, 255));
		panel_2.add(panel_6);
		panel_6.setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.setBounds(10, 25, 124, 30);
		panel_6.add(comboBox);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(230, 230, 250));
		panel_2.add(panel_7);
		panel_7.setLayout(null);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(10, 27, 124, 30);
		panel_7.add(comboBox_1);
		
		panel_8 = new JPanel();
		panel_8.setBackground(new Color(255, 228, 225));
		panel_2.add(panel_8);
		panel_8.setLayout(null);
		
		AM = new JRadioButton("AM");
		AM.setBackground(new Color(176, 196, 222));
		AM.setFont(new Font("Tahoma", Font.BOLD, 16));
		AM.setBounds(0, 27, 54, 23);
		//panel_8.add(AM);
		
		PM = new JRadioButton("PM");
		PM.setBackground(new Color(176, 196, 222));
		PM.setFont(new Font("Tahoma", Font.BOLD, 16));
		PM.setBounds(82, 29, 109, 23);
		//panel_8.add(PM);
		
		BG = new ButtonGroup();
		BG.add(PM);
		BG.add(AM);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 228, 196));
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnNewButton = new JButton("SUBMIT");
		
		btnNewButton.setBackground(new Color(245, 222, 179));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(165, 32, 108, 31);
		panel.add(btnNewButton);
	}
}
