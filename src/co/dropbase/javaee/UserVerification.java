package co.dropbase.javaee;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserVerification extends HttpServlet { 
	 
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // reading the user input
		String user= request.getParameter("username");   
	    String pw= request.getParameter("password");  
	    UserCreation userpw = new UserCreation();
	    userpw.addUser(user, pw);
	    PrintWriter out = response.getWriter();
	    //String  LOGIN_PAGE = "/WebContent/Usermessage.jsp";
	    //response.sendRedirect(LOGIN_PAGE);
	    request.getRequestDispatcher("/WEB-INF/Usermessage.jsp").forward(request, response);  
	    out.print("Registerd");
	    		
	}  
}

