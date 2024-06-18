package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import DTO.novoAcaiDTO;

public class novoAcaiDAO {
	Connection conn;
	PreparedStatement pstm;
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
}
