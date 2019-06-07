/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Miguel
 */
public class NodoD {

    private Cancion datos;
    private NodoD ant;
    private NodoD sig;

    public NodoD(Cancion datos) {
        this.datos= datos;
        ant = null;
        sig = null;
    }

    public Cancion getDatos() {
        return datos;
    }

    public void setDatos(Cancion datos) {
        this.datos = datos;
    }

    public NodoD getAnt() {
        return ant;
    }

    public void setAnt(NodoD ant) {
        this.ant = ant;
    }

    public NodoD(Cancion datos, NodoD ant, NodoD sig) {
        this.datos = datos;
        this.ant = ant;
        this.sig = sig;
    }

    public NodoD getSig() {
        return sig;
    }

    public void setSig(NodoD sig) {
        this.sig = sig;
    }

    @Override
    public String toString() {
        return "NodoD{" + "datos=" + datos + ", ant=" + ant + ", sig=" + sig + '}';
    }
}
