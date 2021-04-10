package CompanySalesManagementSystem;

import java.sql.SQLException;


/* 
 * This is the master class that runs all the our source code and program
 */
public class master {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {	
	
		Login nm = new Login();
		nm.login();
	
	}
	
}
