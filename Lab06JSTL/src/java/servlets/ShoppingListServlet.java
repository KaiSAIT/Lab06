package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //create session
        HttpSession session = request.getSession(); 
        session.getAttribute("username"); 
        String action = request.getParameter("action");
        
        //check if an action was not selected and if so, invalidate session
        if (action != null) {
            if (action.equals("logout")) {
                session.invalidate(); 
                response.sendRedirect("shoppingList"); 
                return;
            }
        }
        
        // check if username is valid, 
        //if (session.getAttribute("username") != null) {
        //    getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        //    return;
        //}
        
        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        return; 
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // create session
        HttpSession session = request.getSession(); 
        String action = request.getParameter("action");
        
        String username = "";
        username = request.getParameter("username");
        
        // retrieve the items
        ArrayList<String> items = (ArrayList<String>)session.getAttribute("items");
        
        // create new array list if there arent any existing items
        if (items == null) {
            items = new ArrayList<>();
        }
        
        if (action != null) {
            // if user is register a name
            if (action.equals("register")) {
                session.setAttribute("username", username);
                response.sendRedirect("shoppingList");
                return;
            }
            // if user is adding an item
            if (action.equals("add")) {
                if (request.getParameter("item") != null) {
                    items.add(request.getParameter("item"));
                }
                session.setAttribute("items", items);
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                return;
            }
            // if user is deleting an item
            if (action.equals("delete")) {
                if (request.getParameter("item") != null) {
                    items.remove(request.getParameter("item"));
                }
                session.setAttribute("items", items);
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                return;
            }
        }
        
    }

}
