package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;

public class ReservaModelo extends Conector {
	PreparedStatement prt;
	/*
	 * "INSERT INTO reservas(nombre_usuario, apellido_usuario, dni_usuario, numero_usuarios, inicio_reserva, fin_reserva,  luz, id_parcela) "
	 * + "VALUES (?,?,?,?,?,?,?,?)"
	 * 
	 * "DELETE FROM reservas WHERE id = ?"
	 */

	public void insertarReserva(Reserva reserva) {
		try {
			prt = conexion.prepareStatement(
					"INSERT INTO reservas(nombre_usuario, apellido_usuario, dni_usuario, numero_usuarios, inicio_reserva, fin_reserva, luz, id_parcela)VALUES (?,?,?,?,?,?,?,?)");
			prt.setString(1, reserva.getNombre_usuario());
			prt.setString(2, reserva.getApellido_usuario());
			prt.setString(3, reserva.getDni_usuario());
			prt.setInt(4, reserva.getNumero_usuarios());
			prt.setDate(5, new Date(reserva.getInicio_reserva().getTime()));
			prt.setDate(6, new Date(reserva.getFin_reserva().getTime()));
			prt.setBoolean(7, reserva.isLuz());
//			prt.setInt(8, reserva.getParcela().getId()); no usar
			prt.setInt(8, reserva.getId_parcela());

			prt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void EliminarReserva(int id) {

		try {
			prt = conexion.prepareStatement("DELETE FROM reservas WHERE id=?");
			prt.setInt(1, id);

			prt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Reserva getReserva(int id) {
		Reserva reserva = new Reserva();
		try {
			prt = conexion.prepareStatement("SELECT * FROM reservas WHERE id=?");
			prt.setInt(1, id);
			ResultSet resultado = prt.executeQuery();
			while (resultado.next()) {
				reserva.setNombre_usuario(resultado.getString("nombre_usuario"));
				reserva.setApellido_usuario(resultado.getString("apellido_usuario"));
				reserva.setDni_usuario(resultado.getString("dni_usuario"));
				reserva.setNumero_usuarios(resultado.getInt("numero_usuarios"));
				reserva.setInicio_reserva(resultado.getDate("inicio_reserva"));
				reserva.setFin_reserva(resultado.getDate("fin_reserva"));
				reserva.setLuz(resultado.getBoolean("luz"));
				reserva.setId(resultado.getInt(9));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reserva;

	}

	public int getmaxIdReserva() {
		int maxId = 0;
		try {
			prt = conexion.prepareStatement("SELECT MAX(id) FROM reservas");
			ResultSet rs = prt.executeQuery();
			maxId = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return maxId;

	}
	
	
}