package view;

import java.util.concurrent.Semaphore;

import exercicio3.controller.BancoController;
import exercicio3.entities.Conta;
import exercicio3.entities.Tipo;
import exercicio3.entities.Transacao;

public class Main {

	public static void main(String[] args) {
		Conta conta1 = new Conta();
		Conta conta2 = new Conta();
		Conta conta3 = new Conta();
		Conta conta4 = new Conta();
		
		Transacao t1 = new Transacao(conta1, 100.0, Tipo.SAQUE);//saque inicio
		Transacao t2 = new Transacao(conta2, 100.0, Tipo.SAQUE);
		Transacao t3 = new Transacao(conta3, 100.0, Tipo.SAQUE);
		Transacao t4 = new Transacao(conta3, 100.0, Tipo.SAQUE);
		Transacao t5 = new Transacao(conta3, 100.0, Tipo.SAQUE);
		Transacao t6 = new Transacao(conta3, 100.0, Tipo.SAQUE);
		Transacao t7 = new Transacao(conta3, 100.0, Tipo.SAQUE);
		Transacao t8 = new Transacao(conta3, 100.0, Tipo.SAQUE);
		Transacao t9 = new Transacao(conta4, 100.0, Tipo.SAQUE);
		Transacao t10 = new Transacao(conta3, 100.0, Tipo.SAQUE);//saque fim
		Transacao t11 = new Transacao(conta1, 100.0, Tipo.DEPOSITO);//deposito inicio
		Transacao t12 = new Transacao(conta2, 100.0, Tipo.DEPOSITO);
		Transacao t13 = new Transacao(conta3, 100.0, Tipo.DEPOSITO);
		Transacao t14 = new Transacao(conta3, 100.0, Tipo.DEPOSITO);
		Transacao t15 = new Transacao(conta3, 100.0, Tipo.DEPOSITO);
		Transacao t16 = new Transacao(conta3, 100.0, Tipo.DEPOSITO);
		Transacao t17 = new Transacao(conta3, 100.0, Tipo.DEPOSITO);
		Transacao t18 = new Transacao(conta3, 100.0, Tipo.DEPOSITO);
		Transacao t19 = new Transacao(conta4, 100.0, Tipo.DEPOSITO);
		Transacao t20 = new Transacao(conta3, 100.0, Tipo.DEPOSITO);//deposito fim
		
		Transacao[] transacao = {t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18,t19,t20};
		
		BancoController bc = new BancoController(new Semaphore(1), new Semaphore(1), transacao);
		bc.start();

	}

}
