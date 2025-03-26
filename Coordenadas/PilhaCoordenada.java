package Coordenadas;

public class PilhaCoordenada {
    private Coordenada[] elementos;
    private int topo;

    public PilhaCoordenada(int capacidade) {
        elementos = new Coordenada[capacidade];
        topo = -1;
    }

    public void push(int x, int y) {
        if (isFull()) {
            throw new IllegalStateException("A pilha está cheia");
        }
        elementos[++topo] = new Coordenada(x, y);
    }

    public Coordenada pop() {
        if (isEmpty()) {
            throw new IllegalStateException("A pilha está vazia");
        }
        Coordenada removido = elementos[topo];
        elementos[topo--] = null;
        return removido;
    }

    public Coordenada peek() {
        if (isEmpty()) {
            throw new IllegalStateException("A pilha está vazia");
        }
        return elementos[topo];
    }

    public boolean isEmpty() {
        return topo == -1;
    }

    public boolean isFull() {
        return topo == elementos.length - 1;
    }
}
