package cadastros;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import app.Professor;

public class CadastroProfessor {
	int numProfs;
	private List<Professor> professores;
	
	public CadastroProfessor() {
		numProfs = 0;
		professores = new ArrayList<Professor>();
	}
	
	public int cadastrarProfessor(Professor p) {
		if (p.validarProfessor()) {
			boolean cadastrou = professores.add(p);
			if (cadastrou) {
				numProfs = professores.size();
			}
			return numProfs;
		}else {
    		JOptionPane.showMessageDialog(null, "Professor não cadastrado.\n"
    				+ "Preencha os campos em branco!");
    		 return numProfs;
    	}
		
	}
	
	public Professor pesquisarProfessor(String matriculaProfessor) {
		for (Professor p: professores) {
			if (p.getMatriculaFUB().equalsIgnoreCase(matriculaProfessor)) {
				return p;
			}
		}
		return null;
	}
	
	public boolean removerProfessor(Professor p) {
		boolean removeu = false; 
		if (professores.contains(p)) {
			removeu = professores.remove(p);
		}
		return removeu;
	}
	
	public boolean atualizarProfessor(String matricula, Professor p) {
		boolean resposta = false;
		Professor remover = pesquisarProfessor(matricula);
		if (remover != null) {
			professores.remove(remover);
			resposta = professores.add(p);
		}
		return resposta;
	}
	
	public List<Professor> listarProfessores() {
        return new ArrayList<Professor>(professores);
    }
	
}
