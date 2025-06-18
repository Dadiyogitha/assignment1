package project1;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		try {
			Connection con=dbcon.getCon();
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			pw.print(name + " "+ email + " "+ password);
			String query="insert into user1 values(?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,name);
			ps.setString(2,email);
			ps.setString(3,password);
			int i=ps.executeUpdate();
			if(i>0) {
				pw.print("insertion");
				RequestDispatcher rd=request.getRequestDispatcher("login.html");
				rd.forward(request, response);
			}
			else {
				response.setContentType("text/html");
				pw.print("<h2>error!, register again</h2>");
				RequestDispatcher rd=request.getRequestDispatcher("register.html");
				rd.include(request, response);
			}
			
		}
		catch(Exception e) {
			
		}
		
	}

}
