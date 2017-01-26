
public class Hospital_Management {
	public static void main(String[] args) {
		
		// Initalize all three Object manual
		Login login = new Login();
		Control control = new Control();
		
		
		// If we are deploying to new Hardware then run cretable Script
		//CreateTable createtable = new CreateTable();
		DB db = new DB();
		
		// Visible First Jframe as main
		login.frmSmsHospital.setVisible(true);
		
		control.Login_Auth(login, db);	
		
	}
}
