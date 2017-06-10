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
import javax.servlet.http.HttpSession;

/*This page should display a form with the following four (4) elements:

    - Name
        - The name field should be an input of type text with a name, name.
    - Description
        - The description field should be a textarea with the name, description.
    - Quantity
        - The quantity field should be an input of type text with the name, quantity.
    - Price
        - The price field should be an input of type text with the name, price.

Validation

All form fields should be validated using the following criteria:

    The name and description fields must not be empty. If they are, you should display an error message below each field.
    The quantity and price fields must be Integers and Doubles, respectively. If they are not, display an error message below each field indicating the problem.

Upon submitting a valid form, the new inventory item should be added to your inventory, and the User should be redirected back to the Inventory servlet.
Sticky-Forms

If the User submits a new item with errors, you should re-display the form, keeping all valid form values sticky. That is to say, you should not make your User re-enter form values that are already correct. However, do not retain erroneous form data. Refer to the example application for an example of this behavior.*/@WebServlet("/Store/AddItem")
public class AddItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		if(getServletContext().getAttribute("items") == null){
			List<storeItem> items = new ArrayList<storeItem>();
			
			getServletContext().setAttribute("items", items);
		}
	}
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		response.setContentType("text/html");
		
		String name = request.getParameter("name") == null ? "" : request.getParameter("name");
		String description = request.getParameter("description") == null ? "" : request.getParameter("description");
		String quantity = request.getParameter("quantity") == null ? "" : request.getParameter("quantity");
		String price = request.getParameter("price") == null ? "" : request.getParameter("price");

		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println(" 	<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.4/css/bootstrap.min.css' integrity='sha384-2hfp1SzUoho7/TsGGGDaFdsuuDL0LX2hnUp6VkX3CUQ2K4K+xjboZdsXyp4oUHZj' crossorigin='anonymous'>");
		out.println("	<meta charset=\"UTF-8\">");
		out.println("	<title>AddItem</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class='container-fluid'>");
			out.println("<h3> Add Item </h3>");
			out.println("<form action='AddItem' method='post'>");

			out.println("<div class='form-group col-xs-3' >");
				out.println(" Name: <input type='text' class='form-control' placeholder='Enter Name' name='name' value='"+ name +"'>");
				out.println(" Description: <textarea class='form-control' placeholder='Describe Item' name='description' value='"+ description +"'></textarea>");
				out.println(" Quantity: <input type='text' class='form-control' placeholder='Enter Name' name='quantity' value='"+ quantity +"'>");
				out.println(" Price: <input type='text' class='form-control' placeholder='Enter Name' name='price' value='"+ price + "'>");
				out.println("<button type='submit' class='btn btn-outline-primary col-xs'>Add Item </button>");
			out.println("</div>");

			out.println("</form>");
			
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");

		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		ServletContext context = this.getServletContext();
		List<storeItem> items = (List<storeItem>) context.getAttribute("items");
		PrintWriter out = response.getWriter();

		response.setContentType("text/html");
		
		Boolean allGood = false;
		String name = request.getParameter("name") == null ? "" : request.getParameter("name");
		String description = request.getParameter("description") == null ? "" : request.getParameter("description");
		String quantity = request.getParameter("quantity") == null ? "" : request.getParameter("quantity");
		String price = request.getParameter("price") == null ? "" : request.getParameter("price");

		
		if (allGood == false) {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println(
					" 	<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.4/css/bootstrap.min.css' integrity='sha384-2hfp1SzUoho7/TsGGGDaFdsuuDL0LX2hnUp6VkX3CUQ2K4K+xjboZdsXyp4oUHZj' crossorigin='anonymous'>");
			out.println("	<meta charset=\"UTF-8\">");
			out.println("	<title>AddItem</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<div class='container-fluid'>");
			out.println("<h3> Add Item </h3>");
			out.println("<form action='AddItem' method='post'>");
			out.println("<div class='form-group has-* col-xs-3' >");
			if (name.trim().length() <= 1 && name.equals("")) {
				out.println("<div class='form-group has-danger' >");
				out.println(
						" Name: <input type='text' class='form-control form-control-danger' placeholder='Enter Name' name='name' value='"
								+ name + "'>");
				out.println("<div class='form-control-feedback'> Invalid name.</div>");
				out.println("</div>");
				allGood = false;
			} else {
				out.println("<div class='form-group has-success' >");
				out.println(
						" Name: <input type='text' class='form-control form-control-success' placeholder='Enter Name' name='name' value='"
								+ name + "'>");
				out.println("</div>");
				allGood = true;
			}
			if (description.trim().length() <= 2 && description.equals("")) {
				out.println("<div class='form-group has-danger' >");
				out.println(
						" Description: <textarea class='form-control form-control-danger' placeholder='Describe Item' name='description'>"
								+ description + "</textarea>");
				out.println("<div class='form-control-feedback'> Invalid Description.</div>");
				out.println("</div>");
				allGood = false;
			} else {
				out.println("<div class='form-group has-success' >");
				out.println(
						" Description: <textarea class='form-control form-control-success' placeholder='Describe Item' name='description'>"
								+ description + "</textarea>");
				out.println("</div>");
				allGood = true;
			}
			try {
				int quan = Integer.parseInt(quantity);
				if (quan > 0) {
					out.println("<div class='form-group has-success' >");
					out.println(
							" Quantity: <input type='text' class='form-control form-control-success' placeholder='Enter Quantity' name='quantity' value='"
									+ quantity + "'>");
					out.println("</div>");
					allGood = true;
				} else {
					quan = 0;
					out.println("<div class='form-group has-danger' >");
					out.println(
							" Quantity: <input type='text' class='form-control form-control-danger' placeholder='Enter Quantity' name='quantity' value='"
									+ quantity + "'>");
					out.println("<div class='form-control-feedback'> Invalid Quantity.</div> ");
					out.println("</div>");
					allGood = false;
				}
			} catch (NumberFormatException e) {
				int quan = 0;
				out.println("<div class='form-group has-danger' >");
				out.println(
						" Quantity: <input type='text' class='form-control form-control-danger' placeholder='Enter Quantity' name='quantity' value='"
								+ quantity + "'>");
				out.println("<div class='form-control-feedback'> Invalid Quantity.</div>");
				out.println("</div>");
				allGood = false;
			}
			try {
				Double pric = Double.parseDouble(price);
				if (pric > 0) {
					out.println("<div class='form-group has-success' >");
					out.println(
							" Price: <input type='text' class='form-control form-control-success' placeholder='Enter Price' name='price' value='"
									+ price + "'>");
					out.println("</div>");
					allGood = true;
				} else {
					pric = 0.0;
					out.println("<div class='form-group has-danger' >");
					out.println(
							" Price: <input type='text' class='form-control form-control-danger' placeholder='Enter Name' name='price' value='"
									+ price + "'>");
					out.println("<div class='form-control-feedback'> Invalid Price.</div>");
					out.println("</div>");
					allGood = false;
				}

			} catch (NumberFormatException e) {
				Double pric = 0.0;
				out.println("<div class='form-group has-danger' >");
				out.println(
						" Price: <input type='text' class='form-control form-control-danger' placeholder='Enter Name' name='price' value='"
								+ price + "'>");
				out.println("<div class='form-control-feedback'> Invalid Price.</div>");
				out.println("</div>");
				allGood = false;
			}
			out.println("<button type='submit' class='btn btn-outline-primary'>Add Item </button>");
			out.println("</div>");
			out.println("</form>");
			out.println("</div>");
			out.println("</body>");
			out.println("</html>");
		}
		
		if(allGood == true){
			storeItem item = new storeItem(Double.parseDouble(price), Integer.parseInt(quantity), name, description);
			items.add(item);
			response.sendRedirect("Inventory");
		}
		
		
	}

}
