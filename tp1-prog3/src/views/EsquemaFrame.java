package views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.Adjetivo;
import models.Esquema;
import models.Palabra;
import models.Sustantivo;
import models.Verbo;
import services.EsquemaService;

public class EsquemaFrame extends JFrame {

	private JPanel contentPane;
	private JList<Class<? extends Palabra>> lstEsquema;
	DefaultComboBoxModel<Class<? extends Palabra>> modelo;

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
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 457, 217);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lstEsquema = new JList<Class<? extends Palabra>>();
		modelo = new DefaultComboBoxModel<Class<? extends Palabra>>();
		lstEsquema.setModel(modelo);
		lstEsquema.setBounds(125, 166, 206, -150);
		contentPane.add(lstEsquema);

		JButton btnSustantivo = new JButton("Sustantivo");
		btnSustantivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modelo.addElement(Sustantivo.class);
			}
		});
		btnSustantivo.setBounds(10, 11, 89, 23);
		contentPane.add(btnSustantivo);

		JButton btnAdjetivo = new JButton("Adjetivo");
		btnAdjetivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelo.addElement(Adjetivo.class);
			}
		});
		btnAdjetivo.setBounds(10, 45, 89, 23);
		contentPane.add(btnAdjetivo);

		JButton btnVerbo = new JButton("Verbo");
		btnVerbo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelo.addElement(Verbo.class);
			}
		});
		btnVerbo.setBounds(10, 79, 89, 23);
		contentPane.add(btnVerbo);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Esquema nuevoEsquema = new Esquema();
				for (int i = 0; i < modelo.getSize() ; i++) {
					nuevoEsquema.AgregarTermino(modelo.getElementAt(i));
				}
				EsquemaService.getInstance().agregarEsquema(nuevoEsquema);
				modelo.removeAllElements();
			}
		});
		btnGuardar.setBounds(345, 11, 89, 23);
		contentPane.add(btnGuardar);

	}

}
