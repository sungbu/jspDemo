package net.hnjdzy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BaseDao {
	
	String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String url = "jdbc:sqlserver://localhost:1433;DatabaseName=ConstructionDB";
	String username = "sa";
	String password = "123456";
	
	public  Connection getConnection() {
		Connection conn = null;
		try {
		   Class.forName(driverName);
		   conn = DriverManager.getConnection(url,username,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public void closeAll(ResultSet rs,PreparedStatement pstmt,Connection conn) {
	try {
		if(rs!=null) rs.close();
		if(pstmt!=null)  pstmt.close();
		if(conn!=null)  conn.close();
	} catch (Exception e1) {
		e1.printStackTrace();
	}
	}
	

}
