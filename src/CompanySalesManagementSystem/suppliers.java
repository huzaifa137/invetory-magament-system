package CompanySalesManagementSystem;

import java.sql.*;
import java.util.*;

class demo
{
	
	Connection con;
	static String url="jdbc:mysql://localhost:3306/inventory";
	static String name="root";
	static String pass="";
	
	public static void suppliertable() throws SQLException
	{
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con =DriverManager.getConnection(url, name, pass);
			Statement st = con.createStatement();
		
			ResultSet rs = st.executeQuery("select * from suppliers");
			
			while(rs.next())
			{
				String table = rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getDate(4) + " " + rs.getInt(5);
				System.out.println(table);
				
			}
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
		}
	}
	
		
		public void catagories() throws ClassNotFoundException, SQLException
		{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, name, pass);
			
			PreparedStatement st = con.prepareStatement("select * from suppliers");
			ResultSet rs = st.executeQuery();
			
			while(rs.next())
			{
				String x = rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + "" + rs.getDate(4) + " " + rs.getInt(5);
				
				System.out.println(x);
				
			}
		}	

public void number()
{
	
}

}

public class suppliers extends demo {
	
		static Scanner scan;
		static int choice;
		
		public static void main(String args[]) throws SQLException
		{
			scan = new Scanner(System.in);
				
			System.out.println("\t \t \t Supplier Menu ");
			
		
			do
			{
				System.out.println("\n 1. view all supplier Details"
						+ "\n 2. View Supplier's Name"
						+ "\n 3. view supplier sales catagories"
						+ "\n 4. Amount of goods per Supplier");
				
				System.out.println("Make a choice from the Above");
				choice = scan.nextInt();
				
				switch(choice)
				{
				
				case 1:
					suppliertable();
					break;
				
				}
				
				
			}while(choice != -10);
	}
}

