package net.hnjdzy.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import net.hnjdzy.entity.User;

public class UserDao extends BaseDao {
	
	public boolean getUserInfo(User user) {
		Connection conn = getConnection();
		String sql = "select * from userinfo where username='"+user.getUsername()+"' and password='"+user.getPassword()+"'";
		Statement st = null;
		ResultSet rs = null;
		boolean flag = false;
		try {
			st = conn.createStatement();			
			rs = st.executeQuery(sql);
			if(rs.next()) {
				flag = true;
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}finally {	
			try {
				if(rs!=null)  rs.close();
				if(st!=null)  st.close();
				if(conn!=null)  conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			
		}
		
		return flag;
	}

}
