import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Ask {
	private int DID;
	private String Patient;
	private String Doctor;
	private String Dieases;
	private int PatientID;
	
	public Ask(){
		try{
			//1. Get a connection to database
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
			//2. Create a statement
			Statement myStmt = myConn.createStatement();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void DoctorID(String Doctor_Name){
		try{
			//1. Get a connection to database
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
			//2. Create a statement
			Statement myStmt = myConn.createStatement();
			//3.Execute SQL Query
			ResultSet myRs = myStmt.executeQuery("Select * from doctor where name='"+Doctor_Name+"'");
			while(myRs.next()){
				DID = myRs.getInt("id");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public String AppID_Patient(int appid){
		try{
			//1. Get a connection to database
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
			//2. Create a statement
			Statement myStmt = myConn.createStatement();
			//3.Execute SQL Query
			ResultSet myRs = myStmt.executeQuery("Select name from patient inner join appointment on appointment.p_id = patient.id where appointment.id="+appid);
			while(myRs.next()){
				Patient = myRs.getString("name");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return Patient;
	}
	
	
	public String AppID_Doctor(int appid){
		try{
			//1. Get a connection to database
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
			//2. Create a statement
			Statement myStmt = myConn.createStatement();
			//3.Execute SQL Query
			ResultSet myRs = myStmt.executeQuery("Select name from doctor inner join appointment on appointment.d_id = doctor.id where appointment.id="+appid);
			while(myRs.next()){
				Doctor = myRs.getString("name");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return Doctor;
	}
	
	public String AppID_Diease(int appid){
		try{
			//1. Get a connection to database
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
			//2. Create a statement
			Statement myStmt = myConn.createStatement();
			//3.Execute SQL Query
			ResultSet myRs = myStmt.executeQuery("Select diease from appointment where appointment.id="+appid);
			while(myRs.next()){
				Dieases = myRs.getString("diease");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return Dieases;
	}
	
	public void NewPatient_ID(String Name, String Mobile){
		try{
			//1. Get a connection to database
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
			//2. Create a statement
			Statement myStmt = myConn.createStatement();
			//3.Execute SQL Query
			ResultSet myRs = myStmt.executeQuery("Select id from patient where name='"+Name +"'  and mobile="+ Mobile+"'");
			while(myRs.next()){
				PatientID = myRs.getInt("id");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public int PendingSlot(int DID, String slot){
		try{
			//1. Get a connection to database
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
			//2. Create a statement
			Statement myStmt = myConn.createStatement();
			//3.Execute SQL Query
			ResultSet myRs = myStmt.executeQuery("Select * from doctor_slot where d_id="+DID+" and app_date=CURDATE()");
			while(myRs.next()){
				if(slot.equals("AM")){
					return myRs.getInt("slot_am");
				}else{
					return myRs.getInt("slot_pm");
				}	
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}
	
	
	public int getDID() {
		return DID;
	}
	public String getPatient() {
		return Patient;
	}
	public String getDoctor() {
		return Doctor;
	}
	public String getDieases() {
		return Dieases;
	}
	public int getPatientID() {
		return PatientID;
	}
	
	
	
	

	
	
}
