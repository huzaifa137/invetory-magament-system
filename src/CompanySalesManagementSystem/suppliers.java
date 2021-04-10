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
	static Connection con1;
	static Scanner scan;
	static int choice;
	
	public static  void combine() throws ClassNotFoundException, SQLException
	{
		scan = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url, name, pass);	
	}
	/*
	*This is does display the all the supplier tables
	*/
	public static void suppliertable() throws SQLException
	{
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con =DriverManager.getConnection(url, name, pass);
			Statement st = con.createStatement();
		
			ResultSet rs = st.executeQuery("select * from suppliers");
			
			System.out.println("\n \t \t \t Supplier Details ");
			
				System.out.println("\nid \t Name  \t  catagory of goods\tDate of commodity \tAmount of products");
				System.out.println("------------------------------------------------------------------------------------");
			while(rs.next())
			{
				String table = rs.getInt(1)+ "\t" + rs.getString(2)+ "\t" + " \t" + rs.getString(3) + "\t" +"\t " + rs.getDate(4) + "\t \t " + rs.getInt(5);
				System.out.println(table);
				
			}
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
		}
	}
	
	private static void name()
	{
	
		try {
			combine();
			
			System.out.println("Enter id to modify");
			int size=scan.nextInt();
			
			System.out.println("Enter the new product name:");
			String name1=scan.next();
			
			Statement st = con.createStatement();
			//st.executeUpdate("update products set pname='"+name1+"' where id='"+size+"'");
			st.executeUpdate("update suppliers set category_of_commodity='"+name1+"' where id='"+size+"'");
			
			System.out.println("\nThe item has been modified successfully");
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void catagory() throws ClassNotFoundException, SQLException

	{
		
		combine();
		
		System.out.println("Enter id to modify");
		int size=scan.nextInt();
		
		System.out.println("Enter the new catagory for item:");
		String name1=scan.next();
		
		Statement st = con.createStatement();
		st.executeUpdate("update suppliers set category_of_commodity='"+name1+"' where id='"+size+"'");
		
		System.out.println("\nThe item has been modified successfully");
		
	}

	private static void stock() 

	{
			
			try {
				combine();
				
				System.out.println("Enter id to modify");
				int size=scan.nextInt();
				
				System.out.println("Enter amount of new stock for item:");
				int price=scan.nextInt();
				
				Statement st = con.createStatement();
				st.executeUpdate("update suppliers set Amount_of_products='"+price+"' where id='"+size+"'");
				
				System.out.println("\nThe item has been modified successfully");
				
				
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}

	public static void suggest() throws SQLException
	{
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con =DriverManager.getConnection(url, name, pass);
			Statement st = con.createStatement();
		
			ResultSet rs = st.executeQuery("select * from suggest");
			
			System.out.println("\n \t \t \t Supplier Details ");
			
				System.out.println("\nid \t Name");
				System.out.println("------------------");
			while(rs.next())
			{
				String table = rs.getInt(1)+ "\t" + rs.getString(2);
				System.out.println(table);
				
			}
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
		}
	}
	public static void modify()throws ClassNotFoundException, SQLException
	{
		
		
		int id;
		combine();
		
	
		
		do
		{
			System.out.println("\n\t \t Modify Menu \n"
					+ "\n1.Modify name"
					+ "\n2.Modify catagory"
					+ "\n3.Modify stock"
					+ "\n4 Exit");
		
			System.out.println("\nChoose the choice you wish to modify");
			id=scan.nextInt();
			
			switch(id) {
			
			case 1:
				name();
				break;
			case 2:
				catagory();
				break;
			case 3:
				stock();
				break;
			}
		}while(id != 4);
		
	}
	//This is used to add a certain product in the table
	public static void addproduct() throws SQLException, ClassNotFoundException
	{

		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url, name, pass);
		
		System.out.println("\n\t \t \t Add new product in stock\n");
		
		System.out.println("Enter product name :");
		String name1=scan.next();
	
		System.out.println("Enter Supplier name :");
		String supname=scan.next();
		
		System.out.println("Enter product price");
		int price=scan.nextInt();
		
		System.out.println("Enter catagory for product");
		String cats=scan.next();
		
		System.out.println("Enter the amount of stock");
		int stock=scan.nextInt();
		
		long millis=System.currentTimeMillis();  
        java.sql.Date date=new java.sql.Date(millis);  
		Statement st = con.createStatement();
		st.executeUpdate("insert into products (Pname,Pprice,Catagory,Pstock,Date) values ('"+name1+"','"+price+"','"+cats+"','"+stock+"','"+date+"')");
		
		//Statement st2 = con1.createStatement();
		st.executeUpdate("INSERT INTO suppliers(Name, category_of_commodity,Date_of_Commodity,Amount_of_products) VALUES ('"+supname+"','"+cats+"','"+date+"','"+stock+"')");
		
		System.out.println("\nItem has been addeded to the sugggested item list");
	
		
	}

 }
	

public class suppliers extends demo {
	
	/*
	 * This is the method module that controls the 
	 * running and executing of the whole program
	 * and the logic.
	 */
		public void collect() throws SQLException, ClassNotFoundException
		{
			
			scan = new Scanner(System.in);
			
			do
			{
				System.out.println("\n \t \t \t Supplier's Menu \n "
						+ "\n 1. view all supplier Details"
						+ "\n 2. Modify"
						+ "\n 3. View Suggested goods"
						+ "\n 4. Add product"
						+ "\n 5. Exit");
				
				System.out.println("\nMake a choice from the Above");
				choice = scan.nextInt();
				
				switch(choice)
				{
				
				case 1:
					suppliertable();
					break;
					
				case 2:
					modify();
					break;
				case 3:
					suggest();
					break;
				case 4:
					addproduct();
					break;
				}
			
			}while(choice != 5);
			
		System.out.println("\n \t \t \t \t \t *** Thank you our dear Supplier *** \n ");
	}
		
		public static void main(String args[]) throws ClassNotFoundException, SQLException
		{
			
			suppliers nm = new suppliers();
			nm.collect();
	}
}