package br.ufscar.dc.dsw.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import br.ufscar.dc.dsw.validation.UniqueCNPJ;

@SuppressWarnings("serial")
@Entity
@Table(name = "Studio")
public class Studio extends AbstractEntity<Long> {

    @UniqueCNPJ(message = "{Unique.studio.CNPJ}")
    @NotBlank
    @Size(min = 18, max = 18, message = "{Size.studio.CNPJ}")
    @Column(nullable = false, unique = true, length = 18)
    private String CNPJ;

    @NotBlank
    @Size(min = 3, max = 60, message = "{Size.studio.nome}")
    @Column(nullable = false, length = 60)
    private String nome;

    @Column(nullable = false)
    private Integer ano;

    @OneToMany(mappedBy = "studio")
    private List<Filme> filmes;

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

