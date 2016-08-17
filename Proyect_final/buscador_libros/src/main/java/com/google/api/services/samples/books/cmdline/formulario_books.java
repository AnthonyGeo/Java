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
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport; 
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.books.Books;
import com.google.api.services.books.BooksRequestInitializer;
import com.google.api.services.books.Books.Volumes.List;
import com.google.api.services.books.model.Volume;
import com.google.api.services.books.model.Volumes;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.NumberFormat;
import java.awt.Window.Type;
import java.awt.SystemColor;
/**
 * @author(s) ANTHONY HERNANDEZ Y JOHANNA CHOEZ
 *
 */
public class formulario_books {
  
  private static final String APPLICATION_NAME = "books";
  private static final NumberFormat CURRENCY_FORMATTER = NumberFormat.getCurrencyInstance();
  private static final NumberFormat PERCENT_FORMATTER = NumberFormat.getPercentInstance();
  JFrame frame;
  private static DefaultListModel<String> modelo = new DefaultListModel();
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
    frame.getContentPane().setBackground(SystemColor.menu);
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
        modelo.removeAllElements();
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
        consulta();
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
  private static void queryGoogleBooks(JsonFactory jsonFactory, String query) throws Exception  {
    ClientCredentials.errorIfNotSpecified();
    // Configurar el cliente de Libros .
    final Books books = new Books.Builder(GoogleNetHttpTransport.newTrustedTransport(), jsonFactory, null)
        .setApplicationName(APPLICATION_NAME)
        .setGoogleClientRequestInitializer(new BooksRequestInitializer(ClientCredentials.API_KEY))
        .build();
    // Establecer la cadena de consulta y filtrar sólo los libros electrónicos de Google .
    modelo.addElement("CONSULTA:    '" + query + "'");
    List volumesList = books.volumes().list(query);
    volumesList.setFilter("ebooks");

    // Ejecutar la consulta .
    Volumes volumes = volumesList.execute();
    if (volumes.getTotalItems() == 0 || volumes.getItems() == null) {
      System.out.println("No matches found.");
      return;
    }

    // resultados de la salida .
    for (Volume volume : volumes.getItems()) {
      Volume.VolumeInfo volumeInfo = volume.getVolumeInfo();
      Volume.SaleInfo saleInfo = volume.getSaleInfo();
      modelo.addElement("---------------------------------------------------------------------------------------------------------------------------------------------");
      // Titulo.
      modelo.addElement("Titulo: " + volumeInfo.getTitle());
      // Autor(es).
      java.util.List<String> authors = volumeInfo.getAuthors();
      if (authors != null && !authors.isEmpty()) {
        for (int i = 0; i < authors.size(); ++i) {
          modelo.addElement("Autor(a): "+authors.get(i));
          if (i < authors.size() - 1) {
            modelo.addElement(", "); 
          }
        }
        modelo.addElement("\n");
      }
      // Descripción ( si existe).
      if (volumeInfo.getDescription() != null && volumeInfo.getDescription().length() > 0) {
        modelo.addElement("Descripcion: " + volumeInfo.getDescription()+"\n");
      }
      //Puntuaciones ( si lo hay) .
      if (volumeInfo.getRatingsCount() != null && volumeInfo.getRatingsCount() > 0) {
        int fullRating = (int) Math.round(volumeInfo.getAverageRating().doubleValue());
        modelo.addElement("Opiniones de los usuarios: ");
        int c=0;
        for (int i = 0; i < fullRating; ++i) {
          c++;
        }
        modelo.addElement(Integer.toString(c)+" Estrella(s)" + "  (" + volumeInfo.getRatingsCount() + " lugar)");
      }
      // Precio ( si existe).
      if (saleInfo != null && "FOR_SALE".equals(saleInfo.getSaleability())) {
        double save = saleInfo.getListPrice().getAmount() - saleInfo.getRetailPrice().getAmount();
        if (save > 0.0) {
          modelo.addElement("Precio Mercado: " + CURRENCY_FORMATTER.format(saleInfo.getListPrice().getAmount())
              + "  ");
        }
        modelo.addElement("Google eBooks Precio: "
            + CURRENCY_FORMATTER.format(saleInfo.getRetailPrice().getAmount()));
        if (save > 0.0) {
          modelo.addElement(" Ahorras: " + CURRENCY_FORMATTER.format(save) + " ("
              + PERCENT_FORMATTER.format(save / saleInfo.getListPrice().getAmount()) + ")");
        }
        modelo.addElement("\n");
      }
      // estado de acceso .
      String accessViewStatus = volume.getAccessInfo().getAccessViewStatus();
      String message = "Información adicional acerca de este libro está disponible de libros electrónicos de Google en :";
      if ("FULL_PUBLIC_DOMAIN".equals(accessViewStatus)) {
        message = "Este libro de dominio público está disponible de forma gratuita de libros electrónicos de Google en :";
      } else if ("SAMPLE".equals(accessViewStatus)) {
        message = "Una vista previa de este libro está disponible de libros electrónicos de Google en :";
      }
      modelo.addElement(message);
      // Enlace a Google libros electrónicos .
      modelo.addElement(volumeInfo.getInfoLink());
    }
    modelo.addElement("---------------------------------------------------------------------------------------------------------------------------------------------");
    modelo.addElement( volumes.getTotalItems() + " resultados totales en:  http://books.google.com/ebooks?q="
          + URLEncoder.encode(query, "UTF-8"));
    
   list.setModel(modelo);
  }
  
  public   void consulta() {
   
    JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
    try {
      String query = "";
          query = libro.getText();
      try {
        queryGoogleBooks(jsonFactory, query);
        // ¡Éxito!
        return;
      } catch (IOException e) {
        System.err.println(e.getMessage());
      }
    } catch (Throwable t) {
      t.printStackTrace();
    }
    System.exit(0);
  }
}
 

