package exercicio4.entities;

import java.util.ArrayList;
import java.util.List;

public class Carro {
	private int idCarro;
	private Escuderia escuderia;
	private List<Double> voltaTempo = new ArrayList<>();
	
	public Carro(int idCarro, Escuderia escuderia) {
		super();
		this.idCarro = idCarro;
		this.escuderia = escuderia;
	}

	public int getIdCarro() {
		return idCarro;
	}

	public Escuderia getEscuderia() {
		return escuderia;
	}

	public List<Double> getVoltaTempo() {
		return voltaTempo;
	}
	
	public String melhorVolta() {
		voltaTempo.sort(null);;
		return voltaTempo.get(0)+"";
	}
	
	
	
	public void addTempoVolta(Double tempo) {
		voltaTempo.add(tempo);
	}
	
	

}
