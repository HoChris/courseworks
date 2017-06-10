package lastInventory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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


@WebServlet("/History")
public class history extends HttpServlet {
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

		String history = (String)request.getSession().getAttribute("history");
		List<transOrder> list = new ArrayList<transOrder>();

		Connection c = null;

		if (history !=null) {
			try {
				String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu10";
				String username = "cs3220stu10";
				String password = "8!w3bpj4";

				c = DriverManager.getConnection(url, username, password);

				String sql = "";
				PreparedStatement pstmt = c.prepareStatement(sql);

				sql = "INSERT INTO `inv_history`(`id`, `order`) VALUES (NULL,?)";

				pstmt = c.prepareStatement(sql);
				pstmt.setString(1, history);
				//pstmt.setDouble(2, total);
				pstmt.executeUpdate();

				Statement stmt = c.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM inv_history");

				while (rs.next()) {
					transOrder item = new transOrder(rs.getInt("id"), rs.getString("order"));
					list.add(item);

				}
				request.getSession().invalidate();
				request.setAttribute("historylist", list);
				request.getRequestDispatcher("/WEB-INF/last/History.jsp").forward(request, response);
			} catch (SQLException e) {
				throw new ServletException(e);
			} finally {
				try {
					if (c != null)
						c.close();
				} catch (SQLException e) {
					throw new ServletException(e);
				}
			} 
		}else{
			try {
				String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu10";
				String username = "cs3220stu10";
				String password = "8!w3bpj4";

				c = DriverManager.getConnection(url, username, password);
				Statement stmt = c.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM inv_history");

				while (rs.next()) {
					transOrder item = new transOrder(rs.getInt("id"), rs.getString("order"));
					list.add(item);

				}
				request.setAttribute("historylist", list);
				request.getRequestDispatcher("/WEB-INF/last/History.jsp").forward(request, response);
			} catch (SQLException e) {
				throw new ServletException(e);
			} finally {
				try {
					if (c != null)
						c.close();
				} catch (SQLException e) {
					throw new ServletException(e);
				}


			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}


}
