import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class ConfirmApp {

	private int appID;
	public int getAppID() {
		return appID;
	}
	public void setAppID(int appID) {
		this.appID = appID;
	}
	public int AppID(int DID, String Diease , int Pid, String Slot){
		try{
			//1. Get a connection to database
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
			//2. Create a statement
			Statement myStmt = myConn.createStatement();
			//3.Execute SQL Query
			
			myStmt.executeUpdate("insert into appointment set p_id="+ Pid +" , d_ id="+DID+"  , diease='"+ Diease+"' , app_date=CURDATE()  , slot='"+Slot+"'");
			
			ResultSet myRs = myStmt.executeQuery("select id from appointment where p_id="+Pid+" and d_id="+DID+" and app_date=CURDATE() and diease='"+Diease+"' and slot='"+Slot+"' ");
			while(myRs.next()){
				appID = myRs.getInt("id");
			}
			if(Slot.equals("AM")){
				myStmt.executeUpdate("update doctor_slot set slot_am=slot_am-1 where d_id="+DID+" and app_date=CURDATE()");
			}else{
				myStmt.executeUpdate("update doctor_slot set slot_pm=slot_pm-1 where d_id="+DID+" and app_date=CURDATE()");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return appID;
	}
}
