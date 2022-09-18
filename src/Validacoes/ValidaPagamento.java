package Validacoes;

import Entidades.Pagamento;

public class ValidaPagamento {


    
    public void validaExclusao(Pagamento pag) throws Exception {

        validaCodigo(pag);
       
    }


    public void validaAdicao(Pagamento pag) throws Exception {

        validaCodigo(pag);
        validaNome(pag);
        validaTipo(pag);

    }

    public void validaEdicao(Pagamento pag) throws Exception {

        validaNome(pag);
        validaTipo(pag);

    }



    private void validaTipo(Pagamento pag) throws Exception {
        if (pag.getTipo() == null) {
            throw new Exception("Tipo de pagamento precisa ser informado");
        }
    }  

    private void validaNome(Pagamento pag) throws Exception {
        String nome = pag.getNome();

        if (nome == null) {
            throw new Exception("Nome precisa ser informado");
        }

        if (nome.isEmpty()) {
            throw new Exception("Nome precisa ser informado");
        }

        if (nome.length() < 3) {
            throw new Exception("Nome do pagamento precisa ter no minino 3 letras");
        }

    }    




    private void validaCodigo(Pagamento pag) throws Exception {
        Integer cod = pag.getCodigo();

        if (cod == null) {
           throw new Exception("Código precisa ser informado"); 
        }    

        if (cod == 0) {
            throw new Exception("Código 0 inválido como código de pagamentos");
        }

        if (cod >= 1 && cod <= 3) {
            throw new Exception("Os codigos de 1 a 3 são reservados pelo sistema");
        }
        
        
    }


    
}
