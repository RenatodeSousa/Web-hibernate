package br.com.cast.ManyToOne.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cast.ManyToOne.entidade.Imagem;
import br.com.cast.ManyToOne.entidade.Post;
import br.com.cast.ManyToOne.persistencia.DAOPost;

@WebServlet("/download")
public class download extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String diretorio = "C:\\imagens\\";
		String nome= request.getParameter("nome");

		String dirUpload = diretorio + nome;

		File file = new File(dirUpload);

		FileInputStream in = new FileInputStream(file);
		byte[] bytes = new byte[(int) file.length()];
		in.read(bytes);

		response.setContentType("image/jpeg");

		response.getOutputStream().write(bytes);
	}


}
