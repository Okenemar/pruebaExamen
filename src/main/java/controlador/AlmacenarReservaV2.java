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

import modelo.ParcelaModelo;
import modelo.Reserva;
import modelo.ReservaModelo;

/**
 * Servlet implementation class AlmacenarReservaV2
 */
@WebServlet("/AlmacenarReservaV2")
public class AlmacenarReservaV2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlmacenarReservaV2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("formReservaV2.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ParcelaModelo mParcela = new ParcelaModelo();
		String numero = request.getParameter("numero_parcela");
		Boolean parcelaExiste = mParcela.parcelaExiste(numero);
		if (parcelaExiste == false) {
			String numeroParcela = request.getParameter("numero_parcela");
			
			request.setAttribute("numeroParcela", numeroParcela);
			request.getRequestDispatcher("formParcela.jsp").forward(request, response);			
		}
		
		else {
			ReservaModelo mReserva = new ReservaModelo();
			Reserva reserva = new Reserva();
			
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
			
			
			if(request.getParameter("luz")==null) {
				reserva.setLuz(false);
			}else {
				reserva.setLuz(true);
			}
			
			String numeroParcela = request.getParameter("numero_parcela");
			
			
			reserva.setNombre_usuario(nombre_usuario);
			reserva.setApellido_usuario(apellido_usuario);
			reserva.setDni_usuario(dni_usuario);
			reserva.setNumero_usuarios(numero_usuarios);
			reserva.setInicio_reserva(inicio_reserva);
			reserva.setFin_reserva(fin_reserva);
			
			reserva.setId_parcela(mParcela.getIdParcela(numeroParcela).getId());
			
			mReserva.insertarReserva(reserva);
			
			request.getRequestDispatcher("Inicio").forward(request, response);
		
		}
				
		
	}

}
