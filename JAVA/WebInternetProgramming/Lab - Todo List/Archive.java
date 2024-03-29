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


//updates the DB and sends to archive db? Use different table
//then eventually redirects back to ToDo servlet


@WebServlet("/Labs/Archive")
public class Archive extends HttpServlet {
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
		
		Connection c = null;
		try {
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu10";
			String username = "cs3220stu10";
			String password = "8!w3bpj4";

			c = DriverManager.getConnection(url, username, password);

			String sql = "INSERT INTO `cs3220stu10`.`Archived`(id, description, is_done) SELECT id, description, is_done FROM `cs3220stu10`.`ToDo` WHERE is_done = 'done'";

			PreparedStatement pstmt = c.prepareStatement( sql );

			pstmt.executeUpdate();
			
			sql = "UPDATE `cs3220stu10`.`Archived` SET is_done = 'archived' ";
			
			pstmt = c.prepareStatement( sql );
			
			pstmt.executeUpdate();
			
			sql = "DELETE FROM `cs3220stu10`.`ToDo` WHERE id IN (SELECT id FROM `cs3220stu10`.`Archived`)" ;
			
			pstmt = c.prepareStatement( sql );
			
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
