package VIEW;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.novoAcaiDAO;
import DTO.novoAcaiDTO;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmCadastrarAcaiVIEW extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNomeAcai;
	private JTextField txtPrecoAcai;
	private JTextField txtDescricaoAcai;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmCadastrarAcaiVIEW frame = new frmCadastrarAcaiVIEW();
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
	public frmCadastrarAcaiVIEW() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(10, 10, 426, 243);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNomeAcai = new JLabel("Nome do novo sabor do açaí");
		lblNomeAcai.setBounds(21, 10, 162, 23);
		panel.add(lblNomeAcai);
		
		JLabel lblPrecoAcai = new JLabel("Preço Acai");
		lblPrecoAcai.setBounds(21, 70, 140, 23);
		panel.add(lblPrecoAcai);
		
		txtNomeAcai = new JTextField();
		txtNomeAcai.setBounds(31, 43, 152, 19);
		panel.add(txtNomeAcai);
		txtNomeAcai.setColumns(10);
		
		txtPrecoAcai = new JTextField();
		txtPrecoAcai.setBounds(31, 109, 152, 19);
		panel.add(txtPrecoAcai);
		txtPrecoAcai.setColumns(10);
		
		JLabel lblprecoAcai = new JLabel("Descrição ");
		lblprecoAcai.setBounds(21, 138, 162, 33);
		panel.add(lblprecoAcai);
		
		txtDescricaoAcai = new JTextField();
		txtDescricaoAcai.setBounds(31, 167, 152, 19);
		panel.add(txtDescricaoAcai);
		txtDescricaoAcai.setColumns(10);
		
		JButton btnCadastrarAcai = new JButton("VAMOS NESSA??");
		btnCadastrarAcai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomeAcai, precoAcai, descricaoAcai;
				nomeAcai = txtNomeAcai.getText();
				precoAcai = txtPrecoAcai.getText();
				descricaoAcai = txtDescricaoAcai.getText();
				novoAcaiDTO objnovoacaidto = new novoAcaiDTO();
				objnovoacaidto.setNome_acai(nomeAcai);
				objnovoacaidto.setPreco_acai(precoAcai);
				objnovoacaidto.setDescricao_acai(descricaoAcai);
				novoAcaiDAO objnovoacaidao = new novoAcaiDAO();
				objnovoacaidao.cadastrarAcai(objnovoacaidto); 
			}
		});
		btnCadastrarAcai.setBounds(235, 166, 122, 21);
		panel.add(btnCadastrarAcai);
		
		JButton btnSairCadastrarAcai = new JButton("SAIR");
		btnSairCadastrarAcai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSairCadastrarAcai.setBounds(316, 11, 85, 21);
		panel.add(btnSairCadastrarAcai);
	}
}
