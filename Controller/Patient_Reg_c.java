import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

class chk_mobile{
	static boolean num_valid(String input){
		 try
	        {
	            Integer.parseInt(input);
	        }
	        catch(NumberFormatException ex)
	        {
	            return false;
	        }
	        return true;
	}
}
public class Patient_Reg_c {
	private String name;
	private boolean male;
	private boolean female;
	private String address;
	private String mobile;
	private String dob;
	private int mnum;
	private Date date1;
	private String error = "";
	private String regex = "\\d+";
	private int id;
	
	
	public static boolean isValidDate(String inDate) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    dateFormat.setLenient(false);
	    try {
	      dateFormat.parse(inDate.trim());
	    } catch (ParseException pe) {
	      return false;
	    }
	    return true;
	  }
	
	public Patient_Reg_c(Patient_Reg preg){
		
		preg.getBtnNewButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name = preg.getTextField().getText();
				male = preg.getRdbtnNewRadioButton().isSelected();
				female = preg.getRdbtnNewRadioButton_1().isSelected();
				dob = preg.getTextField_1().getText();
				address = preg.getTextField_2().getText();
				mobile = preg.getTextField_3().getText();
				
				if(name.equals(null) || name.equals("")){
					error += "Name is Empty \n";
				}
				
				if(male && female){
					error += "Select one Gender \n";
				}else if(!(male || female)){
					error += "Select Gender \n";
				}
				
				if(dob.equals(null) || dob.equals("")){
					error += "Enter DOB \n";
				}else if(!isValidDate(dob)){
					error += "Enter date YYYY-MM-DD Formate \n";
				}
				
				if(address.equals(null) || address.equals("")){
					error += "Enter Address \n";
				}
				
				if(mobile.equals(null) || mobile.equals("")){
					error += "Enter Mobile Number \n";
				}else if(!mobile.matches(regex)){
					error += "Enter only Number";
				}else if(mobile.length() != 10){
					error += "Enter 10 Digit Mobile Number Only \n";
				}
				
				
				if(error.equals(null) || error.equals("")){
					
					New_Patient newPatient = new New_Patient();
					newPatient.New_Patient_reg(preg);
					
					Ask ask = new Ask();
					ask.NewPatient_ID(name, mobile);
					id = ask.getPatientID();
					
					
					Dieases dieases = new Dieases();
					Dieases_c dieases_c = new Dieases_c();
					dieases_c.Dieases_action(dieases,id);
					dieases.setVisible(true);
					preg.dispose();
					
					//JOptionPane.showMessageDialog(null,mnum);
				}else{
					
					JOptionPane.showMessageDialog(null, error);
					error = "";
				}
				
			}
		});
	}
	
}
