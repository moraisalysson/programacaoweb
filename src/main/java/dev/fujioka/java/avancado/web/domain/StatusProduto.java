package dev.fujioka.java.avancado.web.domain;

public enum StatusProduto {
	
	CONSUMO(1), CAPITAL(2);
	
	private StatusProduto(final int status) {
		this.status = status;
	}
		
	private int status;
	
	public int getStatus() {
		return status;
	}
}
