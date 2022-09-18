package Testes.Pagamento;

import java.util.List;

import DAOs.PagamentosDAO;
import Entidades.Pagamento;
import Enums.PagamentosEnum;

public class TesteSimplesPagamento {

    PagamentosDAO pgDAO = new PagamentosDAO();

    private void testListaPagamentos() throws Exception {

        List<Pagamento> pags = pgDAO.listar();

        if (pags.size() < 3) {
            throw new Exception("Está faltando algum pagamento base");
        }

        
    }

    private void testAdicionaPagamentoValido() throws Exception {
        Pagamento valido = new Pagamento();
        valido.setCodigo(4);
        valido.setNome("Novo tipo de pagamento");
        valido.setTipo(PagamentosEnum.Dinheiro);
        pgDAO.validaInclusao(valido);
    }

    private void testAdicionaPagamentoInvalido() throws Exception {
        Pagamento invalido = new Pagamento();
        invalido.setCodigo(2);
        invalido.setNome("Novo tipo de pagamento");
        invalido.setTipo(PagamentosEnum.Dinheiro);
        
        Boolean deuErro = false;
        
        try {
            pgDAO.validaInclusao(invalido);
        
        } catch (Exception e) {
          System.out.println(e.getMessage());  
          deuErro = true;
        }   

        if (deuErro == false) {
            throw new Exception("Permitiu a inclusão de um pagamento inválido");
        }

    }



    public static void main(String[] args) {
        System.out.println("Testes de pagamento");
        System.out.println("Testando lista básica de pagamentos");
        try {
            TesteSimplesPagamento ts = new TesteSimplesPagamento();
            ts.testListaPagamentos();
            System.out.println("Teste executado com sucesso"); 
        } catch (Exception e ) {
            System.out.println(e.getMessage());
        }

        System.out.println("Testando Inclusão de Pagamento Válido");
        try {
            TesteSimplesPagamento ts = new TesteSimplesPagamento();
            ts.testAdicionaPagamentoValido();
            System.out.println("Teste executado com sucesso"); 
        } catch (Exception e ) {
            System.out.println(e.getMessage());
        }

        System.out.println("Testando Inclusão de Pagamento Inválido");
        try {
            TesteSimplesPagamento ts = new TesteSimplesPagamento();
            ts.testAdicionaPagamentoValido();
            System.out.println("Teste executado com sucesso"); 
        } catch (Exception e ) {
            System.out.println(e.getMessage());
        }


    } 
    
}
