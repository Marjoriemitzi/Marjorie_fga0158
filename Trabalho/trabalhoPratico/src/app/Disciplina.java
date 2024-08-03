package app;

public class Disciplina {
	
	private String nome,
				   id;

	public Disciplina(String nome, String id) {
		super();
		this.nome = nome;
		this.id = id;
	}
	
	public final String getNome() {
		return nome;
	}
	
	public final String getId() {
		return id;
	}
	
	public String toString() {
		String resposta = "DISCIPLINA\n";
		resposta += "Disciplina: " + nome + '\n';
		resposta += "ID: " + id + '\n';
		return resposta;
	}
	
	
}
