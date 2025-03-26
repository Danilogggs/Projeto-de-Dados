package Main;

import Coordenadas.FilaCoordenada;
import Coordenadas.Coordenada;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class Fila {
    public static void main(String[] args) throws IOException, InterruptedException {
        File arquivo = new File("Imagens/teste.png");
        BufferedImage imagem = ImageIO.read(arquivo);

        JFrame frame = new JFrame("Preenchimento de Imagem");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(imagem.getWidth(), imagem.getHeight());

        JLabel label = new JLabel(new ImageIcon(imagem));
        frame.add(label);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        int largura = imagem.getWidth();
        int altura = imagem.getHeight();

        int origemX = 52;
        int origemY = 176;

        int corFundo = imagem.getRGB(origemX, origemY);
        int novaCor = 0xFFFF0000;

        FilaCoordenada fila = new FilaCoordenada(largura * altura);
        fila.enqueue(new Coordenada(origemX, origemY));

        while (!fila.isEmpty()) {
            Coordenada atual = fila.dequeue();
            int x = atual.x;
            int y = atual.y;

            if (x < 0 || x >= largura || y < 0 || y >= altura)
                continue;

            int corAtual = imagem.getRGB(x, y);

            if (corAtual == corFundo) {
                imagem.setRGB(x, y, novaCor);

                fila.enqueue(new Coordenada(x + 1, y));
                fila.enqueue(new Coordenada(x - 1, y));
                fila.enqueue(new Coordenada(x, y + 1));
                fila.enqueue(new Coordenada(x, y - 1));

                label.setIcon(new ImageIcon(imagem));
                frame.repaint();

                Thread.sleep(0, 1);
            }
        }

        File saida = new File("Imagens/testeGERADO.png");
        ImageIO.write(imagem, "png", saida);
    }
}
