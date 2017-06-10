package Labs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Labs/AboutMe")
public class AboutMe extends HttpServlet {
	private static final long serialVersionUID = 1L;

       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">");
		out.println("</head>");
		out.println("<body>");
			out.println("<div class=\"container\">");

			out.println("<form action=\"AboutMe\" method=\"post\" >");
			out.println(" <input type=\"text\" name=\"cin\" placeholder=\"CIN number\" /> <br/>");
			out.println(" <button type=\"submit\" class=\"btn btn-default\"> Show </button>");
			out.println("</form>");
			
			out.println("</div>");	
			
		out.println("</body>");
		out.println("</html>");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String CIN = request.getParameter("cin");
		
		if(CIN !=null && CIN.equals("221073903"))	{
			
			response.setContentType("text/html");
			
			PrintWriter out = response.getWriter();
			
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">");
			out.println("</head>");
			out.println("<body>");
				out.println("<div class=\"container\">");
			
			
				out.println("<div id=\"name\">");
					out.println("<h3>Christopher Ho </h3>");
					out.println("</div>");
					
					out.println("<p class=\"description\">In terms of programming experience, my strongest is in Java with 10k plus lines"
							+ ". The other languages have roughly the same amount 7k plus lines which are C++, Python, HTML and CSS.	</p><br />");
					out.println("<p class=\"description\">With the knowlegde gained from these classes I hope to land and internship.	</p><br />");
					out.println("<p class=\"description\">Over the Summer, I played around with a Raspberry Pi and built an application that uses"
							+ "said micro computer as a server to host data.</p><br />");
		
				out.println("</div>");	
			out.println("</body>");
			out.println("</html>");

		}
		
		else{
	
			response.sendRedirect("AboutMe");
		}
		

	}

}
