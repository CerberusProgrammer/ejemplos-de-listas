package sample;

public class Lista<T> {

    private Node<T> start;

    Lista () {
        this.start = null;
    }

    public void insertStart(T data) {
        Node<T> node = new Node<>();
        node.setInfo(data);
        node.setSig(start);
        start = node;
    }

    public Node<T> removeStart() {
        if (start == null) {
            return null;
        }
        start = start.getSig();
        return start;
    }

    public void insertEnd(T data) {
        Node<T> node = new Node<>();
        node.setInfo(data);

        if (start == null) {
            node.setSig(start);
            start = node;
        } else {
            Node<T> aux = start;

            while (aux.getSig() != null)
                aux = aux.getSig();

            aux.setSig(node);
            node.setSig(null);
        }
    }

    public Node<T> removeEnd() {
        Node<T> a;
        Node<T> r;

        if (start == null) {
            return null;
        } else {
            if (start.getSig() == null) {
                start = null;
                return null;
            } else {
                r = start;
                a = r;
                while (r.getSig() != null) {
                    a = r;
                    r = r.getSig();
                }
                a.setSig(null);
            }
        }
        return a;
    }

    public String mostrarLista() {
        String s = "";
        Node<T> actual = start;

        while (actual != null) {
            s += actual.getInfo() + "\n";
            actual = actual.getSig();
        }
        return s;
    }

    public String mostrarListaRecursiva() {
        return mostrarRecursivo(start);
    }

    public String mostrarRecursivo(Node<T> x) {
        if (x == null)
            return "";
        else
            return "" + x.getInfo() + " " + mostrarRecursivo(x.getSig());
    }

    public T eliminaX(T data) {
        Node<T> act = start;
        Node<T> ant = null;

        while (act != null && !act.getInfo().equals(data)) {
            ant = act;
            act = act.getRef();
        }
        if (act != null && ant == null) {
            start = act.getRef();
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
        Node<T> aux = start;

        while (!aux.getInfo().equals(data)) {
            aux = aux.getSig();

            if (aux == null)
                return 0;

            x++;
        }

        return x;
    }

    public void insertaEnPosicion(T data, int position) {
        if (start == null) {
            Node<T> node = new Node<>();
            node.setInfo(data);
            if (position == 1) {
                node.setSig(start);
                if (start != null) {
                    start.setAnt(node);
                }
                start = node;
            } else {
                if (start.getSig() == null) {
                    Node<T> r = start;
                    while (r.getSig() != null) {
                        r = r.getSig();
                    }
                    r.setSig(node);
                    node.setAnt(r);
                    node.setSig(null);
                } else {
                    Node<T> r = new Node<>();
                    for (int f = 1; f <= position; f++) {
                        r = r.getSig();
                    }
                    Node<T> s = r.getSig();
                    r.setSig(node);
                    node.setAnt(r);
                    node.setSig(s);
                    s.setAnt(node);
                }
            }
        }
    }

}