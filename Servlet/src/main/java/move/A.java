package move;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class A
 */
@WebServlet("/A")
public class A extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 포워드 방식으로 페이지 이동
		String targetURL = "/B";
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		System.out.println("name : " + name);
		RequestDispatcher dispatcher = request.getRequestDispatcher(targetURL);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
