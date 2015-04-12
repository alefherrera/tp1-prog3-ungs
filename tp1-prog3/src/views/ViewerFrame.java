package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListDataListener;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ListModel;

import models.Sustantivo;
import services.PalabraService;

public class ViewerFrame extends JFrame {

	private JPanel contentPane;
	private JList list;
	
	public class CustomModel<T> implements ListModel<T>{
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
					ViewerFrame frame = new ViewerFrame();
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
	public ViewerFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		list = new JList();
		list.setBounds(10, 11, 414, 239);
		//list.setModel(new CustomModel<Sustantivo>(PalabraService.getInstance().getSustantivos()));
		contentPane.add(list);
	}
}
