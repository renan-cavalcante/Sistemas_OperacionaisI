package exercicio3.entities;

public class Conta {
	private Integer idConta;
	private double saldo;
	private static int contador = 0;
	
	public Conta() {
		contador++;
		idConta = contador;
	}

	public Integer getIdConta() {
		return idConta;
	}


	public double getSaldo() {
		return saldo;
	}

	public void saque(double valor) {
		saldo -= valor;
	}
	
	public void deposito(double valor) {
		saldo += valor;
	}
	

}
