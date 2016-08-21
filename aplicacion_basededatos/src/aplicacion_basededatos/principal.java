package aplicacion_basededatos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class principal {

	private JFrame frame;
	agregar nuevo = new agregar(); 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					principal window = new principal();
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
	public principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 270, 269);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("APLICACION");
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		lblNewLabel.setBounds(85, 11, 103, 37);
		frame.getContentPane().add(lblNewLabel);
		
		JButton agregar = new JButton("AGREGAR");
		agregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nuevo.formulario();
				
			}
		});
		agregar.setBounds(85, 59, 89, 23);
		frame.getContentPane().add(agregar);
		
		JButton listar = new JButton("LISTAR");
		listar.setBounds(85, 114, 89, 23);
		frame.getContentPane().add(listar);
		
		JButton salir = new JButton("SALIR");
		salir.setBounds(85, 170, 89, 23);
		frame.getContentPane().add(salir);
	}

}
