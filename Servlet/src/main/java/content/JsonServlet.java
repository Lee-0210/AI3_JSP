package content;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import dto.Users;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JsonServlet
 */
@WebServlet("/JsonServlet")
public class JsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GET 요청");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청
		// JSON -> Map
		ServletInputStream sis = request.getInputStream();
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> map = mapper.readValue(sis, new TypeReference<>() {});
		
		String name = (String)map.get("name");
		int age = Integer.parseInt((String)map.get("age"));
		List<String> roles = (List<String>)map.get("roles");
		
		System.out.println("name : " + name);
		System.out.println("age : " + age);
		System.out.println("roles : " + roles.toString());
		
		// 응답
		// Map -> JSON
		String jsonString = mapper.writeValueAsString(map);
		response.getWriter().println(jsonString);
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청
		// JSON -> Users
		ServletInputStream sis = request.getInputStream();
		ObjectMapper mapper = new ObjectMapper();
		Users user = mapper.readValue(sis, Users.class);
		System.out.println("Users.class : " + Users.class);
		System.out.println("name : " + user.getName());
		System.out.println("age : " + user.getAge());
		System.out.println("roles : " + user.getRoles());
		
		// 응답
		// Users -> JSON
		String jsonString = mapper.writeValueAsString(user);
		response.getWriter().println(jsonString);
	}
}
