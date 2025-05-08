package content;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HtmlServlet
 */
@WebServlet("/HtmlServlet")
public class HtmlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 응답
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title>HTML 컨텐츠 타입</title>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h1>HTML 컨텐츠 타입</h1>");
		writer.println("<img src='https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQjaNbi0Od-NiDUKukYfjI7UjFWlOW7F2-8aw&s'/>");
		writer.println("</body>");
		writer.println("</html>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("POST 요청");
	}
}
