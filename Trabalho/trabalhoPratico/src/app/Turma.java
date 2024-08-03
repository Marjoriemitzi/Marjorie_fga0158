package app;

import java.util.ArrayList;
import java.util.List;

public class Turma {
	
	private String codigo;
	private Disciplina disciplina;
	private Professor professor;
	private List<Aluno> alunos;
	
	public Turma(String codigo, Disciplina disciplina, Professor professor) {
        this.codigo = codigo;
        this.disciplina = disciplina;
        this.professor = professor;
        this.alunos = new ArrayList<>();
    }
	
	public String getCodigo() {
        return codigo;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }
    
    public void matricularAluno(Aluno aluno) {
        alunos.add(aluno);
    }
    
    public String toString() {
    	StringBuilder sb = new StringBuilder();
        sb.append("Código da Turma: ").append(codigo).append("\n")
          .append("Disciplina: ").append(disciplina.getNome()).append("\n")
          .append("Professor: ").append(professor.getNome()).append("\n")
          .append("Alunos:\n");
        for (Aluno aluno : alunos) {
            sb.append(aluno.getMatricula()).append(" - ").append(aluno.getNome()).append("\n");
        }
        return sb.toString();
    }
	
}
