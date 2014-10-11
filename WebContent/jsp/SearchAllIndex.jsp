<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.*, com.vjia.solr.search.JavaSearcher"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index Searcher (by all fields)</title>
</head>
<body>
<form id="search_index_form" name="search_index_form" action="./SearchAllIndex.jsp" method="post">
	<input id="input_key" name="input_key" type="text" value="" />
	<input type="submit" name="submit" value="Search"/>
	<input type="button" name="button" value="Reset" onclick="this.form.reset()"/>
</form>
<%
Collection javaEntities = null;
String inputKey = request.getParameter("input_key");
if(inputKey==null || inputKey.equals("")){
	// no search
} else {
	JavaSearcher javaSearcher = new JavaSearcher();
	javaEntities = javaSearcher.searchAllByKey(inputKey);
}
// loop collection to render the View
%>
<%
if(javaEntities != null && !javaEntities.isEmpty()) {
	out.println("Get result count : "+javaEntities.size());
	out.println(javaEntities);
} else {
	out.println("No result found.");
}
%>

<%-- TODO: the render can be a ajax way, search by button, show below button, without page refresh --%>
<p/>
<a href="../index.jsp">Home Page</a>
</body>
</html>