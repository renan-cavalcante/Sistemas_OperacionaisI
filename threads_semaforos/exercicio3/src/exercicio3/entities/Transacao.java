package exercicio3.entities;

public class Transacao {
	private Conta conta;
	private Double valor;
	private Tipo tipo;

	public Transacao(Conta conta, Double valor, Tipo tipo) {
		this.conta = conta;
		this.valor = valor;
		this.tipo = tipo;
	}

	public Conta getConta() {
		return conta;
	}

	public Double getValor() {
		return valor;
	}

	public Tipo getTipo() {
		return tipo;
	}
}
