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

/**
 * @author ANTHONY HERNANDEZ Y JOHANNA CHOEZ
 *
 */

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

import javax.swing.DefaultListModel;
import javax.swing.JList;



public class buscador {
  
  private static JList<String> list;
  private static DefaultListModel<String> modelo = new DefaultListModel();
  private static final String APPLICATION_NAME = "books";
  private static final NumberFormat CURRENCY_FORMATTER = NumberFormat.getCurrencyInstance();
  private static final NumberFormat PERCENT_FORMATTER = NumberFormat.getPercentInstance();
  
  private static void queryGoogleBooks(JsonFactory jsonFactory, String query,JList<String> list) throws Exception  {
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
  
  public void consulta(String nombre,JList<String> list) {
   
    JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
    try {
      String query = "";
          query = nombre;
      try {
        queryGoogleBooks(jsonFactory, query,list);
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
  
  public void borrar(){
    modelo.removeAllElements();
  }

}

