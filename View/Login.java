

//import java.awt.EventQueue

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class Login {

	JFrame frmSmsHospital;
	JButton btnLogin;
	private JTextField textField;
	private JTextField textField_1;
	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JTextField getTextField_1() {
		return textField_1;
	}

	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}

	public Login() {
		frmSmsHospital = new JFrame();
		frmSmsHospital.setTitle("S.M.S HOSPITAL");
		frmSmsHospital.getContentPane().setBackground(Color.GRAY);
		frmSmsHospital.setBounds(100, 100, 450, 300);
		frmSmsHospital.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSmsHospital.getContentPane().setLayout(null);
		
		btnLogin = new JButton(" LOGIN");
		btnLogin.setForeground(new Color(0, 0, 0));
		btnLogin.setBackground(Color.LIGHT_GRAY);
		
		
		
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLogin.setBounds(220, 190, 91, 23);
		frmSmsHospital.getContentPane().add(btnLogin);
		
		JLabel lblUserid = new JLabel("USER_ID");
		lblUserid.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUserid.setBounds(153, 59, 80, 28);
		frmSmsHospital.getContentPane().add(lblUserid);
		
		textField = new JTextField();
		textField.setBounds(268, 64, 135, 20);
		frmSmsHospital.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPasswd = new JLabel("PASSWORD");
		lblPasswd.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPasswd.setBounds(154, 122, 79, 14);
		frmSmsHospital.getContentPane().add(lblPasswd);
		
		textField_1 = new JTextField();
		textField_1.setBounds(268, 120, 135, 20);
		frmSmsHospital.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel.setBounds(10, 28, 160, 170);
			}
		});
		frmSmsHospital.getContentPane().add(lblNewLabel);
		
	
	}
}
