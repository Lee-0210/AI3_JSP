package content;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

import dto.MapWrapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import util.XmlMapper;

/**
 * Servlet implementation class XmlServlet
 */
@WebServlet("/XmlServlet")
public class XmlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * curl -X GET http://localhost:8090/Servlet/XmlServlet ^
	 * -H "Content-Type: application.xml" ^
	 * -d "<Users><name>ALOHA</name><age>20</age></Users>"
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/xml; charset=utf-8");
		// 요청
		// xml --> Map
		BufferedReader reader = request.getReader();
		StringBuilder sb = new StringBuilder();
		String line;
		while((line = reader.readLine()) != null) {
			sb.append(line);
		}
		String xml = sb.toString();
		Map<String, Object> map = null;
		try {
			map = XmlMapper.toMap(xml);
		} catch (Exception e) {
			System.err.println("XML -> Map 변환 중 에러 발생");
		}
		
		map.entrySet()
		   .stream()
		   .forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));
		
		
		// map --> xml
		JAXBContext context = null;
		try {
			// Map 을 MapWrapper 로 포함
			MapWrapper wrapper = new MapWrapper(map);
			// JAXBContext 객체 생성
			context = JAXBContext.newInstance(MapWrapper.class);
			// 마샬링 	: 객체 --> XML
			// 언마샬링	: XML --> 객체
			// 객체를 XML 로 변환해주는 객체, 마샬러 생성
			Marshaller marshaller = context.createMarshaller();
			// XML 태그의 들여쓰기를 해주는 역할
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			// 문자열을 메모리에서 사용하는 객체 (StringWriter)
			StringWriter stringWriter = new StringWriter();
			// 객체 --> XML 로 변환
			// mashaller.marshal(변환할 클래스, StringWriter객체);
			marshaller.marshal(wrapper, stringWriter);
			xml = stringWriter.toString();
		} catch (Exception e) {
			System.err.println("map --> xml 변환 시 에러");
		}
		
		System.out.println("map --> xml : ");
		System.out.println(xml);
		response.getWriter().println(xml);
		
		
		
		// JSON 객체 생성 (연습)
//		ObjectMapper mapper = new ObjectMapper();
//        ObjectNode json = mapper.createObjectNode();
//        json.put("name", "ALOHA");
//        json.put("age", 20);
//        response.getWriter().println(json.toPrettyString());
        
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
