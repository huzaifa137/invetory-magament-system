package CompanySalesManagementSystem;


import java.sql.*;
import java.util.*;


class demo3
{
	static String url="jdbc:mysql://localhost:3306/inventory";
	static String user="root";
	static String pass="";
	static String query="select * from companysales";
	static Scanner scan;
	static Statement st;
	static Connection con;
	
	
/*
 	*This dsiplays the view and all the products that are being stored
 */
	public static void view() throws ClassNotFoundException, SQLException
	{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(url, user, pass);
		Statement st =con.createStatement();
		ResultSet rs =st.executeQuery(query);
		
			System.out.println("\n\nid \t Name \t Items_bought \t Remainingquantity \t Date");
			System.out.println("------------------------------------------------------------------");
		while(rs.next())
		{
			
			System.out.println(rs.getInt("id") + "\t"+rs.getString("name") + "\t\t " + rs.getInt("items_bought") +  "\t \t"+  rs.getInt("remainigquantity") + "\t\t" + rs.getDate("Date"));
		}
	}
	
	/*
	 *This is modifying the name of the companysales in the table 
	 */
	public static void name() throws ClassNotFoundException, SQLException{

		
		scan = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(url, user, pass);
		st =con.createStatement();
		
		System.out.println("Enter id to modify");
		int size=scan.nextInt();
		
		System.out.println("Enter the new product name:");
		String name=scan.next();
		
		Statement st = con.createStatement();
		st.executeUpdate("update companysales set name='"+name+"' where id='"+size+"'");
		
		System.out.println("\nThe item has been modified successfully");
	}
	
	/*
	 *This is modifying the reamining quantities  of the companysales in the table 
	 */
	public static void quantitysales() throws ClassNotFoundException, SQLException {
		
		scan =new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(url, user, pass);
		st =con.createStatement();
		
		System.out.println("Enter id to modify");
		int size=scan.nextInt();
		
		System.out.println("Enter the new remainingquantity name:");
		int name=scan.nextInt();
		
		Statement st = con.createStatement();
		st.executeUpdate("update companysales set remainigquantity='"+name+"' where id='"+size+"'");
		
		System.out.println("\nThe sales have been modified successfully");
	}
	
	/*
	 *This actual logic for modifying all the above methods
	 *which are being implemented above.
	 */
	public void modifysales()throws ClassNotFoundException, SQLException
	{
		
		scan= new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(url, user, pass);
		
	    int id;
	
		do
		{
			System.out.println("\n\t \t CompanySales Menu \n"
					+ "\n1.View CompanySales "
					+ "\n2.Modify CompanySales"
					+ "\n3.Exit");
		
			System.out.println("\nChoose the choice you wish to modify");
			id=scan.nextInt();
			
			switch(id) {
			
			case 1:
				view();
				break;
			case 2:
				System.out.println("\n\t \t Modfiy Menu \n"
						+ "\n1.Modify name"
						+ "\n2.Modify remainingSales"
						+ "\n3.Exit");
				
				int id2=scan.nextInt();
				if(id2==1) {
					name();
				}
				else if(id2==2)
				{
					quantitysales();
				}
				else
				{
					System.out.println("The inserted value is incorrect !!!");
				}	
				break;
			}
		}while(id!=3);
	}
}

	public class Companysales extends demo3{

	/*
	*Running the main Companysales and all it's methods implemented in the above
	 */
	public static void main(String args[]) throws ClassNotFoundException, SQLException
	{
		Companysales cs = new Companysales();
		cs.modifysales();
	}
	
}
