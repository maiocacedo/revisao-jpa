package br.edu.utfpr.giuvane.revisao.modelo.classes;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Caio Macedo
 */
@Entity
@Table(name = "TB_PATRIMONIO")
public class Patrimonio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PAT_CODIGO")
    private Long codigo;

    @Column(name = "PAT_DESCRICAO", length = 60, nullable = false)
    private String descricao;

    @Temporal(TemporalType.DATE)
    @Column(name = "PAT_DATAFABRICACAO", nullable = false)
    private Date dataFabricacao;

    @Temporal(TemporalType.DATE)
    @Column(name = "PAT_DATAAQUISICAO", nullable = false)
    private Date dataAquisicao;

    @Temporal(TemporalType.DATE)
    @Column(name = "PAT_DATAELIMINACAO")
    private Date dataEliminacao;

    @Column(name = "PAT_VLRAQUISICAO", precision = 10, scale = 2)
    private BigDecimal valorAquisicao;

    @Column(name = "PAT_OBS", length = 100)
    private String observacao;

    @Column(name = "PAT_LOCALIZACAO", length = 100)
    private String localizacao;

    @ManyToOne(fetch = javax.persistence.FetchType.LAZY)
    @JoinColumn(name = "PAT_CODTIPO", nullable = false)
    private Tipo tipo;

    @ManyToOne(fetch = javax.persistence.FetchType.LAZY)
    @JoinColumn(name = "PAT_CODMARCA", nullable = false)
    private Marca marca;

    @ManyToOne(fetch = javax.persistence.FetchType.LAZY)
    @JoinColumn(name = "PAT_CODDEPARTAMENTO", nullable = false)
    private Departamento departamento;

    @ManyToOne(fetch = javax.persistence.FetchType.LAZY)
    @JoinColumn(name = "PAT_CODPREDIO", nullable = false)
    private Predio predio;

    @javax.persistence.PrePersist
    public void aoCadastrar() {
        if (this.dataAquisicao == null) {
            this.dataAquisicao = new java.util.Date(); // define a data atual caso não seja preenchida na inserção
        }
        System.out.println("[Callback JPA] O patrimônio " + this.descricao + " está sendo salvo no banco de dados.");
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(Date dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public Date getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(Date dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    public Date getDataEliminacao() {
        return dataEliminacao;
    }

    public void setDataEliminacao(Date dataEliminacao) {
        this.dataEliminacao = dataEliminacao;
    }

    public BigDecimal getValorAquisicao() {
        return valorAquisicao;
    }

    public void setValorAquisicao(BigDecimal valorAquisicao) {
        this.valorAquisicao = valorAquisicao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Predio getPredio() {
        return predio;
    }

    public void setPredio(Predio predio) {
        this.predio = predio;
    }
}
