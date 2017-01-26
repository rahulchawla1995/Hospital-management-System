import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;




public class Patient_c {
	private int id;
	private String ID;
	private String mobile;
	public void patient_auth(Patient_Login patient){
		patient.getBtnNewButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ID = patient.getTextField().getText();
				id = Integer.parseInt(ID);
				mobile = patient.getTextField_1().getText();
				Patient_auth patient_auth = new Patient_auth(); 
				if(!(ID.equals(null) || ID.equalsIgnoreCase(""))){
					patient_auth.ID(ID);
					if(patient_auth.isAuth()){
						Dieases dieases = new Dieases();
						Dieases_c dieases_c = new Dieases_c();
						dieases_c.Dieases_action(dieases,id);
						dieases.setVisible(true);
						patient.dispose();
						//JOptionPane.showMessageDialog(null, "Successfully Matched with ID");
					}else{
						JOptionPane.showMessageDialog(null, "Wrong Patient ID!");
					}
				}else if(!(mobile.equals(null) || mobile.equalsIgnoreCase(""))){
					patient_auth.mobile(mobile);
					if(patient_auth.isAuth()){
						Dieases dieases = new Dieases();
						dieases.setVisible(true);
						patient.dispose();
						//JOptionPane.showMessageDialog(null, "Successfully Matched with Mobile");
					}else{
						JOptionPane.showMessageDialog(null, "Wrong Number Entered");
					}
				}else{
					JOptionPane.showMessageDialog(null, "TRY AGAIN!!");
				}
				
			}
		});
		
		patient.getBtnNewButton_1().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Patient_Reg patient_reg = new Patient_Reg();
				Patient_Reg_c preg = new Patient_Reg_c(patient_reg);
				patient.dispose();
				patient_reg.setVisible(true);
			}
		});
	}
}
