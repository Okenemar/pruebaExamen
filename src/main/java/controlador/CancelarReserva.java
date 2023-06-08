package controlador;

import java.io.IOException;
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
 * Servlet implementation class CancelarReserva
 */
@WebServlet("/CancelarReserva")
public class CancelarReserva extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelarReserva() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO implementar la eliminacion de la reserva
		//abrir la vista confirmacion.jsp
		ParcelaModelo mParcela = new ParcelaModelo();
		int idParcela = Integer.parseInt(request.getParameter("id"));
		Parcela parcela = mParcela.getParcela(idParcela);
		
		ReservaModelo mReserva = new ReservaModelo();
		String nombre_usuario = request.getParameter("nombre_usuario");
		String apellido_usuario = request.getParameter("apellido_usuario");
		
		
		request.setAttribute("parcela", parcela);
		request.getRequestDispatcher("infoReserva.jsp").forward(request, response);
		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
