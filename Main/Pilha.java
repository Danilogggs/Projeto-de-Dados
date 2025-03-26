package Main;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import javax.swing.*;
import Coordenadas.PilhaCoordenada;
import Coordenadas.Coordenada;

public class Pilha {
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

        PilhaCoordenada pilha = new PilhaCoordenada(largura * altura);
        pilha.push(origemX, origemY);

        while (!pilha.isEmpty()) {
            Coordenada topo = pilha.peek();

            if (topo.x < 0 || topo.x >= largura || topo.y < 0 || topo.y >= altura) {
                pilha.pop();
                continue;
            }

            int corAtual = imagem.getRGB(topo.x, topo.y);

            if (corAtual == corFundo) {
                Coordenada atual = pilha.pop();
                imagem.setRGB(atual.x, atual.y, novaCor);

                pilha.push(atual.x + 1, atual.y);
                pilha.push(atual.x - 1, atual.y);
                pilha.push(atual.x, atual.y + 1);
                pilha.push(atual.x, atual.y - 1);

                label.setIcon(new ImageIcon(imagem));
                frame.repaint();

                Thread.sleep(1);
            } else {
                pilha.pop();
            }
        }

        File saida = new File("Imagens/testeGERADO.png");
        ImageIO.write(imagem, "png", saida);
    }
}
