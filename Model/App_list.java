import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class App_list {

	public void Doctor_list(Appointment app,String dieases_name){
		try{
			//1. Get a connection to database
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
			//2. Create a statement
			Statement myStmt = myConn.createStatement();
			//3.Execute SQL Query
			ResultSet myRs = myStmt.executeQuery("select * from doctor inner join diease on doctor.specility = diease.speciality where diease.d_name='" + dieases_name + "'"); 
			//4. Process the result set
			app.getComboBox().addItem("");
			while(myRs.next()){
				Statement slot = myConn.createStatement();
				ResultSet slotRs = slot.executeQuery("select * from doctor_slot where d_id="+myRs.getString("id") + " and (slot_am > 0 or slot_pm > 0) and app_date=CURDATE() ");
				app.getComboBox().addItem(myRs.getString("name"));
				while(slotRs.next()){
					if(slotRs.getInt("slot_am") > 0 && slotRs.getInt("slot_pm") > 0){
						app.getPanel_8().add(app.getAM());
						app.getPanel_8().add(app.getPM());
					}else if(slotRs.getInt("slot_am") > 0){
						app.getPanel_8().add(app.getAM());
					}else{
						app.getPanel_8().add(app.getPM());
					}
				}
				//dieases.getComboBox().addItem(myRs.getString("d_name"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
