package net.hnjdzy.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.hnjdzy.entity.Project;
import net.hnjdzy.service.ProjectService;

/**
 * Servlet implementation class ProjectAddServlet
 */
@WebServlet("/ProjectAddServlet")
public class ProjectAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String projectId = request.getParameter("textfield");
		String projectName = request.getParameter("textfield2");
		
		
		Project p = new Project();
		p.setProjectId(projectId);
		p.setProjectName(projectName);
		
		ProjectService ps = new ProjectService();
		ps.add(p);		
		
		
		List<Project> list = ps.getAll();
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("project_list.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
