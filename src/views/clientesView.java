package views;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controle.clientesViewController;

public class clientesView extends JFrame {

    clientesViewController controle = new clientesViewController(this);

    public void montarTela() {
        JScrollPane painelLista = new JScrollPane();
        painelLista.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        painelLista.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        JPanel painelBotoes = new JPanel();
                
        painelBotoes.setBackground(Color.LIGHT_GRAY);
        painelBotoes.setLayout(new FlowLayout(FlowLayout.LEFT));
        JButton btAdd = new JButton("Adicionar");
        JButton btMod = new JButton("Alterar");
        JButton btDel = new JButton("Remover");
        painelBotoes.add(btAdd);
        painelBotoes.add(btMod);
        painelBotoes.add(btDel);
        
        JTable tabela = controle.montaTabela();
        painelLista = new JScrollPane(tabela);
        
        btAdd.addActionListener(controle);
        btMod.addActionListener(controle);
        btDel.addActionListener(controle);
        

        add(painelLista, "Center");
        add(painelBotoes, "South");
    }

    public void exibirJanela() {
        setVisible(true);
    }

    public clientesView() {
        setSize(800,300);
        setTitle("Listagem de Clientes Ubeer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        clientesView view = new clientesView();
        view.montarTela();
        view.exibirJanela();
    }
    
}
