package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import enums.Topico;
import models.Adjetivo;
import models.Esquema;
import models.Sustantivo;
import models.Verbo;
import services.OracionService;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;

public class FraseFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblFrase;
	private JButton btnFrases;
	private JComboBox cmbTopico;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		cmbTopico = new JComboBox<Topico>();
		cmbTopico.setBounds(72, 12, 96, 20);
		cmbTopico.setModel(new DefaultComboBoxModel<Topico>(Topico.values()));
		contentPane.add(cmbTopico);
		
		btnFrases = new JButton("Generar");
		btnFrases.setBounds(274, 11, 155, 23);
		btnFrases.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				OracionService os = OracionService.getInstance();
				lblFrase.setText("Frase: " + os.GenerarOracion((Topico) cmbTopico.getSelectedItem()));	
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnFrases);
		
		lblFrase = new JLabel("Frase:");
		lblFrase.setBounds(5, 28, 424, 228);
		contentPane.add(lblFrase);
		
		
	}
}
