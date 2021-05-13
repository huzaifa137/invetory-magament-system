package CompanySalesManagementSystem;

import java.sql.*;
import java.util.Scanner;



class demo4
{
	static String url="jdbc:mysql://localhost:3306/inventory";
	static String user="root";
	static String pass="";
	static Scanner scan;
	static ResultSet rs;
	static Statement st;
	static Connection con;
	
	/*
	* This is used to display the view of the whole data in the company
	*/
	public static void view() throws SQLException, ClassNotFoundException
	{
	 Connection con;
	 Statement st;
	 String url="jdbc:mysql://localhost:3306/inventory";
	 String user="root";
	 String pass="";
	 String query="select * from accounting";
	 
	 
	Class.forName("com.mysql.cj.jdbc.Driver");
    con = DriverManager.getConnection(url, user, pass);
	st =con.createStatement();
	ResultSet rs =st.executeQuery(query);
	
	System.out.println("\nid \t Goods catagory \t Total of goods \t price range \t TotalCommission  \t Totalprofits \t TotalAmount \tWaiting commodities ");
	System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
	
		while(rs.next())
		{
		
			System.out.println(rs.getInt("id") + "\t \t"+  rs.getString("Goods catagory")+"\t \t " + "\t"+  rs.getInt("Total of goods") +"\t \t " + rs.getInt("price range")+ "\t \t"+ "\t "+rs.getInt("TotalCommission") + "\t \t  " + rs.getInt("Totalprofits") + " \t  \t " +rs.getInt("TotalAmount") + "\t \t "+rs.getString("Waiting commodities"));
		}
	}
	
	
	public static void suggest() throws SQLException
	{
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con =DriverManager.getConnection(url, user, pass);
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
	
	/*
	* It does display the whole logic which 
	* of how this module works
	*/	
	public void work() throws ClassNotFoundException, SQLException
		{
		int choice;
		scan = new Scanner(System.in);
		do
		{
		System.out.println("\n \t \t Accounting Menu \n "
				+ "\n 1.View All Accounting Details"
				+ "\n 2.View suggested goods"
				+ "\n 3.Exit");
		
		System.out.println("\n Choose from the above");
		
		choice =scan.nextInt();
		switch(choice)
		{
			case 1:
				view();
				break;
			case 2:
				suggest();
				break;
		}
	}while(choice != 3);
	
	}

}

		/*
		*This is actual part the runs the whole module
		*/		
	public class Accounting extends demo4{
	
	public static void main (String args[]) throws ClassNotFoundException, SQLException
		{
			Accounting acc = new Accounting();
			acc.work();	
		}
}
