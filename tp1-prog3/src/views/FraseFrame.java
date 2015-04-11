package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

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

public class FraseFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblFrase;
	private JButton btnFrases;

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
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		btnFrases = new JButton("Frases");
		btnFrases.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Esquema esq = new Esquema();
				esq.AgregarTermino(Sustantivo.class);
				esq.AgregarTermino(Verbo.class);
				esq.AgregarTermino(Adjetivo.class);
				OracionService os = OracionService.getInstance();
				lblFrase.setText("Frase: " + os.GenerarOracion(esq,Topico.ACCION));	
			}
		});
		contentPane.add(btnFrases, BorderLayout.NORTH);
		
		lblFrase = new JLabel("Frase:");
		contentPane.add(lblFrase, BorderLayout.CENTER);
	}

}
