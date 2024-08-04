package cadastros;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import app.*;

public class CadastroTurma {
    int numTurmas;
    private List<Turma> turmas;
    private Map<Aluno, List<Turma>> alunoTurmasMap;

    public CadastroTurma() {
        numTurmas = 0;
        turmas = new ArrayList<>();
        alunoTurmasMap = new HashMap<>();
    }

    public int cadastrarTurma(Turma t) {
        boolean cadastrou = turmas.add(t);
        if (cadastrou) {
            numTurmas = turmas.size();
        }
        return numTurmas;
    }

    public Turma pesquisarTurma(String codigoTurma) {
        for (Turma t : turmas) {
            if (t.getCodigo().equalsIgnoreCase(codigoTurma)) {
                return t;
            }
        }
        return null;
    }

    public boolean removerTurma(Turma t) {
        if (turmas.contains(t)) {
            for (Aluno aluno : t.getAlunos()) {
                List<Turma> listaTurmas = alunoTurmasMap.get(aluno);
                if (listaTurmas != null) {
                    listaTurmas.remove(t);
                }
            }
            return turmas.remove(t);
        }
        return false;
    }

    public boolean atualizarTurma(String codigo, Turma t) {
        Turma remover = pesquisarTurma(codigo);
        if (remover != null) {
            turmas.remove(remover);
            return turmas.add(t);
        }
        return false;
    }

    public void matricularAlunoEmTurma(Aluno aluno, Turma turma) {
        turma.matricularAluno(aluno);
        alunoTurmasMap.computeIfAbsent(aluno, k -> new ArrayList<>()).add(turma);
    }

    public void removerAlunoDeTodasTurmas(Aluno aluno) {
        List<Turma> listaTurmas = alunoTurmasMap.remove(aluno);
        if (listaTurmas != null) {
            for (Turma turma : listaTurmas) {
                turma.removerAluno(aluno);
            }
        }
    }

    public List<Turma> listarTurmas() {
        return new ArrayList<>(turmas);
    }
}
