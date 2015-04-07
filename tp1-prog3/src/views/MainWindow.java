package views;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import models.Adjetivo;
import models.Sustantivo;
import models.Verbo;
import services.PalabraService;
import enums.Genero;
import enums.Numero;
import enums.Tiempo;
import enums.Topico;

public class MainWindow {

	private JFrame frmIngre;
	private JTextField textSustantivo;
	private JTextField textVerbo;
	private JTextField textAdjetivo;
	private JLabel lblEstado;
	private JComboBox<Genero> cmbGenero;
	private JComboBox<Topico> cmbTopico;
	private JComboBox<Tiempo> cmbTiempo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmIngre.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIngre = new JFrame();
		frmIngre.setResizable(false);
		frmIngre.setTitle("Ingreso palabras");
		frmIngre.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				PalabraService.getInstance().PersistirTodo();
			}
		});
		frmIngre.setBounds(100, 100, 486, 326);
		frmIngre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIngre.getContentPane().setLayout(null);

		JLabel lblSustantivo = new JLabel("Sustantivo");
		lblSustantivo.setBounds(10, 11, 86, 14);
		frmIngre.getContentPane().add(lblSustantivo);

		textSustantivo = new JTextField();
		textSustantivo.setBounds(10, 32, 171, 20);
		frmIngre.getContentPane().add(textSustantivo);
		textSustantivo.setColumns(10);

		cmbGenero = new JComboBox<Genero>();
		cmbGenero.setModel(new DefaultComboBoxModel<Genero>(Genero.values()));
		cmbGenero.setBounds(191, 32, 84, 20);
		frmIngre.getContentPane().add(cmbGenero);

		cmbTopico = new JComboBox<Topico>();
		cmbTopico.setModel(new DefaultComboBoxModel<Topico>(Topico.values()));
		cmbTopico.setBounds(285, 32, 75, 20);
		frmIngre.getContentPane().add(cmbTopico);

		JButton btnAgregarSustantivo = new JButton("Agregar");
		btnAgregarSustantivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAgregarSustantivo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Sustantivo sustantivo = new Sustantivo(
						textSustantivo.getText(),
						(Genero) cmbGenero.getSelectedItem(),
						textSustantivo.getText().toLowerCase().endsWith("s") ? Numero.PLURAL : Numero.SINGULAR ,
						(Topico) cmbTopico.getSelectedItem());
				if (PalabraService.getInstance().agregarSustantivo(sustantivo)){
					lblEstado.setText("La palabra " + sustantivo.getTexto() + " ha sido agregada satisfactoriamente.");
				}else{
					lblEstado.setText("La palabra " + sustantivo.getTexto() + " ya se encuentra en el almacén de sustantivos.");
				}
			}
		});
		btnAgregarSustantivo.setBounds(370, 31, 89, 23);
		frmIngre.getContentPane().add(btnAgregarSustantivo);

		JLabel lblVerbo = new JLabel("Verbo");
		lblVerbo.setBounds(10, 63, 46, 14);
		frmIngre.getContentPane().add(lblVerbo);

		textVerbo = new JTextField();
		textVerbo.setBounds(10, 88, 171, 20);
		frmIngre.getContentPane().add(textVerbo);
		textVerbo.setColumns(10);

		cmbTiempo = new JComboBox<Tiempo>();
		cmbTiempo.setModel(new DefaultComboBoxModel<Tiempo>(Tiempo.values()));
		cmbTiempo.setBounds(191, 88, 84, 20);
		frmIngre.getContentPane().add(cmbTiempo);

		JButton btnAgregarVerbo = new JButton("Agregar");
		btnAgregarVerbo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Verbo verbo = new Verbo(textVerbo.getText(), (Tiempo) cmbTiempo
						.getSelectedItem());
				if (PalabraService.getInstance().agregarVerbo(verbo)){
					lblEstado.setText("La palabra " + verbo.getTexto() + " ha sido agregada satisfactoriamente.");
				}else{
					lblEstado.setText("La palabra " + verbo.getTexto() + " ya se encuentra en el almacén de verbos.");
				}
			}
		});
		btnAgregarVerbo.setBounds(370, 87, 89, 23);
		frmIngre.getContentPane().add(btnAgregarVerbo);

		JLabel lblAdjetivo = new JLabel("Adjetivo");
		lblAdjetivo.setBounds(10, 119, 46, 14);
		frmIngre.getContentPane().add(lblAdjetivo);

		textAdjetivo = new JTextField();
		textAdjetivo.setBounds(10, 144, 171, 20);
		frmIngre.getContentPane().add(textAdjetivo);
		textAdjetivo.setColumns(10);

		JButton btnAgregarAdjetivo = new JButton("Agregar");
		btnAgregarAdjetivo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Adjetivo adjetivo = new Adjetivo(textAdjetivo.getText());
				if (PalabraService.getInstance().agregarAdjetivo(adjetivo)){
					lblEstado.setText("La palabra " + adjetivo.getTexto() + " ha sido agregada satisfactoriamente.");
				}else{
					lblEstado.setText("La palabra " + adjetivo.getTexto() + " ya se encuentra en el almacén de adjetivos.");
				}
			}
		});
		btnAgregarAdjetivo.setBounds(370, 143, 89, 23);
		frmIngre.getContentPane().add(btnAgregarAdjetivo);
		
		JButton btnPersistir = new JButton("Persistir");
		btnPersistir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				PalabraService.getInstance().PersistirTodo();
			}
		});
		btnPersistir.setBounds(370, 211, 89, 23);
		frmIngre.getContentPane().add(btnPersistir);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(0, 266, 480, 31);
		frmIngre.getContentPane().add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		lblEstado = new JLabel("Ingrese un sustantivo, verbo o adjetivo");
		panel.add(lblEstado);
		
		JButton btnAgregarEsquema = new JButton("Agregar esquema");
		btnAgregarEsquema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EsquemaFrame nueva = new EsquemaFrame();
				nueva.setVisible(true);
			}
		});
		btnAgregarEsquema.setBounds(10, 211, 135, 23);
		frmIngre.getContentPane().add(btnAgregarEsquema);
	}
}
