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
import icsd.model.ProductModel;


@WebServlet("/ProductDetails")
public class ProductDetails extends HttpServlet {
	DBhandler objDH=null;
    public ProductDetails() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init(ServletConfig config) throws ServletException
    {
    	objDH=new DBhandler();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			ICSDAuthentication.ckeckauth(request);
		
		String categoryid=request.getParameter("catid");
				
		LinkedList<ProductModel> lst=objDH.getAllProductsByCategoryId(categoryid);
		PrintWriter out=response.getWriter();
		out.println("<html><head><title>prod page</title>"
				
				+ "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We\" crossorigin=\"anonymous\"></head><body>");
		out.println("<div class='container'>");
		out.println("<p class=\"d-block p-2 bg-primary text-white text-center fs-1\"> PRODUCT DETAILS</p>");
		out.println("<table class='table table-bordered'>");
		out.println("<tr  class='bg-warning'>");
		out.println("<th>pid</th>");
		out.println("<th>prod name</th>");
		out.println("<th>prod img</th>");
		out.println("<th>prod desc</th>");
		out.println("<th>prod price</th>");
		out.println("<th>qty</th>");
		out.println("</tr>");
		for (ProductModel obj : lst) 
		{
			out.println("<tr>");
			out.println("<td>"+obj.getProdid()+"</td>");
			out.println("<td><a href='AddToCart?pid="+obj.getProdid()+"'>"+obj.getProductname()+"</a></td>");
			out.println("<td> <img  src='img/"+obj.getProdimgurl()+"'/></td>");
			out.println("<td>"+obj.getProddesc()+"</td>");
			out.println("<td>"+obj.getPrice()+"</td>");
			out.println("<td>"+obj.getQty()+"</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("<div>");
		out.println("</body></head>");
		} catch (ICSDAuthException e) {
			PrintWriter out=response.getWriter();
			out.println("<html><head><title>Category page</title></head><body>");
			out.println("<a href='home.html'>"+e.getMessage()+"</a>");
			out.println("</body>");
			out.println("</html>");
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