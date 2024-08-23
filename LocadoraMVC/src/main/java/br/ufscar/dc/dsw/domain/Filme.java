package br.ufscar.dc.dsw.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "Filme")
public class Filme extends AbstractEntity<Long> {

    @NotBlank(message = "{NotBlank.filme.titulo}")
    @Size(max = 60)
    @Column(nullable = false, length = 60)
    private String titulo;

    @NotBlank(message = "{NotBlank.filme.diretor}")
    @Size(max = 60)
    @Column(nullable = false, length = 60)
    private String diretor;

    @NotNull(message = "{NotNull.filme.data}")
    @Column(nullable = false)
    private LocalDate data;

    @NotBlank(message = "{NotBlank.filme.genero}")
    @Size(max = 60)
    @Column(nullable = false, length = 60)
    private String genero;

    @NotNull(message = "{NotNull.filme.nota}")
    @DecimalMin(value = "0.0", inclusive = true, message = "{DecimalMin.filme.nota}")
    @DecimalMax(value = "10.0", inclusive = true, message = "{DecimalMax.filme.nota}")
    @Column(nullable = false, columnDefinition = "DECIMAL(8,2) DEFAULT 0.0")
    private BigDecimal nota;

    @NotNull(message = "{NotNull.filme.studio}")
    @ManyToOne
    @JoinColumn(name = "studio_id")
    private Studio studio;

    // Getters e Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public BigDecimal getNota() {
        return nota;
    }

    public void setNota(BigDecimal nota) {
        this.nota = nota;
    }

    public Studio getStudio() {
        return studio;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }
}

