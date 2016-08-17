package proyecto_final;

import java.awt.EventQueue; 

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.TextField;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class formulario {

	private JFrame frame;
	private JTextField txtUrl;
	private JLabel lblNewLabel_2;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					formulario window = new formulario();
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
	public formulario() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(144, 238, 144));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ANIALIZADOR DE CONTENIDO WEB");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Pristina", Font.BOLD, 17));
		lblNewLabel.setBounds(74, 11, 311, 26);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("URL");
		lblNewLabel_1.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 60, 27, 26);
		frame.getContentPane().add(lblNewLabel_1);
		
		frame.setResizable(false);
		frame.setVisible(true);
		
		txtUrl = new JTextField();
		txtUrl.setToolTipText("");
		txtUrl.setBounds(42, 64, 383, 20);
		frame.getContentPane().add(txtUrl);
		txtUrl.setColumns(10);
		
		lblNewLabel_2 = new JLabel("RESUTADO MOVIL");
		lblNewLabel_2.setFont(new Font("Traditional Arabic", Font.BOLD, 12));
		lblNewLabel_2.setBounds(42, 105, 131, 26);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblResultadoEscritorio = new JLabel("RESULTADO ESCRITORIO");
		lblResultadoEscritorio.setFont(new Font("Traditional Arabic", Font.BOLD, 11));
		lblResultadoEscritorio.setBounds(281, 105, 144, 26);
		frame.getContentPane().add(lblResultadoEscritorio);
		
		final JButton btnAnalizar = new JButton("ANALIZAR");
		btnAnalizar.setFont(new Font("Perpetua Titling MT", Font.BOLD, 9));
		btnAnalizar.setEnabled(false);
		btnAnalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnAnalizar.setBounds(183, 228, 89, 23);
		frame.getContentPane().add(btnAnalizar);
		
		JTextArea textMovil = new JTextArea();
		textMovil.setBounds(41, 142, 144, 72);
		frame.getContentPane().add(textMovil);
		
		JTextArea textEscritorio = new JTextArea();
		textEscritorio.setBounds(270, 142, 154, 72);
		frame.getContentPane().add(textEscritorio);
		
	    JButton btnValidar = new JButton("VALIDAR");		   	
	    btnValidar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtUrl.getText().length()==0)
					JOptionPane.showMessageDialog(null, "INGRESE UNA URL","ERROR",JOptionPane.ERROR_MESSAGE);				
				if(txtUrl.getText().length()>=4){
				if(txtUrl.getText().substring(0,4).equals("www.") && txtUrl.getText().substring(txtUrl.getText().length()-4,txtUrl.getText().length()).equals(".com")  ){
					JOptionPane.showMessageDialog(null, "PAGINA WEB CORRECTA");
					btnAnalizar.setEnabled(true);
				}
				else{
					JOptionPane.showMessageDialog(null, "PAGINA WEB INCORRECTA","ERROR",JOptionPane.ERROR_MESSAGE);
				     txtUrl.setText("");    
				}	
		}	
}
		});
		btnValidar.setFont(new Font("Perpetua Titling MT", Font.BOLD, 9));
		btnValidar.setBounds(84, 228, 89, 23);
		frame.getContentPane().add(btnValidar);
		
		JLabel lblNewLabel_3 = new JLabel("Ejemplo: www.ejemplo.com");
		lblNewLabel_3.setToolTipText("");
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setEnabled(false);
		lblNewLabel_3.setBackground(Color.WHITE);
		lblNewLabel_3.setBounds(42, 84, 169, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton btnSALIR = new JButton("SALIR");
		btnSALIR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int op=JOptionPane.showConfirmDialog(null, "¿Desea salir de la aplicacion?", "Atencion",JOptionPane.YES_NO_OPTION);
				if(op == JOptionPane.YES_NO_OPTION)
				System.exit(0);
			}
		});
		btnSALIR.setFont(new Font("Perpetua Titling MT", Font.BOLD, 9));
		btnSALIR.setBounds(281, 226, 89, 23);
		frame.getContentPane().add(btnSALIR);
	}
}
