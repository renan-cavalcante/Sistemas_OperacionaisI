package exercicio4.controller;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Semaphore;

import exercicio4.entities.Carro;

public class TreinoController extends Thread {

	private static Comparator<Carro> comp = (c1,c2) -> c1.melhorVolta().compareTo(c2.melhorVolta());
	private static Map<Carro,String> grid = new TreeMap<>(comp);
	private Semaphore treinoSema;
	private Carro carro;
	private int voltas = 0;
	
	public TreinoController(Semaphore treinoSema, Carro carro) {
		super();
		this.treinoSema = treinoSema;
		this.carro = carro;
	}
	
	@Override
	public void run() {
		try {
			carro.getEscuderia().getSemaforo().acquire();
			treinoSema.acquire();
			entradaPista();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			carro.getEscuderia().getSemaforo().release();;
			treinoSema.release();
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	private void entradaPista() {
		System.out.println(carro.getIdCarro()+"# da "+carro.getEscuderia().getNome()+" entrou na pista");
		while(voltas < 3) {
			carro.addTempoVolta(volta());
		}
		grid.put(carro, carro.melhorVolta());
		System.out.println(carro.getIdCarro()+"# da "+carro.getEscuderia().getNome()+" saiu da pista");
		
	}

	public Double volta() {
		voltas++;
		double tempo = Math.random()*30 + 60;
		System.out.println(voltas+"º volta do "+carro.getIdCarro()+"# da "+carro.getEscuderia().getNome()+" tempo ="+tempo);	
		return tempo;
	}
	
	public Map<Carro,String> getGrid(){
		return grid;
	}
}
