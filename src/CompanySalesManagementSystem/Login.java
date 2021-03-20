package CompanySalesManagementSystem;

import java.util.*;
import java.io.*;
import java.sql.SQLException;

public class Login {

	static Scanner scan;
	static String username;
	static String password;
	static String confirmpassword;
	static int option,flag=0;
	
	public static void swap() throws ClassNotFoundException, SQLException
	{
		suppliers sp = new suppliers();		
		Customer cs = new Customer();
		scan = new Scanner(System.in);
		
		
		do{
				System.out.println("\n \t \t \t MENU \n "
						+ "\n 1.General Information"
						+ "\n 2.Customer Details"
						+ "\n 3.Supplier Details"
						+ "\n 4.Products Details"
						+ "\n 5.company Sales"
						+ "\n 6.Accounting Details");
				
				System.out.println("\n Select catagory");
				option =scan.nextInt();
				
				switch(option)
				{
				case 3:
					sp.collect();
					break;
				case 2:
					cs.cust();
					break;
				
				}
		}while(option!=-12);
		
	}
	
	public static void Admin() {
		
		try {
			
		BufferedReader bf = new BufferedReader( new FileReader("G:\\passwords\\Adminusername.txt"));
		BufferedReader bf2 = new BufferedReader( new FileReader("G:\\passwords\\Adminpasswword.txt"));
		
		System.out.println("\nEnter the Admin Username ");
		username=scan.next();
		
		System.out.println("Enter the Admin password");
		password=scan.next();
		
		String x=null;
		String y=null;
		
		
			while((x=bf.readLine())!=null && (y=bf2.readLine())!=null)
			{
				if(username.equals(x) && password.equals(y))
				{
					
						System.out.println("\n \t \tAdmin Login Successfully \n ");
						flag=1;
						
						if(flag==1) {
							swap();
						}
						break;
				}
				else
				{
					System.out.println("\nIncorrect password or Username ");
					break;
				}	
			}
			bf.close();
			bf2.close();
			
		}
		
		catch(Exception e)
		{
			System.out.println("\nPLease make a correct Suggestion");;
		}
		
	}
	
	public static void supplier()
	{
		try {
			BufferedReader bf = new BufferedReader( new FileReader("G:\\passwords\\supplierusername.txt"));
			BufferedReader bf2 = new BufferedReader( new FileReader("G:\\passwords\\supplierpassword.txt"));
			
			System.out.println("\nEnter the Supplier Username ");
			username=scan.next();
			
			System.out.println("Enter the Supplier password");
			password=scan.next();
			
			String x=null;
			String y=null;
			
			
				while((x=bf.readLine())!=null && (y=bf2.readLine())!=null)
				{
					if(username.equals(x) && password.equals(y))
					{
						
							System.out.println("\nSupplier Login Successfully");
							break;
					}
					else
					{
						System.out.println("\nIncorrect password or Username ");
						break;
					}	
				}
				bf.close();
				bf2.close();
			}
			
			catch(Exception e)
			{
				System.out.println("\nPLease make a correct Suggestion");;
			}
			
		}
	
	public static void customer()
	{
		try {
			BufferedReader bf = new BufferedReader( new FileReader("G:\\passwords\\customerusername.txt"));
			BufferedReader bf2 = new BufferedReader( new FileReader("G:\\passwords\\customerpassword.txt"));
			
			System.out.println("\nEnter the Customer Username ");
			username=scan.next();
			
			System.out.println("Enter the Customer password");
			password=scan.next();
			
			String x=null;
			String y=null;
			
			
				while((x=bf.readLine())!=null && (y=bf2.readLine())!=null)
				{
					if(username.equals(x) && password.equals(y))
					{
						
							System.out.println("\n \t \t \t Customer Login Successfully");
							break;
					}
					else
					{
						System.out.println("\n \t \t \t Incorrect password or Username ");
						break;
					}	
				}
				bf.close();
				bf2.close();
			}
			
			catch(Exception e)
			{
				System.out.println("\nPLease make a correct Suggestion");
		
			}
	
	}
	
	public static void addnewcustomer()
	{
	
		try {
			
			System.out.println("\nEnter customer name :");
			
			username=scan.next();
			
			System.out.println("Enter customer password");
			password=scan.next();
			
			System.out.println("confirm password");
			confirmpassword=scan.next();
			
			
			BufferedWriter bw = new BufferedWriter( new FileWriter("G:\\passwords\\customerusername.txt",true));
			BufferedWriter bw2 = new BufferedWriter( new FileWriter("G:\\passwords\\customerpassword.txt",true));
			
			if(password.equals(confirmpassword))
			{
				bw.newLine();
				bw.write(username);
				bw2.newLine();
				bw2.write(password);
				
				System.out.println("\n Customer Registered Successfully");
			}
			else
			{
				System.out.println("Password dont match !!!");
			}
			
			bw.close();
			bw2.close();
			
		} catch (IOException e) {
			System.out.println("Incorrect username or password");
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
						+ "\n 4.New Customer");
				
				
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
					addnewcustomer();
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