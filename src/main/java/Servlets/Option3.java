package Servlets;

import Beans.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class Option3
 */
public class Option3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Option3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/3.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String selectedOption = request.getParameter("user3");
		
		sql sql = new sql();
		
		boolean exists = Beans.sql.Nameprüfer(selectedOption);
		
				if(exists) {
					
					
					
					Admin admin = new Admin();
					
					ResultSet rs = admin.customerTransaction(selectedOption);
					
					
					if (rs!=null) {
					try {
						String table = sql.generateTable(rs);
						request.setAttribute("table", table);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}
					
					else {
						
						String table = null;
						request.setAttribute("table", table);
					}
					
					
					
					this.getServletContext().getRequestDispatcher("/WEB-INF/3(2).jsp").forward(request, response);
				}
				
				else {
					
					boolean bool = true;
					
					request.setAttribute("bool", bool );
				
					this.getServletContext().getRequestDispatcher("/WEB-INF/3.jsp").forward(request, response);
					
				}
				
				
	}

}
