package app;

public class PessoaFisica {
	
	protected String nome, 
	               cpf, 
	               email;
	
	public PessoaFisica(String nome, String cpf, String email) {
		this.nome = nome; 
		this.cpf = cpf;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getEmail() {
		return email;
	}
	
	public String toString() {
		String resposta = "\n";
		resposta += "NOME: " + nome + '\n';
		resposta += "CPF: " + cpf + '\n'; 
		resposta += "EMAIL: " + email + '\n';
		return resposta;
	}
}
