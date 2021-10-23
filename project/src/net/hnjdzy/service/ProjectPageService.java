package net.hnjdzy.service;

import java.util.ArrayList;
import java.util.List;

import net.hnjdzy.dao.ProjectPageDao;
import net.hnjdzy.entity.Project;
import net.hnjdzy.util.Page;

public class ProjectPageService {
	
	public Page getPage(int currPageNo) {
		
		Page p = new Page();
		p.setCurrPageNo(currPageNo);
		
		ProjectPageDao pageDao = new ProjectPageDao();
		//��ü�¼����
		int totalCount = pageDao.getCount();
		p.setTotalCount(totalCount);
		
		//������ҳ��
		p.setTotalPageCount(totalCount);
		
		
		//ִ��select * from where project_id>=  and project_id<=    order by project_id
		List<Project>  list = new ArrayList<Project>();
		list = pageDao.getList(p);
		
		p.setProjectList(list);
		
		return p;
	}

}
