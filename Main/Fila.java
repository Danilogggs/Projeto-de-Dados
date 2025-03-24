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
        File arquivo = new File("Imagens/rio.png");
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
        int origemX = 1;
        int origemY = 1;
        int corFundo = imagem.getRGB(origemX, origemY);
        int novaCor = 0xFFFF0000; // Vermelho

        FilaCoordenada fila = new FilaCoordenada();
        fila.enfileirar(origemX, origemY);

        while (!fila.vazia()) {
            Coordenada coord = fila.desenfileirar();
            int x = coord.x;
            int y = coord.y;

            if (x < 0 || x >= largura || y < 0 || y >= altura)
                continue;

            int corAtual = imagem.getRGB(x, y);
            if (corAtual == corFundo) {
                imagem.setRGB(x, y, novaCor);

                fila.enfileirar(x + 1, y);
                fila.enfileirar(x - 1, y);
                fila.enfileirar(x, y + 1);
                fila.enfileirar(x, y - 1);

                label.setIcon(new ImageIcon(imagem));
                frame.repaint();

                Thread.sleep(0,1);
            }
        }

        File saida = new File("Imagens/Fila2_ATUALIZADA.png");
        ImageIO.write(imagem, "png", saida);
    }
}