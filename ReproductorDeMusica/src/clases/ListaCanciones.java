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
public class ListaCanciones {

    private NodoD inicio;
    private NodoD fin;
    private NodoD actual;
    String[] re;

    
    
    public ListaCanciones() {
        inicio = null;
        fin = null;
    }
    
    public String[] getLista() {
        NodoD aux;
        int elemento = 0;

        re = new String[recorrerLista()];
        String ayuda = "";

        aux = inicio;
        while (aux != null) {
            ayuda = aux.getDatos().getTitulo();
            re[elemento] = ayuda;
            aux = aux.getSig();
            elemento++;
        }
        return re;
    }
    
     public void setActual(String titulo) {

        NodoD aux;
        int elementos = 0;

        aux = inicio;
        while (aux != null) {
            if (titulo.equalsIgnoreCase(aux.getDatos().getTitulo())) {
                actual = aux;
            }
            aux = aux.getSig();
            elementos++;
        }
    }
     
 
    
    public int recorrerLista() {
        NodoD aux;
        int elementos = 0;

        aux = inicio;
        while (aux != null) {
          
            aux = aux.getSig();
            elementos++;
        }
        return elementos;
    }

    public String sacarCancion(int i) {
        getLista();
        return re[i];
    }

    public void insertarOrden(NodoD nuevo) {
        NodoD aux;
        //Caso 1: Lista vacia
        if (inicio == null) {
            inicio = nuevo;
            fin = nuevo;
        } else {
            aux = inicio;
            while (aux != null && nuevo.getDatos().getTitulo().compareTo(aux.getDatos().getTitulo()) > 0) {
                aux = aux.getSig();
            }
            //Caso 2:Inserción al inicio
            if (aux == inicio) {
                nuevo.setSig(inicio);
                inicio.setAnt(nuevo);
                inicio = nuevo;
            }
            //Caso 3:Inserción al final
            if (aux == null) {
                fin.setSig(nuevo);
                nuevo.setAnt(fin);
                fin = nuevo;
            } else //Caso 4: Insertar en medio
            if (aux != null && aux.getAnt() != null) {
                System.out.println("Caso 4");
                nuevo.setSig(aux);
                nuevo.setAnt(aux.getAnt());
                aux.getAnt().setSig(nuevo);
                aux.setAnt(nuevo);
            }
        }
    }

    public void recorrerLista(char orden) {
        NodoD aux;
        if (orden == 'A') {
            System.out.println("Recorido desde el inicio hasta el final");
            aux = inicio;
            while (aux != null) {
                System.out.println("==>" + aux.getDatos().toString());
                aux = aux.getSig();
            }
        } else {
            System.out.println("Recorido desde el final hasta el inicio");
            aux = fin;
            while (aux != null) {
                System.out.println("===>" + aux.getDatos().toString());
                aux = aux.getAnt();
            }
        }
    }

    public NodoD irPrimero() {
        actual = inicio;
        return inicio;
    }

    public NodoD irUltimo() {
        actual = fin;
        return fin;
    }

    public NodoD irAnterior() {
        if (actual.getAnt() != null) {
            actual = actual.getAnt();
        }
        return actual;
    }

    public NodoD irSiguiente() {
        if (actual.getSig() != null) {
            actual = actual.getSig();

        }
        return actual;
    }

    public NodoD getActual() {
        return actual;
    }

    public boolean eliminar() {
        if (actual == null) {
            return false;
        } else if (actual == inicio) {

            if (actual.getSig() == null) {
                // inicio = actual.getSig();
                // actual.getSig().setAnt(null);
                inicio = null;
                fin = null;
                actual = null;
                System.out.println("lista vacia");
            } else {

                inicio = actual.getSig();
                inicio.setAnt(null);
                System.out.println("lista von un elemento");

            }
            // como elimiar cuando es el ultimo
        } else if (actual == fin) {
            fin = actual.getAnt();
            fin.setSig(null);
            System.out.println("ultimo elemento");
            return true;
        } else {
            actual.getAnt().setSig(actual.getSig());
            actual.getSig().setAnt(actual.getAnt());
            System.out.println("en el medio");
        }
        return true;
    }

}
