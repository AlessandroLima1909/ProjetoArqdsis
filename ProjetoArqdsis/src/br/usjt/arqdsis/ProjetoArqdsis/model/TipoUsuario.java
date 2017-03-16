package br.usjt.arqdsis.ProjetoArqdsis.model;

public enum TipoUsuario {
	ATENDENTE(1), SINDICO(2), FUNCIONARIO(3);

	private int tipo;

	TipoUsuario(int tipo) {
		this.tipo = tipo;
	}

	public int getTipo() {
		return tipo;
	}

}
