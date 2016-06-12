package test;

import java.sql.*;

public class testJDBC {
	public static void main(String args[]){
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try{
			Class.forName("com.ibm.db2.jcc.DB2Driver").newInstance();
			conn=DriverManager.getConnection("jdbc:db2://localhost:50000/bps", "bps", "password");
			stmt=conn.createStatement();
			rs=stmt.executeQuery("Select * from user");
			while(rs.next()){
				System.out.print(rs.getString(2));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
