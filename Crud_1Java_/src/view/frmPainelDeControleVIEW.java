package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.novoAcaiDAO;
import DTO.novoAcaiDTO;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import java.awt.Font;

public class frmPainelDeControleVIEW extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNomeAcai;
	private JTextField txtPrecoAcai;
	private JTextField txtDescricaoAcai;
	private JTable tabelaSaboresAcai;
	private JLabel lblNome;
	private JLabel lblCodigo;
	private JLabel lblPrecoUnid;
	private JTextField txtIdAcai;
	private JButton btnAlterar;
	private JButton btnExcluir;
	

	/**
	 * Launch the application.
	 */
	private void listarSaboresAcai() {
		try {
			novoAcaiDAO objnovoacaidao = new novoAcaiDAO();
			DefaultTableModel model = (DefaultTableModel) tabelaSaboresAcai.getModel();
			model.setNumRows(0);
			ArrayList<novoAcaiDTO> lista = objnovoacaidao.pesquisarSabor();
			for(int num = 0; num < lista.size(); num ++) {
				model.addRow(new Object[] {
						lista.get(num).getId_acai(),
						lista.get(num).getNome_acai(),
						lista.get(num).getDescricao_acai(),
						lista.get(num).getPreco_acai()
						
				});
			}
		} catch (Exception erro) {
			JOptionPane.showInternalMessageDialog(null,"Listar valores VIEW:" + erro);
		}
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmPainelDeControleVIEW frame = new frmPainelDeControleVIEW();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private void alterarSabor() {
		int id_acai;
		String nome_acai, preco_acai, descricao_acai;//passar pra DTO
		id_acai =Integer.parseInt(txtIdAcai.getText());//passar o id pra variavel e depois pra dto.
		nome_acai = txtNomeAcai.getText();
		preco_acai = txtPrecoAcai.getText();
		descricao_acai = txtDescricaoAcai.getText();
		novoAcaiDTO objnovoacaidto = new novoAcaiDTO();//Instanciando para acessar a classe
		objnovoacaidto.setId_acai(id_acai);
		objnovoacaidto.setNome_acai(nome_acai);
		objnovoacaidto.setDescricao_acai(descricao_acai);
		objnovoacaidto.setPreco_acai(preco_acai);
		
		novoAcaiDAO objnovoacaidao = new novoAcaiDAO();
		objnovoacaidao.alterarNovoAcai(objnovoacaidto);
	}
	
	private void CarregarCampos() {
		int setar = tabelaSaboresAcai.getSelectedRow();//selecionar a linha da tabela :)
		txtIdAcai.setText(tabelaSaboresAcai.getModel().getValueAt(setar, 0).toString());//Pega linha e coluna que o usuario quer. Coluna zero, setar=linha do id que ele vai digitar.
		txtNomeAcai.setText(tabelaSaboresAcai.getModel().getValueAt(setar, 1).toString());
		txtDescricaoAcai.setText(tabelaSaboresAcai.getModel().getValueAt(setar, 2).toString());
		txtPrecoAcai.setText(tabelaSaboresAcai.getModel().getValueAt(setar, 3).toString());
	}
	private void CadastrarSabor(){
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
	private void LimparCampos() {
		txtIdAcai.setText("");
		txtDescricaoAcai.setText("");
		txtNomeAcai.setText("");
		txtPrecoAcai.setText("");
		txtNomeAcai.requestFocus();
	}
	private void excluirSaborAcai() {
		int id_acai;
		id_acai = Integer.parseInt(txtIdAcai.getText());
		novoAcaiDTO objnovoacaidto = new novoAcaiDTO();
		objnovoacaidto.setId_acai(id_acai);
		
		novoAcaiDAO objnovoacaidao = new novoAcaiDAO();
		objnovoacaidao.excluirNovoAcai(objnovoacaidto);
		
	}
	/**
	 * Create the frame.
	 */
	public frmPainelDeControleVIEW() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtIdAcai = new JTextField();
		txtIdAcai.setEditable(false);
		txtIdAcai.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtIdAcai.setBounds(278, 218, 449, 51);
		contentPane.add(txtIdAcai);
		txtIdAcai.setColumns(10);
		
		lblPrecoUnid = new JLabel("VALOR DO ITEM R$");
		lblPrecoUnid.setToolTipText("");
		lblPrecoUnid.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblPrecoUnid.setBounds(739, 324, 226, 39);
		contentPane.add(lblPrecoUnid);
		
		lblCodigo = new JLabel("DESCRIÇÃO");
		lblCodigo.setToolTipText("");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblCodigo.setBounds(504, 324, 226, 39);
		contentPane.add(lblCodigo);
		
		lblNome = new JLabel("NOME");
		lblNome.setToolTipText("");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNome.setBounds(278, 324, 226, 39);
		contentPane.add(lblNome);
		
		JLabel lbliD = new JLabel("            ID");
		lbliD.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lbliD.setToolTipText("");
		lbliD.setBounds(47, 324, 226, 39);
		contentPane.add(lbliD);
		
		txtNomeAcai = new JTextField();
		txtNomeAcai.setToolTipText("");
		txtNomeAcai.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNomeAcai.setBounds(278, 0, 449, 55);
		contentPane.add(txtNomeAcai);
		txtNomeAcai.setColumns(10);
		
		txtPrecoAcai = new JTextField();
		txtPrecoAcai.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPrecoAcai.setBounds(278, 75, 449, 51);
		contentPane.add(txtPrecoAcai);
		txtPrecoAcai.setColumns(10);
		
		txtDescricaoAcai = new JTextField();
		txtDescricaoAcai.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDescricaoAcai.setBounds(278, 145, 449, 51);
		contentPane.add(txtDescricaoAcai);
		txtDescricaoAcai.setColumns(10);
		
		tabelaSaboresAcai = new JTable();
		tabelaSaboresAcai.setBounds(42, 364, 925, 387);
		contentPane.add(tabelaSaboresAcai);
		tabelaSaboresAcai.setGridColor(new Color(0, 0, 0));
		tabelaSaboresAcai.setAutoscrolls(false);
		tabelaSaboresAcai.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"ID", "Nome do a\u00E7a\u00ED", "pre\u00E7o do A\u00E7a\u00ED", "Descri\u00E7\u00E3o"
			}
		));
		tabelaSaboresAcai.setToolTipText("");
		tabelaSaboresAcai.setForeground(new Color(0, 0, 0));
		tabelaSaboresAcai.setBackground(new Color(255, 255, 255));
		
		JLabel lblFundo = new JLabel("");
		lblFundo.setIcon(new ImageIcon(frmPainelDeControleVIEW.class.getResource("/Icons/Tentando DeNovo(1).png")));
		lblFundo.setBounds(0, 0, 1530, 835);
		contentPane.add(lblFundo);
		
		JButton btnSairCadastrarAcai = new JButton("");
		btnSairCadastrarAcai.setOpaque(false);
		btnSairCadastrarAcai.setBorderPainted(false);
		btnSairCadastrarAcai.setBounds(1299, 726, 191, 90);
		contentPane.add(btnSairCadastrarAcai);
		
		JButton btnPesquisarSabores = new JButton("");
		btnPesquisarSabores.setBorderPainted(false);
		btnPesquisarSabores.setOpaque(false);
		btnPesquisarSabores.setBounds(1078, 26, 440, 128);
		contentPane.add(btnPesquisarSabores);
		btnPesquisarSabores.setHideActionText(true);
		
		btnAlterar = new JButton("");
		btnAlterar.setOpaque(false);
		btnAlterar.setBorderPainted(false);
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarSabor();
				listarSaboresAcai();
				LimparCampos();
			}
		});
		btnAlterar.setBounds(759, 207, 274, 62);
		contentPane.add(btnAlterar);
		
		btnExcluir = new JButton("");
		btnExcluir.setOpaque(false);
		btnExcluir.setBorderPainted(false);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirSaborAcai();
				listarSaboresAcai();
				LimparCampos();
			}
			
		});
		btnExcluir.setBounds(759, 136, 272, 60);
		contentPane.add(btnExcluir);
		
		JButton btnCarregarCampos = new JButton("");
		btnCarregarCampos.setBorderPainted(false);
		btnCarregarCampos.setOpaque(false);
		btnCarregarCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarregarCampos();
				listarSaboresAcai();
			}
		});
		btnCarregarCampos.setBounds(769, 64, 264, 62);
		contentPane.add(btnCarregarCampos);
		
		JButton btnCadastrarAcai = new JButton("");
		btnCadastrarAcai.setOpaque(false);
		btnCadastrarAcai.setBorderPainted(false);
		btnCadastrarAcai.setBounds(759, 0, 274, 55);
		contentPane.add(btnCadastrarAcai);
		btnCadastrarAcai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarSabor(); 
				listarSaboresAcai();
				LimparCampos();
			}
		});
		btnPesquisarSabores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarSaboresAcai();
			}
		});
		btnSairCadastrarAcai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMenuAdministradorView objadministrador = new frmMenuAdministradorView();
				objadministrador.setVisible(true);
				dispose();
			}
		});
		listarSaboresAcai();/*execução automática após o método construtor.*/
	}
	
}
