import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;


public class Appointment_c {
	private String slot;
	private String Doctor_name;
	private int appid;
	private int DID;
	public void App(Appointment app, String dieases_name, int Pid){
		App_list app_list = new App_list();
		app_list.Doctor_list(app, dieases_name);
		
		app.getBtnNewButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Doctor_name = app.getComboBox().getSelectedItem().toString();
				Enumeration<AbstractButton> allRadioButton = app.getBG().getElements();
				while(allRadioButton.hasMoreElements())  
		        {  
		           JRadioButton temp=(JRadioButton)allRadioButton.nextElement();  
		           if(temp.isSelected())  
		           {  
		        	   slot = temp.getText();
		           }  
		        }
				
				Ask ask = new Ask();
				ask.DoctorID(Doctor_name);
				DID = ask.getDID();
				if(slot.equals(null) || slot.equals("") || Doctor_name.equals(null) || Doctor_name.equals("")){
					JOptionPane.showMessageDialog(null, "TRY AGAIN!!");
				}else{
					if(Pid == -999){
							JOptionPane.showMessageDialog(null, "No. Of Appointment Left ("+ slot +") : "+ ask.PendingSlot(DID, slot));	
					}else{
						ConfirmApp book = new ConfirmApp();
						appid = book.AppID(DID, dieases_name, Pid, slot);
						conf_page confirm_page  = new conf_page(appid);
						confirm_page.setVisible(true);
						app.dispose();
					
					}
				}
				
			}
		});
	}
}
