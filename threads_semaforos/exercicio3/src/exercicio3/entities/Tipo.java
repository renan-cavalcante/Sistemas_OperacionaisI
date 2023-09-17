package exercicio3.entities;

import exercicio3.controller.BancoController;

public enum Tipo{
	SAQUE(1){
		@Override
		public void operacao(BancoController controller, Conta conta, double valor) {
			
			 new Thread(( ) -> {
				controller.saque(conta, valor);
			}).start();
			
			
		}

		
	}, 
	DEPOSITO(2) {
		@Override
		public void operacao(BancoController controller, Conta conta, double valor) {
			
			
			new Thread(( )-> {
				controller.deposito(conta,valor);
			}).start();
			
		}
		
	};

	private int codigo;
	
	abstract public void operacao(BancoController controller, Conta conta, double valor);
	

	Tipo(int i) {
		this.codigo = i;
	}
	
	public int getCode() {
		return codigo;
	}
	
	public static Tipo valueOf(int codigo) {
		for(Tipo value : Tipo.values()) {
			if(value.getCode() == codigo) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
}
