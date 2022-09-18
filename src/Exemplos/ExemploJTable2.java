package Exemplos;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

import java.awt.FlowLayout;
import java.awt.event.MouseListener;

public class ExemploJTable2 extends JFrame {


    ExemploControle2 controle = new ExemploControle2(this);

    public ExemploJTable2()  {
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Exemplo JScrollPape");
        String[] colunas = new String[] {"Nome","Endereço", "Número", "Bairro"} ;

        Object[][] dados = new Object[][] {
            {"João", "Algum lugar", 74, "Bairro"},
            {"Miriam", "Algum lugar", 74, "Boa vista"},
            {"Rodrigo", "Rua dos Rodrigos", 124, "Jardim Iririu"}
        };
        
        JTable tabela = new JTable(dados, colunas);
        

        TableColumn colunaNome = tabela.getColumnModel().getColumn(0);
        colunaNome.setMinWidth(150);
        colunaNome.setMaxWidth(150);
        colunaNome.setPreferredWidth(150);

        TableColumn colunaEndereco = tabela.getColumnModel().getColumn(1);
        colunaEndereco.setMinWidth(150);
        colunaEndereco.setMaxWidth(150);
        colunaEndereco.setPreferredWidth(150);

        JScrollPane painel = new JScrollPane(tabela);
        painel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        painel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

        add(painel,"Center");

        JButton btAdd = new JButton("Adicionar");
        JButton btAlt = new JButton("Alterar");
        JButton btRem = new JButton("Remover");

        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.LEFT));
        painelBotoes.add(btAdd);
        painelBotoes.add(btAlt);
        painelBotoes.add(btRem);

        btAdd.addActionListener(controle);

        btRem.addActionListener(controle);

        add(painelBotoes,"South");
        setVisible(true);

    }

    public static void main(String[] args) {
        
        ExemploJTable2 a = new ExemploJTable2();
    }
    
}
