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
	static String result;
	static Connection con;
	static Statement st;
	static Scanner scan;
	static String name;
	static int size,price;
	
	
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
	
	
	public static void add() throws ClassNotFoundException, SQLException
	{
		
	
	}
	
	public static void remove()throws ClassNotFoundException, SQLException
	{
		
	}
	
	public static void modify()throws ClassNotFoundException, SQLException
	{
		
		
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
