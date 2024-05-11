package br.ufscar.dc.dsw.domain;

public class Filme {

    private Long id;
    private String nome;
    private String diretor;
    private Integer ano;
    private Float preco;
    private Studio studio;

    public Filme(Long id) {
        this.id = id;
    }

    public Filme(String nome, String diretor, Integer ano, Float preco, Studio studio) {
        this.nome = nome;
        this.diretor = diretor;
        this.ano = ano;
        this.preco = preco;
        this.studio = studio;
    }

    public Filme(Long id, String nome, String diretor, Integer ano, Float preco, Studio studio) {
        this(nome, diretor, ano, preco, studio);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public Studio getStudio() {
        return studio;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }
}
