import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Fila {
    public static void main(String[] args) throws IOException {
        // File arquivo = new File("Imagens/jetixIMG.png");
        File arquivo = new File("Imagens/jetixIMG2.png");
        BufferedImage imagem = ImageIO.read(arquivo);

        int largura = imagem.getWidth();
        int altura = imagem.getHeight();

        int origemX = 1;
        int origemY = 1;

        int corFundo = imagem.getRGB(origemX, origemY); 
        int novaCor = 0xFFFF0000;

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
            }
        }

        // File saida = new File("Imagens/Fila1_ATUALIZADA.png");
        File saida = new File("Imagens/Fila2_ATUALIZADA.png");
        ImageIO.write(imagem, "png", saida);
    }
}
