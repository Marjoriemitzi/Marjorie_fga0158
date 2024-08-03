package app;

public class Professor extends PessoaFisica{
	
	private String areaFormacao, 
	       matriculaFUB; 
	
	public Professor(String nome, String cpf, String email, String areaFormacao, String matriculaFUB) {
		super(nome, cpf, email);
		this.areaFormacao = areaFormacao;
		this.matriculaFUB = matriculaFUB;
	}

	public final String getAreaFormacao() {
		return areaFormacao;
	}

	public final String getMatriculaFUB() {
		return matriculaFUB;
	}
	
	public String toString() {
		String resposta = "PROFESSOR\n";
		resposta += "NOME: " + nome + '\n';
		resposta += "CPF: " + cpf + '\n'; 
		resposta += "EMAIL: " + email + '\n';
		resposta += "Area de Formacao: " + areaFormacao + '\n';
		resposta += "Matricula: " + matriculaFUB + '\n';
		return resposta;
	}
	
}
