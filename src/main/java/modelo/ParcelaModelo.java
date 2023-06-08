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
				parcela.setId(resultado.getInt(1));
				parcela.setNumero(resultado.getString(2));
				parcela.setM_cuadrados(resultado.getInt(3));
				parcela.setPrecio_dia(resultado.getDouble(4));
				
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
				parcela.setNumero(resultado.getString(1));
				parcela.setM_cuadrados(resultado.getInt(2));
				parcela.setPrecio_dia(resultado.getDouble(3));
				parcela.setId(resultado.getInt(4));;
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return parcela;
	}
	

	


}
