/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Objetos.Objeto;      
import Operaciones.Operaciones;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;

import org.xml.sax.SAXException;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 *
 * @author Anthony Hernandez
 */
public class GUI extends javax.swing.JFrame {
	
	//public int c=0;
	Operaciones operaciones;
    /**
     * Creates new form GUI
     */
    public GUI() {
        initComponents();
        operaciones = new Operaciones();
        operaciones.conectar();
        setResizable(false);
        setVisible(true);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTPersonas = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        
        
        JButton btnActualizar = new JButton("Actualizar");
        JButton btnNewButton_1 = new JButton("Consultar");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTPersonas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTPersonas);
        
        
        
        jButton1.setText("Cargar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
                jButton1.setEnabled(false);
                jButton2.setEnabled(true);
                btnActualizar.setEnabled(true);
                btnNewButton_1.setEnabled(true);
                
            }
        });

        jButton2.setText("Eliminar registro");
        jButton2.setEnabled(false);
        
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					jButton2ActionPerformed(evt);
				} catch (TransformerConfigurationException | ParserConfigurationException | SAXException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        
        
        btnNewButton_1.setEnabled(false);
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(java.awt.event.ActionEvent evt) {
        		jbtnNewButton_1ActionPerformed(evt);
        	}
        });
        
        
        btnActualizar.setEnabled(false);
        btnActualizar.addActionListener(new ActionListener() {
        	public void actionPerformed(java.awt.event.ActionEvent evt) {
        		try {
					jbtnActualizar_1ActionPerformed(evt);
				} catch (TransformerConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParserConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SAXException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}        		       	        	       
        	}
        });
        jPanel1 = new javax.swing.JPanel();
        jBGuardar = new javax.swing.JButton();
        
                jBGuardar.setText("Importar");
                jBGuardar.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        try {
					jBGuardarActionPerformed(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
                        btnActualizar.setEnabled(false);
                		jButton2.setEnabled(false);
                		btnNewButton_1.setEnabled(false);
                		jButton1.setEnabled(true);
                    }
                });
                
                JButton btnNewButton = new JButton("Salir");
                btnNewButton.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent arg0) {
                		int op = JOptionPane.showConfirmDialog(null, "¿Desea salir del programa?", "Atencion",JOptionPane.YES_NO_OPTION);
                    	if(op == JOptionPane.YES_NO_OPTION){
                    		System.exit(0);	
                    	}
                		
                	}
                });
                
                JButton btnNewButton_2 = new JButton("");
                btnNewButton_2.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent arg0) {
                		JOptionPane.showMessageDialog(null, "Autor: Anthony Hernandez \n"+"Pontificia Universidad Catolica del Ecuador Sede Esmeraldas \n"+"Derechos de autor reservados \n"+"Anthony Company S.A","Info",JOptionPane.INFORMATION_MESSAGE);
                	}
                });
                btnNewButton_2.setIcon(new ImageIcon("F:\\P.O.O\\Java_clase\\ProyectoSQLite\\botoninfo.jpg"));
                
                JButton btnAgregar = new JButton("Agregar ");
                btnAgregar.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent arg0) {
                		 btnActualizar.setEnabled(false);
                 		jButton2.setEnabled(false);
                 		btnNewButton_1.setEnabled(false);
                 		jButton1.setEnabled(true);
                		try{
                	        	
                	        	int matricula= Integer.parseInt( JOptionPane.showInputDialog("Matricula"));
                	        	String nombre= JOptionPane.showInputDialog("Nombre");
                	        	String direccion= JOptionPane.showInputDialog("Direccion");
                	        	String ciudad= JOptionPane.showInputDialog("Ciudad");
                	        	int edad= Integer.parseInt( JOptionPane.showInputDialog("Edad"));
                	        	Objeto persona = new Objeto(""+matricula,nombre,direccion,ciudad,""+edad);
                	            operaciones.guardarUsuario(persona);
                	            JOptionPane.showMessageDialog(null, "AGREGADO CON EXITO","AVISO",JOptionPane.INFORMATION_MESSAGE);
                                operaciones.xml();
                	        }catch(Exception ex){
                	            JOptionPane.showMessageDialog(null,"Error:"+ex.getMessage()+"\nVerifique");
                	        }
                	}
                });
                
                        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                        jPanel1Layout.setHorizontalGroup(
                        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
                        		.addGroup(jPanel1Layout.createSequentialGroup()
                        			.addContainerGap(572, Short.MAX_VALUE)
                        			.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        			.addContainerGap())
                        		.addGroup(jPanel1Layout.createSequentialGroup()
                        			.addGap(173)
                        			.addComponent(jBGuardar, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
                        			.addGap(28)
                        			.addComponent(btnAgregar, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                        			.addContainerGap(181, Short.MAX_VALUE))
                        		.addGroup(jPanel1Layout.createSequentialGroup()
                        			.addGap(247)
                        			.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                        			.addContainerGap(258, Short.MAX_VALUE))
                        );
                        jPanel1Layout.setVerticalGroup(
                        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
                        		.addGroup(jPanel1Layout.createSequentialGroup()
                        			.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                        			.addGap(87)
                        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
                        				.addComponent(btnAgregar)
                        				.addComponent(jBGuardar))
                        			.addGap(31)
                        			.addComponent(btnNewButton)
                        			.addGap(88))
                        );
                        jPanel1.setLayout(jPanel1Layout);
                        
                                jTabbedPane1.addTab("Formulario", jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2Layout.setHorizontalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(btnActualizar, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
        				.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE))
        			.addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
        			.addGap(11)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jButton1)
        				.addComponent(jButton2)
        				.addComponent(btnActualizar)
        				.addComponent(btnNewButton_1))
        			.addContainerGap())
        );
        jPanel2.setLayout(jPanel2Layout);

        jTabbedPane1.addTab("Lista", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void limpiar(){
        
    }
  
    @SuppressWarnings("unchecked")
	private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) throws IOException {//GEN-FIRST:event_jBGuardarActionPerformed
    	operaciones.insertar("delete from Objeto ");
        operaciones.totalObjetos((DefaultTableModel)jTPersonas.getModel());
    	String contenido_xml = "";
		BufferedReader br = new BufferedReader(new FileReader("file.xml"));
		try {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();  
		    }
		    contenido_xml = sb.toString();
		}
		catch(Exception e){
			 System.out.println("Error al leer el fichero");
		 }finally {
		    br.close();
		}
		
		XStream xstream = new XStream(new DomDriver());
		xstream.alias("Alumno", Estudiante.class);
		List<Estudiante> lst_estudiante = new ArrayList<Estudiante>();
		lst_estudiante = (List<Estudiante>) xstream.fromXML(contenido_xml);
		Estudiante a = new Estudiante();
		try{
			for(int i=0;i<lst_estudiante.size();i++){
			a = lst_estudiante.get(i);
			int mat = Integer.parseInt(a.getMatricula());
			int edad = Integer.parseInt(a.getEdad());
			
        	Objeto persona = new Objeto(""+mat,a.getNombre()
                     ,a.getDireccion(),a.getCiudad(),""+edad);
        	 operaciones.guardarUsuario(persona);
			}
           
            JOptionPane.showMessageDialog(null, "GUARDADO CON EXITO","AVISO",JOptionPane.INFORMATION_MESSAGE);
            limpiar();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error:"+ex.getMessage()+"\nVerifique");
        }
    }//GEN-LAST:event_jBGuardarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed 
    	operaciones.totalObjetos((DefaultTableModel)jTPersonas.getModel());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) throws TransformerConfigurationException, ParserConfigurationException, SAXException {//GEN-FIRST:event_jButton2ActionPerformed
    	int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id a eliminar: "));
    	if(operaciones.validar(id)==true){
        int op = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el registro de la base de datos?", "Atencion",JOptionPane.YES_NO_OPTION);
        if(op == JOptionPane.YES_NO_OPTION){
        operaciones.insertar("delete from Objeto where matricula="+id);
        operaciones.totalObjetos((DefaultTableModel)jTPersonas.getModel());
        JOptionPane.showMessageDialog(null, "Registro eliminado con exito","AVISO",JOptionPane.INFORMATION_MESSAGE);
        operaciones.xml();
        }
    	}
    	else
    		JOptionPane.showMessageDialog(null, "Registro no encontrado","ERROR",JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_jButton2ActionPerformed
    private void jbtnNewButton_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    	int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese matricula a consulta: "));
    	if(operaciones.validar(id)==true)
    	operaciones.consultar1(Integer.toString(id));
    	else
    		JOptionPane.showMessageDialog(null, "Registro no encontrado","ERROR",JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_jButton2ActionPerformed
   
    
    private void jbtnActualizar_1ActionPerformed(java.awt.event.ActionEvent evt) throws TransformerConfigurationException, ParserConfigurationException, SAXException {//GEN-FIRST:event_jButton2ActionPerformed
    	int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la matricula a Actualizar: "));
    	int op;
    	if(operaciones.validar(id)==true){
    		op = Integer.parseInt(JOptionPane.showInputDialog("OP1: MATRICULA \n"+"OP2: NOMBRE \n"+"OP3: DIRECCION \n"+"OP4: CIUDAD \n"+"OP5: EDAD \n"));
    		switch (op){
    		case 1:
    			int id_1 =Integer.parseInt(JOptionPane.showInputDialog("Ingrese su nueva matricula"));
    			operaciones.insertar("UPDATE Objeto SET matricula = "+id_1+" WHERE matricula ="+ id);
    			 jButton1ActionPerformed(evt);
    			JOptionPane.showMessageDialog(null, "Informacion actualizada con exito","AVISO",JOptionPane.INFORMATION_MESSAGE);
    	    break;
    		case 2:
    			String name =JOptionPane.showInputDialog("Ingrese su nuevo nombre");
    			operaciones.insertar("UPDATE Objeto SET nombre = "+"'"+name+"'"+" WHERE matricula ="+ id);
    			jButton1ActionPerformed(evt);
    			JOptionPane.showMessageDialog(null, "Informacion actualizada con exito","AVISO",JOptionPane.INFORMATION_MESSAGE);
    		break;
    		case 3:
    			String dir_1 =JOptionPane.showInputDialog("Ingrese su nueva direccion");
    			operaciones.insertar("UPDATE Objeto SET direccion = '"+dir_1+"' WHERE matricula ="+ id);
    			jButton1ActionPerformed(evt);
    			JOptionPane.showMessageDialog(null, "Informacion actualizada con exito","AVISO",JOptionPane.INFORMATION_MESSAGE);
    	    break;
    		case 4:
    			String ciu_1 =JOptionPane.showInputDialog("Ingrese su nueva ciudad");
    			operaciones.insertar("UPDATE Objeto SET ciudad = "+"'"+ciu_1+"'"+" WHERE matricula ="+ id);    			
    			jButton1ActionPerformed(evt);
    			JOptionPane.showMessageDialog(null, "Informacion actualizada con exito","AVISO",JOptionPane.INFORMATION_MESSAGE);
    	    break;
    		case 5:
    			int edad_1 =Integer.parseInt(JOptionPane.showInputDialog("Ingrese su nueva edad"));
    			operaciones.insertar("UPDATE Objeto SET edad = "+edad_1+" WHERE matricula ="+ id);    			
    			jButton1ActionPerformed(evt);
    			JOptionPane.showMessageDialog(null, "Informacion actualizada con exito","AVISO",JOptionPane.INFORMATION_MESSAGE);
    	    break;
    		
    		}
    		int op1 = JOptionPane.showConfirmDialog(null, "¿Desea exportar el XML con la informacion actualizada?", "Atencion",JOptionPane.YES_NO_OPTION);
        	if(op1 == JOptionPane.YES_NO_OPTION){
            operaciones.xml();
        	JOptionPane.showMessageDialog(null, "XML exportado con exito", "AVISO",JOptionPane.INFORMATION_MESSAGE);
        	}
    }
    	
    	else
    		JOptionPane.showMessageDialog(null, "Registro no encontrado","ERROR",JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_jButton2ActionPerformed
   
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new GUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTPersonas;
    private javax.swing.JTabbedPane jTabbedPane1;
}
