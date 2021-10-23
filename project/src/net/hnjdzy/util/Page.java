package net.hnjdzy.util;

import java.util.List;

import net.hnjdzy.entity.Project;

public class Page {
	private int currPageNo = 1; // 当前页码
    private int pageSize = 10;    // 页面大小，即每页显示记录数
    private int totalCount;          // 记录总数
    private int totalPageCount; // 总页数
    List<Project>  projectList; //每页项目集合
    
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
				//计算总页数	        	
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
