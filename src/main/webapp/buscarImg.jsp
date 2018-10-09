<%@page import="br.com.cast.ManyToOne.entidade.Imagem"%>
<%@page import="br.com.cast.ManyToOne.entidade.Post"%>
<%@page import="br.com.cast.ManyToOne.persistencia.DAOPost"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%

String id = request.getParameter("id");
DAOPost dao = new DAOPost();
Post ps = dao.buscarPorIdpost(Integer.parseInt(id));


%>


	<div>
		<p>		
			<%= ps.getTexto() %>
		</p>
		<p>		
			<%= ps.getData() %>
		</p>
		<p>
			<%for( Imagem i: ps.getListImg()) {%>
				<img  name="nome" width="300px" src="download?nome=<%=i.getImagem()%>" />
			<%} %>
		</p>
	
	</div>

</body>
</html>