package VIEW;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.usuarioDAO;
import DTO.usuarioDTO;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class frmLoginView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtSenha;
	private JButton btnTecladoVirtualLogin1;
	private JLabel lblNewLabel;
	private JButton btnEntrarSistema;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmLoginView frame = new frmLoginView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmLoginView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 520);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(189, 187, 187));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUsuario = new JTextField();
		txtUsuario.setBorder(null);
		txtUsuario.setBounds(109, 217, 302, 18);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtSenha = new JTextField();
		txtSenha.setBorder(null);
		txtSenha.setColumns(10);
		txtSenha.setBounds(109, 277, 302, 18);
		contentPane.add(txtSenha);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(frmLoginView.class.getResource("/Icons/LoginUmTela.png")));
		lblNewLabel.setBounds(10, -12, 626, 485);
		contentPane.add(lblNewLabel);
		
		btnTecladoVirtualLogin1 = new JButton("");
		btnTecladoVirtualLogin1.setBorder(null);
		btnTecladoVirtualLogin1.setOpaque(false);
		btnTecladoVirtualLogin1.setBounds(41, 411, 85, 43);
		contentPane.add(btnTecladoVirtualLogin1);
		
		JButton btnSairLogin1 = new JButton("");
		btnSairLogin1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSairLogin1.setBorder(null);
		btnSairLogin1.setOpaque(false);
		btnSairLogin1.setBounds(533, 411, 85, 37);
		contentPane.add(btnSairLogin1);
		
		btnEntrarSistema = new JButton("");
		btnEntrarSistema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				String nome_usuario, senha_usuario;
				nome_usuario = txtUsuario.getText();
				senha_usuario = txtSenha.getText();
				
				usuarioDTO objusuariodto = new usuarioDTO();
				objusuariodto.setNome_usuario(nome_usuario);
				objusuariodto.setSenha_usuario(senha_usuario);
				
				usuarioDAO objusuariodao = new usuarioDAO();
				ResultSet rsusuariodao = objusuariodao.autenticacaoUsuario(objusuariodto);
				
				if(rsusuariodao.next()) {
					//chamar tela que eu quero abrir
					frmMenuAdministradorView objmenuadministradorview = new frmMenuAdministradorView();
					objmenuadministradorview.setVisible(true);//aparercer a tela
					dispose();//fecha a tela que voce quer
					
				}else {
					//Enviar mensagem dizendo incorreto.
					JOptionPane.showMessageDialog(null, "Usuario ou senha invalidos");
				}
			}catch (SQLException erro) {
				JOptionPane.showMessageDialog(null, "FRMLOGINVIEW" + erro);
			}
				
			}
		});
		btnEntrarSistema.setOpaque(false);
		btnEntrarSistema.setBorderPainted(false);
		btnEntrarSistema.setBounds(409, 411, 91, 37);
		contentPane.add(btnEntrarSistema);
		
		JButton btnAbrirCaixa = new JButton("");
		btnAbrirCaixa.setBorderPainted(false);
		btnAbrirCaixa.setOpaque(false);
		btnAbrirCaixa.setBounds(294, 411, 91, 37);
		contentPane.add(btnAbrirCaixa);
	}
}
