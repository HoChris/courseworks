package Labs;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//update servlet runs queries to run and updates the changes to made 
//from the jsp page.

@WebServlet("/Labs/Update")
public class Update extends HttpServlet {
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
		
		String state = request.getParameter("state").equals("notdone") ? "done" : "notdone";
		int id = Integer.parseInt(request.getParameter("id"));
		
		Connection c = null;
		try {
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu10";
			String username = "cs3220stu10";
			String password = "8!w3bpj4";

			c = DriverManager.getConnection(url, username, password);
			
			String sql = "UPDATE `cs3220stu10`.`ToDo` SET `is_done` = ? WHERE `ToDo`.`id` = ? ";
			
			 PreparedStatement pstmt = c.prepareStatement( sql );
			 
			 pstmt.setString(1, state);
			 pstmt.setInt(2, id);
			 
			 pstmt.executeUpdate();
			 
			 response.sendRedirect("Todo");
			
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

