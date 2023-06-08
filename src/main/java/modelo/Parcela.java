package modelo;

import java.util.ArrayList;
/**
 * 
 * @author Eñaut
 * Esta clase DTO representa la entidad
 * PARCELA de la BBDD
 *
 */
public class Parcela {
	//TODO crear los atributos pribados, setters y getters
	private int id;
	private String numero;
	private int m_cuadrados;
	private double precio_dia;
	private ArrayList<Reserva> reservas;
	
	public Parcela(int id, String numero, int m_cuadrados, double precio_dia, ArrayList<Reserva> reservas) {
		super();
		this.id = id;
		this.numero = numero;
		this.m_cuadrados = m_cuadrados;
		this.precio_dia = precio_dia;
		this.reservas = reservas;
	}

	public Parcela() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public int getM_cuadrados() {
		return m_cuadrados;
	}

	public void setM_cuadrados(int m_cuadrados) {
		this.m_cuadrados = m_cuadrados;
	}

	public double getPrecio_dia() {
		return precio_dia;
	}

	public void setPrecio_dia(double precio_dia) {
		this.precio_dia = precio_dia;
	}
	
	

	public ArrayList<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(ArrayList<Reserva> reservas) {
		this.reservas = reservas;
	}

	@Override
	public String toString() {
		return "Parcela [id=" + id + ", numero=" + numero + ", m_cuadrados=" + m_cuadrados + ", precio_dia="
				+ precio_dia + ", reservas=" + reservas + "]";
	}
	
	
	
}
