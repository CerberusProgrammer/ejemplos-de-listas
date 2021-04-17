package sample;

public class ListaCircular<T> {

    Node<T> inicio;
    Node<T> fin;

    public ListaCircular() {
        this.inicio = null;
        this.fin = null;
    }

    public ListaCircular(Node<T> inicio, Node<T> fin) {
        this.inicio = inicio;
        this.fin = fin;
    }

    void insertaInicio(T dato) {
        Node<T> n = new Node<>();
        n.setInfo(dato);

        if (inicio == null) {
            inicio = n;
            fin = n;
            n.setSig(inicio);
        } else {
            n.setSig(inicio);
            inicio = n;
            fin.setSig(inicio);
        }
    }

    void insertaFinal(T dato) {
        Node<T> n = new Node<>();
        n.setInfo(dato);

        if (inicio == null) {
            inicio = n;
            fin = n;
            n.setSig(inicio);
        } else {
            n.setSig(inicio);
            fin.setSig(n);
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
        }

        return n.getInfo();
    }

    T eliminaFinal() {
        Node<T> n = fin;

        if (inicio == null)
            return null;
        else if (inicio == fin)
            inicio = fin = null;
        else {
            Node<T> r = inicio;

            while (r.getSig() != fin)
                r = r.getSig();

            fin = r;
            fin.setSig(inicio);
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

    public T eliminaX(T data) {
        Node<T> act = inicio;
        Node<T> ant = null;

        while (act != null && !act.getInfo().equals(data)) {
            ant = act;
            act = act.getRef();
        }
        if (act != null && ant == null) {
            inicio = act.getRef();
            return act.getInfo();
        }
        if (act != null && ant != null) {
            ant.setRef(act.getRef());
            return act.getInfo();
        }
        return null;
    }

    public int buscar(T data) {
        int x = 0;
        Node<T> aux = inicio;

        while (!aux.getInfo().equals(data)) {
            aux = aux.getSig();

            if (aux == null)
                return 0;

            x++;
        }

        return x;
    }

}
