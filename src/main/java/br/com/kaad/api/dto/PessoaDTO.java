/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kaad.api.dto;

import br.com.kaad.api.model.EstadoCivil;
import br.com.kaad.api.model.Pessoa;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author diego.nogueira
 */
@Getter
@Setter
public class PessoaDTO {
    
    private Long id;
    private String nome;
    
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date nascimento;
    
    private EstadoCivil estadoCivil;
    
    private String nomeParceiro;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date nascimentoParceiro;
    
    public PessoaDTO(Pessoa pessoa) {
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.nascimento = pessoa.getNascimento();
        this.estadoCivil = pessoa.getEstadoCivil();
        this.nomeParceiro = pessoa.getNomeParceiro();
        this.nascimentoParceiro = pessoa.getNascimentoParceiro();
    }
}
