package br.fsg.filereader.enumerator;

public enum Status {

	DISPONIVEL("Disponível"), RESERVADO("Reservado"), VENDIDO("Vendido"), ENTREGUE("Entregue");

	private String descricao;

	private Status(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return descricao;
	}
}
