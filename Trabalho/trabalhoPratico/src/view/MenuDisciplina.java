package view;

import java.util.List;

import javax.swing.JOptionPane;

import app.Disciplina;
import cadastros.CadastroDisciplina;

public class MenuDisciplina {
	public static Disciplina dadosNovoDisciplina() {
		String nome = lerNome();
		String id = lerId();
		return new Disciplina(nome, id);
	}
	
	private static String lerId() {
		return JOptionPane.showInputDialog("Informe o ID da disciplina: ");
	}

	private static String lerNome() {
		return JOptionPane.showInputDialog("Informe o nome da disciplina: ");
	}
	
	public static void menuDisciplina(CadastroDisciplina cadDisciplina) {
		String txt = "Informe a opção desejada \n"
				+ "1 - Cadastrar disciplina\n"
				+ "2 - Pesquisar disciplina\n"
				+ "3 - Atualizar disciplina\n"
				+ "4 - Remover disciplina\n"
				+ "5 - Listar as disciplinas\n"
				+ "0 - Voltar para menu anterior";
		
		int opcao = -1;
		do {
			String strOpcao = JOptionPane.showInputDialog(txt);
			opcao = Integer.parseInt(strOpcao);

			switch (opcao) {
			case 1:
				Disciplina novoDisciplina = dadosNovoDisciplina();
				cadDisciplina.cadastrarDisciplina(novoDisciplina);
				break;
				
			case 2: 
				String id = lerId();
				Disciplina d = cadDisciplina.pesquisarDisciplina(id);
				if (d != null)
					JOptionPane.showMessageDialog(null, d.toString());
				break;
				
			case 3: 
				id = lerId(); 
				Disciplina novoCadastro = dadosNovoDisciplina();
				boolean atualizado = cadDisciplina.atualizarDisciplina(id, novoCadastro);
				if (atualizado) {
					JOptionPane.showMessageDialog(null, "Cadastro atualizado.");
				}
				break;
				
			case 4: 
				id = lerId();
				Disciplina remover = cadDisciplina.pesquisarDisciplina(id);
				boolean removido = cadDisciplina.removerDisciplina(remover);
				if (removido) {
					JOptionPane.showMessageDialog(null, "Disciplina removida do cadastro");
					System.gc();
				}
				
			case 5:
				List<Disciplina> disciplinas = cadDisciplina.listarDisciplinas();
                StringBuilder sb = new StringBuilder();
                for (Disciplina disc : disciplinas) {
                    sb.append(disc.toString()).append("\n");
                }
                JOptionPane.showMessageDialog(null, sb.toString());
                break;

			default:
				break;
			}
		} while (opcao != 0);
		return;
	}
	
}
