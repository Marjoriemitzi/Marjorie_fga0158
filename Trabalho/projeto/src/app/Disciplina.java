package app;

import javax.swing.JOptionPane;

public class Disciplina {
	
	private String nome,
				   id;

	public Disciplina(String nome, String id) throws CampoEmBrancoException{
		super();
		
		 try {
	         setNome(nome);
	     } catch (CampoEmBrancoException e) {
	            System.out.println(e.getMessage());
	            JOptionPane.showMessageDialog(null, "Nome em branco.");
	        }
		 try {
			 setId(id);
		 } catch (CampoEmBrancoException e) {
			 System.out.println(e.getMessage());
	            JOptionPane.showMessageDialog(null, "Id em branco.");

		 }
}
	
	public boolean validarDisciplina() {
		try {
			setNome(nome);
			setId(id);
			return true;
		} catch (CampoEmBrancoException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	
	 public final String getNome() {
	        return nome;
	    }

	 public void setNome(String nome) throws CampoEmBrancoException {
	        if (nome == null || nome.trim().isEmpty()) {
	            throw new CampoEmBrancoException("O campo 'nome' está em branco.");
	        }
	        this.nome = nome;
	    }
	    
	 
	public final String getId() {
		return id;
	}
	
	public void setId(String id)throws CampoEmBrancoException {
		if (id == null || id.trim().isEmpty()) {
			throw new CampoEmBrancoException("O campo 'id' está em branco.");
		}
		this.id = id; 
	}
	
	public String toString() {
		String resposta = "DISCIPLINA\n";
		resposta += "Disciplina: " + nome + '\n';
		resposta += "ID: " + id + '\n';
		return resposta;
	}
	
	
}