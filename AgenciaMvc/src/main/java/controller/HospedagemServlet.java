package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HospedagemDao;
import model.Hospedagem;

/**
 * Servlet implementation class HospedagemServlet
 */
@WebServlet({ "/hospedagem", "/cadastrar-hospedagem", "/editar-hospedagem", "/atualizar-hospedagem", "/deletar-hospedagem" })
public class HospedagemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	HospedagemDao hospedagemDao = new HospedagemDao();
	Hospedagem hospedagem = new Hospedagem();

	public HospedagemServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		switch (action) {
		case "/hospedagem":
			read(request, response);
			break;

		case "/cadastrar-hospedagem":
			create(request, response);
			break;

		case "/editar-hospedagem":
			readById(request, response);
			break;

		case "/atualizar-hospedagem":
			update(request, response);
			break;

		case "/deletar-hospedagem":
			delete(request, response);
			break;

		default:
			response.sendRedirect("index.html");
			break;
		}

	}

	// Create
	protected void create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		hospedagem.setEmpresa(request.getParameter("empresa"));
		hospedagem.setEndereco(request.getParameter("endereco"));
		hospedagem.setData_hospedagem(request.getParameter("data"));
		hospedagem.setImagem(request.getParameter("imagem"));
		hospedagem.setValor_diaria(Double.parseDouble(request.getParameter("valor")));
		hospedagemDao.saveHosting(hospedagem);
		response.sendRedirect("hospedagem");

	}

	// Read
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Hospedagem> lista = hospedagemDao.readHosting();

		request.setAttribute("hospedagem", lista);

		RequestDispatcher rd = request.getRequestDispatcher("./view/hospedagem/index.jsp");
		rd.forward(request, response);

	}

	// Update
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		hospedagem.setId_hospedagem(Integer.parseInt(request.getParameter("id")));
		hospedagem.setImagem(request.getParameter("imagem"));
		hospedagem.setEmpresa(request.getParameter("empresa"));
		hospedagem.setEndereco(request.getParameter("endereco"));
		hospedagem.setData_hospedagem(request.getParameter("data"));
		hospedagem.setValor_diaria(Double.parseDouble(request.getParameter("valor")));
		hospedagemDao.updateHosting(hospedagem);
		response.sendRedirect("hospedagem");
	}

	// Delete
	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		hospedagemDao.deleteHosting(id);
		response.sendRedirect("hospedagem");
	}

	// Read by Id
	protected void readById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		hospedagem = hospedagemDao.getHostingById(id);

		request.setAttribute("id", hospedagem.getId_hospedagem());
		request.setAttribute("empresa", hospedagem.getEmpresa());
		request.setAttribute("endereco", hospedagem.getEndereco());
		request.setAttribute("data", hospedagem.getData_hospedagem());
		request.setAttribute("valor", hospedagem.getValor_diaria());
		request.setAttribute("imagem", hospedagem.getImagem());

		RequestDispatcher rd = request.getRequestDispatcher("./view/hospedagem/atualizar.jsp");
		rd.forward(request, response);

	}

}
