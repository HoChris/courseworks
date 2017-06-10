package lastInventory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class details
 */
@WebServlet("/Details")
public class details extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void init( ServletConfig config ) throws ServletException
	{
		super.init( config );

		try
		{
			Class.forName( "com.mysql.jdbc.Driver" );
		}
		catch( ClassNotFoundException e )
		{
			throw new ServletException( e );
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> DetPro = new ArrayList<Product>();
		int id =  Integer.parseInt(request.getParameter("id"));
		
		Connection c = null;
		try
		
		{
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu10";
			String username = "cs3220stu10";
			String password = "8!w3bpj4";

			c = DriverManager.getConnection( url, username, password );
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery( "SELECT * FROM inventory WHERE id = " + id);

			while( rs.next() )
			{	Product det = new Product( rs.getString( "name" ),
					rs.getString( "description" ), rs.getDouble( "price" ), rs.getInt("quantity"), rs.getInt("id") );
			DetPro.add( det );
			}
		}
		catch( SQLException e )
		{
			throw new ServletException( e );
		}
		finally
		{
			try
			{
				if( c != null ) c.close();
			}
			catch( SQLException e )
			{
				throw new ServletException( e );
			}
		}

		request.setAttribute( "DetPro", DetPro );
		request.getRequestDispatcher( "/WEB-INF/last/Details.jsp" ).forward(
				request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.sendRedirect("Details");
	}

}
