import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JdbcExample {

	public static void main(String[] args) {
		Connection conn=null;
		//connecting to database
		// TODO Auto-generated method stub
		String dbURL = "jdbc:mysql://localhost:3306/sampledb";
		String username = "root";
		String password = "secret";
		 
		try {
		 
		    conn = DriverManager.getConnection(dbURL, username, password);
		 
		    if (conn != null) {
		        System.out.println("Connected");
		    }
		} catch (SQLException ex) {
		    ex.printStackTrace();
		}
		//insert query
		String q1 = "INSERT INTO Users (username, password, fullname, email) VALUES (?, ?, ?, ?)";
		 
		PreparedStatement statement = conn.prepareStatement(q1);
		statement.setString(1, "bill");
		statement.setString(2, "secretpass");
		statement.setString(3, "Bill Gates");
		statement.setString(4, "bill.gates@microsoft.com");
		 
		int rowsInserted = statement.executeUpdate();
		if (rowsInserted > 0) {
		    System.out.println("A new user was inserted successfully!");
		}
		//select query
		String q2 = "SELECT * FROM Users";
		 
		Statement statement1 = conn.createStatement();
		ResultSet result = ((java.sql.Statement) statement1).executeQuery(q2);
		 
		int count = 0;
		 
		while (result.next()){
		    String name = result.getString(2);
		    String pass = result.getString(3);
		    String fullname = result.getString("fullname");
		    String email = result.getString("email");
		 
		    String output = "User #%d: %s - %s - %s - %s";
		    System.out.println(String.format(output, ++count, name, pass, fullname, email));
		}
		//update query
		String q3 = "UPDATE Users SET password=?, fullname=?, email=? WHERE username=?";
		 
		PreparedStatement statement2 = conn.prepareStatement(q3);
		statement2.setString(1, "123456789");
		statement2.setString(2, "William Henry Bill Gates");
		statement2.setString(3, "bill.gates@microsoft.com");
		statement2.setString(4, "bill");
		 
		int rowsUpdated = statement2.executeUpdate();
		if (rowsUpdated > 0) {
		    System.out.println("An existing user was updated successfully!");
		}
		//delete query
		String sql = "DELETE FROM Users WHERE username=?";
		 
		PreparedStatement statement3 = conn.prepareStatement(sql);
		statement3.setString(1, "bill");
		 
		int rowsDeleted = statement3.executeUpdate();
		if (rowsDeleted > 0) {
		    System.out.println("A user was deleted successfully!");
		}
	}

}
