package CompanySalesManagementSystem;

import java.util.*;
import java.io.*;

public class Login {

	static Scanner scan;
	static String username;
	static String password;
	static String confirmpassword;

	public static void main(String args[]) {

		try {
			
			scan= new Scanner(System.in);
			BufferedWriter bf = new BufferedWriter(new FileWriter("G:\\passwords\\password.txt",true));
			
			System.out.println("\nEnter your name :");
			username=scan.nextLine();
			
			System.out.println("Enter password");
			password=scan.nextLine();
			
			System.out.println("Confirm password");
			confirmpassword=scan.nextLine();
			
			if(password.equals(confirmpassword))
			{
				System.out.println("The admin has been added successfully");
			}
			else
			{
				System.out.println("Password incorrect, try agian");
			}
			
			
			bf.write(username);
			bf.newLine();
			bf.write(password);

			bf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
