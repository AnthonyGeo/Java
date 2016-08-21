package aplicacion_basededatos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class agregar {

	private JFrame frame;
	private JTextField id;
	private JTextField nombre;
	private JTextField edad;
	base_sqlite base = new base_sqlite();
	/**
	 * Launch the application.
	 */
	public   void formulario() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					agregar window = new agregar();
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
	public agregar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 292, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(22, 46, 46, 14);
		frame.getContentPane().add(lblId);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(22, 115, 67, 14);
		frame.getContentPane().add(lblNombre);
		
		JLabel lblEdad = new JLabel("EDAD");
		lblEdad.setBounds(22, 185, 46, 14);
		frame.getContentPane().add(lblEdad);
		
		id = new JTextField();
		id.setBounds(111, 43, 86, 20);
		frame.getContentPane().add(id);
		id.setColumns(10);
		
		nombre = new JTextField();
		nombre.setBounds(111, 112, 86, 20);
		frame.getContentPane().add(nombre);
		nombre.setColumns(10);
		
		edad = new JTextField();
		edad.setBounds(111, 182, 86, 20);
		frame.getContentPane().add(edad);
		edad.setColumns(10);
		
		JButton btnGuardar = new JButton("GUARDAR");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				try {
					base.datos(Integer.parseInt(id.getText()),nombre.getText(),Integer.parseInt(edad.getText()));
				} catch (NumberFormatException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnGuardar.setBounds(81, 228, 110, 23);
		frame.getContentPane().add(btnGuardar);
	}
}
