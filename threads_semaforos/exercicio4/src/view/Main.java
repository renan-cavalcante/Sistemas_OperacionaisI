package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Semaphore;

import exercicio4.controller.TreinoController;
import exercicio4.entities.Carro;
import exercicio4.entities.Escuderia;

public class Main {

	public static void main(String[] args) {
		Escuderia ferrari = new Escuderia("Ferrari", new Semaphore(1));
		Escuderia mercedez = new Escuderia("Mercedes", new Semaphore(1));
		Escuderia redBull = new Escuderia("RedBull", new Semaphore(1));
		Escuderia williams = new Escuderia("Williams", new Semaphore(1));
		Escuderia mcLaren = new Escuderia("McLaren", new Semaphore(1));
		Escuderia alpine = new Escuderia("Alpine", new Semaphore(1));
		Escuderia alphaTauri = new Escuderia("AlphaTauri", new Semaphore(1));
		
		Carro carroFerrari1 = new Carro(1, ferrari);
		Carro carroFerrari2 = new Carro(2, ferrari);
		
		Carro carroMercedez1 = new Carro(1, mercedez);
		Carro carroMercedez2 = new Carro(2, mercedez);
		
		Carro carroRedBull1 = new Carro(1, redBull);
		Carro carroRedBull2 = new Carro(2, redBull);
		
		Carro carroWilliams1 = new Carro(1, williams);
		Carro carroWilliams2 = new Carro(2, williams);
		
		Carro carroMcLaren1 = new Carro(1, mcLaren);
		Carro carroMcLaren2 = new Carro(2, mcLaren);
		
		Carro carroAlpine1 = new Carro(1, alpine);
		Carro carroAlpine2 = new Carro(2, alpine);
		
		Carro carroAlphaTauri1 = new Carro(1, alphaTauri);
		Carro carroAlphaTauri2 = new Carro(2, alphaTauri);
		
		List<Carro> carros = new ArrayList<>();
		
		carros.add(carroAlpine2);
		carros.add(carroAlpine1);
		carros.add(carroMcLaren2);
		carros.add(carroMcLaren1);
		carros.add(carroRedBull2);
		carros.add(carroRedBull1);
		carros.add(carroMercedez2);
		carros.add(carroMercedez1);
		carros.add(carroFerrari2);
		carros.add(carroFerrari1);
		carros.add(carroAlphaTauri2);
		carros.add(carroAlphaTauri1);
		carros.add(carroWilliams2);
		carros.add(carroWilliams1);
		
		Semaphore semaforo = new Semaphore(5);
		
		for(Carro c : carros) {
			new TreinoController(semaforo, c).start();
		}
		
		Map<Carro,String> grid =  new TreinoController(null, null).getGrid();
		
		
		int posicao = 1;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("===========Grid classificatorio==========    ===");
		for(Carro c : grid.keySet()) {
			System.out.println(posicao+"# "+c.getIdCarro()+"carro da "+c.getEscuderia().getNome()+" com tempo: " + grid.get(c));
			posicao++;
		}
		
	}

}
