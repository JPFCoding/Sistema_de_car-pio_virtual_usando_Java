package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.lang.reflect.Executable;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class frmMenuAdministradorView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmMenuAdministradorView frame = new frmMenuAdministradorView();
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
	public frmMenuAdministradorView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(217, 108, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTelaAdministradorView = new JLabel("");
		lblTelaAdministradorView.setIcon(new ImageIcon(frmMenuAdministradorView.class.getResource("/Icons/TelaAdministradorRedmens1530_835.png")));
		lblTelaAdministradorView.setBounds(0, 0, 1530, 835);
		contentPane.add(lblTelaAdministradorView);
		
		JButton btnAcessarCadastrarNovoAcai = new JButton("");
		btnAcessarCadastrarNovoAcai.setOpaque(false);
		btnAcessarCadastrarNovoAcai.setBounds(128, 265, 623, 199);
		contentPane.add(btnAcessarCadastrarNovoAcai);
		
		JButton btnSairMenuAdministrador = new JButton("");
		btnSairMenuAdministrador.setOpaque(false);
		btnSairMenuAdministrador.setBounds(99, 718, 199, 77);
		contentPane.add(btnSairMenuAdministrador);
		
		JButton btnTelaVendas = new JButton("");
		btnTelaVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaVendendoView objtelavendendoview = new TelaVendendoView();
				objtelavendendoview.setVisible(true);
				dispose();
			}
		});
		btnTelaVendas.setOpaque(false);
		btnTelaVendas.setBounds(866, 599, 631, 182);
		contentPane.add(btnTelaVendas);
		btnSairMenuAdministrador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLoginView objlogin = new frmLoginView();
				objlogin.setVisible(true);
				dispose();
			}
		});
		btnAcessarCadastrarNovoAcai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPainelDeControleVIEW objcadastraracaiview = new frmPainelDeControleVIEW();
				objcadastraracaiview.setVisible(true);
				dispose();
			}
		});
	}
}
