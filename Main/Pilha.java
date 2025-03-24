package Main;

import Coordenadas.Coordenada;
import Coordenadas.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class Pilha {
    public static void main(String[] args) throws IOException, InterruptedException  {
        File arquivo = new File("Imagens/cruz.png");
        // File arquivo = new File("jetixIMG2.png");
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

        int origemX = 673;
        int origemY = 253;

        int corFundo = imagem.getRGB(origemX, origemY); 
        int novaCor = 0xFFFF0000; 

        PilhaCoordenada pilha = new PilhaCoordenada();
        pilha.empilhar(origemX, origemY);

        while (!pilha.vazio()) {
            Coordenada coord = pilha.desempilhar();
            int x = coord.x;
            int y = coord.y;

            if (x < 0 || x >= largura || y < 0 || y >= altura)
                continue;

            int corAtual = imagem.getRGB(x, y);

            if (corAtual == corFundo) {
                imagem.setRGB(x, y, novaCor);

                pilha.empilhar(x + 1, y);
                pilha.empilhar(x - 1, y);
                pilha.empilhar(x, y + 1);
                pilha.empilhar(x, y - 1);

                label.setIcon(new ImageIcon(imagem));
                frame.repaint();

                Thread.sleep(0,1);
            }

        }

        File saida = new File("Imagens/Pilha1_ATUALIZADA.png");
        // File saida = new File("Imagens/Pilha2_ATUALIZADA.png");
        ImageIO.write(imagem, "png", saida);
    }
}
