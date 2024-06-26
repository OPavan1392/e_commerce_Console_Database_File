package Ecommerce;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import Product_Management_database.ProductManagementDatabase;

import User_Management_Database.UserManagementDatabase;

public class MainEcommerce {
	public static void main(String[] args) throws IOException, SQLException {

		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to the ecommerce Management:");
		boolean Shouldcon = true;
		while (Shouldcon) {

			System.out.println("What do you want to do :");
			System.out.println("1.Product Management");
			System.out.println("2.User Management");
			System.out.println("9.Exit");
			int decision = sc.nextInt();
			switch (decision) {
			case 1:
				ProductManagementDatabase.ProductManagent();
				break;
			case 2:
				UserManagementDatabase.UserManagement();
				break;
			case 9:
				System.out.println("Exiting form main application");
				Shouldcon = false;
				break;

			}
		}
sc.close();
	}

}
