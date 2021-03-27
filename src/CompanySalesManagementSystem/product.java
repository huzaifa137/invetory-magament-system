package CompanySalesManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

class demo2
{

	static String url="jdbc:mysql://localhost:3306/inventory";
	static String user="root";
	static String pass="";
	static String query="select * from products";
	static Scanner scan;
	static String name;
	static Statement st;
	static Connection con;
	static int size,price;
	
	
	public static  void combine() throws ClassNotFoundException, SQLException
	{
		scan = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url, user, pass);
		
	}
	
	private static void name()
	{
	
		try {
			combine();
			
			System.out.println("Enter id to modify");
			size=scan.nextInt();
			
			System.out.println("Enter the new product name:");
			name=scan.next();
			
			Statement st = con.createStatement();
			st.executeUpdate("update products set pname='"+name+"' where id='"+size+"'");
			
			System.out.println("\nThe item has been modified successfully");
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void price()

	{
		try {
			combine();
			
			System.out.println("Enter id to modify");
			size=scan.nextInt();
			
			System.out.println("Enter the new price for item:");
			price=scan.nextInt();
			
			Statement st = con.createStatement();
			st.executeUpdate("update products set Pprice='"+price+"' where id='"+size+"'");
			
			System.out.println("\nThe item has been modified successfully");
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	private static void stock() 
{
		
		try {
			combine();
			
			System.out.println("Enter id to modify");
			size=scan.nextInt();
			
			System.out.println("Enter amount of new stock for item:");
			price=scan.nextInt();
			
			Statement st = con.createStatement();
			st.executeUpdate("update products set Pstock='"+price+"' where id='"+size+"'");
			
			System.out.println("\nThe item has been modified successfully");
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void catagory() throws ClassNotFoundException, SQLException
	{
		
		combine();
		
		System.out.println("Enter id to modify");
		size=scan.nextInt();
		
		System.out.println("Enter the new catagory for item:");
		name=scan.next();
		
		Statement st = con.createStatement();
		st.executeUpdate("update products set catagory='"+name+"' where id='"+size+"'");
		
		System.out.println("\nThe item has been modified successfully");
		
	}
	
	private static void prods() throws ClassNotFoundException, SQLException
	{

		Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(url, user, pass);
		Statement st =con.createStatement();
		ResultSet rs =st.executeQuery(query);
		
			System.out.println("\n\nid \t Name \t \t Pprice \t Catagory \t Pstock  \t PDate");
			System.out.println("------------------------------------------------------------------------------------------");
		while(rs.next())
		{
			
			
			System.out.println(rs.getInt("id") + "\t"+rs.getString("Pname") + "\t\t " +    rs.getInt("Pprice") +"\t \t " + rs.getString("Catagory") + "\t "+rs.getInt("Pstock") + "\t \t" +rs.getDate("Date"));
		
	}
}
	
	public static void list() throws ClassNotFoundException, SQLException
	{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(url, user, pass);
		Statement st =con.createStatement();
		ResultSet rs =st.executeQuery(query);
		
			System.out.println("\nid \t Name \t \t Pprice \t Catagory \t Pstock  \t PDate");
			System.out.println("------------------------------------------------------------------------------------------");
		while(rs.next())
		{
			
			
			System.out.println(rs.getInt("id") + "\t"+rs.getString("Pname") + "\t\t " +    rs.getInt("Pprice") +"\t \t " + rs.getString("Catagory") + "\t "+rs.getInt("Pstock") + "\t \t" +rs.getDate("Date"));
		}
		
	}
	
	public static void add() throws ClassNotFoundException, SQLException
	{
		combine();
		
		System.out.println("\n\t \t \t Add new product in stock\n");
		
		System.out.println("Enter product name :");
		name=scan.next();
	
		System.out.println("Enter product price");
		int price=scan.nextInt();
		
		System.out.println("Enter catagory for product");
		String cat=scan.next();
		
		System.out.println("Enter the amount of stock");
		int stock=scan.nextInt();
		
		long millis=System.currentTimeMillis();  
        java.sql.Date date=new java.sql.Date(millis);  
		Statement st = con.createStatement();
		st.executeUpdate("insert into products (Pname,Pprice,Catagory,Pstock,Date) values ('"+name+"','"+price+"','"+cat+"','"+stock+"','"+date+"')");
		
		System.out.println("\nItem has been addeded to the sugggested item list");
	
	}
	
	public static void remove()throws ClassNotFoundException, SQLException
	{
		
		combine();
		
		System.out.println("\nEnter product name to be removed");
		name=scan.nextLine();
	
		Statement st = con.createStatement();
		st.executeUpdate("Delete from products where pname='"+name+"'");
		System.out.println("\n Item has been removed successfully");
	}
	
	public static void modify()throws ClassNotFoundException, SQLException
	{
		
		
		int id;
		combine();
		
	
		
		do
		{
			System.out.println("\n\t \t Modify Menu \n"
					+ "\n1.Modify name"
					+ "\n2.Modify price"
					+ "\n3.Modify catagory"
					+ "\n4.Modify stock"
					+ "\n5.Display products details");
		
			System.out.println("\nChoose the choice you wish to modify");
			id=scan.nextInt();
			
			switch(id) {
			
			case 1:
				name();
				break;
			case 2:
				price();
				break;
			case 3:
				catagory();
				break;
			case 4:
				stock();
				break;
			case 5:
				prods();
				break;
			}
		}while(id!=138334);
		
	}

	public static void search() throws SQLException, ClassNotFoundException
	{

			
			scan = new Scanner(System.in);
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pass);

			PreparedStatement st = con.prepareStatement("select * from products where Pname=(?)");
			System.out.println("Enter the item you need ");
			String name=scan.nextLine();
			st.setString(1, name);
			ResultSet rs = st.executeQuery();
			
			while(rs.next())
			{
				
				System.out.println("\nName   \t \t categories  \t  \t Pprice \tRemainingStock");
				System.out.println("--------------------------------------------------------------------------------------------------------");;
				System.out.println(rs.getString(2) + "  \t  " + rs.getString(4) +"   \t \t "+ rs.getInt(3) +"\t \t \t "+ rs.getInt(5));
				
			}	
		}
}

 	public class product extends demo2{
 		
	public void pro() throws SQLException, ClassNotFoundException
	{
		

		int choice;
		 scan=new Scanner(System.in);
		
			do {
					System.out.println("\n \n  \t \t Product Menu \n "
							+ "\n1.List Items"
							+ "\n2.Add Item"
							+ "\n3.remove item"
							+ "\n4.Modify item"
							+ "\n5.Search item");
				
				System.out.println("\nPlease make your suggestion");
				choice=scan.nextInt();
				
				switch(choice) {
				
				case 1:
					list();
					break;
					
				case 2:
					add();
					break;
					
				case 3:
					remove();
					break;
				
				case 4:
					modify();
					break;
				case 5:
					search();
					break;
					
				}
			}while(choice !=-1220012);
	}

	public static void main(String args[]) throws SQLException, ClassNotFoundException
	{
		
		product pr = new product();
		pr.pro();
	
		
	}
}
