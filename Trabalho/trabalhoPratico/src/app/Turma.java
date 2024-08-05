package app;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Turma {
    private String codigo;
    private Disciplina disciplina;
    private Professor professor;
    private List<Aluno> alunos;

    public Turma(String codigo, Disciplina disciplina, Professor professor) throws CampoEmBrancoException, DisciplinaNaoAtribuidaException, ProfessorNaoAtribuidoException {
        setCodigo(codigo);
        setDisciplina(disciplina);
        setProfessor(professor);
        this.alunos = new ArrayList<>();
        
        try {
        	setCodigo(codigo);
        } catch(CampoEmBrancoException e) {
        	System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Codigo em branco.");
        }
        try {
        	setDisciplina(disciplina);
        } catch(DisciplinaNaoAtribuidaException e) {
        	System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Disciplina nao atribuida.");
        }
        try {
        	setProfessor(professor);
        } catch(ProfessorNaoAtribuidoException e) {
        	System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Professor nao atribuida.");
        }
    }
    
    public boolean validarTurma() {
	    try {
	    	setCodigo(codigo);
	    	setDisciplina(disciplina);
	    	setProfessor(professor);
	        return true;
	    } catch (CampoEmBrancoException | DisciplinaNaoAtribuidaException | ProfessorNaoAtribuidoException e) {
	        System.out.println(e.getMessage());
	        return false;
	    }
	}

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) throws CampoEmBrancoException {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new CampoEmBrancoException("O campo 'código' está em branco.");
        }
        this.codigo = codigo;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) throws DisciplinaNaoAtribuidaException {
        if (disciplina == null) {
            throw new DisciplinaNaoAtribuidaException("A disciplina não foi atribuída.");
        }
        this.disciplina = disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) throws ProfessorNaoAtribuidoException {
        if (professor == null) {
            throw new ProfessorNaoAtribuidoException("O professor não foi atribuído.");
        }
        this.professor = professor;
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
        return "Código da Turma: " + codigo;
    }
}
