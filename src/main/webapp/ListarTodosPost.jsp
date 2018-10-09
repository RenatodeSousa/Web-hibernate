<%@page import="java.util.List"%>
<%@page import="br.com.cast.ManyToOne.entidade.Imagem"%>
<%@page import="br.com.cast.ManyToOne.entidade.Post"%>
<%@page import="br.com.cast.ManyToOne.persistencia.DAOPost"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Post</title>
</head>
<body>
<%

//String id = request.getParameter("id");
//DAOPost dao = new DAOPost();
//List<Post> lsPost = dao.buscarTodos();


%>


	<div>
	<%for(Post posts: new DAOPost().buscarTodos()){ %>
		<p>		
			<%= posts.getTexto() %>
		</p>
		<p>		
			<%= posts.getData() %>
		</p>
		<p>
			<%for( Imagem i: posts.getListImg()) {%>
				<img  name="nome" width="300px" src="download?nome=<%=i.getImagem()%>" />
			<%} %>
		</p>
	<%} %>
	</div>

</body>
</html>