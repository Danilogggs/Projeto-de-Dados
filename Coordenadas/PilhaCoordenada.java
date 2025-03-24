package Coordenadas;

public class PilhaCoordenada {
    Coordenada topo;

    public void empilhar(int x, int y) {
        Coordenada nova = new Coordenada(x, y);
        nova.proximo = topo;
        topo = nova;
    }

    public Coordenada desempilhar() {
        if (vazio()) throw new RuntimeException("Pilha vazia");
        Coordenada temp = topo;
        topo = topo.proximo;
        return temp;
    }

    public boolean vazio() {
        return topo == null;
    }
}