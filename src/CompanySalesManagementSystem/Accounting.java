package CompanySalesManagementSystem;

import java.sql.*;
import java.util.Scanner;



class demo4
{
	static Scanner scan;
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
				+ "\n 2.Exit");
		
		System.out.println("\n Choose from the above");
		
		choice =scan.nextInt();
		switch(choice)
		{
			case 1:
				view();
				break;	
		}
	}while(choice != 2);
	
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
