package Validacoes;

import java.util.ArrayList;
import java.util.List;

import Entidades.Cliente;
import Entidades.Pagamento;
import Enums.PagamentosEnum;

public class ValidaCliente {

    public void validaEdicao(Cliente cli) throws Exception {
        validaNome(cli);
        validaEndereco(cli);
        validaBairro(cli);
        validaCEP(cli);
        validaNumero(cli);
        validaTelefone(cli);
        validaFormadePagamento(cli);
        validaSenha(cli);
   }


   public void validaInclusao(Cliente cli) throws Exception {
        validaNome(cli);
        validaEndereco(cli);
        validaBairro(cli);
        validaCEP(cli);
        validaNumero(cli);
        validaTelefone(cli);
        validaFormadePagamento(cli);
        validaEmail(cli);
        validaSenha(cli);
   }
    
    private List<String> listaCaracteresEspeciais() {
        List<String> caracteres = new ArrayList<String>();
        caracteres.add("!");
        caracteres.add("@");
        caracteres.add("#");
        caracteres.add("$");
        caracteres.add("%");
        caracteres.add("&");
        caracteres.add("*");

        return caracteres;
    }


    public static void main(String[] args) {
              
        
    }

    private void validaSenha(Cliente cli) throws Exception {
        String senha = cli.getSenha();

        if (senha == null) {
            throw new Exception("Uma senha precisa ser informada!");
        }



        if (senha.length() <= 5) {
            throw new Exception("A senha deve possuir pelo menos 6 caracteres");
        }

        if (senha.equals(senha.toLowerCase())) { 
            throw new Exception("A senha deve ser formada por caracteres maiúsculos e minúsculos");
        }    
        
        List<String> especiais = listaCaracteresEspeciais();
        Boolean contem = false;
        for (String esp:especiais) {
            if (senha.indexOf(esp) > -1) {
                contem = true;
            }
        }
        if (contem == false) {
            throw new Exception("Senha deve conter pelo menos um caracter especial" + especiais.toString());
        }


        

    }



    private void validaEmail(Cliente cli) throws Exception {
        String email = cli.getEmail();
        validaStrings(email, "E-mail");

        if (email.indexOf("@") == -1 ) {
            throw new Exception("E-mail inválido");
        }

        if (email.indexOf(".") == -1 ) {
            throw new Exception("E-mail inválido");
        }
    }

    private void validaTelefone(Cliente cli) throws Exception {
        String telefone = cli.getTelefone();

        if (telefone == null) {
            throw new Exception("Telefone não pode ser null");
        }

        
    }



    private void validaFormadePagamento(Cliente cli) throws Exception {
        Pagamento pag = cli.getFormadePagamento();
        if (pag == null) {
            throw new Exception("Forma de pagamento não pode ser nulo");
        }

        if (pag.getTipo() == PagamentosEnum.Crédito ) {
            if (pag.getNumero() == null) {
                throw new Exception("Número do cartão de cédito precisa ser informado");
            }

            if (pag.getCVC() == null || pag.getCVC() <= 99) {
                throw new Exception("Número CVC válido precisa ser informado");
            }
        }

        if (pag.getTipo() == PagamentosEnum.Débito) {
            if (pag.getNumero() == null) {
                throw new Exception("Número do cartão de débito precisa ser informado");
            }
            System.out.println("pag.getCVC() " + pag.getCVC());
            if (pag.getCVC() == null || pag.getCVC() <= 99) {
                System.out.println("errou pag.getCVC() " + pag.getCVC());
                throw new Exception("Número CVC válido precisa ser informado");
            }
        }

        

    }
        
    private void validaCEP(Cliente cli) throws Exception {
        Integer cep = cli.getCEP();
        if (cep == null) {
            throw new Exception("CEP não pode ser nulo");
        }

        if (cep < 1000000) {
            throw new Exception("CEP informado é inválido");
        }

    }

    private void validaBairro(Cliente cli) throws Exception {
        if (cli.getBairro() == null) {
            throw new Exception("Bairro nulo ou inválido");
        }


    }

    private void validaStrings(String valor, String nomeCampo) throws Exception {
        if (valor == null) {
            throw new Exception(nomeCampo + " não pode ser nulo");
        }

        if (valor.isBlank()) {
            throw new Exception(nomeCampo + " não pode ser vazio");
        }

    }

    private void validaNumero(Cliente cli) throws Exception {
        Integer numero = cli.getNumero();
        String complemento = cli.getComplemento();

        if (numero == null) {
            if (complemento == null || complemento.isBlank()) {
                throw new Exception("Número ou complemento precisa ser informado");
            }
        }

    }

    private void validaEndereco(Cliente cli) throws Exception {
        validaStrings(cli.getEndereco(), "Endereço do cliente");
    }




    private void validaNome(Cliente cli) throws Exception {
        String nome = cli.getNome();
        
        
        validaStrings(nome, "Nome do cliente");
        
        System.out.println("nome.length() " + nome.length());
        if (nome.length() <= 3) {
            throw new Exception("O nome do cliente precisa de no mínimo 3 letras");
        }

    }


    
}
