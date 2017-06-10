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

import dbTodo.Duhtodo;

@WebServlet("/Inventory")
public class inventory extends HttpServlet {
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

		if(getServletContext().getAttribute("items") == null){
			List<Product> list = new ArrayList<Product>();
			getServletContext().setAttribute("items", list);
		}
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Product> list = new ArrayList<Product>();
		Connection c = null;

		try {
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu10";
			String username = "cs3220stu10";
			String password = "8!w3bpj4";

			c = DriverManager.getConnection(url, username, password);

			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery( "SELECT * FROM inventory" );

			while( rs.next() )
			{
				Product item = new Product( rs.getString("name"), rs.getString("description"), rs.getDouble("price"), rs.getInt("quantity"), rs.getInt("id"));
				list.add( item );

			}

			request.setAttribute("items", list);
			request.getRequestDispatcher("/WEB-INF/last/inventorymanager.jsp").forward(request, response);

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

		String name, description;
		name = description = null;
		double price = 0;
		int quantity = 0;
		int id;
		Connection c = null;

		name = request.getParameter("name") != null ? request.getParameter("name"): "";
		description = request.getParameter("description") != null ? request.getParameter("description"): "";
		price = !request.getParameter("price").trim().equals("") ? Double.parseDouble(request.getParameter("price")) : 0.0;
		quantity = !request.getParameter("quantity").trim().equals("")?  Integer.parseInt(request.getParameter("quantity")) : 0;
		id = !request.getParameter("id").equals("") ? Integer.parseInt(request.getParameter("id")) : -1;

		try {

			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu10";
			String username = "cs3220stu10";
			String password = "8!w3bpj4";

			c = DriverManager.getConnection(url, username, password);

			String sql = "";
			PreparedStatement pstmt = c.prepareStatement(sql);

			if( name.trim().equals("") && description.trim().equals("") && price == 0 && quantity <= 0 && id == -1
					|| !name.trim().equals("") && !description.trim().equals("") && price == 0 && quantity <= 0  && id == -1
					|| !name.trim().equals("") && description.trim().equals("") && price == 0 && quantity <= 0  && id == -1
					|| name.trim().equals("") && !description.trim().equals("") && price == 0 && quantity <= 0  && id == -1){
				getServletContext().setAttribute("error", true);
				doGet(request, response);
			} else {
				
				if(id !=-1 && request.getParameter("action").equals("0")){
					sql = "DELETE FROM inventory WHERE id = ?";

					pstmt = c.prepareStatement(sql);
					pstmt.setInt(1, id);
					pstmt.executeUpdate();
					doGet(request,response);
				} else {
					sql = "INSERT INTO inventory (id, name , description, quantity, price) VALUES (NULL, ?, ?, ?, ?)";

					pstmt = c.prepareStatement(sql);

					pstmt.setString(1, name);
					pstmt.setString(2, description);
					pstmt.setInt(3, quantity);
					pstmt.setDouble(4, price);
					pstmt.executeUpdate();
					doGet(request, response);
				}
			}
		} catch (SQLException e) {
			throw new ServletException(e);
		} finally {
			try {
				getServletContext().setAttribute("error", false);
				if (c != null)
					c.close();
			} catch (SQLException e) {
				throw new ServletException(e);
			}
		}

	}

}
