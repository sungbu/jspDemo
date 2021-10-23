package net.hnjdzy.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.hnjdzy.entity.Project;
import net.hnjdzy.service.ProjectService;

/**
 * Servlet implementation class ProjectServlet
 */
@WebServlet("/ProjectServlet")
public class ProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//1.接收参数（登录）
		request.setCharacterEncoding("utf-8");
		String index = request.getParameter("opr");
		ProjectService ps = new ProjectService();
		
		if(index.equals("queryall")) {//查询全部
			
			List<Project> list = ps.getAll();
			
			request.setAttribute("list", list);
			request.getRequestDispatcher("project_list_page.jsp").forward(request, response);
		}else if(index.equals("add")) {//添加数据
			
			
			String projectId = request.getParameter("textfield").trim();
			String projectName = request.getParameter("textfield2");
			
			
			Project p = new Project();
			p.setProjectId(projectId);
			p.setProjectName(projectName);
			
			//ProjectService ps = new ProjectService();
			ps.add(p);		
			
			
			List<Project> list = ps.getAll();
			
			request.setAttribute("list", list);
			request.getRequestDispatcher("project_list.jsp").forward(request, response);
			
		}else if(index.equals("edit")) {
			
			String projectId = request.getParameter("id");
			
			Project p = new Project();
			p = ps.getProjectById(projectId);
			
			request.setAttribute("project", p);
			request.getRequestDispatcher("project_edit.jsp").forward(request, response);		
			
			
		}else if(index.equals("update")) {
			String projectId = request.getParameter("textfield").trim();
			String projectName = request.getParameter("textfield2");
			String deputyName = request.getParameter("textfield9");
			String telephone = request.getParameter("textfield6");
			String addr = request.getParameter("textfield7");
			
			Project p = new Project();
			p.setProjectId(projectId);
			p.setProjectName(projectName);
			p.setDeputyName(deputyName);
			p.setTelephone(telephone);
			p.setAddr(addr);
			
			ps.updateById(p);
			
			
            List<Project> list = ps.getAll();
			
			request.setAttribute("list", list);
			request.getRequestDispatcher("project_list.jsp").forward(request, response);
			
			
		}else if(index.equals("del")) {
			String projectId = request.getParameter("id");
			
			ps.delByProjectId(projectId);
			
			
            List<Project> list = ps.getAll();
			
			request.setAttribute("list", list);
			request.getRequestDispatcher("project_list.jsp").forward(request, response);
			
			
			
			
		}else if(index.equals("sel")) {
			String v = request.getParameter("value");
			if(v.equals("1")) {
				 List<Project> list = ps.getAll();
				 request.setAttribute("list", list);
				 request.getRequestDispatcher("project_list.jsp").forward(request, response);
			}else {
				 List<Project> list = new ArrayList<Project>();
				 Project p = new Project();
				 p = ps.getProjectById(v);
				 if(p!=null) {
					 list.add(p);
				 }	
				 request.setAttribute("list", list);
				 request.getRequestDispatcher("project_list.jsp").forward(request, response);	
			}
			
		}else if(index.equals("query")) {
			
			String id = request.getParameter("value");
			if(id!=""||id!=null) {
				 List<Project> list = new ArrayList<Project>();
				 Project p = new Project();
				 p = ps.getProjectById(id);
				 if(p!=null) {
					 list.add(p);
				 }	
				 request.setAttribute("list", list);
				 request.getRequestDispatcher("project_list.jsp").forward(request, response);	
			}
			
		}
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
