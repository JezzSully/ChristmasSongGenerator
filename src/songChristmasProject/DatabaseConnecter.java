package songChristmasProject;

import java.sql.*;

public class DatabaseConnecter
{
	public void Create(String DB_URL,String USER,String PASS, Connection conn, Statement stmt) {
	try {
	     conn = DriverManager.getConnection(DB_URL, USER, PASS);
	     
	     //Create
	     //System.out.println("Inserting Cyberpunk into the table...");
	     stmt = conn.createStatement();
	     String sql = "INSERT INTO generated_song " + "VALUES ("+SONGFILENAME+", "+ConcatinateNouns+", "
	     		+ ""+ConcatinateVerbs+", "+ConcatinateAdjectives+")";
	     String sql = "INSERT INTO generated_song " + "VALUES ("+Rating+", "+Comment+")";
	     stmt.executeUpdate(sql);
	     //System.out.println("Insert complete!");
	 }
	     
	   catch(SQLException SQLException){
	    System.out.println("Not Christmasy enough!");
	       System.out.println("SQLException: " + SQLException.getMessage());
	       System.out.println("SQLState: " + SQLException.getSQLState());
	   }
	}

}
