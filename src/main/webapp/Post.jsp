<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Novo Post</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.css">
</head>
<body>

	<div align="center">
		<h1>Postagem</h1>

		<form action="InsertPost.jsp" method="post">

			<div class="col-sm-6">

				<div class="form-group">
					<div class="row">
						<label for="nome">Digite a url das imagens, separado por
							Enter</label>
						<textarea class="form-control" id="urlImagem" name="urlImagem"
							rows="5"></textarea>
					</div>

				</div>
				<div class="row">
					<label for="nome">Digite o texto</label> <input type="textarea"
						class="form-control" id="texto" name="texto">

				</div>

				<input type="submit" value="Salvar" class="btn btn-primary" /> <a
					href="Post.jsp" class="btn btn-light">Cancelar</a>
			</div>
			<div>

				
				
				<input type="file" name="myimagens[]" multiple="multiple">


			</div>
		</form>
		

	</div>


</body>
<script type="text/javascript">

const droppableZoneSign = document.getElementById('droppable-zone-sign')

document.addEventListener('dragenter', event => {
    droppableZoneSign.classList.add('droppable')
})

document.addEventListener('dragleave', event => {
    droppableZoneSign.classList.remove('droppable')
})

document.addEventListener('dragover', event => {
    event.stopPropagation();
    event.preventDefault();
    droppableZoneSign.classList.add('droppable')
    // isso adiciona o sinal de mais (+) ao lado do cursor para indicar ao usuário
    // que uma ação diferente será tomada
    event.dataTransfer.dropEffect = 'copy';
})

document.addEventListener('drop', event => {
    outputEl.classList.remove('droppable')
    event.stopPropagation();
    event.preventDefault();

    // trata o filesList
    appendFiles(event.dataTransfer.files)
})
</script>
</html>