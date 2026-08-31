/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.giuvane.revisao.modelo.classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Alterado para se adequar ao banco de dados e ao Mapeamento Objeto-Relacional
 * @author Giuvane Conti
 * @author Caio Macedo
 */
@Entity
@Table(name = "TB_DEPARTAMENTO")
public class Departamento {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DEP_CODIGO")
    private Long codigo;
    
    @Column(name = "DEP_DESCRICAO", length = 60, nullable = false)
    private String descricao;

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
    
}
