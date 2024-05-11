package br.ufscar.dc.dsw.domain;

public class Studio{

    private Long id;
    private String CNPJ;
    private String empresa;

    public Studio(Long id) {
        this.id = id;
    }

    public Studio(String CNPJ, String empresa) {
        this.CNPJ = CNPJ;
        this.empresa = empresa;
    }

    public Studio(Long id, String CNPJ, String empresa) {
        this(CNPJ, empresa);
        this.id = id;
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

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
}
