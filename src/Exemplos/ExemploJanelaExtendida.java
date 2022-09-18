package Exemplos;

import javax.swing.JLabel;

public class ExemploJanelaExtendida extends ExemploJanelaAbstrata {


    public ExemploJanelaExtendida() {
        super();
        setResizable(false);
        setTitle("Esta é a nossa Janela Extendida!!!!");

    }

    public void montaTela() {
        super.montaTela();
        add(new JLabel("Este é o label da janela Extendida!"));
    }
    
    public static void main(String[] args) {
        ExemploJanelaExtendida a = new ExemploJanelaExtendida();
        a.montaTela();
        a.mostraJanela();
    }
    
}
