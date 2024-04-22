package modelo;

public class Estrella {
	
	 	private EstrellaFlyweight flyweight;

	    public Estrella(EstrellaFlyweight flyweight) {
	        this.flyweight = flyweight;
	    }

	    public EstrellaFlyweight getFlyweight() {
	        return flyweight;
	    }
}
