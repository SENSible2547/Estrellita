package vista;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VistaPrincipal extends JFrame{
	private int[][] espacioEstrellas;
    private DibujoEstrellas dibujoEstrellas;

    public VistaPrincipal(int[][] espacioEstrellas) {
        this.setEspacioEstrellas(espacioEstrellas);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1900, 1000);

        JButton botonDerecha = new JButton(">");
        botonDerecha.addActionListener(e -> {
            dibujoEstrellas.desplazarDerecha();
        });

        JButton botonIzquierda = new JButton("<");
        botonIzquierda.addActionListener(e -> {
            dibujoEstrellas.desplazarIzquierda();
        });
        JButton botonArriba = new JButton("^");
        botonArriba.addActionListener(e -> {
            dibujoEstrellas.desplazarArriba();
        });

        JButton botonAbajo = new JButton("v");
        botonAbajo.addActionListener(e -> {
            dibujoEstrellas.desplazarAbajo();
        });
        
        JButton botonMas = new JButton("+");
        botonMas.addActionListener(e -> {
            dibujoEstrellas.Aumentar();
        });
        JButton botonMenos = new JButton("-");
        botonMenos.addActionListener(e -> {
            dibujoEstrellas.Disminuir();
        });


        JPanel botonesPanel = new JPanel();
        botonesPanel.add(botonIzquierda);
        botonesPanel.add(botonDerecha);
        botonesPanel.add(botonArriba);
        botonesPanel.add(botonAbajo);
        botonesPanel.add(botonMas);
        botonesPanel.add(botonMenos);


        add(botonesPanel, BorderLayout.SOUTH);
        dibujoEstrellas = new DibujoEstrellas(espacioEstrellas);
        add(dibujoEstrellas, BorderLayout.CENTER);

        setVisible(true);
    }

	public int[][] getEspacioEstrellas() {
		return espacioEstrellas;
	}

	public void setEspacioEstrellas(int[][] espacioEstrellas) {
		this.espacioEstrellas = espacioEstrellas;
	}

}
