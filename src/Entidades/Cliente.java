package Entidades;

import Enums.BairrosEnum;

public class Cliente {

    private String nome;//
    private String endereco;//
    private Integer numero;//
    private String complemento;
    private BairrosEnum Bairro;//   
    private Integer CEP;
    private Pagamento formadePagamento;
    private String telefone;//
    private String email;//
    private String senha;
    private Integer codigo;

    public Integer getCodigo() {
        return codigo;
    }
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    public String getComplemento() {
        return complemento;
    }
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public Integer getNumero() {
        return numero;
    }
    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    public BairrosEnum getBairro() {
        return Bairro;
    }
    public void setBairro(BairrosEnum bairro) {
        Bairro = bairro;
    }
    public Integer getCEP() {
        return CEP;
    }
    public void setCEP(Integer cEP) {
        CEP = cEP;
    }
    public Pagamento getFormadePagamento() {
        return formadePagamento;
    }
    public void setFormadePagamento(Pagamento formadePagamento) {
        this.formadePagamento = formadePagamento;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    @Override
    public String toString() {
        return "Cliente [CEP=" + CEP + ", codigo=" + codigo + ", complemento=" + complemento + ", email=" + email
                + ", endereco=" + endereco + ", nome=" + nome + ", numero=" + numero + ", senha=" + senha
                + ", telefone=" + telefone + "]";
    }

    


    
    
}
