package vista;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class DibujoEstrellas extends JPanel{
	
	
	private int[][] espacioEstrellas;
    Random random = new Random();
    private int xOffset = 0;
    private int yOffset = 0;
    public double zoomFactor=1.0;
    BufferedImage[] imagenesEstrellas = new BufferedImage[10];
    private int[][] estrellasSeleccionadas;
    private boolean estrellasSeleccionadasInicializadas = false;
    


    public DibujoEstrellas(int[][] espacioEstrellas) {
        this.espacioEstrellas = espacioEstrellas;
        try {
            imagenesEstrellas[0] = ImageIO.read(new File("src/imgs/estrella0.png"));
            imagenesEstrellas[1] = ImageIO.read(new File("src/imgs/estrella1.png"));
            imagenesEstrellas[2] = ImageIO.read(new File("src/imgs/estrella2.png"));
            imagenesEstrellas[3] = ImageIO.read(new File("src/imgs/estrella3.png"));
            imagenesEstrellas[4] = ImageIO.read(new File("src/imgs/estrella4.png"));
            imagenesEstrellas[5] = ImageIO.read(new File("src/imgs/estrella5.png"));
            imagenesEstrellas[6] = ImageIO.read(new File("src/imgs/estrella6.png"));
            imagenesEstrellas[7] = ImageIO.read(new File("src/imgs/estrella7.png"));
            imagenesEstrellas[8] = ImageIO.read(new File("src/imgs/estrella8.png"));
            imagenesEstrellas[9] = ImageIO.read(new File("src/imgs/estrella9.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform savedXForm = g2d.getTransform(); 
        g2d.scale(zoomFactor, zoomFactor);
        setBackground(new java.awt.Color(0, 0, 0));

        int width = getWidth();
        int height = getHeight();

        if (!estrellasSeleccionadasInicializadas) {
            estrellasSeleccionadas = new int[espacioEstrellas.length][espacioEstrellas[0].length];
            for (int x = 0; x < espacioEstrellas.length; x++) {
                for (int y = 0; y < espacioEstrellas[x].length; y++) {
                    estrellasSeleccionadas[x][y] = random.nextInt(imagenesEstrellas.length);
                }
            }
            estrellasSeleccionadasInicializadas = true; 
        }
        
        for (int x = 0; x < width; x++) {
            int matrixX = (x + xOffset) % espacioEstrellas.length;
            if (matrixX < 0) {
                matrixX += espacioEstrellas.length;
            }

            for (int y = 0; y < height; y++) {
                int matrixY = (y + yOffset) % espacioEstrellas[matrixX].length;
                if (matrixY < 0) {
                    matrixY += espacioEstrellas[matrixX].length;
                }
              
                int estrellas = espacioEstrellas[matrixX][matrixY];
                int indiceAleatorio = estrellasSeleccionadas[matrixX][matrixY];
                for (int i = 0; i < estrellas; i++) {
              
              g2d.drawImage(imagenesEstrellas[indiceAleatorio],x, y, this);
               }
          }
          
        }
        g2d.setTransform(savedXForm);
    }
    
  

    public void desplazarDerecha() {
        xOffset += 6;
        repaint();
    }

    public void desplazarIzquierda() {
        xOffset -= 6;
        repaint();
    }
    public void desplazarArriba() {
        yOffset -= 6;
        repaint();
    }

    public void desplazarAbajo() {
        yOffset += 6;
        repaint();
    }
    public void Aumentar() {
    	zoomFactor *= 1.5;
         repaint();
    }
    public void Disminuir() {
    	zoomFactor /= 1.5; 
       if (zoomFactor < 1.0) {
    	   zoomFactor = 1.0;
        }
        repaint();
    }
}
