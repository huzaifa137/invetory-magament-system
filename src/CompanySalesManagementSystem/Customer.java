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
	static Statement st,st1,st2,st3,st4,st5;
	static Scanner scan;
	static String name;
	static ResultSet rs;
	static int size,price;
	
	public static  void combine() throws ClassNotFoundException, SQLException
	{
		scan = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url, user, pass);
	}
	
	/*
	* This is the module that does control the purchasing of goods 
	* from the products table and making all the updates that are needed.
	*/
	public static void buy() throws SQLException, ClassNotFoundException
	{

		combine();
		System.out.println("\nEnter item name to buy");
		name=scan.next();
		
		Statement st5 = con.createStatement();
		ResultSet rs11 =st5.executeQuery("Select Pstock from products where Pname='"+name+"'");
		rs11.next();
		
		int dons1 = rs11.getInt("Pstock");
		
		if(dons1 == 0)
		{
			System.out.println("The item is out of stock ");
		}
		else
		{
		System.out.println("\nEnter the quantity of the product");
		size=scan.nextInt();
		
		PreparedStatement st = con.prepareStatement("Update products set Pprice=(Pprice*?) where Pname='"+name+"'");
		st.setInt(1, size);
		st.executeUpdate();
		
		ResultSet rs =st.executeQuery("Select Pprice from products where Pname='"+name+"'");
		rs.next();
		
		int dons = rs.getInt("Pprice");
		
		
		System.out.println( dons +"rs"+"\t is total amount needed to purchase selected goods\n"
				+ "\nDo you wish to continue and purchace the products?"
				+ "\nPress y to purchase or n to cancel order ");
		
		
		char x =scan.next().charAt(0);
	
		if(x == 'y' || x== 'Y')
		{
			long millis=System.currentTimeMillis();  
	        java.sql.Date date=new java.sql.Date(millis);  
	        
			System.out.println("Purchase Succesfully done");
			PreparedStatement st1 = con.prepareStatement("Update products set Pprice=((Pprice/?)) where Pname='"+name+"'");
			st1.setInt(1, size);
			st1.executeUpdate();
			
			PreparedStatement st2 = con.prepareStatement("Update products set Pstock=(Pstock-?) where Pname='"+name+"'");
			st2.setInt(1, size);
			st2.executeUpdate();
			
			PreparedStatement st4 = con.prepareStatement("Update suppliers set Amount_of_products=(Amount_of_products-?) where Pname='"+name+"'");
			st4.setInt(1, size);
			st4.executeUpdate();
			
			
			Statement st3 = con.createStatement();
			ResultSet rs1 =st.executeQuery("Select Pstock from products where Pname='"+name+"'");
			rs1.next();
			int stck = rs1.getInt("Pstock");
			
			st3.executeUpdate("insert into companysales (name,items_bought,remainigquantity,Date) values ('"+name+"','"+size+"','"+stck+"','"+date+"')");
			System.out.println("\nThe product has been bought successfully");
		}
		else if(x == 'n' || x== 'N')
		{
			System.out.println("The purchase is cancelled");
			PreparedStatement st1 = con.prepareStatement("Update products set Pprice=((Pprice/?)) where Pname='"+name+"'");
			st1.setInt(1, size);
			st1.executeUpdate();
			
		}
		
		else
		{
			System.out.println("Wrong seleection");
			System.out.println("The purchase is cancelled");
			PreparedStatement st1 = con.prepareStatement("Update products set Pprice=((Pprice/?)) where Pname='"+name+"'");
			st1.setInt(1, size);
			st1.executeUpdate();
			
		}
	
		}
	}
	
	/*
	 * Here we do searh for a specified item in the table
	 */
	public static void search() throws SQLException, ClassNotFoundException
	{

		{
			
			combine();
			System.out.println("Enter the name of the item you need ");
			String name=scan.nextLine();
			
			st=con.createStatement();
			rs = st.executeQuery("select * from products where Pname='"+name+"'");
			rs.next();
			
			if(rs.getRow()>0)
			{
				System.out.println("\nName   \t category  \t Pprice \tRemainingStock");
				System.out.println("------------------------------------------------------------");
				System.out.println(rs.getString(2) + "  \t  " + rs.getString(4) +"   \t "+ rs.getInt(3) +"\t \t"+ rs.getInt(5));	
			}
			else
			{	
				System.out.println("\nItem is not found in the Stock");
			}
			
		}	
		
	}
	
	/*
	* This does shows the list of all the products
	 */
	public static void list() throws ClassNotFoundException, SQLException
	{
		
		combine();
	    st =con.createStatement();
		ResultSet rs =st.executeQuery(query);
		
		System.out.println("\nid \t Name \t \t Pprice \t Catagory \t Pstock  \t PDate");
		System.out.println("------------------------------------------------------------------------------------------");
		while(rs.next())
		{
			System.out.println(rs.getInt("id") + "\t"+rs.getString("Pname") + "\t\t " +    rs.getInt("Pprice") +" \t  \t " + rs.getString("Catagory") + "\t \t "+rs.getInt("Pstock") + "\t \t " +rs.getDate("Date"));
		}
		
	}
	
	/*
	* Here , a user can suggest a specified product that
	 * will / may be added in the our products table which
	 * will be sold 
	 */
	public static void suggest() throws ClassNotFoundException, SQLException
	{
	
		combine();
		
		System.out.println("\nSuggest an item to added in our stock");
		name=scan.nextLine();
		
		Statement st = con.createStatement();
		st.executeUpdate("insert into suggest (Product_name) values ('"+name+"')");
		
		System.out.println("\nItem has been addeded to the sugggested item list");
	}

}

	public class Customer extends demo1 {
	
	/*
	*The main class that will execute and run all the 
	 *module and program once it's executed. 
	 */
	public void cust() throws SQLException, ClassNotFoundException
	{
		
		int choice;
		 
		 scan=new Scanner(System.in);
		
			do {
					System.out.println("\n \n  \t \t Customer Menu \n "
							+ "\n1.List Items"
							+ "\n2.Search Items"
							+ "\n3.Buy item"
							+ "\n4.Suggest item"
							+ "\n5.Exit");
				
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
			
			}while(choice !=5);
		
	}
   
	public static void main(String args[]) throws ClassNotFoundException, SQLException	
{
	
	Customer cs = new Customer();
	cs.cust();
	
}
	
}