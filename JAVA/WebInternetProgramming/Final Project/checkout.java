package lastInventory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Checkout")
public class checkout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	List<Product> ShopPro = new ArrayList<Product>();

	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		try {
			Class.forName("com.mysql.jdbc.Driver"); 
		} catch (ClassNotFoundException e) {
			throw new ServletException(e);
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/last/checkout.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
HttpSession session = request.getSession(true);		
		
		String firstName = request.getParameter("name1");
		String lastName = request.getParameter("name2");
		String email = request.getParameter("email");
		Double totalPrice = (Double) request.getSession().getAttribute("totalPrice");
		
		boolean error = false;
		
		if(firstName == null || firstName.trim().length() == 0){
			request.setAttribute("firstNameError", "Please enter your first name.");
			error = true;
		}else{
			request.setAttribute("firstName", firstName);
		}
		
		if(lastName == null || lastName.trim().length() == 0){
			request.setAttribute("lastNameError", "Please enter your last name.");
			error = true;
		}else{
			request.setAttribute("lastName", lastName);
		}
		
		if(email == null || email.trim().length() == 0){
			request.setAttribute("emailError", "Please enter your email address.");
			error = true;
		}else{
			request.setAttribute("email", email);
		}
		
		if(error == true){
			request.getRequestDispatcher("/WEB-INF/Checkout.jsp").forward(request, response);
			return;
		}
		
		
		
		List<Product> cart = (List<Product>) session.getAttribute("ShopPro");
		StringBuilder sb = new StringBuilder();
		
		for(Product x: cart){
			String name = x.getName();
			int quantity = x.getQuantity();
			int id = x.getId();
			
			sb.append(name + " -- " + quantity +" || ");
			Connection c = null;
			try
			{
				String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu10";
				String username = "cs3220stu10";
				String password = "8!w3bpj4";

				c = DriverManager.getConnection(url, username, password);

				String sql = "";
				PreparedStatement pstmt = c.prepareStatement(sql);


				sql = "UPDATE inventory SET quantity = quantity - ? WHERE id = ?";

				pstmt = c.prepareStatement(sql);
				pstmt.setInt(1, quantity);
				pstmt.setInt(2, id);
				pstmt.executeUpdate();
				
				
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
			
		}
		sb.append(" >>> Total: $" + totalPrice);
		
		request.getSession().setAttribute("history", sb.toString());
		
		String confirmationNumber = randomString();
		request.setAttribute("confirmationNumber", confirmationNumber);
		
		//request.getSession().invalidate();
		request.getRequestDispatcher("/WEB-INF/last/Submit.jsp").forward(request, response);
	}
	

	public static String randomString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
	
}
