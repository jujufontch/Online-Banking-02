package Servlets;

import Beans.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet implementation class AdminSteuer
 */
public class AdminSteuer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSteuer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String selectedOption = request.getParameter("ASchoice");
		
		sql sql = new sql();
		
		Admin admin = new Admin();
		
		if(selectedOption.equals("1")) {
			
			
			
			
			try {
				String table= 	sql.generateTable(admin.showAllCustomerInfo());
				
                request.setAttribute("table", table);
				
				this.getServletContext().getRequestDispatcher("/WEB-INF/1.jsp").forward(request, response);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
		
		else if(selectedOption.equals("2")) {
			
			try {
				String table= 	sql.generateTable(admin.showAllTran());
				
               request.setAttribute("table", table);
				
				this.getServletContext().getRequestDispatcher("/WEB-INF/2.jsp").forward(request, response);
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
		
		else if(selectedOption.equals("3")||selectedOption.equals("4")||selectedOption.equals("5")) {
			
			 response.sendRedirect(selectedOption);
		}
		
		else {
			boolean welcome = false;
			
			request.setAttribute("welcome", welcome);
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/AdminSteuer.jsp").forward(request, response);

		}
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
