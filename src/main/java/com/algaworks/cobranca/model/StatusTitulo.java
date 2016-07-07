package com.algaworks.cobranca.model;

public enum StatusTitulo {
	RECEBIDO("Recebido"),
	PENDENTE("Pendente");
	
	private String descricao;
	
	private StatusTitulo(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
