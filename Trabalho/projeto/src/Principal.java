import javax.swing.JOptionPane;
import cadastros.*;
import view.*;
import app.*;

public class Principal {

    static CadastroAluno cadAluno;
    static CadastroProfessor cadProfessor;
    static CadastroDisciplina cadDisciplina;
    static CadastroTurma cadTurma;
    
    public static void main(String[] args) {
        try {
            cadTurma = new CadastroTurma();
            cadAluno = new CadastroAluno(cadTurma);
            cadProfessor = new CadastroProfessor();
            cadDisciplina = new CadastroDisciplina();
            
            adicionarDadosIniciais();

            int opcao = 0; 

            do {
                try {
                    opcao = MenuPrincipal.menuOpcoes(); 
                    
                    switch (opcao) {
                        case 1: 
                            MenuAluno.menuAluno(cadAluno); 
                            break;
                        case 2: 
                            MenuProfessor.menuProfessor(cadProfessor);
                            break;
                        case 3: 
                            MenuDisciplina.menuDisciplina(cadDisciplina);
                            break;
                        case 4: 
                            MenuTurma.menuTurma(cadTurma, cadDisciplina, cadProfessor, cadAluno);
                            break;
                        case 0: 
                            JOptionPane.showMessageDialog(null, "Saindo do sistema.");
                            break;
                        default: 
                            JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
                            break;
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "##Error##");
                }
            } while (opcao != 0);
            
        } catch (CampoEmBrancoException | DisciplinaNaoAtribuidaException | ProfessorNaoAtribuidoException e) {
            JOptionPane.showMessageDialog(null, "Erro ao iniciar o sistema: " + e.getMessage());
        }
    }

    private static void adicionarDadosIniciais() throws CampoEmBrancoException, DisciplinaNaoAtribuidaException, ProfessorNaoAtribuidoException {
        // Criando e cadastrando disciplinas
        Disciplina matematica = new Disciplina("Matemática", "11");
        Disciplina portugues = new Disciplina("Português", "22");
        cadDisciplina.cadastrarDisciplina(matematica);
        cadDisciplina.cadastrarDisciplina(portugues);
        
        // Criando e cadastrando professores
        Professor profAna = new Professor("Ana", "23467123401", "ana.1@gmail.com", "Engenharia automotiva", "00");
        Professor profCarlos = new Professor("Carlos", "12345678901", "carlos@gmail.com", "Software", "01");
        cadProfessor.cadastrarProfessor(profAna);
        cadProfessor.cadastrarProfessor(profCarlos);
        
        // Criando e cadastrando alunos
        Aluno alunoJoao = new Aluno("João", "98765432110", "joaozinhogameplay@gmail.com", "99", "Software");
        Aluno alunoMaria = new Aluno("Marjorie", "45667812390", "marjorie@gmail.com", "98", "Aero");
        cadAluno.cadastrarAluno(alunoJoao);
        cadAluno.cadastrarAluno(alunoMaria);
        
        // Criando e cadastrando turmas
        Turma turmaMatematicaA = new Turma("t1", matematica, profAna);
        Turma turmaPortuguesB = new Turma("t2", portugues, profCarlos);
        cadTurma.cadastrarTurma(turmaMatematicaA);
        cadTurma.cadastrarTurma(turmaPortuguesB);
        
        // Matriculando alunos nas turmas
        cadTurma.matricularAlunoEmTurma(alunoJoao, turmaMatematicaA);
        cadTurma.matricularAlunoEmTurma(alunoMaria, turmaPortuguesB);
    }
}
