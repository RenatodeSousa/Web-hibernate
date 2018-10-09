<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="br.com.cast.ManyToOne.entidade.Post"%>
<%@page import="br.com.cast.ManyToOne.entidade.Imagem"%>
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
		String imgs = request.getParameter("urlImagem");
		String texto = request.getParameter("texto");
		//String im = request.getParameter("imagens");
		

		 List<String> urlImagens = Arrays.asList(imgs.replace("\r", "").split("\n"));
		
		DAOPost dao = new DAOPost();

		Post p = new Post();
		p.setTexto(texto);
		p.setData(new Date());

		for (String urlImagem : urlImagens) {
			Imagem i = new Imagem();
			i.setImagem(urlImagem);
			p.addListImg(i);
		}

		dao.inserirPost(p); 
	%>
</body>
</html>