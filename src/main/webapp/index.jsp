<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="br.com.cast.entidade.Pessoa"%>
<%@page import="java.util.List"%>
<%@page import="br.com.cast.persistencia.DAOPessoa"%>
<html>
<body>
<h2>Hello World!</h2>

<%
DAOPessoa dao = new DAOPessoa();
List<Pessoa> p = dao.consultar();


%>
<table>

<% for (Pessoa pessoa : p) { %>

<tr>
<td><%=pessoa.getNome() %></td>

<td><%=pessoa.getCargo().getNome()%></td>
</tr>
</table>
<%} %>
</body>
</html>
