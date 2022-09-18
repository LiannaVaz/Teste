package Testes.Cliente;

import DAOs.ClientesDAO;
import DAOs.PagamentosDAO;
import Entidades.Cliente;
import Entidades.Pagamento;
import Enums.BairrosEnum;

public class TesteSimplesCliente {

    ClientesDAO cd = new ClientesDAO();
    PagamentosDAO pd = new PagamentosDAO();

    public static void main(String[] atgs) {
        TesteSimplesCliente tsc = new TesteSimplesCliente();
        System.out.println("Bateria de testes para Cliente");
        try {
            System.out.println("Iniciando teste de criação de cliente");
            tsc.testeCriacaoCliente();
            System.out.println("Teste de criação de cliente realizada com sucesso");
            System.out.println("Iniciando teste de criação e cliente com senha fraca");
            tsc.testeCriacaoClientecomSenhaFraca();
            System.out.println("Teste de criação de usuário com senha fraca realizado com sucesso");
            System.out.println("Testando e-mail inválido");
            tsc.testeCriacaoClientecomEmailInvalido();
            System.out.println("Teste com email inválido realizado com sucesso");
            System.out.println("Testando criação de usuário sem forma de pagamento");
            tsc.testeCriacaoClienteSemPagamento();
            System.out.println("Teste de cliente sem pagamento realizado com sucesso");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

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

    private void testeCriacaoCliente() throws Exception {
        Cliente cli = preencheDadosCliente();
    
        cd.validaInclusao(cli);
        cd.adicionar(cli);

    }

    private void testeCriacaoClientecomSenhaFraca() throws Exception {
        Cliente cli = preencheDadosCliente();
        Boolean validou = false;
        cli.setSenha("senha");
        
        try {
            cd.validaInclusao(cli);
            validou = true;
            cd.adicionar(cli);
        } catch (Exception e) {}

        if (validou) {
            throw new Exception("Criou um usuário desreipeitando a regra da senha!");
        }

    }

    private void testeCriacaoClientecomEmailInvalido() throws Exception {
        Cliente cli = preencheDadosCliente();
        Boolean validou = false;
        cli.setEmail("teste@testecom");
        
        try {
            cd.validaInclusao(cli);
            validou = true;
            cd.adicionar(cli);
        } catch (Exception e) {}

        if (validou) {
            throw new Exception("Criou um usuário desreipeitando a regra do e-mail");
        }

    }

    private void testeCriacaoClienteSemPagamento() throws Exception {
        Cliente cli = preencheDadosCliente();
        Boolean validou = false;
        cli.setFormadePagamento(null);
        
        try {
            cd.validaInclusao(cli);
            validou = true;
            cd.adicionar(cli);
        } catch (Exception e) {}

        if (validou) {
            throw new Exception("Criou um usuário sem um método de pagamento atrelado");
        }

    }

    
}
