package CompanySalesManagementSystem;

import java.util.*;
import java.sql.*;


public class Login {

	static Scanner scan;
	static String id;
	static String password,type,name;
	static String confirmpassword;
	static String url="jdbc:mysql://localhost:3306/inventory";
	static String user="root";
	static String pass="";
	static ResultSet rs;
	static Connection con;
	static Statement st;
	static int option,flag=0;
	
	public static void swap() throws ClassNotFoundException, SQLException
	{
		suppliers sp = new suppliers();		
		Customer cst = new Customer();
		product pr = new product();
		
		
		
		do{
			
				scan = new Scanner(System.in);
				System.out.println("\n \t \t \t MENU \n "
						+ "\n 1.Customer Details"
						+ "\n 2.Supplier Details"
						+ "\n 3.Products Details"
						+ "\n 4.company Sales"
						+ "\n 5.Accounting Details"
						+ "\n 6.Manage system Users"
						+ "\n 7.Exit");
				
				System.out.println("\n Select catagory");
				option =scan.nextInt();
				
				switch(option)
				{
				
				case 1:
					cst.cust();
					break;
					
				case 2:
					sp.collect();
					break;
					
				case 3:
					pr.pro();
					break;
				case 6:
					managesystemusers();
					break;
				
				}
		}while(option!=7);
		System.out.println("\t \t \t *** Thank you *** ");
	}
	
	public static void Admin() throws ClassNotFoundException, SQLException {
		
		scan = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url, user, pass);
		

		System.out.println("\nEnter Admin username:");
		id=scan.nextLine();
		
		System.out.println("Enter Admin password");
		password=scan.nextLine();
		
		
		st=con.createStatement();
		rs = st.executeQuery("select * from login where username='"+id+"' and password='"+password+"'");
		rs.next();
		if(rs.getRow()>0)
		{
			System.out.println("\n \t \tAdmin Login Successfull");
				swap();
		}
		else
		{
			
			System.out.println("Incorrect username or password");
		}
		
