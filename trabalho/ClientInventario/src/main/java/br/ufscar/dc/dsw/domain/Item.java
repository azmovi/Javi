package br.ufscar.dc.dsw.domain;

import java.math.BigDecimal;

public class Item {

    private Long id;
    private String titulo;
    private String descricao;
    private Integer ano;
    private BigDecimal preco;
    private Loja loja;

    public Item() {
    }
    
    public Item(Long id, String titulo, String descricao, Integer ano, BigDecimal preco, Loja loja) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.ano = ano;
        this.preco = preco;
        this.loja = loja;
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getAno() {
        return ano;
    }
    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public BigDecimal getPreco() {
        return preco;
    }
    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Loja getLoja() {
        return loja;
    }
    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    @Override
	public String toString() {
		return id + " - " + titulo + " - " + descricao + " - " + ano + " - " + preco;
	}
}
