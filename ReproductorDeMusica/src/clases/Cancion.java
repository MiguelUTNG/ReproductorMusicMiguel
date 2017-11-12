/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;


/**
 *
 * @author usuario
 */
public class Cancion {
    private int id;
    private String titulo;
    private String genero;
    private String artista;
    private String album;
    private int year;
    private String ruta;
    

    public Cancion(String titulo, String genero, String artista, String album, int year, String ruta) {
        this.titulo = titulo;
        this.genero = genero;
        this.artista = artista;
        this.album = album;
        this.year = year;
        this.ruta = ruta;
    }
    
    public Cancion(){
        this("","","","",0,"");
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
    
    
    @Override
    public String toString() {
        return "Cancion{" + "titulo=" + titulo + ", genero=" + genero + ", artista=" + artista + ", album=" + album + ", year=" + year + ", ruta=" + ruta + '}';
    }
}
