import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;


public class Dieases_c {

	
	public void Dieases_action(Dieases dieases, int pid){
		
		Dieases_list dieases_list = new Dieases_list(dieases);
		
		dieases.getBtnNewButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String diease_name = dieases.getComboBox().getSelectedItem().toString();
				Appointment app = new Appointment();
				Appointment_c app_c = new Appointment_c();
				app_c.App(app, diease_name,pid);
				app.setVisible(true);
				dieases.dispose();
			}
		});
	}
}
