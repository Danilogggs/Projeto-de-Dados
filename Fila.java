class NoFila {
    int valor;
    NoFila proximo;

    NoFila(int valor) {
        this.valor = valor;
        this.proximo = null;
    }
}

class Fila {
    NoFila inicio, fim;

    public Fila() {
        inicio = fim = null;
    }

    public void enfileirar(int valor) {
        NoFila novo = new NoFila(valor);
        if (fim != null) {
            fim.proximo = novo;
        } else {
            inicio = novo;
        }
        fim = novo;
    }

    public int desenfileirar() {
        if (inicio == null) throw new RuntimeException("Fila vazia");
        int valor = inicio.valor;
        inicio = inicio.proximo;
        if (inicio == null) fim = null;
        return valor;
    }

    public boolean estaVazia() {
        return inicio == null;
    }

    public void imprimir() {
        NoFila atual = inicio;
        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }
}
