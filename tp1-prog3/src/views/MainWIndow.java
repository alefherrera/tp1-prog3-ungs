package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

import models.Adjetivo;
import models.Sustantivo;
import models.Verbo;
import services.PalabraService;
import enums.Genero;
import enums.Numero;
import enums.Tiempo;
import enums.Topico;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainWIndow {

	private JFrame frame;
	private JTextField textSustantivo;
	private JTextField textVerbo;
	private JTextField textAdjetivo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWIndow window = new MainWIndow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWIndow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 530, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblSustantivo = new JLabel("Sustantivo");
		lblSustantivo.setBounds(10, 11, 86, 14);
		frame.getContentPane().add(lblSustantivo);

		textSustantivo = new JTextField();
		textSustantivo.setBounds(10, 32, 86, 20);
		frame.getContentPane().add(textSustantivo);
		textSustantivo.setColumns(10);

		JComboBox cmbGenero = new JComboBox();
		cmbGenero.setModel(new DefaultComboBoxModel(Genero.values()));
		cmbGenero.setBounds(106, 32, 84, 20);
		frame.getContentPane().add(cmbGenero);

		JComboBox cmbNumero = new JComboBox();
		cmbNumero.setModel(new DefaultComboBoxModel(Numero.values()));
		cmbNumero.setBounds(200, 32, 75, 20);
		frame.getContentPane().add(cmbNumero);

		JComboBox cmbTopico = new JComboBox();
		cmbTopico.setModel(new DefaultComboBoxModel(Topico.values()));
		cmbTopico.setBounds(285, 32, 75, 20);
		frame.getContentPane().add(cmbTopico);

		JButton btnAgregarSustantivo = new JButton("Agregar");
		btnAgregarSustantivo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Sustantivo sustantivo = new Sustantivo(
						textSustantivo.getText(), (Genero) cmbGenero
								.getSelectedItem(), (Numero) cmbNumero
								.getSelectedItem(), (Topico) cmbTopico
								.getSelectedItem());
				PalabraService.getInstance().agregarSustantivo(sustantivo);
			}
		});
		btnAgregarSustantivo.setBounds(370, 31, 89, 23);
		frame.getContentPane().add(btnAgregarSustantivo);

		JLabel lblVerbo = new JLabel("Verbo");
		lblVerbo.setBounds(10, 63, 46, 14);
		frame.getContentPane().add(lblVerbo);

		textVerbo = new JTextField();
		textVerbo.setBounds(10, 88, 86, 20);
		frame.getContentPane().add(textVerbo);
		textVerbo.setColumns(10);

		JComboBox cmbTiempo = new JComboBox();
		cmbTiempo.setModel(new DefaultComboBoxModel(Tiempo.values()));
		cmbTiempo.setBounds(106, 88, 84, 20);
		frame.getContentPane().add(cmbTiempo);

		JButton btnAgregarVerbo = new JButton("Agregar");
		btnAgregarVerbo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Verbo verbo = new Verbo(textVerbo.getText(), (Tiempo) cmbTiempo
						.getSelectedItem());
				PalabraService.getInstance().agregarVerbo(verbo);
			}
		});
		btnAgregarVerbo.setBounds(370, 87, 89, 23);
		frame.getContentPane().add(btnAgregarVerbo);

		JLabel lblAdjetivo = new JLabel("Adjetivo");
		lblAdjetivo.setBounds(10, 119, 46, 14);
		frame.getContentPane().add(lblAdjetivo);

		textAdjetivo = new JTextField();
		textAdjetivo.setBounds(10, 144, 86, 20);
		frame.getContentPane().add(textAdjetivo);
		textAdjetivo.setColumns(10);

		JButton btnAgregarAdjetivo = new JButton("Agregar");
		btnAgregarAdjetivo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Adjetivo adjetivo = new Adjetivo(textAdjetivo.getText());
				PalabraService.getInstance().agregarAdjetivo(adjetivo);
			}
		});
		btnAgregarAdjetivo.setBounds(370, 143, 89, 23);
		frame.getContentPane().add(btnAgregarAdjetivo);
		
		JButton btnPersistir = new JButton("Persistir");
		btnPersistir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				PalabraService.getInstance().PersistirTodo();
			}
		});
		btnPersistir.setBounds(186, 212, 89, 23);
		frame.getContentPane().add(btnPersistir);
	}
}