		con.close();
	}
	
	public static void supplier() throws ClassNotFoundException, SQLException
	{
		
		scan = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url, user, pass);
		

		System.out.println("\nEnter Supplier username:");
		id=scan.nextLine();
		
		System.out.println("Enter Supplier password");
		password=scan.nextLine();
		
		
		st=con.createStatement();
		rs = st.executeQuery("select * from login where username='"+id+"' and password='"+password+"'");
		rs.next();
		if(rs.getRow()>0)
		{
			System.out.println("\n \t \tSupplier Login Successfull");
			suppliers sp = new suppliers();		
				sp.collect();
		}
		else
		{
			
			System.out.println("Incorrect username or password");
		}
		
		con.close();
	}
	
	public static void customer() throws SQLException, ClassNotFoundException

	{
		scan = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url, user, pass);
		

		System.out.println("\nEnter Customer username:");
		id=scan.nextLine();
		
		System.out.println("Enter Customer password");
		password=scan.nextLine();
		
		
		st=con.createStatement();
		rs = st.executeQuery("select * from login where username='"+id+"' and password='"+password+"'");
		rs.next();
		if(rs.getRow()>0)
		{
			System.out.println("\n \tCustomer Login Successfull");
			Customer cs = new Customer();
			cs.cust();
		}
		else
		{
			
			System.out.println("Incorrect username or password");
		}
		
		con.close();
	}
	
	private static void custreg() throws SQLException, ClassNotFoundException {
		
		scan = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url, user, pass);
		
		System.out.println("Enter login criteria");
		type=scan.next();
		
		System.out.println("Enter customer name :");
		id=scan.next();
		
		System.out.println("Enter customer password");
		password=scan.next();
		
		System.out.println("confirm password");
		confirmpassword=scan.next();
		
		if(password.equals(confirmpassword)) {
			
			Statement st = con.createStatement();
			st.executeUpdate("insert into login(username,password,type) values ('"+id+"', '"+password+"','"+type+"')");
			System.out.println("\nNew customer Registered Succcesfully");
			
		}
		else
		{
			System.out.println("Password mismatch !!!");
		}
		
	}
	
	private static void Admireg() throws ClassNotFoundException, SQLException {
		scan = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url, user, pass);
		
		System.out.println("Enter login criteria");
		type=scan.next();
		
		System.out.println("Enter Admin name :");
		id=scan.next();
		
		System.out.println("Enter Admin password");
		password=scan.next();
		
		System.out.println("confirm password");
		confirmpassword=scan.next();
		
		if(password.equals(confirmpassword)) {
			
			Statement st = con.createStatement();
			st.executeUpdate("insert into login(username,password,type) values ('"+id+"', '"+password+"','"+type+"')");
			System.out.println("\nNew Admin Registered Succcesfully");
			
		}
		else
		{
			System.out.println("Password mismatch !!!");
		}
		
	}

	private static void suppreg() throws SQLException, ClassNotFoundException {
		
		scan = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url, user, pass);
		
		System.out.println("Enter your catagory");
		type=scan.next();
		
		System.out.println("Enter Supplier name :");
		id=scan.next();
		
		System.out.println("Enter Supplier password");
		password=scan.next();
		
		System.out.println("confirm password");
		confirmpassword=scan.next();
		
		if(password.equals(confirmpassword)) {
			
			Statement st = con.createStatement();
			st.executeUpdate("insert into login(username,password,type) values ('"+id+"', '"+password+"','"+type+"')");
			System.out.println("\nNew Supplier Registered Succcesfully");
			
		}
		else
		{
			System.out.println("Password mismatch !!!");
		}
		
	}
	
	public static void managesystemusers() throws ClassNotFoundException, SQLException
	{
	
			scan = new Scanner(System.in);
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pass);
		
			
			System.out.println("\n 1.Add System user"
					+ "\n 2.Delete System User"
					+ "\n 3.Modify System user");
			
			int num=scan.nextInt();
			if(num==1)
			{
			do{
				
				scan = new Scanner(System.in);
				System.out.println("\n \t \t \t MENU \n "
						+ "\n 1.Add Admin"
						+ "\n 2.Add Supplier"
						+ "\n 3.Add Customer");
				
				System.out.println("\n Select catagory");
				option =scan.nextInt();
				
				switch(option)
				{
					
				case 1:
					Admireg();
					break;
					
				case 2:
					suppreg();
					break;
					
				case 3:
					custreg();
					break;
					
				}
		}while(option!=-12);
	}

			else if(num==2)
			{
			
				System.out.println("\n \t \t \t MENU \n "
						+ "\n 1.Delete Admin"
						+ "\n 2.Delete Supplier"
						+ "\n 3.Delete Customer");
				
				int m=scan.nextInt();
				
				if(m==1)
				{
					System.out.println("Enter username of Admin to delete");
					name=scan.next();
					
					Statement st = con.createStatement();
					st.executeUpdate("Delete from login where username='"+name+"'");
					System.out.println("\n Admin has been removed successfully");
				}
				else if(m==2)
				{
				
					System.out.println("Enter username of Supplier to delete");
					name=scan.next();
					
					Statement st = con.createStatement();
					st.executeUpdate("Delete from login where username='"+name+"'");
					System.out.println("\n Supplier has been removed successfully");
				}
				else if(m==3){
					

					System.out.println("Enter username of Customer to delete");
					name=scan.next();
					
					Statement st = con.createStatement();
					st.executeUpdate("Delete from login where username='"+name+"'");
					System.out.println("\n Customer has been removed successfully");
				}
				else
				{
					System.out.println("Incorrect option being selected");
				}
			}
			
			else if(num==3)
			{

				System.out.println("\n \t \t \t MENU \n "
						+ "\n 1.Modify Admin"
						+ "\n 2.Modify Supplier"
						+ "\n 3.Modify Customer");
				
				int n=scan.nextInt();
				
				if(n==1)
				{
					System.out.println("\n\t \t Modify Username and password of any Admin\n");
					
					System.out.println("Enter name of Admin to modify");
					name=scan.next();
					
					
					System.out.println("Enter new username");
					String name1=scan.next();
					
					System.out.println("Enter new password");
					String name2=scan.next();
					
					Statement st = con.createStatement();
					st.executeUpdate("Update login set username='"+name1+"', password ='"+name2+"' where username='"+name+"'");
					System.out.println("\nAdmin has been modified successfully");
					
				}
				
				else if(n==2)
				{
					
					System.out.println("\n\t \t Modify Username and password of any Supplier\n");

						System.out.println("Enter name of Supplier to modify");
						name=scan.next();
						
						
						System.out.println("Enter new username");
						String name1=scan.next();
						
						System.out.println("Enter new password");
						String name2=scan.next();
						
						Statement st = con.createStatement();
						st.executeUpdate("Update login set username='"+name1+"', password ='"+name2+"' where username='"+name+"'");
						System.out.println("\n Supplier has been modified successfully");
				}
				
				
				else if(n==3)
				{
					
					
					System.out.println("\n\t \t Modify Username and password of any Customer\n");
					
					System.out.println("Enter name of Customer to modify");
					name=scan.next();
					
					System.out.println("Enter new username");
					String name1=scan.next();
					
					System.out.println("Enter new password");
					String name2=scan.next();
					
					Statement st = con.createStatement();
					st.executeUpdate("Update login set username='"+name1+"', password ='"+name2+"' where username='"+name+"'");
					System.out.println("\n customer has been modified successfully");
				}
			}
			else
			{
				System.out.println("Incorrect option Selected !!!");
			}
	}
	
	
	public void login()
	{
		
		try
		{
			scan= new Scanner(System.in);
			
			do
			{
				
				System.out.println("\n \t \t \t Login As  ");
				System.out.println("\n 1.Admin"
						+ "\n 2.Supplier"
						+ "\n 3.Customer"
						+ "\n 4.Register as a new Customer");
				
				System.out.println("\n Choose you're criteria \n");
				option =scan.nextInt();
				
				
				switch(option)
				{
				case 1:
						Admin();
					break;
					
				case 2:
					supplier();
					break;
					
				case 3:
					customer();
					break;
					
				case 4:
					custreg();
					break;
				}
				
			}while(option!=-137);
			System.out.println(" Please make a selection from the above !!!");
		}

		catch(Exception e)
		{
			System.out.println("\n \t \t \t Please make a correct Selection of the Above");
		}
		
	}
	
	public static void main(String args[]){
		
		Login nm = new Login();
		nm.login();
		
	}
	
}