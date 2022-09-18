package Exemplos;

import javax.swing.JOptionPane;

public class ExemploJOptionPane {
    public static void main(String[] args) {
        //JOptionPane.showMessageDialog(null, "Ocorreu um erro", "ERRO", JOptionPane.ERROR_MESSAGE);

        //Janela de confirmação
        Integer opcao = JOptionPane.showConfirmDialog(null, "Confirma Exclusão?", "Confirmação", JOptionPane.YES_NO_OPTION);
        System.out.println("opcao: " + opcao);


    }
}
