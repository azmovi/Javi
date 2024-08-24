package br.ufscar.dc.dsw.domain;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

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

	@NotBlank(message = "{NotBlank.filme.genero}")
	@Size(max = 60)
	@Column(nullable = false, length = 60)
	private String genero;
    
	@NotNull(message = "{NotNull.filme.ano}")
	@Column(nullable = false, length = 5)
	private Integer ano;
	
	@NotNull(message = "{NotNull.filme.orcamento}")
	@Column(nullable = false, columnDefinition = "DECIMAL(8,2) DEFAULT 0.0")
	private BigDecimal orcamento;

    @NotNull(message = "{NotNull.filme.nota}")
    @Min(value = 0, message = "A nota deve ser no mínimo 0")
    @Max(value = 10, message = "A nota deve ser no máximo 10")
    @Column(nullable = false)
    private Integer nota;

    
	@NotNull(message = "{NotNull.filme.studio}")
	@ManyToOne
	@JoinColumn(name = "studio_id")
	private Studio studio;

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

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota= nota;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public BigDecimal getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(BigDecimal orcamento) {
		this.orcamento= orcamento;
	}

	public Studio getStudio() {
		return studio;
	}

	public void setStudio(Studio studio) {
		this.studio = studio;
	}
}
