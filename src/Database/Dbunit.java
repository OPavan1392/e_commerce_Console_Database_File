package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dbunit {
	private static Connection connect;
	private static Statement statement;
	
	static {
		try {
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","Test123");
			statement = connect.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static ResultSet ExecuteSelectQuery(String query) throws SQLException {
		ResultSet result = statement.executeQuery(query);
		return result;
		
	}
	public static void ExecuteQuery(String query) throws SQLException {
		
		statement.execute(query);
	}

}
