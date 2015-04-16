package views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListDataListener;

import services.OracionService;
import services.PersistenciaService;
import enums.Topico;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FraseFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblFrase;
	private JButton btnFrases;
	private JComboBox cmbTopico;
	private JScrollPane scrollPane;
	private JList listOraciones;
	private JTextField txtCantidad;
	private JButton btnGuardar;
	private List<String> oraciones;

	public class CustomModel<T> implements ListModel<T> {
		private List<T> source;

		public CustomModel(List<T> s) {
			source = s;
		}

		@Override
		public void addListDataListener(ListDataListener arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public T getElementAt(int arg0) {
			return source.get(arg0);
		}

		@Override
		public int getSize() {
			return source.size();
		}

		@Override
		public void removeListDataListener(ListDataListener arg0) {
			// TODO Auto-generated method stub

		}

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FraseFrame frame = new FraseFrame();
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
	public FraseFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 341);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		cmbTopico = new JComboBox<Topico>();
		cmbTopico.setBounds(119, 12, 96, 20);
		cmbTopico.setModel(new DefaultComboBoxModel<Topico>(Topico.values()));
		contentPane.add(cmbTopico);

		btnFrases = new JButton("Generar");
		btnFrases.setBounds(330, 11, 155, 23);
		btnFrases.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Integer cantidad = Integer.parseInt(txtCantidad.getText());
				OracionService os = OracionService.getInstance();
				oraciones = os.GenerarOraciones(
						(Topico) cmbTopico.getSelectedItem(), cantidad);
				listOraciones.setModel(new CustomModel<String>(oraciones));
				// lblFrase.setText("Frase: " + os.GenerarOracion((Topico)
				// cmbTopico.getSelectedItem()));
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnFrases);

		lblFrase = new JLabel("Frase:");
		lblFrase.setBounds(5, 28, 480, 228);
		contentPane.add(lblFrase);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 47, 422, 203);
		contentPane.add(scrollPane);

		listOraciones = new JList();
		scrollPane.setViewportView(listOraciones);

		txtCantidad = new JTextField();
		txtCantidad.setTransferHandler(null);
		/*
		 * txtCantidad.setInputVerifier(new InputVerifier() {
		 * 
		 * @Override public boolean verify(JComponent input) { JTextField tf =
		 * (JTextField) input; String cadena = tf.getText(); try {// if is
		 * number Integer.parseInt(cadena); return true; } catch
		 * (NumberFormatException e) { return false;// else then do blah } } });
		 */
		txtCantidad.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)))) {
					getToolkit().beep();
					e.consume();
				}
			}
		});

		txtCantidad.setBounds(281, 12, 39, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);

		btnGuardar = new JButton("Guardar");
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PersistenciaService.getInstance().save(
						String.join(System.getProperty("line.separator"), oraciones), "oraciones.txt");
			}
		});
		btnGuardar.setBounds(396, 268, 89, 23);
		contentPane.add(btnGuardar);

		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(225, 15, 46, 14);
		contentPane.add(lblCantidad);

		JLabel lblTema = new JLabel("Tema");
		lblTema.setBounds(46, 15, 46, 14);
		contentPane.add(lblTema);

	}
}
