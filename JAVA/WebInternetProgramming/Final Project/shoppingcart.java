package lastInventory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShoppingCart
 */
@WebServlet("/ShoppingCart")
public class shoppingcart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	List<Product> ShopPro;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.getRequestDispatcher("/WEB-INF/last/ShoppingCart.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);		
		
		ShopPro = (List<Product>) session.getAttribute("ShopPro");
		if(ShopPro == null){
	         ShopPro = new ArrayList<Product>();
	         session.setAttribute("ShopPro", ShopPro);
	    }
		
        Integer id = Integer.valueOf( request.getParameter( "id" ) );
        String name = request.getParameter("name"); 
        String description = request.getParameter("description");
        Double price = Double.valueOf( request.getParameter("price") );
        Integer quantity = Integer.valueOf( request.getParameter( "quantity" ) );
        
                
		if( request.getParameter( "reqQuantity" ) == null 
				|| request.getParameter( "reqQuantity" ).trim().length() == 0 
				|| isInteger(request.getParameter( "reqQuantity" )) == false ) {
			
			request.setAttribute("quantityError", "Not a Valid Quantity. Please Try Again.");
		    request.getRequestDispatcher("/WEB-INF/last/Storefront.jsp").forward(request, response);
			return;
		}
        
        Integer reqQuantity = Integer.valueOf( request.getParameter( "reqQuantity" ) );
        
		if( reqQuantity > quantity ) {
			request.setAttribute("quantityError", "There is not enough in our inventory for that item. Please Try Again.");
		    request.getRequestDispatcher("/WEB-INF/last/Storefront.jsp").forward(request, response);
			return;
		}

        
        ShopPro.add( new Product(name, description, price, reqQuantity, id));

        session.setAttribute("ShopPro", ShopPro);
        
        Double totalPrice = 0.00;
        int totalQuantity = 0;
        
        for(Product x: ShopPro){
        	totalPrice = totalPrice + (x.getPrice()*x.getQuantity());
        	totalQuantity = totalQuantity + x.getQuantity();
        }
        totalPrice = Double.parseDouble(String.format("%.2f", totalPrice));
        session.setAttribute("totalPrice", totalPrice);
        session.setAttribute("totalQuantity", totalQuantity);
        
	    request.getRequestDispatcher("/WEB-INF/last/Storefront.jsp").forward(request, response);
	}
	
	
	public static boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    }
	    return true;
	}

}
