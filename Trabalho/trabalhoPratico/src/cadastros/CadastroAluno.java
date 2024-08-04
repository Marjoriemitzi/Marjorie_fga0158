package cadastros;

import java.util.ArrayList;
import java.util.List;

import app.Aluno;

public class CadastroAluno {
    int numAlunos;
    private List<Aluno> alunos;
    private CadastroTurma cadastroTurma;

    public CadastroAluno(CadastroTurma cadastroTurma) {
        numAlunos = 0;
        this.cadastroTurma = cadastroTurma;
        alunos = new ArrayList<>();
    }

    public int cadastrarAluno(Aluno a) {
        boolean cadastrou = alunos.add(a);
        if (cadastrou) {
            numAlunos = alunos.size();
        }
        return numAlunos;
    }

    public Aluno pesquisarAluno(String matriculaAluno) {
        for (Aluno a : alunos) {
            if (a.getMatricula().equalsIgnoreCase(matriculaAluno)) {
                return a;
            }
        }
        return null;
    }

    public boolean removerAluno(Aluno a) {
        boolean removeu = false;
        if (alunos.contains(a)) {
            removeu = alunos.remove(a);
            cadastroTurma.removerAlunoDeTodasTurmas(a);
        }
        return removeu;
    }

    public boolean atualizarAluno(String matricula, Aluno a) {
        Aluno remover = pesquisarAluno(matricula);
        if (remover != null) {
            alunos.remove(remover);
            return alunos.add(a);
        }
        return false;
    }

    public List<Aluno> listarAlunos() {
        return new ArrayList<>(alunos);
    }
}
