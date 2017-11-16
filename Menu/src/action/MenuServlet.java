package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.FirstMenu;
import entity.SecondMenu;
import service.MenuService;

public class MenuServlet extends HttpServlet {

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String op = request.getParameter("op");
		MenuService menuService = new MenuService();
		
		if("firstMenuList".equals(op))
		{
			ArrayList<FirstMenu> firstMenu = new ArrayList<FirstMenu>();
			firstMenu = menuService.getFirstMenuList();
			request.getSession().setAttribute("firstMenu", firstMenu);
			response.sendRedirect("../admin/MenuManagement.jsp");
		}
		
		if("secondMenuList".equals(op))
		{
			ArrayList<SecondMenu> secondMenu = new ArrayList<SecondMenu>();
			secondMenu = menuService.getSecondMenuList();
			request.getSession().setAttribute("secondMenu", secondMenu);
			response.sendRedirect("../admin/MenuManagement.jsp");
		}
		
		if("addFirstMenu".equals(op))
		{
			String name = request.getParameter("addFirstMenu");
			if(menuService.addFirstMenu(name))
			{
				ArrayList<FirstMenu> firstMenu = new ArrayList<FirstMenu>();
				firstMenu = menuService.getFirstMenuList();
				request.getSession().setAttribute("firstMenu", firstMenu);
				response.sendRedirect("../admin/MenuManagement.jsp");
			}
			else
				out.print("<script>alert('添加菜单出错，请重新添加');history.back();</script>");
		}
		
		if("addSecondMenu".equals(op))
		{
			String name = request.getParameter("addSecondMenu");
			if(menuService.addSecondMenu(name))
			{
				ArrayList<SecondMenu> secondMenu = new ArrayList<SecondMenu>();
				secondMenu = menuService.getSecondMenuList();
				request.getSession().setAttribute("secondMenu", secondMenu);
				response.sendRedirect("../admin/MenuManagement.jsp");
			}
			else
				out.print("<script>alert('添加菜单出错，请重新添加');history.back();</script>");
		}

		if("modFirstMenu".equals(op))
		{
			String id = request.getParameter("id");
			String newName = request.getParameter("name");
			FirstMenu fm = new FirstMenu();
			fm.setId(Integer.valueOf(id));
			fm.setName(newName);
			if(menuService.modFirstMenu(fm))
			{
				ArrayList<FirstMenu> firstMenu = new ArrayList<FirstMenu>();
				firstMenu = menuService.getFirstMenuList();
				request.getSession().setAttribute("firstMenu", firstMenu);
				response.sendRedirect("../admin/MenuManagement.jsp");
			}
			else
				out.print("<script>alert('修改菜单出错，请重新添加');history.back();</script>");
		}
		
		if("modSecondMenu".equals(op))
		{
			String id = request.getParameter("id");
			String newName = request.getParameter("name");
			SecondMenu sm = new SecondMenu();
			sm.setId(Integer.valueOf(id));
			sm.setName(newName);
			if(menuService.modSecondMenu(sm))
			{
				ArrayList<SecondMenu> secondMenu = new ArrayList<SecondMenu>();
				secondMenu = menuService.getSecondMenuList();
				request.getSession().setAttribute("secondMenu", secondMenu);
				response.sendRedirect("../admin/MenuManagement.jsp");
			}
			else
				out.print("<script>alert('修改菜单出错，请重新添加');history.back();</script>");
		}
		
		if("delFirstMenu".equals(op))
		{
			String id = request.getParameter("id");
			FirstMenu fm = new FirstMenu();
			fm.setId(Integer.valueOf(id));
			if(menuService.delFirstMenu(fm))
			{
				ArrayList<FirstMenu> firstMenu = new ArrayList<FirstMenu>();
				firstMenu = menuService.getFirstMenuList();
				request.getSession().setAttribute("firstMenu", firstMenu);
				response.sendRedirect("../admin/MenuManagement.jsp");
			}
			else
				out.print("<script>alert('更新菜单出错，请重新添加');history.back();</script>");
		}
		
		if("delSecondMenu".equals(op))
		{
			String id = request.getParameter("id");
			SecondMenu sm = new SecondMenu();
			sm.setId(Integer.valueOf(id));
			if(menuService.delSecondMenu(sm))
			{
				ArrayList<SecondMenu> secondMenu = new ArrayList<SecondMenu>();
				secondMenu = menuService.getSecondMenuList();
				request.getSession().setAttribute("secondMenu", secondMenu);
				response.sendRedirect("../admin/MenuManagement.jsp");
			}
			else
				out.print("<script>alert('更新菜单出错，请重新添加');history.back();</script>");
		}
		
		if("sortID".equals(op))
		{
			
			if(menuService.sortID())
			{
				ArrayList<FirstMenu> firstMenu = new ArrayList<FirstMenu>();
				firstMenu = menuService.getFirstMenuList();
				request.getSession().setAttribute("firstMenu", firstMenu);
				response.sendRedirect("../admin/MenuManagement.jsp");
			}
		}
		
		out.flush();
		out.close();
	}

}
