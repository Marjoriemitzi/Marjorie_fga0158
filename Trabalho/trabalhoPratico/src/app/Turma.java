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
    
    public void removerAluno(Aluno aluno) {
        alunos.remove(aluno);
    }
    
    public String imprimirListaPresenca() {
        StringBuilder sb = new StringBuilder();
        sb.append("Disciplina: ").append(disciplina.getNome()).append("\n");
        sb.append("Professor: ").append(professor.getNome()).append("\n");
        sb.append("Código da Turma: ").append(codigo).append("\n");
        sb.append("Lista de Alunos:\n");

        for (Aluno aluno : alunos) {
            sb.append("Matrícula: ").append(aluno.getMatricula()).append(", Nome: ").append(aluno.getNome()).append("\n");
        }

        return sb.toString();
    }

    @Override
    public String toString() {
        return "Codigo da Turma:" + codigo;
    }
	
}
