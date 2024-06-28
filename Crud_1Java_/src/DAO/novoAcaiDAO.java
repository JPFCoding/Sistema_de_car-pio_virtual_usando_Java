package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DTO.novoAcaiDTO;

public class novoAcaiDAO {
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;
	ArrayList<novoAcaiDTO> lista = new ArrayList<>();
	public void cadastrarAcai(novoAcaiDTO objnovoacaidto) {
	String sql = "insert into acai (nome_acai, descricao_acai, preco_acai) values (?, ?, ?) ";
	conn = new ConexaoDAO().conectaBD();
	
	try {
		
		pstm = conn.prepareStatement(sql);
		pstm.setString(1, objnovoacaidto.getNome_acai());
		pstm.setString(2, objnovoacaidto.getDescricao_acai());
		pstm.setString(3, objnovoacaidto.getPreco_acai());
		
		pstm.execute();
		pstm.close();
		
	} catch (Exception erro) {
		JOptionPane.showMessageDialog(null, "novoAcaiDAO" + erro);
	}
	}
	public ArrayList<novoAcaiDTO> pesquisarSabor(){
		String sql = "select *from acai";
		conn = new ConexaoDAO().conectaBD();
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()){
				novoAcaiDTO objnovoacaidto = new novoAcaiDTO();
				objnovoacaidto.setId_acai(rs.getInt("id_acai"));
				objnovoacaidto.setNome_acai(rs.getString("nome_acai"));
				objnovoacaidto.setDescricao_acai(rs.getString("descricao_acai"));
				objnovoacaidto.setPreco_acai(rs.getString("preco_acai"));
				
				lista.add(objnovoacaidto);
			} 
		}
			catch (SQLException erro) {
			JOptionPane.showConfirmDialog(null, "novoAcaiDAO Pesquisar" + erro);
		}
		return(lista);
}
	public void alterarNovoAcai(novoAcaiDTO objnovoacaidto){
		String sql = "update acai set nome_acai = ? , descricao_acai = ?, preco_acai = ? where id_acai = ?";
		
		conn = new ConexaoDAO().conectaBD();
		
		try {
			
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, objnovoacaidto.getNome_acai());
			pstm.setString(2, objnovoacaidto.getDescricao_acai());
			pstm.setString(3, objnovoacaidto.getPreco_acai());
			pstm.setInt(4, objnovoacaidto.getId_acai());
			
			pstm.execute();
			pstm.close();
			
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "alterarNovoAcaiDTO" + erro);
		}
	}
	public void excluirNovoAcai(novoAcaiDTO objnovoacaidto) {
		String sql = "delete from acai where id_acai = ?";
		conn = new ConexaoDAO().conectaBD();
		try {
			
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, objnovoacaidto.getId_acai());
			
			pstm.execute();
			pstm.close();
			
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "excluirNovoAcai" + erro);
		}
	}
}
