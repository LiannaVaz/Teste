package Entidades;

import Enums.PagamentosEnum;

public class Pagamento {
    private PagamentosEnum tipo;
    private Integer codigo;
    private Integer CVC;
    private String nome;
    private Integer numero;
    private Boolean credencial;

    public Boolean getCredencial() {
        return credencial;
    }
    public void setCredencial(Boolean credencial) {
        this.credencial = credencial;
    }
    public Integer getNumero() {
        return numero;
    }
    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public PagamentosEnum getTipo() {
        return tipo;
    }
    public void setTipo(PagamentosEnum tipo) {
        this.tipo = tipo;
    }
    public Integer getCodigo() {
        return codigo;
    }
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    public Integer getCVC() {
        return CVC;
    }
    public void setCVC(Integer cVC) {
        CVC = cVC;
    }

    


    
}
