import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Patient_auth {
	private int ID_num;
	private boolean auth;
	private int patient_id;
	
	public int getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}
	public boolean isAuth() {
		return auth;
	}
	public void setAuth(boolean auth) {
		this.auth = auth;
	}
	public void mobile(String mobile){
		
		
		try{
			//1. Get a connection to database
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
			//2. Create a statement
			Statement myStmt = myConn.createStatement();
			//3.Execute SQL Query
			ResultSet myRs = myStmt.executeQuery("select * from patient where mobile='" +mobile+ "'");
			//4. Process the result set
			while(myRs.next()){
				if(mobile.equals(myRs.getString("mobile"))){
					patient_id = myRs.getInt("id");
					auth = true;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void ID(String ID){
		ID_num = Integer.parseInt(ID);
		try{
			//1. Get a connection to database
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
			//2. Create a statement
			Statement myStmt = myConn.createStatement();
			//3.Execute SQL Query
			ResultSet myRs = myStmt.executeQuery("select * from patient where id='" + this.ID_num+ "'");
			//4. Process the result set
			while(myRs.next()){
				if(this.ID_num == myRs.getInt("id")){
					patient_id = myRs.getInt("id");
					auth = true;
				}
			}
		}catch(Exception e){
			e.printStackTrace(); 
		}
		
	}
}
