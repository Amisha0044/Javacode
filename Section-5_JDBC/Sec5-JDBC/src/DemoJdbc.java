/*

// 1. FETCHING ALL RECORDS

import java.sql.*; 	// 1) import package


public class DemoJdbc {

	public static void main(String[] args) {
		
//		  1) import package 2) load and register the driver 3) create connection 4)
//		  create statement 5) execute statement 6) process the results 7) close the
//		  connection
		 

		String url = "jdbc:postgresql://localhost:5432/DB1_student"; 	// url includes 3 things as part of java app
																		// connecting to DB- 1) jdbc, 2) postgresql (DB
																		// type), 3) DB name but as this DB is networked DB
																		// and accessed through network hence need to
																		// mention ip (localhost if on the same machine i.e.
																		// on local, if other machine, mention IP) and port
		String userName = "postgres"; 	// username for DBMS (can be changed if needed), keeps changing from DB to DB
		String password = "Admin@1"; 	// password for DBMS
//		String sql = "select \"sName\" from \"table1_student\" where \"sId\"=1;"; 	// -- PostgreSQL treats unquoted
																					// identifiers as lower case. If your
																					// table or column names are
																					// case-sensitive, use double
																					// quotes:
		String sql = "select * from table1_student";
		String name = "";

		try {
			//Class.forName("org.postgresql.Driver"); 		// 2) load & register the driver - Driver is a class available in
															// org.postgresql package which is already added as part of JAR file
			Connection con = DriverManager.getConnection(url, userName, password);  // 3) create connection object -
																					// getConnection(url, user, password) is
																					// a method available in DriverManager
																					// class included in java.sql package
																					// which return an object of type
																					// Connection
			System.out.println("connection established");
			
			Statement statement = con.createStatement(); 	// 4) create statement -- createStatement is a method with
															// return type Connection declared in an interface named
															// Connection
			ResultSet rs = statement.executeQuery(sql); 	// 5) execute (sql) statement -- executeQuery method
																	// is used to fetch data from DB with return type as
																	// ResultSet and is declared in an interface named
																	// Statement
//			System.out.println(rs.next());					// true
			
//			rs.next();
// //		name = rs.getString(1);							// Amisha
//			name = rs.getString("sName");					// Amisha
//			System.out.println("Student name with sId=1 is: " + name);
			
			while (rs.next()) { 	// re.next does 2 things - check if next row is available (returns true) and also
									// moves the pointer to that next row
				System.out.println(rs.getInt(1) + " - " + rs.getString(2) + " - " + rs.getInt(3));
			}
			
			con.close();
			System.out.println("connection closed");
			
		} 
//		catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} 
		catch (SQLException e) {
			e.printStackTrace();
		}

	
	}
}
*/