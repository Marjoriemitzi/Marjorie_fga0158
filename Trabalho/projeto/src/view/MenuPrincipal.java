package view;

import javax.swing.JOptionPane;

public class MenuPrincipal {

    public static int menuOpcoes() {
        String opcoes = "1 - Abrir cadastro de alunos \n"
                      + "2 - Abrir cadastro de professores \n"
                      + "3 - Abrir cadastro de disciplinas \n"
                      + "4 - Abrir cadastro de turmas \n"
                      + "0 - Sair";
        int opcao = -1;
        
        while (opcao < 0 || opcao > 4) {
            try {
                String strOpcao = JOptionPane.showInputDialog(opcoes);
                if (strOpcao == null || strOpcao.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, insira um número.");
                    continue;
                }
                opcao = Integer.parseInt(strOpcao);
                if (opcao < 0 || opcao > 4) {
                    JOptionPane.showMessageDialog(null, "Número fora do intervalo permitido. Tente novamente.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, insira um número.");
            }
        }
        return opcao;
    }
}
