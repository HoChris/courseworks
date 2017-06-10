package Store;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;
import javax.servlet.http.Cookie;


@WebServlet(urlPatterns={"/Store/Login"}, loadOnStartup=1)
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		// Create the collection in the servlet context to be used by all other servlets
		List<Users> users = new ArrayList<Users>();
		
		// Pre-Populate your users database with the following accounts
		users.add(new Users("John", "Doe", "john@doe.com", "aa"));
		users.add(new Users("Mary", "Jane", "mary@jane.com", "bb"));
		users.add(new Users("Joe", "Boxer", "joe@boxer.com", "cc"));
		
		// Add the users list to the global scope
		getServletContext().setAttribute("users", users);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie[] cookies = request.getCookies();
		
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/html");
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println(" 	<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.4/css/bootstrap.min.css' integrity='sha384-2hfp1SzUoho7/TsGGGDaFdsuuDL0LX2hnUp6VkX3CUQ2K4K+xjboZdsXyp4oUHZj' crossorigin='anonymous'>");
		out.println("	<meta charset=\"UTF-8\">");
		out.println("	<title>Users Login</title>");
		out.println("</head>");
		out.println("<body>");
		
		out.println("<form class='form-horizontal col-md-6' method='post' action='Login'>");
//email input
			out.println("<div class='form-group'>");
				out.println("<label for='inputEmail' class='col-sm-2 control-label'>Email</label>");
				out.println("<div class='col-sm-10'>");
				
//cookie user email
//				Cookie c = null;
				String curEmail = null;
				Users curUser = (Users)getServletContext().getAttribute("CurrentUser");
				if(curUser == null){
					 curEmail = null;
				}else{
					 if (cookies != null) {
//debugg cookies
//						 for(int i = 0; i < cookies.length; i++){
//							 c = cookies[i];
//							 System.out.println(c.getName());
//							 System.out.println(c.getValue() +"\n\n");
//						 }
						for (Cookie cookie : cookies) {
							
							if (cookie.getName().equals("username")) {
								curEmail = curUser.getEmail();
							}
						} 
					}
				}
				
				if(curEmail == null){
						out.println("<input type='text' class='form-control' name='email' id='inputEmail' placeholder='Email'>");
				}else{
						out.println("<input type='text' class='form-control' name='email' id='inputEmail' placeholder='Email' value='"+  curEmail +"'>");
				}
				out.println("</div>");
			out.println("</div></br>");
//password input			
			out.println("<div class='form-group'>");
				out.println("<label for='inputPassword' class='col-sm-2 control-label'>Password</label>");
					out.println("<div class='col-sm-10'>");
						out.println("<input type='password' class='form-control' name='password' id='inputPassword' placeholder='Password'>");
					out.println("</div>");
			out.println("</div>");
//checkbox input
			out.println("<div class='form-group'>");
				out.println("<div class='col-sm-offset-2 col-sm-10'>");
					out.println("<div class='checkbox'>");
						out.println("<label>");
							out.println("<input type='checkbox' name='rememberMe' value='true'> Remember me");
						out.println("</label>");
					out.println("</div>");
				out.println("</div>");
			out.println("</div>");
//submit imput
			out.println("<div class='form-group'>");
				out.println("<div class='col-sm-offset-2 col-sm-10'>");
					out.println("<button type='submit' class='btn btn-default'>Sign in</button>");
				out.println("</div>");
			out.println("</div>");
		out.println("</form>");
		
		
		
		
		out.println("</body>");
		out.println("</html>");
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Users> users = (List)getServletContext().getAttribute("users");

		String email = request.getParameter("email");
		Boolean rMe = Boolean.parseBoolean(request.getParameter("rememberMe"));
		String pass = request.getParameter("password");


//if email in user list
		for(Users user: users ){
	//if not 
			if( email == null || !user.getEmail().equals(email.trim()) ){
				getServletContext().setAttribute("valid", false);
				
			}else{
				if(rMe != true ){
					getServletContext().setAttribute("CurrentUser", null);
					
					getServletContext().setAttribute("valid", true);

					response.sendRedirect("Inventory");
				
				}
				if(user.getPassword().equals(pass)){
					
					if(rMe == true){
						email = user.getEmail();
						Cookie username = new Cookie("username", email);
						username.setMaxAge(60*3);
						
						response.addCookie(username);
						
						getServletContext().setAttribute("valid", true);
						getServletContext().setAttribute("CurrentUser", user);
						response.sendRedirect("Inventory");
					}
	
				}
			}
		}
		
		
		PrintWriter out = response.getWriter();
		
		Boolean valid = (Boolean)getServletContext().getAttribute("valid");
		
		response.setContentType("text/html");
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println(" 	<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.4/css/bootstrap.min.css' integrity='sha384-2hfp1SzUoho7/TsGGGDaFdsuuDL0LX2hnUp6VkX3CUQ2K4K+xjboZdsXyp4oUHZj' crossorigin='anonymous'>");
		out.println("	<meta charset=\"UTF-8\">");
		out.println("	<title>Users Login</title>");
		out.println("</head>");
		out.println("<body>");
		
		out.println("<form class='form-horizontal col-md-6' method='post' action='Login'>");
//email input
			out.println("<div class='form-group has-*'>");
				out.println("<label for='inputEmail' class='col-sm-2 control-label'>Email</label>");
			if(valid == false){
					out.println("<div class='col-sm-10'>");
						out.println("<input type='text' class='form-control form-control-danger' name='email' id='inputEmail' placeholder='Email'>");
						out.println("<div class='form-control-feedback'> Invalid Username and/or Password.</div>");
					out.println("</div>");
			}else{
					out.println("<div class='col-sm-10'>");
						out.println("<input type='text' class='form-control' name='email' id='inputEmail' placeholder='Email'>");	
					out.println("</div>");
			}
			out.println("</div></br>");
//password input			
			out.println("<div class='form-group'>");
				out.println("<label for='inputPassword' class='col-sm-2 control-label'>Password</label>");
					out.println("<div class='col-sm-10'>");
						out.println("<input type='password' class='form-control' name='password' id='inputPassword' placeholder='Password'>");
					out.println("</div>");
			out.println("</div>");
//checkbox input
			out.println("<div class='form-group'>");
				out.println("<div class='col-sm-offset-2 col-sm-10'>");
					out.println("<div class='checkbox'>");
						out.println("<label>");
							out.println("<input type='checkbox' name='rememberMe' value='true'> Remember me");
						out.println("</label>");
					out.println("</div>");
				out.println("</div>");
			out.println("</div>");
//submit imput
			out.println("<div class='form-group'>");
				out.println("<div class='col-sm-offset-2 col-sm-10'>");
					out.println("<button type='submit' class='btn btn-default'>Sign in</button>");
				out.println("</div>");
			out.println("</div>");
		out.println("</form>");
		

		out.println("</body>");
		out.println("</html>");


	}

}
