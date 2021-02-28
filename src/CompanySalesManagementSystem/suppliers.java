package CompanySalesManagementSystem;

import java.sql.*;
import java.util.*;

class demo
{
	
	
	static String url="jdbc:mysql://localhost:3306/inventory";
	static String name="root";
	static String pass="";
	static String query="Select name from suppliers"; 
	static Connection con;
	static Scanner scan;
	
	public static void suppliertable() throws SQLException
	{
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con =DriverManager.getConnection(url, name, pass);
			Statement st = con.createStatement();
		
			ResultSet rs = st.executeQuery("select * from suppliers");
			
			while(rs.next())
			{
				
				System.out.println("\n \t \t \t Supplier Details ");
				
				String table = rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getDate(4) + " " + rs.getInt(5);
				System.out.println("\n " + table);
				
			}
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
		}
	}
	
	public static void suppliername() throws ClassNotFoundException, SQLException
		{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, name, pass);

			PreparedStatement st = con.prepareStatement("select name from suppliers");
			ResultSet rs = st.executeQuery();
			
			while(rs.next())
			{
				
				System.out.println("\nSupplier'sname");
				System.out.println("\n" + rs.getString("name"));
				
			}
		}	

	public static void categories()throws ClassNotFoundException, SQLException
	{
	
		{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, name, pass);

			PreparedStatement st = con.prepareStatement("select name , category_of_commodity from suppliers");
			ResultSet rs = st.executeQuery();
			
			while(rs.next())
			{
				
				System.out.println("\nName   \t \t categories");
				System.out.println("\n" + rs.getString("name") + " \t  " + rs.getString("category_of_commodity"));
				
			}
		}	
	}

	public static void number_of_products() throws ClassNotFoundException, SQLException
	{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url, name, pass);

		PreparedStatement st = con.prepareStatement("select name , category_of_commodity, Amount_of_products from suppliers");
		ResultSet rs = st.executeQuery();
		
		while(rs.next())
		{
			
			System.out.println("\nName \t categories \t Amount_of_products");
			System.out.println("\n" + rs.getString("name") + "\t  " + rs.getString("category_of_commodity") + "\t \t \t" + rs.getInt("Amount_of_products"));
		}
	}
	
}

public class suppliers extends demo {
	
		static Scanner scan;
		static int choice;
		
		public static void main(String args[]) throws SQLException, ClassNotFoundException
		{
			scan = new Scanner(System.in);
		
			do
			{
				System.out.println("\n \t \t \t Menu \n "
						+ "\n 1. view all supplier Details"
						+ "\n 2. View Supplier's Name"
						+ "\n 3. view supplier sales catagories"
						+ "\n 4. Amount of goods per Supplier");
				
				System.out.println("\n \n \t \tMake a choice from the Above");
				choice = scan.nextInt();
				
				switch(choice)
				{
				
				case 1:
					suppliertable();
					break;
					
				case 2:
					suppliername();
					break;
				case 3:
					categories();
					break;
				
				case 4:
					number_of_products();
					break;
				
				default :System.out.println("Please make a correct Selection !!!");
					
				}
				
				
			}while(choice != -10);
	}
}

