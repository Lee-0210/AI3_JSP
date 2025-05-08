package content;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class XmlServlet
 */
@WebServlet("/XmlServlet")
public class XmlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("application/xml; charset=utf-8");
//		
//		String xml = "<Board>"
//				+ "<title>제목</title>"
//				+ "<writer>작성자</writer>"
//				+ "<content>내용</content>"
//				+ "</Board>";
//		response.getWriter().println(xml);
		
		ObjectMapper mapper = new ObjectMapper();
        ObjectNode json = mapper.createObjectNode();
        
        json.put("name", "ALOHA");
        json.put("age", 20);
        
        response.getWriter().println(json.toPrettyString());
        
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
