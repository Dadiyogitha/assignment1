package project1;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
//import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class update
 */
@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		    PrintWriter pw = response.getWriter();
	        String name = request.getParameter("name");
	        String email = request.getParameter("email");
	        String password = request.getParameter("password");

	        

	        try {
	            Connection con = dbcon.getCon();
	            String query = "UPDATE user1 SET  email=?, password=? WHERE name=?";
	            PreparedStatement ps = con.prepareStatement(query);
	            ps.setString(1, email);
	            ps.setString(2, password);
	            ps.setString(3, name);
	            int i = ps.executeUpdate();
	            if (i > 0) {
	            	
	            	RequestDispatcher rd = request.getRequestDispatcher("/displayAll");
	    	        rd.forward(request, response);
	                
	            } else {
	            	pw.print("not updated ");
	            	RequestDispatcher rd = request.getRequestDispatcher("index.html");
	    	        rd.include(request, response);
	                
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	            
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
