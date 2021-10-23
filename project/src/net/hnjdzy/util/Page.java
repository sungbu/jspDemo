package net.hnjdzy.util;

import java.util.List;

import net.hnjdzy.entity.Project;

public class Page {
	private int currPageNo = 1; // ��ǰҳ��
    private int pageSize = 10;    // ҳ���С����ÿҳ��ʾ��¼��
    private int totalCount;          // ��¼����
    private int totalPageCount; // ��ҳ��
    List<Project>  projectList; //ÿҳ��Ŀ����
    
	public int getCurrPageNo() {
		return currPageNo;
	}
	public void setCurrPageNo(int currPageNo) {
		this.currPageNo = currPageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		 if (totalCount > 0) {
				this.totalCount = totalCount;
				//������ҳ��	        	
			              totalPageCount = (this.totalCount % pageSize == 0) ?
			                                             (this.totalCount / pageSize) :
			                                             ((this.totalCount / pageSize) + 1);
	     }
	}
	public int getTotalPageCount() {
		return totalPageCount;
	}
	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	public List<Project> getProjectList() {
		return projectList;
	}
	public void setProjectList(List<Project> projectList) {
		this.projectList = projectList;
	}
    
	


}
