import javax.swing.JOptionPane;

import cadastros.*;
import view.*;
import app.*;

public class Principal {

	static CadastroAluno cadAluno;
	static CadastroProfessor cadProfessor;
	static CadastroDisciplina cadDisciplina;
	static CadastroTurma cadTurma;
	
	public static void main(String[] args) throws CampoEmBrancoException, DisciplinaNaoAtribuidaException, ProfessorNaoAtribuidoException {
		cadTurma = new CadastroTurma();
		cadAluno = new CadastroAluno(cadTurma);
		cadProfessor = new CadastroProfessor();
		cadDisciplina = new CadastroDisciplina();
		
		int opcao = 0; 
		
		adicionarDadosIniciais();

		do {
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
				break;
				default: 
					JOptionPane.showMessageDialog(null, "Opcao invalida");
					opcao = -1;
				break;
			}
		} while (opcao != 0);
		return;
	}
	private static void adicionarDadosIniciais() throws CampoEmBrancoException, DisciplinaNaoAtribuidaException, ProfessorNaoAtribuidoException {
        // Criando e cadastrando disciplinas
        Disciplina matematica = new Disciplina("Matemática", "11");
        Disciplina portugues = new Disciplina("Português", "22");
        cadDisciplina.cadastrarDisciplina(matematica);
        cadDisciplina.cadastrarDisciplina(portugues);
        
        // Criando e cadastrando professores
        Professor profAna = new Professor("Ana", "123", "email", "engenharia", "00");
        Professor profCarlos = new Professor("Carlos", "123", "email", "engenharia", "01");
        cadProfessor.cadastrarProfessor(profAna);
        cadProfessor.cadastrarProfessor(profCarlos);
        
        // Criando e cadastrando alunos
        Aluno alunoJoao = new Aluno("João", "123", "joaozin", "99", "soft");
        Aluno alunoMaria = new Aluno("Maria", "456", "joaozin", "98", "soft");
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
