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
 * Servlet implementation class ConfirmarReserva
 */
@WebServlet("/AlmacenarReserva")
public class AlmacenarReserva extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlmacenarReserva() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ParcelaModelo mParcela = new ParcelaModelo();
		int idParcela = Integer.parseInt(request.getParameter("id_parcela"));
		Parcela parcela = mParcela.getParcela(idParcela);
		
		request.setAttribute("parcela", parcela);
		request.getRequestDispatcher("formReserva.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReservaModelo mReserva = new ReservaModelo();
		
		
		String nombre_usuario = request.getParameter("nombre");
		String apellido_usuario = request.getParameter("apellido");
		String dni_usuario = request.getParameter("dni");
		int numero_usuarios = Integer.parseInt(request.getParameter("numero_personas"));
		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
		Date inicio_reserva = new Date();
		try {
			inicio_reserva = formato.parse(request.getParameter("fecha_inicio"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date fin_reserva = new Date();
		try {
			fin_reserva = formato.parse(request.getParameter("fecha_fin"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		Boolean luz = Boolean.parseBoolean(request.getParameter("luz"));
		int id_parcela = Integer.parseInt(request.getParameter("id_parcela"));
		
		Reserva reserva = new Reserva();
		reserva.setNombre_usuario(nombre_usuario);
		reserva.setApellido_usuario(apellido_usuario);
		reserva.setDni_usuario(dni_usuario);
		reserva.setNumero_usuarios(numero_usuarios);
		reserva.setInicio_reserva(inicio_reserva);
		reserva.setFin_reserva(fin_reserva);
		reserva.setLuz(luz);
		reserva.setId_parcela(id_parcela);
		
		
		
		
		mReserva.insertarReserva(reserva);
		
		request.getRequestDispatcher("infoReserva.jsp").forward(request, response);
	}

}
