package br.ufscar.dc.dsw.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;

import br.ufscar.dc.dsw.validation.UniqueCnpj;

@SuppressWarnings("serial")
@Entity
@Table(name = "Studio")
public class Studio extends AbstractEntity<Long> {

    @UniqueCnpj(message = "{Unique.studio.cnpj}")
    @NotBlank(message = "{NotBlank.studio.cnpj}")
    @Size(min = 18, max = 18, message = "{Size.studio.cnpj}")
    @Column(nullable = false, unique = true, length = 18)
    private String cnpj;
    
    @NotBlank(message = "{NotBlank.studio.nome}")
    @Size(min = 3, max = 60, message = "{Size.studio.nome}")
    @Column(nullable = false, length = 60)
    private String nome;

    @NotNull(message = "{NotNull.studio.ano}")
    @Column(nullable = false)
    private Integer ano;

    @OneToMany(mappedBy = "studio")
    private List<Filme> filmes;
    
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public List<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }
}

