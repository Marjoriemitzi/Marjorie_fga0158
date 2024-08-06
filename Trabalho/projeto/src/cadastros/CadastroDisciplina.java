package cadastros;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import app.Disciplina;

public class CadastroDisciplina {
	int numDisciplinas; 
	private List<Disciplina> disciplinas;
	
	public CadastroDisciplina() {
		numDisciplinas = 0;
		disciplinas = new ArrayList<Disciplina>();
	}
	
	public int cadastrarDisciplina(Disciplina d) {
		if(d.validarDisciplina()) {
			boolean cadastrou = disciplinas.add(d);
			if (cadastrou) {
				numDisciplinas = disciplinas.size();
			}
			return numDisciplinas;
		} else {
			JOptionPane.showMessageDialog(null, "Disciplina não cadastrada.\n"
    				+ "Preencha os campos em branco!");
    		 return numDisciplinas;
		}
		
	}
	
	public Disciplina pesquisarDisciplina(String id) {
		for (Disciplina d: disciplinas) {
			if (d.getId().equalsIgnoreCase(id)) {
				return d;
			}
		}
		return null;
	}
	
	public boolean removerDisciplina(Disciplina d) {
		boolean removeu = false; 
		if (disciplinas.contains(d)) {
			removeu = disciplinas.remove(d);
		}
		return removeu;
	}
	
	public boolean atualizarDisciplina(String id, Disciplina d) {
		boolean resposta = false;
		Disciplina remover = pesquisarDisciplina(id);
		if (remover != null) {
			disciplinas.remove(remover);
			resposta = disciplinas.add(d);
		}
		return resposta;
	}
	
	 public List<Disciplina> listarDisciplinas() {
	        return new ArrayList<Disciplina>(disciplinas);
	    }
}
