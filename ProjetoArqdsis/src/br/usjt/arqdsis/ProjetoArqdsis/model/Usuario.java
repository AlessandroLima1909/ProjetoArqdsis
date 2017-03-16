package br.usjt.arqdsis.ProjetoArqdsis.model;

public class Usuario {
	private String nome, cpf, usuario, senha, email, horarioTrabalho;
	private int id;
	private TipoUsuario tipoUsuario;

	public int getTipoUsuario() {
		return tipoUsuario.getTipo();
	}

	public void setTipoUsuario(int tipoUsuario) {

		if      (tipoUsuario == 1)
			this.tipoUsuario = TipoUsuario.ATENDENTE;
		else if (tipoUsuario == 2)
			this.tipoUsuario = TipoUsuario.SINDICO;
		else if (tipoUsuario == 3)
			this.tipoUsuario = TipoUsuario.ATENDENTE;
	}

	public String getHorarioTrabalho() {
		return horarioTrabalho;
	}

	public void setHorarioTrabalho(String horarioTrabalho) {
		this.horarioTrabalho = horarioTrabalho;
	}

	public String getEmail() {
		return email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
