import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;




public class Menu_c {
	private int id= -999;
	public void select(Menu menu){

		menu.getBtnNewButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dieases dieases = new Dieases();
				Dieases_c dieases_c = new Dieases_c();
				dieases_c.Dieases_action(dieases,id);
				dieases.setVisible(true);
				menu.dispose();
				//JOptionPane.showMessageDialog(null, "TRY AGAIN!!");
			}
		});
		
		
		menu.getBtnNewButton_1().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Patient_Login patient = new Patient_Login();
				Patient_c patient_c = new Patient_c();
				menu.dispose();
				patient.setVisible(true);
				patient_c.patient_auth(patient);
				
	
			}
		});
		
		
	}
}
