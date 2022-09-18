package Testes.Pagamento;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import DAOs.PagamentosDAO;
import Entidades.Pagamento;
import Enums.PagamentosEnum;

public class TesteJUnitPagamento {

    PagamentosDAO pgDAO = new PagamentosDAO();

    @Test
    public void testListaPagamentos()  {
        List<Pagamento> pags = pgDAO.listar();
        assertTrue("Está faltando algum pagamento base", (pags.size() <= 3) ) ;   
    }

    @Test
    public void remocaoInvalida()  {
        Pagamento valido = new Pagamento();
        valido.setCodigo(1);
        Boolean validouExclusao = false;
        try {
            pgDAO.validaExclusao(valido);
            
        } catch (Exception e) {
            validouExclusao = true;
           e.printStackTrace();
        }
        assertTrue("O sistema permitiu excluir uma forma de pagamento interna do sistema", validouExclusao);
    }



    @Test
    public void testAdicionaPagamentoValido()  {
        Pagamento valido = new Pagamento();
        valido.setCodigo(4);
        valido.setNome("Novo tipo de pagamento");
        valido.setTipo(PagamentosEnum.Dinheiro);
        Boolean validouInclusao = false;
        try {
            pgDAO.validaInclusao(valido);
            validouInclusao = true;
        } catch (Exception e) {
           e.printStackTrace();
        }
        assertTrue("Não foi possível criar um novo tipo de pagamento", validouInclusao);
    }

    @Test
    public void testAdicionaPagamentoInvalido()  {
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

        assertTrue("Permitiu a inclusão de um pagamento inválido", deuErro);

    }


    
}
