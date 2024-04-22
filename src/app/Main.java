package app;
import vista.VistaPrincipal;

public class Main {
	public static void main(String[] args) {
        int totalEstrellas = 1000;
        int width = 1000;
        int height = 1000;
        int[][] espacioEstrellas = new int[width][height];

        for (int i = 0; i < totalEstrellas; i++) {
            int x = (int) (Math.random() * width);
            int y = (int) (Math.random() * height);
            espacioEstrellas[x][y]++;
        }

        VistaPrincipal view = new VistaPrincipal(espacioEstrellas);
    }

}
