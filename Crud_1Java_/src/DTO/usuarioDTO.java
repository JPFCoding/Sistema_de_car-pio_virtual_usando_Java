package DTO;

public class usuarioDTO {
	private int Id_Usuario;
	private String nome_usuario, senha_usuario;
	public int getId_Usuario() {
		return Id_Usuario;
	}
	public void setId_Usuario(int id_Usuario) {
		Id_Usuario = id_Usuario;
	}
	public String getNome_usuario() {
		return nome_usuario;
	}
	public void setNome_usuario(String nome_usuario) {
		this.nome_usuario = nome_usuario;
	}
	public String getSenha_usuario() {
		return senha_usuario;
	}
	public void setSenha_usuario(String senha_usuario) {
		this.senha_usuario = senha_usuario;
	}
}
