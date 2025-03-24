package Coordenadas;

public class Coordenada {
    public int x;
    public int y;
    public Coordenada proximo;

    public Coordenada(int x, int y) {
        this.x = x;
        this.y = y;
        this.proximo = null;
    }
}