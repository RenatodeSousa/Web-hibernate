package br.com.cast.ManyToOne.servlet;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import br.com.cast.ManyToOne.entidade.Imagem;
import br.com.cast.ManyToOne.entidade.Post;
import br.com.cast.ManyToOne.persistencia.DAOPost;


@WebServlet("/Upload")
@MultipartConfig
public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Upload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dirUpload = "c:\\imagens\\";
		String texto = request.getParameter("texto");
		
		
		Part part = request.getPart("meuArquivo");
		String arquivoOriginal = Paths.get(part.getSubmittedFileName()).toString();
		
		String extensao = arquivoOriginal.substring(arquivoOriginal.lastIndexOf("."));
		
		String nomeArquivo = UUID.randomUUID().toString()+ extensao;
		String imgCompleto = nomeArquivo;
		part.write(dirUpload + imgCompleto);
		
		DAOPost post = new DAOPost();
		Post p = new Post();
		p.setTexto(texto);
		p.setData(new Date());
		
		Imagem img = new Imagem();
		img.setImagem(imgCompleto);
		p.addListImg(img);
		
		post.inserirPost(p);
			
	}

}
