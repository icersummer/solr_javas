<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.*, com.vjia.solr.index.*"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Java File & Index it</title>
</head>
<body>
<%
// Prompt Message

String fileName = request.getParameter("fileName");
String fileContent = request.getParameter("fileContent");
if(fileName==null || fileName.equals("")){
	out.println(" Error occur !! <br/> Form no fill !!");
} else {
	XMLCreator xc = new XMLCreator();
	// result: index 0: created or not; index 1: created xml path
	Object[] result = xc.createXML(fileName, fileContent);
	boolean created = Boolean.valueOf(result[0].toString());
	String xmlPath = (String)result[1];
	if(created){
		out.println("File Created ! : " + xmlPath);
	} else {
		out.println(" Error occur !!");
	}
}
%>

<form id="create_index_form" name="create_index_form" action="./create_java_and_index.jsp" method="post">
	<input id="fileName" name="fileName" type="text" value=""/>
	<textarea id="fileContent" name="fileName" rows="5" cols="5"></textarea>
	
	<input type="submit" name="submit" value="Create"/>
	<input type="button" name="button" value="Reset" onclick="this.form.reset()"/>
</form> 

<p/>
<a href="../index.jsp">Home Page</a>
</body>
</html>