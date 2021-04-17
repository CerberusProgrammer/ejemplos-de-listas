package sample;

public class ListaCircularDoble<T> {

    Node<T> inicio;
    Node<T> fin;

    public ListaCircularDoble() {
        inicio = null;
        fin = null;
    }

    void insertaInicio(T dato) {
        Node<T> n = new Node<>();
        n.setInfo(dato);

        if (inicio == null) {
            inicio = fin = n;
            n.setSig(inicio);
            n.setAnt(inicio);
        } else {
            n.setSig(inicio);
            inicio.setAnt(n);
            inicio = n;
            fin.setSig(inicio);
            n.setAnt(fin);
        }
    }

    void insertaFin(T dato) {
        Node<T> n = new Node<>();
        n.setInfo(dato);

        if (inicio == null) {
            inicio = n;
            fin = n;
            n.setSig(inicio);
            n.setAnt(inicio);
        } else {
            n.setSig(inicio);
            inicio.setAnt(n);
            fin.setSig(n);
            n.setAnt(fin);
            fin = n;
        }
    }

    T eliminaInicio() {
        Node<T> n = inicio;

        if (inicio == null)
            return null;
        else if (inicio == fin)
            inicio = fin = null;
        else {
            fin.setSig(inicio.getSig());
            inicio = inicio.getSig();
            inicio.setAnt(fin);
        }

        return n.getInfo();
    }

    T eliminaFin(){
        Node<T> n = fin;

        if (inicio == null)
            return null;
        else if (inicio == fin)
            inicio = fin = null;
        else {
            Node<T> r = fin.getAnt();
            r.setSig(inicio);
            inicio.setAnt(r);
            fin = r;
        }

        return n.getInfo();
    }

    String recorre() {
        Node<T> aux = inicio;
        String s = "Lista: \n ";

        if (aux != null) {
            s += aux.getInfo() + ", \n ";
            aux = aux.getSig();

            while (aux != inicio) {
                s += aux.getInfo() + ", \n ";
                aux = aux.getSig();
            }
        } else {
            s+= "Vacia";
        }
        return s;
    }

    public String mostrarListaRecursiva() {
        return mostrarRecursivo(inicio);
    }

    private String mostrarRecursivo(Node<T> x) {
        if (x == fin)
            return "" + x.getInfo();
        else
            return "" + x.getInfo() + " " + mostrarRecursivo(x.getSig());
    }
}
