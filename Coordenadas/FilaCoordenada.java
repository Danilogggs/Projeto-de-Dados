class FilaCoordenada {
    Coordenada inicio, fim;

    public void enfileirar(int x, int y) {
        Coordenada nova = new Coordenada(x, y);
        if (fim != null) {
            fim.proximo = nova;
        } else {
            inicio = nova;
        }
        fim = nova;
    }

    public Coordenada desenfileirar() {
        if (vazia()) throw new RuntimeException("Fila vazia");
        Coordenada temp = inicio;
        inicio = inicio.proximo;
        if (inicio == null) fim = null;
        return temp;
    }

    public boolean vazia() {
        return inicio == null;
    }
}
