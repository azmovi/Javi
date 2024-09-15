package br.ufscar.dc.dsw.domain;

import java.util.List;

public class Loja {

    private Long id;
    private String CNPJ;
    private String nome;
    private String categoria;
    private String endereco;
    private String cidade;
    private List<Item> itens;

    public Loja() {
    }
    
    public Loja(Long id, String CNPJ, String nome, String categoria, String endereco, String cidade, List<Item> itens) {
        this.id = id;
        this.CNPJ = CNPJ;
        this.nome = nome;
        this.categoria = categoria;
        this.endereco = endereco;
        this.cidade = cidade;
        this.itens = itens;
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getCNPJ() {
        return CNPJ;
    }
    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public List<Item> getItens() {
        return itens;
    }
    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    @Override
	public String toString() {
		return id + " - " + nome + " - " + CNPJ + " - " + cidade + " - " + endereco + " - " + categoria + " - " + itens;
	}
}

