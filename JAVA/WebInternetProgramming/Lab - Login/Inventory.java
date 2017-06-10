package Store;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*The Inventory servlet should display a table of all items in your store. If your store does not contain any items, you should display the following message in an H3 tag:

There are no items in your inventory

Otherwise, you should display a table with the following column headings: Name, Description, Quantity, Price, and Actions.

The Actions column should contain a link that, when clicked, removes the specified item from your inventory.

Above your table should be a search form consisting of an input text field with the name, query, and another input of type submit. The form should submit to the Inventory Servlet using a GET request.

When searching, any and all items in your inventory that contain the search text in either the name or description should be displayed. Otherwise, the item should not be displayed in the table. Submitting an empty form should result in every record being displayed.

You should also have a hyperlink below your Inventory table that links to the AddItem Servlet.*/
@WebServlet(urlPatterns ={"/Store/Inventory"}, loadOnStartup=1)
public class Inventory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Inventory() {
        super();
  
    }
   
    public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		//pre-pop
		List<storeItem> items = new ArrayList<storeItem>();
		
		getServletContext().setAttribute("items", items);
		
		items.add(new storeItem(25.0, 1, "Flask", "Holds liquor."));
		items.add(new storeItem(500. , 1, "Phone", "Call people."));
		items.add(new storeItem(2.37, 9, "Pen", "Write Things"));


	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String query = request.getParameter("query") == null ? "" :  request.getParameter("query");
		
		ServletContext context = this.getServletContext();
		
		@SuppressWarnings("unchecked")
		List<storeItem> items = (List<storeItem>) context.getAttribute("items");
		
		response.setContentType("text/html");
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println(" 	<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.4/css/bootstrap.min.css' integrity='sha384-2hfp1SzUoho7/TsGGGDaFdsuuDL0LX2hnUp6VkX3CUQ2K4K+xjboZdsXyp4oUHZj' crossorigin='anonymous'>");
		out.println("	<meta charset=\"UTF-8\">");
		out.println("	<title>Online Store</title>");
		out.println("</head>");
		
		out.println("<body>");
		if(items.isEmpty()){
			out.println("<h3> There are no items in your inventory.</h3>");
		}
		else{
			out.println("<form class='form-inline' action='Inventory' method='get'>");
				out.println("<div class='form-group'>");
					out.println("<input type='text' class='form-control' placeholder='Search Name/Description' name='query'> <button type='submit' class='btn btn-primary'>Search </button>");
				out.println("</div>");
			out.println("</form>");
			out.println("<table class='table table-sm table-hover'>");
				out.println("<thead class='thead-inverse'>");
					out.println("<tr>");
						out.println("<th>Name </th>");
						out.println("<th>Description </th>");
						out.println("<th>Quantity </th>");
						out.println("<th>Price </th>");
						out.println("<th>Actions </th>");
					out.println("</tr>");
				out.println("</thead>");

//table data
				out.println("<tbody>");
				
		if(!query.isEmpty()){
			for(storeItem item : items){
				if(item.getName().toLowerCase().contains(query.toLowerCase()) || item.getDescription().toLowerCase().contains(query.toLowerCase())){
					out.println("<tr>");
						out.println("<td>"+ item.getName() +"</td>");
						out.println("<td>"+ item.getDescription() +"</td>");
						out.println("<td>"+ item.getQuantity() +"</td>");
						out.println("<td>"+ item.getPrice() +"</td>");
					out.println("<td> <a class='btn btn-primary' href='DeleteItem?id=" + item.getId() + "'>Delete</a>");
				out.println("</tr>");
				}
			}
		}
		else{
				for(storeItem item : items){
					out.println("<tr>");
						out.println("<td>"+ item.getName() +"</td>");
						out.println("<td>"+ item.getDescription() +"</td>");
						out.println("<td>"+ item.getQuantity() +"</td>");
						out.println("<td>"+ item.getPrice() +"</td>");
						out.println("<td> <a class='btn btn-primary' href='DeleteItem?id=" + item.getId() + "'>Delete</a>");
					out.println("</tr>");
				}
		}

				out.println("</tbody>");
			out.println("</table>");
		}
			out.println("<a class='btn btn-primary' href='AddItem'>Add Item</a>");
			out.println("<a class='btn btn-primary' href='Logout'>Logout</a>");
		out.println("</body>");
		out.println("</html>");
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
