package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Parcela;


public class ParcelaModelo extends Conector {
	PreparedStatement prt;
	//select * from parcelas
	public ArrayList<Parcela> getParcelas(){
		
		ArrayList<Parcela> parcelas = new ArrayList<>();
		
		try {
			prt = conexion.prepareStatement("SELECT * FROM parcelas");
			
			ResultSet resultado = prt.executeQuery();
			
			while(resultado.next()) {
				Parcela parcela = new Parcela();
				parcela.setId(resultado.getInt("id"));
				parcela.setNumero(resultado.getString("numero"));
				parcela.setM_cuadrados(resultado.getInt("m_cuadrados"));
				parcela.setPrecio_dia(resultado.getDouble("precio_dia"));
				
				parcelas.add(parcela);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return parcelas;
		
	}
	
	public Parcela getParcela(int id) {
		Parcela parcela = new Parcela();
		try {
			prt = conexion.prepareStatement("SELECT * FROM parcelas WHERE id=?");
			prt.setInt(1, id);
			ResultSet resultado = prt.executeQuery();
			while(resultado.next()) {
				parcela.setNumero(resultado.getString("numero"));
				parcela.setM_cuadrados(resultado.getInt("m_cuadrados"));
				parcela.setPrecio_dia(resultado.getDouble("precio_dia"));
				parcela.setId(resultado.getInt("id"));;
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return parcela;
	}
	
	public Parcela getIdParcela(String numero) {
		Parcela parcela = new Parcela();
		
		try {
			prt = conexion.prepareStatement("SELECT id FROM parcelas WHERE numero=?");
			prt.setString(1, numero);
			ResultSet resultado = prt.executeQuery();
			resultado.next();
			parcela.setId(resultado.getInt("id"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return parcela;
	}
	
	public Boolean parcelaExiste(String numero) {
		boolean parcelaExiste = false;
		try {
			prt = conexion.prepareStatement("SELECT id FROM parcelas WHERE numero=?");
			prt.setString(1, numero);
			ResultSet resultado = prt.executeQuery();
			if(resultado.next()) {
				parcelaExiste = true;
			}
			else {
				parcelaExiste = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return parcelaExiste;
	}
	
	public void insertarParcela(Parcela parcela) {
		try {
			prt = conexion.prepareStatement("INSERT INTO parcelas (numero, m_cuadrados, precio_dia) VALUES (?,?,?)");
			
			prt.setString(1, parcela.getNumero());
			prt.setInt(2, parcela.getM_cuadrados());
			prt.setDouble(3, parcela.getPrecio_dia());
			
			prt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
