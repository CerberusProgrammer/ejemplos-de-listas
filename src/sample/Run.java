package sample;

public class Run {

    public static void main(String[] args) {
        Lista<Integer> lista = new Lista<>();
        lista.insertStart(1);
        lista.removeStart();
        lista.insertStart(3);
        lista.insertEnd(4);
        lista.insertStart(2);
        lista.insertStart(21);
        lista.insertStart(22);
        lista.insertStart(23);
        System.out.println(lista.buscar(3));
        lista.eliminaX(3);
        System.out.println("Lista: " + lista.mostrarListaRecursiva());

        ListaDoble<Integer> listaDoble = new ListaDoble<>();
        listaDoble.insertStart(1);
        listaDoble.insertStart(2);
        listaDoble.insertStart(3);
        listaDoble.insertStart(4);
        listaDoble.insertEnd(9);
        listaDoble.insertStart(5);
        System.out.println("Lista Doble: " + listaDoble.mostrarListaRecursiva());

        ListaCircular<Integer> listaCircular = new ListaCircular<>();
        listaCircular.insertaInicio(1);
        listaCircular.insertaInicio(2);
        listaCircular.insertaInicio(3);
        listaCircular.insertaFinal(3);
        listaCircular.insertaInicio(4);
        listaCircular.insertaInicio(5);
        System.out.println("Lista circular: " + listaCircular.mostrarListaRecursiva());

        ListaCircularDoble<Integer> integerListaCircularDoble = new ListaCircularDoble<>();
        integerListaCircularDoble.insertaInicio(1);
        integerListaCircularDoble.insertaInicio(21);
        integerListaCircularDoble.insertaInicio(31);
        integerListaCircularDoble.insertaFin(5);
        integerListaCircularDoble.insertaInicio(41);
        integerListaCircularDoble.insertaInicio(51);
        integerListaCircularDoble.insertaInicio(61);
        System.out.println("Lista Circular Doble: " + integerListaCircularDoble.mostrarListaRecursiva());
    }
}
