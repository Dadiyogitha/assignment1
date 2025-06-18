package project1;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class edituser
 */
@WebServlet("/edituser")
public class edituser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public edituser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name =request.getParameter("name");
		
	     try (Connection con = dbcon.getCon()) {
           String sql = "SELECT * FROM user1 WHERE name = ?";
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setString(1, name);
           ResultSet rs = ps.executeQuery();

           if (rs.next()) {
               request.setAttribute("name", rs.getString("name"));
               request.setAttribute("email", rs.getString("email"));
               request.setAttribute("password", rs.getString("password"));
               RequestDispatcher rd = request.getRequestDispatcher("update.jsp");
               rd.forward(request, response);
           } else {
               response.sendRedirect("displayAll");
           }
       } catch (Exception e) {
           e.printStackTrace();
           response.sendRedirect("displayAll");
       }
   } 
		
        
    
		
	

	
}
        

            

  
