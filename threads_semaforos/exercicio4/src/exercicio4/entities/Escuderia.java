package exercicio4.entities;

import java.util.concurrent.Semaphore;

public class Escuderia {
	private String nome;
	private Semaphore semaforo;
	
	public Escuderia(String nome, Semaphore semaforo) {
		super();
		this.nome = nome;
		this.semaforo = semaforo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Semaphore getSemaforo() {
		return semaforo;
	}
}
