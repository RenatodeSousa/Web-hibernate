<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload</title>
</head>
<body>
	<form action="Upload" method="post" enctype="multipart/form-data">
		<div>

			Texto: <input type="text" name="texto">

		</div>
		<div>
			Arquivo: <input type="file" name="meuArquivo">

		</div>
		<div>
			<input type="submit" value="Enviar Arquivo">
		</div>
		</form>
</body>
</html>