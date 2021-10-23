package net.hnjdzy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.hnjdzy.entity.Project;

public class ProjectDao extends BaseDao {
	
	
	public List<Project> getAll(){
		
		Connection conn = getConnection();
		String sql = "select * from t_project";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Project> list = new ArrayList<Project>();
		try {
			pstmt = conn.prepareStatement(sql);
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
		System.out.println(list.get(0).getProjectId());
		return list;
		
	}	
	
	
	/**
	 * @param p
	 */
	public void add(Project p) {
		Connection conn = getConnection();
		String sql = "insert into t_project values(?,?,?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p.getProjectId());
			pstmt.setString(2, p.getProjectName());
			pstmt.setString(3, p.getDeputyName());
			pstmt.setString(4, p.getTelephone());
			pstmt.setString(5, p.getAddr());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}finally {			
			
			closeAll(null,pstmt,conn);
		}
	}	
	
	
	public Project getProjectById(String projectId) {
		Connection conn = getConnection();
		String sql = "select * from t_project where project_id=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Project p = new Project();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, projectId);
			rs = pstmt.executeQuery();
			if(rs.next()) {				
				p.setProjectId(rs.getString(1));
				p.setProjectName(rs.getString(2));
				p.setDeputyName(rs.getString(3));
				p.setTelephone(rs.getString(4));
				p.setAddr(rs.getString(5));
			}			
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {		
			
			closeAll(rs,pstmt,conn);
		}
		
		return p;		
		
	}
	
	public void updateById(Project p) {
		Connection conn = getConnection();
		String sql = "update t_project set project_name=?,deputy_name=?,telephone=?,addr=? where project_id=?";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p.getProjectName());
			pstmt.setString(2, p.getDeputyName());
			pstmt.setString(3, p.getTelephone());
			pstmt.setString(4, p.getAddr());
			pstmt.setString(5, p.getProjectId());
			
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {			
			
			closeAll(null,pstmt,conn);
		}
		
	}
	
	public void delByProjectId(String projectId) {
		Connection conn = getConnection();
		String sql = "delete from t_project where project_id=?";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);			
			pstmt.setString(1, projectId);			
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {			
			
			closeAll(null,pstmt,conn);
		}
	}
	

}
