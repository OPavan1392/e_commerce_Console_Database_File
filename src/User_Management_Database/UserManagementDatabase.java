package User_Management_Database;


import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Database.Dbunit;

public class UserManagementDatabase {
	public static void UserManagement() throws IOException, SQLException {

		boolean Shouldcontiuetill = true;
		User us = new User();
		System.out.println("Welcome to the UserManagement:");

		while (Shouldcontiuetill) {
			System.out.println("What would you like to do today");
			System.out.println("1. Add User");
			System.out.println("2. Updated user");
			System.out.println("3. Serach User");
			System.out.println("4. Delete User");
			System.out.println("5. Print User Details");
			System.out.println("9. Exit from Application");
			Scanner sc = new Scanner(System.in);
			int Decision = sc.nextInt();
			switch (Decision) {
			case 1:
				System.out.println("Please Enter the User information");
				System.out.println("Enter the ID of the User");
				us.ID = sc.nextInt();
				System.out.println("Enter the First name of the User");
				us.Fname = sc.next();
				System.out.println("Enter the Last name of the User");
				us.Lname = sc.next();
				System.out.println("Enter the Gernder of the User");
				us.gender = sc.next();
				System.out.println("Enter the Age of the User");
				us.age = sc.nextInt();
				System.out.println("Enter the Email of the User");
				us.email = sc.next();
				System.out.println("Enter the Passoword  of the User");
				us.password = sc.next();
				System.out.println("Enter the Confirm Passoword  of the User");
				us.ConfirmPass = sc.next();

				String query = "INSERT INTO user (User_ID, User_Fname, User_Lname, User_Gender, User_age,User_Email, User_pass, User_conpas) VALUES	('"
						+ us.ID + "','" + us.Fname + "', '" + us.Lname + "','" + us.gender + "','" + us.age + "','"
						+ us.email + "','" + us.password + "',	'" + us.ConfirmPass + "')";
				 Dbunit.ExecuteQuery(query);
				 sc.close();
				break;
			case 2:
				System.out.println("Update Product");
				System.out.println("Enter name of the product you want to Update");
				Scanner scup = new Scanner(System.in);
				
				String selectQuery = "Select count(*) from user where User_Fname ='"+scup+"'";
				ResultSet rs = Dbunit.ExecuteSelectQuery(selectQuery);
				rs.next();
				int countofpro=rs.getInt(0);
				
				if(countofpro==1) {
					System.out.println("Enter the ID of the User");
					us.ID = sc.nextInt();
					System.out.println("Enter the First name of the User");
					us.Fname = sc.next();
					System.out.println("Enter the Last name of the User");
					us.Lname = sc.next();
					System.out.println("Enter the Gernder of the User");
					us.gender = sc.next();
					System.out.println("Enter the Age of the User");
					us.age = sc.nextInt();
					System.out.println("Enter the Email of the User");
					us.email = sc.next();
					System.out.println("Enter the Passoword  of the User");
					us.password = sc.next();
					System.out.println("Enter the Confirm Passoword  of the User");
					us.ConfirmPass = sc.next();
					String query1 = "Update user set '" + us.ID + "','" + us.Fname + "', '" + us.Lname + "','" + us.gender
							+ "','" + us.age + "','" + us.email + "','" + us.password + "',	'" + us.ConfirmPass
							+ "' where User_ID=" + scup + "";
				
					Dbunit.ExecuteQuery(query1);
				} 


				

				break;
			case 3:

				System.out.println("To Serach User");
				System.out.println("Enter the ID Name of User You want Serach:");
				Scanner Search1 = new Scanner(System.in);
				String query3="Select * from user where User_ID='"+Search1+"'";
				ResultSet Selectproduct = Dbunit.ExecuteSelectQuery(query3);
				while(Selectproduct.next()) {
					System.out.println(Selectproduct.getString(1));
					System.out.println(Selectproduct.getString(2));
					System.out.println(Selectproduct.getString(3));
					System.out.println(Selectproduct.getString(4));

				}

				break;
			case 4:
				System.out.println("To Delete User:");
				System.out.println("Enter the User ID to Delete");
				Scanner ScDelete = new Scanner(System.in);
				String userD = ScDelete.next();
				String query4="delete from user where product_id=" + userD + " ";
				Dbunit.ExecuteQuery(query4);

				
				break;
			case 5:
				String query5 = "Select * from user ";
				ResultSet result5 = Dbunit.ExecuteSelectQuery(query5);
				while (result5.next()) {
					System.out.println(result5.getString(1) + "" + result5.getString(2) + "" + result5.getString(3) + ""
							+ result5.getString(4) + "" + result5.getString(5) + "" + result5.getString(6) + ""
							+ result5.getString(7) + "" + result5.getString(8));

				}
				break;
			case 9:
				Shouldcontiuetill = false;
				break;

			}

		}
	}

}
