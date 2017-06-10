package Labs;

// update and archive statements servlet that handle on specific task \
// and redirects back to todo servlet then shows the jsp
//Todo servlet get all the info from DB and sends to jsp page
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




@WebServlet(urlPatterns={"/Labs/Todo"}, loadOnStartup=1)
public class Todo extends HttpServlet {
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
        
        if(getServletContext().getAttribute("todos") == null){
        	List<Duhtodo> list = new ArrayList<Duhtodo>();
        	List<Duhtodo> archived = new ArrayList<Duhtodo>();
        	getServletContext().setAttribute("todos", list);
        	getServletContext().setAttribute("archived", archived);
        }
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Duhtodo> list = new ArrayList<Duhtodo>();
		List<Duhtodo> archived = new ArrayList<Duhtodo>();
		
		Connection c = null;
		int total = 0;
		int archived_total = 0;
		int remaining = 0;
		
		try {
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu10";
			String username = "cs3220stu10";
			String password = "8!w3bpj4";


			c = DriverManager.getConnection(url, username, password);
			
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery( "SELECT * FROM `ToDo`" );
			
			 while( rs.next() )
	            {
	                Duhtodo todo = new Duhtodo( rs.getInt( "id" ),
	                    rs.getString( "description" ), rs.getString( "is_done" ) );
	                list.add( todo );
	                remaining = rs.getString("is_done").equals("done") ? remaining + 1 : remaining;
	                total++;
	            }
			 
			 rs =  stmt.executeQuery( "SELECT * FROM `Archived`" );
			 while( rs.next() )
	            {
	                Duhtodo todo = new Duhtodo( rs.getInt( "id" ),
	                    rs.getString( "description" ), rs.getString( "is_done" ) );
	                archived.add( todo );
	                archived_total++;
	            }
			//lists
			 request.setAttribute("todos", list);
			 request.setAttribute("archived", archived);
			//variables
			 request.setAttribute("total", total);
			 request.setAttribute("archived_total", archived_total);
			 request.setAttribute("remaining", remaining);
			//send to jsp
			 request.getRequestDispatcher("../WEB-INF/Todo.jsp").forward(request, response);
			 

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
		
		String titleTodo = null;
		titleTodo = request.getParameter("todo");
		
		Connection c = null;
		
        if (!titleTodo.equals("") || titleTodo.trim().length() < 0) {
			try {
				String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu10";
				String username = "cs3220stu10";
				String password = "8!w3bpj4";

				String sql = "INSERT INTO `cs3220stu10`.`ToDo` (`id`, `description`, `is_done`) VALUES (NULL, ?, ?)";

				c = DriverManager.getConnection(url, username, password);

				PreparedStatement pstmt = c.prepareStatement(sql);

				pstmt.setString(1, titleTodo);
				pstmt.setInt(2, 0);
				pstmt.executeUpdate();

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
        
		doGet(request,response);
	}

}
