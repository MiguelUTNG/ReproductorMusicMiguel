/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dom;

import clases.Cancion;
import clases.ListaCanciones;
import clases.NodoD;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 *
 * @author Miguel
 */
public class CancionDOM {

    private String pathFile = "C:\\Users\\usuario\\Desktop\\ToogleMenu\\MenuEjemplo\\src\\data\\Canciones.xml";
    
    public void addAll(ListaCanciones lista, String pathFile2){
        
        Cancion cancion;
        NodoD nodo = null;
        try{
            Document d = DOMHelper.getDocument(pathFile);
            Element canciones = d.getDocumentElement();
            lista.irPrimero();
            nodo = lista.getActual();
            while (nodo !=null){
                cancion =  nodo.getDatos();
                //crear un item para agregar una cancion
                Element item = d.createElement("cancion");
                //create tag id
                Element id= d.createElement("id");
                id.appendChild(d.createTextNode(""+cancion.getId()));
                item.appendChild(id);
                //Crear tag titulo
                Element titulo = d.createElement("titulo");
                titulo.appendChild(d.createTextNode(cancion.getGenero()));
                item.appendChild(titulo);
                //Crear tag artista
                Element artista = d.createElement("artista");
                artista.appendChild(d.createTextNode(cancion.getArtista()));
                item.appendChild(artista);
                 //Crear tag artista
                Element album = d.createElement("album");
                album.appendChild(d.createTextNode(cancion.getAlbum()));
                item.appendChild(album);
                 //Crear tag artista
                Element year = d.createElement("year");
                year.appendChild(d.createTextNode(""+cancion.getYear()));
                item.appendChild(year);
                //Crear tag ruta
                Element ruta = d.createElement("ruta");
                ruta.appendChild(d.createTextNode(cancion.getRuta()));
                item.appendChild(ruta);
                //Crear tag genero
                Element genero = d.createElement("genero");
                genero.appendChild(d.createTextNode(cancion.getGenero()));
                item.appendChild(genero);
                
                canciones.appendChild(item);
                
                nodo = nodo.getSig();
            }
            DOMHelper.saveXMLContent(d, pathFile2);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
     public List<Cancion> getAll(String pathFile2) {
        List<Cancion> canciones = new ArrayList();
        Cancion cancion;

        try {
            Document d = DOMHelper.getDocument(pathFile2);
            NodeList nl = d.getElementsByTagName("cancion");
            for (int i = 0; i < nl.getLength(); i++) {
                Element item = (Element) nl.item(i);
                cancion = new Cancion();
                cancion.setId(Integer.parseInt(item.getElementsByTagName("id").item(0).getTextContent()));
                cancion.setTitulo(item.getElementsByTagName("titulo").item(0).getTextContent());
                cancion.setGenero(item.getElementsByTagName("genero").item(0).getTextContent());
                cancion.setArtista(item.getElementsByTagName("artista").item(0).getTextContent());
                cancion.setAlbum(item.getElementsByTagName("album").item(0).getTextContent());
                cancion.setYear(Integer.parseInt(item.getElementsByTagName("year").item(0).getTextContent()));
                cancion.setRuta(item.getElementsByTagName("ruta").item(0).getTextContent());

                canciones.add(cancion);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return canciones;
    }
}
