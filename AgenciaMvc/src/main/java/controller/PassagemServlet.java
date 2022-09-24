package controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PassagemDao;
import model.Passagem;

/**
 * Servlet implementation class PassagemServlet
 */
@WebServlet({"/passagem", "/cadastrar-passagem", "/editar-passagem", "/atualizar-passagem", "/deletar-passagem"})
public class PassagemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	PassagemDao passagemDao = new PassagemDao();
	Passagem passagem = new Passagem();

	public PassagemServlet() {
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
		case "/passagem":
			read(request, response);
			break;

		case "/cadastrar-passagem":
			create(request, response);
			break;

		case "/editar-passagem":
			readById(request, response);
			break;
			
		case "/atualizar-passagem":
			update(request, response);
			break;
			
		case "/deletar-passagem":
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

		passagem.setEmpresa(request.getParameter("empresa"));
		passagem.setEmbarque(request.getParameter("embarque"));
		passagem.setDesembarque(request.getParameter("desembarque"));
		passagem.setData_passagem(request.getParameter("data"));
		passagem.setValor_passagem(Double.parseDouble(request.getParameter("valor")));
		passagemDao.saveTicket(passagem);
		response.sendRedirect("passagem");

	}

	// Read
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Passagem> lista = passagemDao.readTicket();

		request.setAttribute("passagem", lista);

		RequestDispatcher rd = request.getRequestDispatcher("./view/passagem/index.jsp");
		rd.forward(request, response);

	}

	// Update
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/* usuario.setId_usuario(Integer.parseInt(request.getParameter("id"))); */
		passagem.setEmpresa(request.getParameter("empresa"));
		passagem.setEmbarque(request.getParameter("embarque"));
		passagem.setDesembarque(request.getParameter("desembarque"));
		passagem.setData_passagem(request.getParameter("data"));
		passagem.setValor_passagem(Double.parseDouble(request.getParameter("valor")));
		passagemDao.updateTicket(passagem);
		response.sendRedirect("passagem");
	}

	// Delete
	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		passagemDao.deleteTicket(id);
		response.sendRedirect("passagem");
	}


	// Read by Id
	protected void readById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		int id = Integer.parseInt(request.getParameter("id"));
		
		passagem = passagemDao.getTicketById(id);
		
		
		request.setAttribute("id", passagem.getId_passagem());
		request.setAttribute("empresa", passagem.getEmpresa());
		request.setAttribute("embarque", passagem.getEmbarque());
		request.setAttribute("desembarque", passagem.getDesembarque());
		request.setAttribute("data", passagem.getData_passagem());
		request.setAttribute("valor", passagem.getValor_passagem());
		
		RequestDispatcher rd = request.getRequestDispatcher("./view/passagem/atualizar.jsp");
		rd.forward(request, response);
		
	}

}
