package sample;

public class Node<T> {

    private T info;
    private Node<T> sig;
    private Node<T> ref;
    private Node<T> ant;

    public Node() {
        this.info = null;
        this.sig = null;
        this.ref = null;
        this.ant = null;
    }

    public T getInfo() {
        return info;
    }

    public Node<T> getAnt() {
        return ant;
    }

    public void setAnt(Node<T> ant) {
        this.ant = ant;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public Node<T> getSig() {
        return sig;
    }

    public void setSig(Node<T> sig) {
        this.sig = sig;
    }

    public Node<T> getRef() {
        return ref;
    }

    public void setRef(Node<T> ref) {
        this.ref = ref;
    }
}
