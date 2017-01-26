import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DB {
	private boolean user_result=false;

	
	
	public void User_Auth(String username,String password){
		try{
			//1. Get a connection to database
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
			//2. Create a statement
			Statement myStmt = myConn.createStatement();
			//3.Execute SQL Query
			ResultSet myRs = myStmt.executeQuery("select * from user where username='"+username+"' and password='"+password+"'");
			//4. Process the result set
			while(myRs.next()){
				if(username.equals(myRs.getString("username")) && password.equals(myRs.getString("password"))){
					user_result = true;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public boolean isUser_result() {
		return user_result;
	}

	public void setUser_result(boolean user_result) {
		this.user_result = user_result;
	}
	
}
