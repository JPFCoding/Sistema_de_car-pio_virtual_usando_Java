package VIEW;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.lang.reflect.Executable;
import java.awt.event.ActionEvent;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		panel.setBounds(0, 0, 426, 263);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnSairMenuAdministrador = new JButton("SAIR");
		btnSairMenuAdministrador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSairMenuAdministrador.setBounds(331, 10, 85, 21);
		panel.add(btnSairMenuAdministrador);
		
		JButton btnAcessarCadastrarNovoAcai = new JButton("Cadastrar novo sabor de açaí");
		btnAcessarCadastrarNovoAcai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCadastrarAcaiVIEW objcadastraracaiview = new frmCadastrarAcaiVIEW();
				objcadastraracaiview.setVisible(true);
			}
		});
		btnAcessarCadastrarNovoAcai.setBounds(10, 22, 85, 21);
		panel.add(btnAcessarCadastrarNovoAcai);
	}

}
