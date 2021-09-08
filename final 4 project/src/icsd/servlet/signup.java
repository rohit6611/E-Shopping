package icsd.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import icsd.dblogic.DBhandler;
import oracle.jdbc.pool.OracleDataSource;

/**
 * Servlet implementation class signup
 */
@WebServlet("/signup")
public class signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
	
//	Connection con = null;
	PreparedStatement stmt;
	DBhandler objDH=new DBhandler();
	
	Connection connection=objDH.getDBcon();

	public signup() {
        super();
        // TODO Auto-generated constructor stub
    }
	
//    public void init(ServletConfig config) throws ServletException
//    {
//       	objDH=new DBhandler();
//       	
//       	Connection connection=objDH.getDBcon();
    
//    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		String strUnm,strPwd;
		strUnm=request.getParameter("txtUnm");
		strPwd=request.getParameter("txtPwd");
		
		try {
			
			stmt = connection.prepareStatement("insert into javauser values (?,?,?)");
			stmt.setLong(1, 1);
			stmt.setString(2, strUnm);
			stmt.setString(3, strPwd);
			int rset=stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PrintWriter out=response.getWriter();
		out.println("<b>signed up successfully</b>");
	}
	public void destroy() {
		if(connection!=null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(stmt!=null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
