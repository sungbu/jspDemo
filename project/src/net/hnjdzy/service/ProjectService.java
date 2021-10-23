package net.hnjdzy.service;

import java.util.List;

import net.hnjdzy.dao.ProjectDao;
import net.hnjdzy.entity.Project;

public class ProjectService {
	
	
	
	public List<Project> getAll(){
		
		ProjectDao pd = new ProjectDao();
		
		return pd.getAll();		
	}
	
	public void add(Project p) {
		ProjectDao pd = new ProjectDao();
		pd.add(p);
	}
	
	public Project getProjectById(String projectId) {
		ProjectDao pd = new ProjectDao();
		return pd.getProjectById(projectId);
	}
	
	public void updateById(Project p) {
		ProjectDao pd = new ProjectDao();
		pd.updateById(p);
	}
	
	public void delByProjectId(String projectId) {
		ProjectDao pd = new ProjectDao();
		pd.delByProjectId(projectId);
	}

}
