package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/userBicicletas")
public class userBicicletas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public userBicicletas() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/LaPlataEnBici/misBicicletas.jsp");
	}



}