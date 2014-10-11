<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
    import="com.vjia.solr.index.*;"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Processing Java Files ... <p/>
<%
String javaFolder = request.getParameter("javaFolder");
String javaFolderPath = request.getParameter("javaFolderPath");
out.println("javaFolder=" + javaFolder);
out.println("javaFolderPath=" + javaFolderPath);

JavaIndexer indexer = new JavaIndexer();
indexer.index(javaFolderPath);
%>
<p/>
<a href="../index.jsp">Home Page</a>
</body>
</html>