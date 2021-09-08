package icsd.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import icsd.Authentication.ICSDAuthException;
import icsd.Authentication.ICSDAuthentication;
import icsd.dblogic.DBhandler;
import icsd.model.categorymodel;


@WebServlet("/CategoryPage")
public class CategoryPage extends HttpServlet {
	DBhandler objDH=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryPage() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init(ServletConfig config) throws ServletException
    {
    	objDH=new DBhandler();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ICSDAuthentication.ckeckauth(request);
		
		
		PrintWriter out=response.getWriter();
		out.println("<html><head><title>Category page</title></head><body>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<th>catid</th>");
		out.println("<th>cat name</th>");
		out.println("<th>cat desc</th>");
		out.println("<th>cat imgurl</th>");
		out.println("<th>cat img</th>");
		out.println("</tr>");
		LinkedList<categorymodel> lst=objDH.getAllCategories();
		for (categorymodel obj : lst) 
		{
			int categoryid=obj.getCategoryid();
			String categoryname=obj.getCategoryname();
			String categorydesc=obj.getCategorydesc();
			String categoryimgurl=obj.getCategoryimgurl();
			out.println("<tr>");
			out.println("<td>"+categoryid+"</td>");
			out.println("<td><a href='ProductDetails?catid="+categoryid+"'>"+categoryname+"</a></td>");
			out.println("<td>"+categorydesc+"</td>");
			out.println("<td>"+categoryimgurl+"</td>");
			out.println("<td><img src='img/"+categoryimgurl+"'/></td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	
	}
	catch (ICSDAuthException e) {
		// TODO Auto-generated catch block
		PrintWriter out=response.getWriter();
		out.println("<html><head><title>Category page</title></head><body>");
		out.println("<a href='home.html'>"+e.getMessage()+"</a>");
		out.println("</body>");
		out.println("</html>");
		e.printStackTrace();
	}
	}

}