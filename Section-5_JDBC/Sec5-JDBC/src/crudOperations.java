// 2. CRUD OPERATIONS


import java.sql.*;
import java.util.Scanner;


public class crudOperations {

	public static void main(String[] args) throws SQLException {
//		JDBC Connectivity Steps:
//			1. import package
//			2. load and register the driver (automatically done)
//			3. create the connection
//			4. create the query
//			5. execute the query
//			6. process the results
//			7. close the connection
		
		String url = "jdbc:postgresql://localhost:5432/DB1_student";
		String username = "postgres";
		String password = "Admin@1";
//		String insertQuery = "insert into table1_student values (5, 'John', 71)";
//		String updateQuery = "update table1_student set \"sName\"='Vansh P' where \"sId\"=3";
//		String deleteQuery = "delete from table1_student where \"sId\"=5";
		
		Scanner input = new Scanner(System.in);
		System.out.print("enter sID: ");
		int sId = input.nextInt();
		System.out.print("enter sName: ");
		String sName = input.next();
		System.out.print("enter marks: ");
		int marks = input.nextInt();
		input.close();
//		String insertQueryWithVariables = "insert into table1_student values ("+sId+", '"+sName+"', "+marks+")";	// tedious and confusing with "Statement"
		String insertQueryWithVariablesAndPS = "insert into table1_student values (?,?,?)";
		
		Connection con = DriverManager.getConnection(url, username, password);
		System.out.println("connection established");
//		Statement stat = con.createStatement();
		//stat.execute(insertQuery);
		//stat.execute(updateQuery);
		//stat.execute(deleteQuery);
//		stat.execute(insertQueryWithVariables);
		
		PreparedStatement ps = con.prepareStatement(insertQueryWithVariablesAndPS);		// PreparedStatement = Statement + additional features and methods
		ps.setInt(1, sId);				// setting the ? passed in query string
		ps.setString(2,  sName);		// passing columnNumber, variableName(to replace ? with variableName value)
		ps.setInt(3,  marks);
		ps.execute();
		
		con.close();
		System.out.println("connection closed");
	}
}
