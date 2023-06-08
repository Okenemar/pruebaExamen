package controlador;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Parcela;
import modelo.ParcelaModelo;
import modelo.Reserva;
import modelo.ReservaModelo;

/**
 * Servlet implementation class IniciarReserva
 */
@WebServlet("/IniciarReserva")
public class IniciarReserva extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IniciarReserva() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ParcelaModelo mParcela = new ParcelaModelo();
		int idParcela = Integer.parseInt(request.getParameter("id"));
		Parcela parcela = mParcela.getParcela(idParcela);
		
		request.setAttribute("parcela", parcela);
		request.getRequestDispatcher("formReserva.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		

	}

}
