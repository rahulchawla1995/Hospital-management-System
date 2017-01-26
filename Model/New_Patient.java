import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.Statement;


public class New_Patient {
	private String gender = "female";
	public void New_Patient_reg(Patient_Reg preg){
		try{
			//1. Get a connection to database
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
			//2. Create a statement
			Statement myStmt = myConn.createStatement();
			//3.Execute SQL Query
			if(preg.getRdbtnNewRadioButton().isSelected()){
				gender = "male";
			}
			myStmt.executeUpdate("insert into patient set name='"+ preg.getTextField().getText()+"'  , dob='"+preg.getTextField_1().getText() +"'  , gender='"+ gender +"'  , address='"+preg.getTextField_2().getText() +"', mobile='"+ preg.getTextField_3().getText()+"'");
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
