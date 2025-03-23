class NoPilha {
    int valor;
    NoPilha proximo;

    NoPilha(int valor) {
        this.valor = valor;
        this.proximo = null;
    }
}

class Pilha {
    NoPilha topo;

    public Pilha() {
        topo = null;
    }

    public void empilhar(int valor) {
        NoPilha novo = new NoPilha(valor);
        novo.proximo = topo;
        topo = novo;
    }

    public int desempilhar() {
        if (topo == null) throw new RuntimeException("Pilha vazia");
        int valor = topo.valor;
        topo = topo.proximo;
        return valor;
    }

    public boolean estaVazia() {
        return topo == null;
    }

    public void imprimir() {
        NoPilha atual = topo;
        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }
}
