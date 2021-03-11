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
	
	public static void buy()
	{
		
		System.out.println("We buy goods Here");
		
		
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
				
				System.out.println("\nName   \t \t categories");
				System.out.println("\n" + rs.getString(2) + " \t  " + rs.getString(4));
				
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
			System.out.println("id \t Name \t \t Pprice \t Catagory \t Pstock  \t PDate");
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
   
public static void main(String args[]) throws ClassNotFoundException, SQLException	
{
	
	int choice;
	 scan=new Scanner(System.in);
	
		do {
				System.out.println("\n Supplier Menu"
						+ "\n1.List Items"
						+ "\n2.Search Items"
						+ "\n3.Buy item"
						+ "\n4.Suggest item");
			
			System.out.println("Please make your suggestion");
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
	
}
