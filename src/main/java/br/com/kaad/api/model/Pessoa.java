/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kaad.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author diego.nogueira
 */
@Entity
@Getter
@Setter
@Table(name = "pessoa")
public class Pessoa implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    
    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;
    
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date nascimento;
    
    private String nomeParceiro;
    
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date nascimentoParceiro;
    
    public Pessoa() {
        
    }
    
    public Pessoa(String nome, EstadoCivil estadoCivil, Date nascimento, String nomeParceiro, Date nascimentoParceiro) {
        this.nome = nome;
        this.estadoCivil = estadoCivil;
        this.nascimento = nascimento;
        this.nomeParceiro = nomeParceiro;
        this.nascimentoParceiro = nascimentoParceiro;
    }

    public Pessoa(Long id, String nome, EstadoCivil estadoCivil, Date nascimento, String nomeParceiro, Date nascimentoParceiro) {
        this.id = id;
        this.nome = nome;
        this.estadoCivil = estadoCivil;
        this.nascimento = nascimento;
        this.nomeParceiro = nomeParceiro;
        this.nascimentoParceiro = nascimentoParceiro;
    }
    
}
