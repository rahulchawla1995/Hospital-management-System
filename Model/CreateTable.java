import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class CreateTable {

	private boolean disease,slot;
	private boolean doctor,patient,user;
	private boolean app;
	private String temp;
	public void createTables(){
		doctor = patient = app = disease = user = slot = false;
		try{
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
			Statement myStmt = myConn.createStatement();
			/* 
			 * Check whther 5 tables present or not
			 * 1. Doctor
			 * 2. Patient
			 * 3. Appointment
			 * 4. User
			 * 5. Disease and speciality
			 */
			
			ResultSet myRs = myStmt.executeQuery("show tables");
			
			while(myRs.next()){
				temp = myRs.getString("Tables_in_project");
				if(temp.equals("patient")){
					patient = true;
				}else if(temp.equals("doctor")){
					doctor = true;
				}else if(temp.equals("appointment")){
					app = true;
				}else if(temp.equals("disease")){
					disease = true;
				}else if(temp.equals("user")){
					user = true;
				}else if(temp.equals("doctor_slot")){
					slot = true;
				}
			}
			/*
			 * create structure of undefined tables here
			 */
			if(doctor == false){
				myStmt.executeUpdate("create table doctor( id int auto_increment not null primary key, name varchar(50) not null, dob date, specility varchar(50) not null)");
			}
			if(patient == false){
				myStmt.executeUpdate("create table patient(id int auto_increment not null,name varchar(50) not null,dob date not null,gender text not null,address varchar(50) not null,mobile varchar(11) not null)");
			}
			if(disease == false){
				myStmt.executeUpdate("create table diease( id int auto_increment not null primary key, d_name varchar(50) not null, speciality varchar(50) not null)");
			}
			if(app == false){
				myStmt.executeUpdate("create table appointment(id int auto_increment not null primary key, p_id int not null, d_id int not null, disease varchar(50) not null, app_date date not null, slot varchar(2) not null)");
			}
			if(user == false){
				myStmt.executeUpdate("create table user(id int auto_increment not null primary key,username not null,password not null)");
			}
			if(slot == false){
				myStmt.executeUpdate("create table doctor_slot(id int auto_increment not null primary key,d_id int not null,app_date date not null,slot_am int null,slot_pm int null)");
			}
			
			if(doctor == false || app == false){
				myStmt.executeUpdate("alter table appointment add foreign key(d_id) references doctor(id)");
			}
			if(patient == false || app == false){
				myStmt.executeUpdate("alter table appointment add foreign key(p_id) references patient(id)");
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
