package Default;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Bloco extends JLabel {
    BufferedImage i1;
    BufferedImage i2;
    BufferedImage i3;
    BufferedImage i4;

    BufferedImage p1;
    BufferedImage p2;
    BufferedImage p3;
    BufferedImage p4;
    {
        try {
            i1 = ImageIO.read(getClass().getResource("/Assets/tipo1.png"));
            i2 = ImageIO.read(getClass().getResource("/Assets/tipo2.png"));
            i3 = ImageIO.read(getClass().getResource("/Assets/tipo3.png"));
            i4 = ImageIO.read(getClass().getResource("/Assets/tipo4.png"));

            p1 = ImageIO.read(getClass().getResource("/Assets/pino1.png"));
            p2 = ImageIO.read(getClass().getResource("/Assets/pino2.png"));
            p3 = ImageIO.read(getClass().getResource("/Assets/pino3.png"));
            p4 = ImageIO.read(getClass().getResource("/Assets/pino4.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    BufferedImage[] imagens = {null,p1,p2,p3,p4};

    String tipo;
    char tipoP;
    int pino1;
    int pino2;
    int pino3;
    int pino4;

    public Bloco(String tipo) {
        this.tipo = tipo;
        this.tipoP = this.tipo.charAt(0);
        if (this.tipoP != '0') {
            this.pino1 = 0;
            this.pino2 = 0;
            this.pino3 = 0;
            this.pino4 = 0;
        }
        setBackground(Color.GRAY);
        setSize(100,100);
        setVisible(true);

    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
        this.tipoP = this.tipo.charAt(0);
        if (this.tipoP != '0') {
            this.pino1 = Integer.parseInt(String.valueOf(tipo.charAt(1)));
            this.pino2 = Integer.parseInt(String.valueOf(tipo.charAt(2)));
            this.pino3 = Integer.parseInt(String.valueOf(tipo.charAt(3)));
            this.pino4 = Integer.parseInt(String.valueOf(tipo.charAt(4)));
        }
        repaint();
    }

    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        switch (tipoP) {
            case '1':
                g2D.drawImage(i1, 0, 0, 90, 90, null);
                g2D.drawImage(imagens[pino1], 35, 0, 20, 20, null);
                g2D.drawImage(imagens[pino2], 70, 35, 30, 30, null);
                g2D.drawImage(imagens[pino3], 35, 70, 30, 30, null);
                g2D.drawImage(imagens[pino4], 0, 35, 30, 30, null);
                break;
            case '2':
                g2D.drawImage(i2, 0, 0, 90, 90, null);
                g2D.drawImage(imagens[pino1], 35, 0, 20, 20, null);
                g2D.drawImage(imagens[pino2], 70, 35, 30, 30, null);
                g2D.drawImage(imagens[pino3], 35, 70, 30, 30, null);
                g2D.drawImage(imagens[pino4], 0, 35, 30, 30, null);
                break;
            case '3':
                g2D.drawImage(i3, 0, 0, 90, 90, null);
                g2D.drawImage(imagens[pino1], 35, 0, 20, 20, null);
                g2D.drawImage(imagens[pino2], 70, 35, 30, 30, null);
                g2D.drawImage(imagens[pino3], 35, 70, 30, 30, null);
                g2D.drawImage(imagens[pino4], 0, 35, 30, 30, null);
                break;
            case '4':
                g2D.drawImage(i4, 0, 0, 90, 90, null);
                g2D.drawImage(imagens[pino1], 35, 0, 20, 20, null);
                g2D.drawImage(imagens[pino2], 70, 35, 30, 30, null);
                g2D.drawImage(imagens[pino3], 35, 70, 30, 30, null);
                g2D.drawImage(imagens[pino4], 0, 35, 30, 30, null);
                break;
        }
    }
}
