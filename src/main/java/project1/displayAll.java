package project1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class displayAll
 */
@WebServlet("/displayAll")
public class displayAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public displayAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
       PrintWriter pw = response.getWriter();
        
		Connection con;
		try {
			con = dbcon.getCon();
			response.setContentType("text/html");
			String query = "select * from user1";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();

			pw.print("<style>");
			pw.print("table { width: 80%; margin: 20px auto; border-collapse: collapse; font-family: Arial, sans-serif; }");
			pw.print("th, td { padding: 12px; text-align: left; border: 1px solid #ccc; }");
			pw.print("th { background-color: #3498db; color: white; }");
			pw.print("tr:nth-child(even) { background-color: #f2f2f2; }");
			pw.print("a { color: #e74c3c; text-decoration: none; font-weight: bold; }");
			pw.print("a:hover { text-decoration: underline; }");
			pw.print("</style>");
			pw.print("<table border =5>");
			pw.print("<tr>");
			pw.print("<th>name</th>");
			pw.print("<th>email</th>");
			pw.print("<th>password</th>");
			pw.print("<th>delete</th>");
			pw.print("<th>Edituser</th>");
			
			pw.print("</tr>");
			while(rs.next())
			{
				pw.print("<tr>");
				pw.print("<td>"+rs.getString(1)+"</td>");
				pw.print("<td>"+rs.getString(2)+"</td>");
				pw.print("<td>"+rs.getString(3)+"</td>");
				pw.print("<td><a href='delete?name="+rs.getString(1)+"'>delete</a></td>");
				pw.print("<td><a href='edituser?name="+rs.getString(1)+"'>edit</a></td>");
				pw.print("</tr>");
			}
			pw.print("</table>");
		} catch (Exception e) {
			// TODO Auto-generated catch block
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


