package Testes.Cliente;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;

import DAOs.ClientesDAO;
import DAOs.PagamentosDAO;
import Entidades.Cliente;
import Entidades.Pagamento;
import Enums.BairrosEnum;
import Enums.PagamentosEnum;

public class TesteJUnitCliente {
    ClientesDAO cd = new ClientesDAO();
    PagamentosDAO pd = new PagamentosDAO();
    
    private Cliente preencheDadosCliente() {
        Cliente cli = new Cliente();

        cli.setNome("Cliente exemplo");
        cli.setEndereco("Rua Saturnino de brito");
        cli.setNumero(74);
        cli.setBairro(BairrosEnum.Aventureiro);
        cli.setCEP(89200000);
        cli.setTelefone("99998888");
        cli.setComplemento("Próximo a ponte");
        cli.setEmail("teste@teste.com");
        cli.setSenha("Senha@2022");
        Pagamento pag = pd.listar().get(0);
        pag.setNumero(23423214);
        pag.setCVC(123);
        cli.setFormadePagamento(pag);
        return cli;

    }

    @Test
    public void testeClientesMockup() {
        ClientesDAO cd = new ClientesDAO();
        List<Cliente> result = cd.listar("teste");
        assertEquals(3, result.size(), "Não retornou a quantidade de clientes esperada");
    }


    @Test
    public void testeCriacaoCliente() {
        Cliente cli = preencheDadosCliente();
        Boolean validou = false;
        try {
            cd.validaInclusao(cli);
            cd.adicionar(cli);
            validou = true;
        } catch (Exception e) {

            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        assertTrue("Não conseguiu cadastrar um novo cliente", validou);

    }

    @Test
    public void testeCriacaoClientecomSenhaFraca()  {
        Cliente cli = preencheDadosCliente();
        Boolean validou = false;
        cli.setSenha("senha");
        
        try {
            cd.validaInclusao(cli);
            validou = true;
            cd.adicionar(cli);
        } catch (Exception e) {}

        assertFalse("Criou um usuário desreipeitando a regra da senha!", validou);
        
    }

    @Test
    public void criacaoClientecomEmailInvalido()  {
        Cliente cli = preencheDadosCliente();
        Boolean validou = false;
        cli.setEmail("teste@testecom");
        
        try {
            cd.validaInclusao(cli);
            validou = true;
            cd.adicionar(cli);
        } catch (Exception e) {}

        assertFalse("Criou um usuário desreipeitando a regra do e-mail", validou);
    }

    @Test
    public void criacaoClientecomNomeInvalido()  {
        Cliente cli = preencheDadosCliente();
        Boolean validou = false;
        cli.setNome("An");
        
        try {
            cd.validaInclusao(cli);
            validou = true;
            cd.adicionar(cli);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertFalse("Criou um usuário desreipeitando a regra para o nome", validou);
    }

    @Test
    public void testeCriacaoClienteSemPagamento()  {
        Cliente cli = preencheDadosCliente();
        Boolean validou = false;
        cli.setFormadePagamento(null);
        
        try {
            cd.validaInclusao(cli);
            validou = true;
            cd.adicionar(cli);
        } catch (Exception e) {}

        assertFalse("Criou um usuário sem um método de pagamento atrelado", validou);
        

    }

    @Test
    public void criacaoCEPInvalido() {
        Cliente cli = preencheDadosCliente();
        cli.setCEP(2343);
        Boolean criouUsuario = false;

        try {
            
            cd.validaInclusao(cli);
            criouUsuario = true;


        } catch (Exception e) {
            e.printStackTrace();           
        }

        assertFalse("Permitiu a criação de um cliente com CEP inválido", criouUsuario);
    }

    @Test
    public void clienteComCVCErrado() {
        Cliente cli = preencheDadosCliente();
        Pagamento pag = new Pagamento();
        pag.setTipo(PagamentosEnum.Crédito);
        pag.setNumero(1212212121);
        pag.setCVC(12);
        cli.setFormadePagamento(pag);
        Boolean criouUsuario = false;

        try {
            cd.validaInclusao(cli);
            criouUsuario = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assertFalse("Criou um usuário informando CVC do cartão de crédito inválido", criouUsuario);
        }



    }



}
