package controlador;

import vista.VistaPrincipal;
import modelo.Estrella;

public class Controlador {
	private Estrella[] model;
    private VistaPrincipal view;

    public Controlador(Estrella[] model, VistaPrincipal view) {
        this.model = model;
        this.view = view;
    }
}
