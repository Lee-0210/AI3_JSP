<%@page import="java.time.ZoneId"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.util.Date"%>
<<<<<<< HEAD
<%@page import="java.security.Timestamp"%>
<%@page import="dto.Board"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.SortedMap"%>
<%@page import="org.apache.taglibs.standard.tag.common.sql.ResultImpl"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>JSTL - SQL</title>
</head>
<body>
	<h1>게시글 목록</h1>
	<sql:setDataSource var="dataSource" 
		url="jdbc:mysql://localhost:3306/aloha?serverTimezone=Asia/Seoul&allowPublicKeyRetrieval=true&useSSL=false"
		driver="com.mysql.cj.jdbc.Driver"
		user="aloha"
		password="123456"
	/>
	<%-- <sql:query var="결과객체" dataSrouce="${dataSource}"> --%>
	<sql:query var="resultSet" dataSource="${dataSource}">
		SELECT * FROM board2
	</sql:query>
	
	<!-- ResultImpl -> Board 객체로 매핑 -->
	<%
		ResultImpl result = (ResultImpl) pageContext.getAttribute("resultSet");	
		SortedMap[] rows = result.getRows();
		List<Board> boardList = new ArrayList<Board>();
		
		for(SortedMap row : rows) {
			Board board = new Board();
			board.setNo((Integer)row.get("no"));
			board.setTitle((String)row.get("title"));
			board.setWriter((String)row.get("writer"));
			board.setContent((String)row.get("content"));
			
			LocalDateTime createdAtLDT = (LocalDateTime) row.get("created_at");
			Date createdAt = Date.from(createdAtLDT.atZone(ZoneId.systemDefault()).toInstant());
			board.setCreatedAt(createdAt);
			
			LocalDateTime updatedAtLDT = (LocalDateTime) row.get("updated_at");
			Date updatedAt = Date.from(createdAtLDT.atZone(ZoneId.systemDefault()).toInstant());
			board.setCreatedAt(updatedAt);
			
			boardList.add(board);
		}
		pageContext.setAttribute("boardList", boardList);
	%>
	
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>등록일자</th>
			<th>수정일자</th>
		</tr>
		<c:forEach var="board" items="${boardList}">
			<tr>
				<td><c:out value="${board.no }"/></td>
				<td><c:out value="${board.title }"/></td>
				<td><c:out value="${board.writer }"/></td>
				<td><fmt:formatDate value="${board.createdAt}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td><fmt:formatDate value="${board.updatedAt}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
=======
<%@page import="java.sql.Timestamp"%>
<%@page import="DTO.Board"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.SortedMap"%>
<%@page import="org.apache.taglibs.standard.tag.common.sql.ResultImpl"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>JSTL - sql</title>
</head>
<body>
	<h1>게시글 목록</h1>
	<!-- 데이터 소스 -->
	<sql:setDataSource var="dataSource" 
		url="jdbc:mysql://localhost:3306/aloha?serverTimezone=Asia/Seoul&allowPublicKeyRetrieval=true&useSSL=false"
		driver="com.mysql.cj.jdbc.Driver"
		user="aloha"
		password="123456"
	/>
	
	<%-- <sql:query var="결과객체" dataSource="${ dataSource }"></sql:query>  --%>
	<sql:query var="resultSet" dataSource="${dataSource}">
		SELECT * FROM board
	</sql:query>
	
	<!-- ResultImpl -> Board 객체로 매핑 -->
	<%
		ResultImpl  result = (ResultImpl) pageContext.getAttribute("resultSet");
		SortedMap[] rows = result.getRows();
		List<Board> boardList = new ArrayList<Board>();
		
		for( SortedMap row : rows ) {
			Board board = new Board();
			board.setNo( (Integer) row.get("no") );
			board.setTitle( (String) row.get("title") );
			board.setWriter( (String) row.get("writer") );
			board.setContent( (String) row.get("content") );
			
			LocalDateTime createdAtLDT = (LocalDateTime) row.get("created_at");
			Date createdAt = Date.from(createdAtLDT.atZone(ZoneId.systemDefault()).toInstant());
			board.setCreatedAt( createdAt );
			
			LocalDateTime updatedAtLDT = (LocalDateTime) row.get("updated_at");
			Date updatedAt = Date.from(updatedAtLDT.atZone(ZoneId.systemDefault()).toInstant());
			board.setUpdatedAt( updatedAt );
			
			boardList.add(board);
		}
		pageContext.setAttribute("boardList", boardList);
	%>
	
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>등록일자</th>
		</tr>
		<c:forEach var="board" items="${ boardList }">
			<tr>
				<td><c:out value="${ board.no }"/></td>
				<td><c:out value="${ board.title }"/></td>
				<td><c:out value="${ board.writer }"/></td>
				<td>
					<fmt:formatDate value="${ board.createdAt }" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>









>>>>>>> branch 'main' of https://github.com/Lee-0210/AI3_JSP.git
