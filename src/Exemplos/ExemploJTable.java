package Exemplos;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

public class ExemploJTable extends JFrame {

    public ExemploJTable()  {
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
        painel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        painel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        add(painel,"Center");
        setVisible(true);

    }

    public static void main(String[] args) {
        ExemploJTable a = new ExemploJTable();
    }
    
}
