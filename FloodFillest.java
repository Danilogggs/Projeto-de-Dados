public class FloodFillest {
    public static void main(String[] args) {
        System.out.println("xxxxxx FILA xxxxxx");
        Fila fila = new Fila();
        fila.enfileirar(10);
        fila.enfileirar(20);
        fila.enfileirar(30);
        fila.imprimir();
        fila.desenfileirar();
        fila.imprimir();

        System.out.println("\nxxxxxx PILHA xxxxxx");
        Pilha pilha = new Pilha();
        pilha.empilhar(100);
        pilha.empilhar(200);
        pilha.empilhar(300);
        pilha.imprimir(); 
        pilha.desempilhar();
        pilha.imprimir();
    }
}
