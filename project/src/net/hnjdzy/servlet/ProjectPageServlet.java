package net.hnjdzy.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.hnjdzy.service.ProjectPageService;
import net.hnjdzy.util.Page;

/**
 * Servlet implementation class ProjectPageServlet
 */
@WebServlet("/ProjectPageServlet")
public class ProjectPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int  currPageNo = Integer.parseInt(request.getParameter("page"));
		
		
		//调用Service中的方法
		ProjectPageService pageService = new ProjectPageService();		
		Page p = new Page();
	    p = pageService.getPage(currPageNo);
		
		request.setAttribute("list", p.getProjectList());
		request.setAttribute("page", p);
		request.getRequestDispatcher("project_list_page.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
