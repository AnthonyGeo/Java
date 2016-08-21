/*
 * Copyright (c) 2011 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.api.services.samples.books.cmdline;

import java.awt.EventQueue;  

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.Window.Type;
import java.awt.SystemColor;
import java.awt.Color;
/**
 * @author(s) ANTHONY HERNANDEZ Y JOHANNA CHOEZ
 *
 */
public class formulario_books {
  
 
  buscador buscar = new buscador();    
  JFrame frame;
  
  private static JList<String> list;
  public static JTextField libro;
  

  /**
   *Iniciar la aplicación .
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        try {
          formulario_books window = new formulario_books();
          window.frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Creación de la aplicación .
   */
  public formulario_books() {
    initialize();
  }

  /**
   * Inicializar el contenido del frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.getContentPane().setBackground(new Color(127, 255, 0));
    frame.setAlwaysOnTop(true);
    frame.setType(Type.POPUP);
    frame.getContentPane().setFont(new Font("Simplified Arabic Fixed", Font.PLAIN, 12));
    frame.setBounds(100, 100, 618, 493);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    JScrollPane scroll = new JScrollPane(list, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
        ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
    frame.getContentPane().add(scroll);
    
    frame.setResizable(false);
    frame.setVisible(true);
    
    JLabel Nombre_Proyecto = new JLabel("BUSCADOR DE LIBROS ");
    Nombre_Proyecto.setFont(new Font("Rockwell", Font.BOLD, 14));
    Nombre_Proyecto.setBounds(225, 0, 183, 26);
    frame.getContentPane().add(Nombre_Proyecto);
    
    JLabel Nombre_Libro = new JLabel("Nombre del libro");
    Nombre_Libro.setFont(new Font("Sylfaen", Font.PLAIN, 14));
    Nombre_Libro.setBounds(10, 25, 96, 19);
    frame.getContentPane().add(Nombre_Libro);
    
    libro = new JTextField();
    libro.setBounds(109, 24, 400, 20);
    frame.getContentPane().add(libro);
    libro.setColumns(10);
    
    JLabel lblEjemplosangreDe = new JLabel("Ejemplo: \"Sangre de Campeon\"");
    lblEjemplosangreDe.setBackground(SystemColor.windowBorder);
    lblEjemplosangreDe.setEnabled(false);
    lblEjemplosangreDe.setBounds(110, 45, 188, 14);
    frame.getContentPane().add(lblEjemplosangreDe);
    
    final JButton Buscar = new JButton("BUSCAR");
    final JButton nuevo = new JButton("NUEVO");
    nuevo.setEnabled(false);
    nuevo.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        libro.setText("");
        buscar.borrar();
        Buscar.setEnabled(true);
        libro.setEnabled(true);
        nuevo.setEnabled(false);
        
      }
    });
    nuevo.setBounds(142, 431, 106, 23);
    frame.getContentPane().add(nuevo);
    
   
    Buscar.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        
        if(libro.getText().length()==0)
          JOptionPane.showMessageDialog(null, "INGRESE UN NOMBRE","ERROR",JOptionPane.ERROR_MESSAGE);
        else{
        buscar.consulta(libro.getText(),list);
        Buscar.setEnabled(false); 
        libro.setEnabled(false);
        nuevo.setEnabled(true);
     }      
}
    });
    Buscar.setBounds(513, 23, 89, 23);
    frame.getContentPane().add(Buscar);
    
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(10, 66, 590, 359);
    frame.getContentPane().add(scrollPane);
    
    list = new JList<String>();
    scrollPane.setViewportView(list);
    
    JButton SALIR = new JButton("FINALIZAR");
    SALIR.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        int op=JOptionPane.showConfirmDialog(null, "¿Desea salir de la aplicacion?", "Atencion",JOptionPane.YES_NO_OPTION);
        if(op == JOptionPane.YES_NO_OPTION)
        System.exit(0);
      }
    });
    SALIR.setBounds(371, 431, 106, 23);
    frame.getContentPane().add(SALIR);
   
  

  }
  
}
 

