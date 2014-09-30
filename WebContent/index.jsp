<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP Index</title>
</head>
<body>
<form id="select_file_form" action="./jsp/JavaIndexer.jsp" method="post">
	<input type="text" value="select the Java Folder Path to index :" />
	<br/>
	<input type="file" id="javaFolder" name="javaFolder" value="F:\gitrepo\crystall-ball\src\com\vj\crystallball" />
	<input type="text" id="javaFolderPath" name="javaFolderPath" value="F:\gitrepo\crystall-ball\src\com\vj\crystallball" />
	<input type="submit" name="button" value="Index" />	
	<input type="button" name="button" value="Reset" onclick="this.form.reset();" />
</form>
<a href="jsp/DeleteAllIndex.jsp">Delete All Index</a>
</body>
</html>