package view;

import javax.swing.JOptionPane;

import app.*;
import cadastros.*;

public class MenuTurma {

    public static Turma dadosNovaTurma(CadastroDisciplina cadDisciplina, CadastroProfessor cadProfessor) {
        try {
            String codigo = lerCodigo();
            if (codigo == null || codigo.trim().isEmpty()) {
                throw new CampoEmBrancoException("O campo 'código' está em branco.");
            }

            Disciplina disciplina = lerDisciplina(cadDisciplina);
            if (disciplina == null) {
                throw new DisciplinaNaoAtribuidaException("A disciplina não foi atribuída.");
            }

            Professor professor = lerProfessor(cadProfessor);
            if (professor == null) {
                throw new ProfessorNaoAtribuidoException("O professor não foi atribuído.");
            }

            return new Turma(codigo, disciplina, professor);

        } catch (CampoEmBrancoException | DisciplinaNaoAtribuidaException | ProfessorNaoAtribuidoException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }

    private static String lerCodigo() {
        return JOptionPane.showInputDialog("Informe o código da turma: ");
    }

    private static Disciplina lerDisciplina(CadastroDisciplina cadDisciplina) {
        String idDisciplina = JOptionPane.showInputDialog("Informe o ID da disciplina: ");
        Disciplina disciplina = cadDisciplina.pesquisarDisciplina(idDisciplina);
        if (disciplina == null) {
            JOptionPane.showMessageDialog(null, "Disciplina não encontrada!");
        }
        return disciplina;
    }

    private static Professor lerProfessor(CadastroProfessor cadProfessor) {
        String idProfessor = JOptionPane.showInputDialog("Informe a Matricula do professor: ");
        Professor professor = cadProfessor.pesquisarProfessor(idProfessor);
        if (professor == null) {
            JOptionPane.showMessageDialog(null, "Professor não encontrado!");
        }
        return professor;
    }

    private static Aluno lerAluno(CadastroAluno cadAluno) {
        String idAluno = JOptionPane.showInputDialog("Informe a Matricula do aluno: ");
        Aluno aluno = cadAluno.pesquisarAluno(idAluno);
        if (aluno == null) {
            JOptionPane.showMessageDialog(null, "Aluno não encontrado!");
        }
        return aluno;
    }

    public static void menuTurma(CadastroTurma cadTurma, CadastroDisciplina cadDisciplina, CadastroProfessor cadProfessor, CadastroAluno cadAluno) {
        String txt = "Informe a opção desejada \n"
                + "1 - Cadastrar turma\n"
                + "2 - Pesquisar turma\n"
                + "3 - Atualizar turma\n"
                + "4 - Remover turma\n"
                + "5 - Matricular aluno em turma\n"
                + "6 - Imprimir lista de presença\n"
                + "0 - Voltar para menu anterior";

        int opcao = -1;
        do {
            String strOpcao = JOptionPane.showInputDialog(txt);
            opcao = Integer.parseInt(strOpcao);

            switch (opcao) {
                case 1:
                    Turma novaTurma = dadosNovaTurma(cadDisciplina, cadProfessor);
                    if (novaTurma != null) {
                        cadTurma.cadastrarTurma(novaTurma);
                        JOptionPane.showMessageDialog(null, "Turma cadastrada com sucesso!");
                    }
                    break;

                case 2:
                    String codigoT = lerCodigo();
                    Turma t = cadTurma.pesquisarTurma(codigoT);
                    if (t != null) {
                        JOptionPane.showMessageDialog(null, t.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Turma não encontrada!");
                    }
                    break;

                case 3:
                    codigoT = lerCodigo();
                    Turma turmaExistente = cadTurma.pesquisarTurma(codigoT);
                    if (turmaExistente != null) {
                        Turma novaTurmaAtualizada = dadosNovaTurma(cadDisciplina, cadProfessor);
                        if (novaTurmaAtualizada != null) {
                            boolean atualizado = cadTurma.atualizarTurma(codigoT, novaTurmaAtualizada);
                            if (atualizado) {
                                JOptionPane.showMessageDialog(null, "Turma atualizada com sucesso!");
                            } else {
                                JOptionPane.showMessageDialog(null, "Falha ao atualizar a turma.");
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Turma não encontrada!");
                    }
                    break;

                case 4:
                    codigoT = lerCodigo();
                    turmaExistente = cadTurma.pesquisarTurma(codigoT);
                    if (turmaExistente != null) {
                        boolean removido = cadTurma.removerTurma(turmaExistente);
                        if (removido) {
                            JOptionPane.showMessageDialog(null, "Turma removida com sucesso!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Falha ao remover a turma.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Turma não encontrada!");
                    }
                    break;

                case 5:
                    String codigoTurma = lerCodigo();
                    Turma turma = cadTurma.pesquisarTurma(codigoTurma);
                    if (turma != null) {
                        Aluno aluno = lerAluno(cadAluno);
                        if (aluno != null) {
                            try {
                                cadTurma.matricularAlunoEmTurma(aluno, turma);
                                JOptionPane.showMessageDialog(null, "Aluno matriculado com sucesso!");
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, e.getMessage());
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Turma não encontrada!");
                    }
                    break;

                case 6:
                    codigoT = lerCodigo();
                    turmaExistente = cadTurma.pesquisarTurma(codigoT);
                    if (turmaExistente != null) {
                        String listaPresenca = turmaExistente.imprimirListaPresenca();
                        JOptionPane.showMessageDialog(null, listaPresenca);
                    } else {
                        JOptionPane.showMessageDialog(null, "Turma não encontrada!");
                    }
                    break;

                case 0:
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
                    break;
            }
        } while (opcao != 0);
    }
}
