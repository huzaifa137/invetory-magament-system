package CompanySalesManagementSystem;


import java.sql.*;
import java.util.*;

class demo1
{

	static String url="jdbc:mysql://localhost/3306/inventory";
	static String user="root";
	static String pass="";
	static Connection con;
	static Statement st;
	
	public static void buy()
	{
		
		System.out.println("We buy goods Here");
		
		
	}
	
	
	public static void search()
	{
	
		System.out.println("We search goods Here");
	}
	
	
	public static void list() throws ClassNotFoundException, SQLException
	{
		
		Class.forName("com.mysql.cj.jdbc");
        con = DriverManager.getConnection(url, user, pass);
		Statement st =con.createStatement();
		
		
		
		
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
