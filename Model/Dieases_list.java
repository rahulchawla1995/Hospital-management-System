import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class Dieases_list {
	public Dieases_list(Dieases dieases){
		try{
			//1. Get a connection to database
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
			//2. Create a statement
			Statement myStmt = myConn.createStatement();
			//3.Execute SQL Query
			ResultSet myRs = myStmt.executeQuery("select * from diease"); 
			//4. Process the result set
			dieases.getComboBox().addItem("");
			while(myRs.next()){
				dieases.getComboBox().addItem(myRs.getString("d_name"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
