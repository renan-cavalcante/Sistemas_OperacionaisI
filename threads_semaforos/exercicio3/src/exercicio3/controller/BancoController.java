package exercicio3.controller;

import java.util.concurrent.Semaphore;

import exercicio3.entities.Conta;
import exercicio3.entities.Transacao;

public class BancoController extends Thread{
	private Semaphore saqueSema;
	private Semaphore depositoSema;
	private Transacao[] transacoes;
	

	public BancoController(Semaphore saqueSema, Semaphore depositoSema, Transacao[] transacoes) {
		this.saqueSema = saqueSema;
		this.depositoSema = depositoSema;
		this.transacoes = transacoes;
		
	}
	
	@Override
	public void run() {
		exec();
		
	}
	
	public int  saque(Conta conta, double valorSaque) {
		try {
			saqueSema.acquire();
			System.err.println("Inicio saque");
			conta.saque(valorSaque);
			System.err.println("Fim saque");
			sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			saqueSema.release();
		}
	return 1;
	
	
	}
	
	public void  deposito(Conta conta, double valorDeposito) {
		try {
			depositoSema.acquire();
			System.out.println("Inicio deposito");
			conta.deposito(valorDeposito);
			System.out.println("Fim deposito");
			sleep(1);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			depositoSema.release();
		}		
	}
	
	public void exec() {
		for(Transacao t : transacoes) {
			t.getTipo().operacao(this,t.getConta(),t.getValor());
		}
	}

}
