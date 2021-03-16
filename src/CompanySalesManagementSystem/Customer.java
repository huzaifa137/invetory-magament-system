package CompanySalesManagementSystem;


import java.sql.*;
import java.util.*;

class demo1
{

	static String url="jdbc:mysql://localhost:3306/inventory";
	static String user="root";
	static String pass="";
	static String query="select * from products";
	static String result;
	static Connection con;
	static Statement st;
	static Scanner scan;
	static String name;
	static int size,price;
	
	public static void buy() throws SQLException, ClassNotFoundException
	{
		scan = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url, user, pass);

		System.out.println("\nEnter item name to buy");
		name=scan.nextLine();
		
		System.out.println("\nEnter the quantity of the product");
		size=scan.nextInt();
		
		System.out.println("\nEnter the price ");
		price=scan.nextInt();
		
		
		PreparedStatement st = con.prepareStatement("Update products set Pstock=(Pstock-?) where Pname='"+name+"'");
		st.setInt(1, size);
		st.executeUpdate();
		System.out.println("The product has been bought successfully");
		
	}
	
	
	public static void search() throws SQLException, ClassNotFoundException
	{

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
	
	
	public static void list() throws ClassNotFoundException, SQLException
	{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(url, user, pass);
		Statement st =con.createStatement();
		ResultSet rs =st.executeQuery(query);
		
		while(rs.next())
		{
			System.out.println("\nid \t Name \t \t Pprice \t Catagory \t Pstock  \t PDate");
			System.out.println("------------------------------------------------------------------------------------------");
			System.out.println(rs.getInt("id") + "\t"+rs.getString("Pname") + "\t\t " +    rs.getInt("Pprice") +"\t \t " + rs.getString("Catagory") + "\t "+rs.getInt("Pstock") + "\t \t" +rs.getDate("Date"));
		}
		
	}
	

	public static void suggest()
	{
		System.out.println("We suggest goods Here");
	}
	
}

public class Customer extends demo1 {

	static Scanner scan;
	
	public void cust() throws SQLException, ClassNotFoundException
	{
		
		int choice;
		 scan=new Scanner(System.in);
		
			do {
					System.out.println("\n \n  \t \t Customer Menu \n "
							+ "\n1.List Items"
							+ "\n2.Search Items"
							+ "\n3.Buy item"
							+ "\n4.Suggest item");
				
				System.out.println("\nPlease make your suggestion");
				choice=scan.nextInt();
				
				switch(choice) {
				
				case 1:
					list();
					break;
					
				case 2:
					search();
					break;
					
				case 3:
					buy();
					break;
				
				case 4:
					suggest();
					break;
					
				}
			}while(choice !=-1220012);
		
	}
   
public static void main(String args[]) throws ClassNotFoundException, SQLException	
{
	
	Customer cs = new Customer();
	cs.cust();
	
}
	
}
