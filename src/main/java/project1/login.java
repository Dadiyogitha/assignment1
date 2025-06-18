package project1;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");

		try {
			Connection con = dbcon.getCon();
			String name = request.getParameter("name");
			String password = request.getParameter("password");

			String query = "SELECT * FROM user1 WHERE name=? AND password=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				HttpSession hs = request.getSession();
				String email = rs.getString("email");
				hs.setAttribute("email", email);
				hs.setAttribute("name", name);

				RequestDispatcher rd = request.getRequestDispatcher("profile.html");
				rd.forward(request, response);
			} else {
				pw.println("<h2 style='color:red;'>Invalid username or password. Try again.</h2>");
				RequestDispatcher rd = request.getRequestDispatcher("login.html");
				rd.include(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			pw.println("<h2 style='color:red;'>Server error occurred.</h2>");
		}
	}
}




