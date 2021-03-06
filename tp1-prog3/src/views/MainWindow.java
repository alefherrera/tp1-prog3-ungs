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
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.BevelBorder;

import models.Adjetivo;
import models.Sustantivo;
import models.Verbo;
import services.PalabraService;
import enums.Genero;
import enums.Numero;
import enums.Persona;
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
	private JComboBox<Numero> cmbNumeroSustantivo;
	private JComboBox<Persona> cmbPersonaVerbo;
	private JComboBox<Numero> cmbNumeroVerbo;
	private JComboBox<Numero> cmbNumeroAdjetivo;
	private JComboBox<Genero> cmbGeneroAdjetivo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					for (LookAndFeelInfo info : UIManager
							.getInstalledLookAndFeels()) {
						if ("Nimbus".equals(info.getName())) {
							UIManager.setLookAndFeel(info.getClassName());
							break;
						}
					}
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
		frmIngre.setBounds(100, 100, 1001, 324);
		frmIngre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIngre.getContentPane().setLayout(null);

		JLabel lblSustantivo = new JLabel("Sustantivo");
		lblSustantivo.setBounds(10, 11, 86, 14);
		frmIngre.getContentPane().add(lblSustantivo);

		textSustantivo = new JTextField();
		textSustantivo.setBounds(10, 32, 171, 20);
		frmIngre.getContentPane().add(textSustantivo);
		textSustantivo.setColumns(10);

		cmbNumeroSustantivo = new JComboBox<Numero>();
		cmbNumeroSustantivo.setModel(new DefaultComboBoxModel<Numero>(Numero
				.values()));
		cmbNumeroSustantivo.setBounds(191, 32, 171, 20);
		frmIngre.getContentPane().add(cmbNumeroSustantivo);

		cmbGenero = new JComboBox<Genero>();
		cmbGenero.setModel(new DefaultComboBoxModel<Genero>(Genero.values()));
		cmbGenero.setBounds(372, 32, 171, 20);
		frmIngre.getContentPane().add(cmbGenero);

		cmbTopico = new JComboBox<Topico>();
		cmbTopico.setModel(new DefaultComboBoxModel<Topico>(Topico.values()));
		cmbTopico.setBounds(553, 32, 171, 20);
		frmIngre.getContentPane().add(cmbTopico);

		JButton btnAgregarSustantivo = new JButton("Agregar");
		btnAgregarSustantivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textSustantivo.getText().isEmpty()){
					lblEstado.setText("Debe ingresar algo.");
					return;
				}
				
				// Todas las palabras que terminan con S o X pueden ser usadas
				// en plural
				Numero nro = null;
				if (textSustantivo.getText().toLowerCase().endsWith("s")
						|| textSustantivo.getText().toLowerCase().endsWith("x"))
					nro = Numero.PLURAL;
				else
					nro = Numero.SINGULAR;

				Sustantivo sustantivo = new Sustantivo(
						textSustantivo.getText(),
						(Genero) cmbGenero.getSelectedItem(),
						nro,
						(Topico) cmbTopico.getSelectedItem());
				if (PalabraService.getInstance().agregarSustantivo(sustantivo)) {
					lblEstado.setText("La palabra " + sustantivo.getTexto()
							+ " ha sido agregada satisfactoriamente.");
				} else {
					lblEstado.setText("La palabra " + sustantivo.getTexto()
							+ " ya se encuentra en el almac�n de sustantivos.");
				}
			}
		});
		btnAgregarSustantivo.setBounds(896, 31, 89, 23);
		frmIngre.getContentPane().add(btnAgregarSustantivo);

		JLabel lblVerbo = new JLabel("Verbo");
		lblVerbo.setBounds(10, 63, 46, 14);
		frmIngre.getContentPane().add(lblVerbo);

		textVerbo = new JTextField();
		textVerbo.setBounds(10, 88, 171, 20);
		frmIngre.getContentPane().add(textVerbo);
		textVerbo.setColumns(10);

		cmbNumeroVerbo = new JComboBox<Numero>();
		cmbNumeroVerbo.setModel(new DefaultComboBoxModel<Numero>(Numero
				.values()));
		cmbNumeroVerbo.setBounds(191, 88, 171, 20);
		frmIngre.getContentPane().add(cmbNumeroVerbo);

		cmbTiempo = new JComboBox<Tiempo>();
		cmbTiempo.setModel(new DefaultComboBoxModel<Tiempo>(Tiempo.values()));
		cmbTiempo.setBounds(372, 88, 171, 20);
		frmIngre.getContentPane().add(cmbTiempo);

		JButton btnAgregarVerbo = new JButton("Agregar");
		btnAgregarVerbo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textVerbo.getText().isEmpty()){
					lblEstado.setText("Debe ingresar algo.");
					return;
				}
				Verbo verbo = new Verbo(textVerbo.getText(), (Tiempo) cmbTiempo
						.getSelectedItem(), (Persona) cmbPersonaVerbo
						.getSelectedItem(), (Numero) cmbNumeroVerbo
						.getSelectedItem());
				if (PalabraService.getInstance().agregarVerbo(verbo)) {
					lblEstado.setText("La palabra " + verbo.getTexto()
							+ " ha sido agregada satisfactoriamente.");
				} else {
					lblEstado.setText("La palabra " + verbo.getTexto()
							+ " ya se encuentra en el almac�n de verbos.");
				}
			}
		});

		cmbPersonaVerbo = new JComboBox<Persona>();
		cmbPersonaVerbo.setModel(new DefaultComboBoxModel<Persona>(Persona
				.values()));
		cmbPersonaVerbo.setBounds(553, 88, 171, 20);
		frmIngre.getContentPane().add(cmbPersonaVerbo);
		btnAgregarVerbo.setBounds(896, 87, 89, 23);
		frmIngre.getContentPane().add(btnAgregarVerbo);

		JLabel lblAdjetivo = new JLabel("Adjetivo");
		lblAdjetivo.setBounds(10, 119, 46, 14);
		frmIngre.getContentPane().add(lblAdjetivo);

		textAdjetivo = new JTextField();
		textAdjetivo.setBounds(10, 144, 171, 20);
		frmIngre.getContentPane().add(textAdjetivo);
		textAdjetivo.setColumns(10);

		JButton btnAgregarAdjetivo = new JButton("Agregar");
		btnAgregarAdjetivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textAdjetivo.getText().isEmpty()){
					lblEstado.setText("Debe ingresar algo.");
					return;
				}
				Adjetivo adjetivo = new Adjetivo(textAdjetivo.getText(),
						(Genero) cmbGeneroAdjetivo.getSelectedItem(),
						(Numero) cmbNumeroAdjetivo.getSelectedItem());
				if (PalabraService.getInstance().agregarAdjetivo(adjetivo)) {
					lblEstado.setText("La palabra " + adjetivo.getTexto()
							+ " ha sido agregada satisfactoriamente.");
				} else {
					lblEstado.setText("La palabra " + adjetivo.getTexto()
							+ " ya se encuentra en el almac�n de adjetivos.");
				}
			}
		});
		cmbNumeroAdjetivo = new JComboBox<Numero>();
		cmbNumeroAdjetivo.setModel(new DefaultComboBoxModel<Numero>(Numero
				.values()));
		cmbNumeroAdjetivo.setBounds(191, 144, 171, 20);
		frmIngre.getContentPane().add(cmbNumeroAdjetivo);

		cmbGeneroAdjetivo = new JComboBox<Genero>();
		cmbGeneroAdjetivo.setModel(new DefaultComboBoxModel<Genero>(Genero
				.values()));
		cmbGeneroAdjetivo.setBounds(372, 144, 171, 20);
		frmIngre.getContentPane().add(cmbGeneroAdjetivo);
		btnAgregarAdjetivo.setBounds(896, 143, 89, 23);
		frmIngre.getContentPane().add(btnAgregarAdjetivo);

		JButton btnPersistir = new JButton("Persistir");
		btnPersistir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				PalabraService.getInstance().PersistirTodo();
			}
		});
		btnPersistir.setBounds(896, 211, 89, 23);
		frmIngre.getContentPane().add(btnPersistir);

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null,
				null));
		panel.setBounds(0, 266, 995, 31);
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
		
		JButton btnGenerarFrases = new JButton("Generar Frases");
		btnGenerarFrases.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FraseFrame newWindow = new FraseFrame();
				newWindow.setVisible(true);
			}
		});
		btnGenerarFrases.setBounds(402, 211, 191, 23);
		frmIngre.getContentPane().add(btnGenerarFrases);
	}
}
