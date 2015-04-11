package views;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import models.Adjetivo;
import models.Esquema;
import models.Sustantivo;
import models.Verbo;
import services.EsquemaService;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EsquemaFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblEsquema;
	private Esquema nuevoEsquema = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EsquemaFrame frame = new EsquemaFrame();
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
	public EsquemaFrame() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				EsquemaService.getInstance().PersistirTodo();
			}
		});
		setTitle("Agregar Esquema");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 495, 182);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		nuevoEsquema = new Esquema();

		JButton btnSustantivo = new JButton("Sustantivo");
		btnSustantivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nuevoEsquema.AgregarTermino(Sustantivo.class);
				updateLabel();
			}
		});
		btnSustantivo.setBounds(55, 11, 89, 23);
		contentPane.add(btnSustantivo);

		JButton btnAdjetivo = new JButton("Adjetivo");
		btnAdjetivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevoEsquema.AgregarTermino(Adjetivo.class);
				updateLabel();
			}
		});
		btnAdjetivo.setBounds(199, 11, 89, 23);
		contentPane.add(btnAdjetivo);

		JButton btnVerbo = new JButton("Verbo");
		btnVerbo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevoEsquema.AgregarTermino(Verbo.class);
				updateLabel();
			}
		});
		btnVerbo.setBounds(343, 11, 89, 23);
		contentPane.add(btnVerbo);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EsquemaService.getInstance().agregarEsquema(nuevoEsquema);
				nuevoEsquema = new Esquema();
				updateLabel();
			}
		});
		btnGuardar.setBounds(295, 81, 89, 23);
		contentPane.add(btnGuardar);

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null,
				null));
		panel.setBounds(0, 122, 489, 31);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		lblEsquema = new JLabel("");
		panel.add(lblEsquema);

		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nuevoEsquema.borrarUltimo();
				updateLabel();
			}
		});
		btnBorrar.setToolTipText("Borrar el ultimo termino");
		btnBorrar.setBounds(103, 81, 89, 23);
		contentPane.add(btnBorrar);

	}
	
	private void updateLabel(){
		lblEsquema.setText(nuevoEsquema.toString());
	}
	
}
