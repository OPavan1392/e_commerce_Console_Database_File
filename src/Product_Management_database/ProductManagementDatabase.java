package Product_Management_database;


import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Database.Dbunit;


public class ProductManagementDatabase {
	public static void ProductManagent() throws IOException, SQLException {
		System.out.println("**Welcome to the Product Management**");
		boolean Exit = true;
		Scanner sc = new Scanner(System.in);

		Product product = new Product();
		while (Exit) {
			System.out.println("What would you like to do today");
			System.out.println("1: Add Product");
			System.out.println("2: Update Product");
			System.out.println("3: Serach Product");
			System.out.println("4: Deleted Product");
			System.out.println("5: Print Product");
			System.out.println("9: Exit Application");

			int Decision = sc.nextInt();

			switch (Decision) {
			case 1:
				System.out.println("Enter the Id of the product");
				product.ID = sc.nextInt();
				System.out.println("Enter the name of the product");
				product.name = sc.next();
				System.out.println("Enter the Quantity of the product");
				product.Quantity = sc.nextInt();
				System.out.println("Enter the Price of the product");
				product.Price = sc.nextInt();
				String query="INSERT INTO product (product_id,product_name, quantity, price) VALUES	("+product.ID+",'"+	product.name+"','"+product.Quantity+"',"+product.Price+" 	)";
				 Dbunit.ExecuteQuery(query);

				break;
				
			case 2:
				Scanner produ = new Scanner(System.in);
				System.out.println("Enter the name of the product you wnat to updat");
				String produtoup = produ.next();
				String selectQuery = "Select count(*) from product where  product_id='"+produtoup+"'";
				ResultSet rs = Dbunit.ExecuteSelectQuery(selectQuery);
				rs.next();
				int countofproduct=rs.getInt(0);
				if(countofproduct==1) {
					System.out.println("Enter the Id of the product");
					product.ID = sc.nextInt();
					System.out.println("Enter the name of the product");
					product.name = sc.next();
					System.out.println("Enter the Quantity of the product");
					product.Quantity = sc.nextInt();
					System.out.println("Enter the Price of the product");
					product.Price = sc.nextInt();
					String updatedproduct = "Update product set product_id =' "+product.ID+"'product_name '"+product.name+"'quantity'"+product.Quantity+"'price'"+product.Price+"' where product_id="+produtoup+"";
					Dbunit.ExecuteQuery(updatedproduct);
				}
							break;
			case 3:
				System.out.println("Enter the product Name you want to serach");
				String prod = sc.next();
				String query3="Select * from product where product_name="+prod+"";
				ResultSet Selectproduct = Dbunit.ExecuteSelectQuery(query3);
				while(Selectproduct.next()) {
					System.out.println(Selectproduct.getString(1));
					System.out.println(Selectproduct.getString(2));
					System.out.println(Selectproduct.getString(3));
					System.out.println(Selectproduct.getString(4));

				}

				break;
			case 4:
				System.out.println("To Delete Product:");
				System.out.println("Enter the CustomerID to Delete");
				Scanner prodelet = new Scanner(System.in);
				String CustID = prodelet.next();

				String query4="delete from product where product_id="+CustID+" ";
		Dbunit.ExecuteQuery(query4);

				break;
			case 5:
				
				String query5="Select * from product ";
				ResultSet resultall = Dbunit.ExecuteSelectQuery(query5)			;
				while(resultall.next()) {
					System.out.println(resultall.getString(1)+""+resultall.getString(2)+""+resultall.getString(3)+""+resultall.getString(4)+"");
					

				}


				break;
			case 9:
				System.out.println("You are seleted exit option");
				Exit = false;

				break;

			}
		}
		sc.close();
	}

	
	
	

}
