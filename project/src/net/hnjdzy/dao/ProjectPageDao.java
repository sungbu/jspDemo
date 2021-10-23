package net.hnjdzy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.hnjdzy.entity.Project;
import net.hnjdzy.util.Page;

public class ProjectPageDao extends BaseDao {
	
	//获得记录总数
	public int getCount() {
		Connection conn = getConnection();
		String sql = "select count(*) as zs from t_project ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);			
			rs = pstmt.executeQuery();
			if(rs.next()) {				
				count = rs.getInt("zs");
			}			
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {		
			
			closeAll(rs,pstmt,conn);
		}
		
		return count;		
	}

	public List<Project> getList(Page page) {
		Connection conn = getConnection();
		String sql = "select * from t_project where project_id>=? and project_id<=? order by cast(project_id as int)";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Project> list = new ArrayList<Project>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (page.getCurrPageNo()-1)*page.getPageSize()+1);
			pstmt.setInt(2, page.getCurrPageNo()*page.getPageSize());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Project p = new Project();
				p.setProjectId(rs.getString(1));
				p.setProjectName(rs.getString(2));
				p.setDeputyName(rs.getString(3));
				p.setTelephone(rs.getString(4));
				p.setAddr(rs.getString(5));
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {			
			
			closeAll(rs,pstmt,conn);
		}		
		return list;
	}

}
