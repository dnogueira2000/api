/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kaad.api.form;

import br.com.kaad.api.model.EstadoCivil;
import br.com.kaad.api.model.Pessoa;
import br.com.kaad.api.repository.PessoaRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author diego.nogueira
 */
@Getter
@Setter
public class PessoaForm {

    @NotNull
    @NotEmpty
    @Length(min = 5)
    private String nome;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date nascimento;

    @NotNull
    private EstadoCivil estadoCivil;

    private String nomeParceiro;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date nascimentoParceiro;

    public Pessoa converter(PessoaForm pessoaForm) {
        Pessoa pessoa = new Pessoa(pessoaForm.getNome(), pessoaForm.getEstadoCivil(), 
                pessoaForm.getNascimento(), pessoaForm.getNomeParceiro(), 
                pessoaForm.getNascimentoParceiro());

        return pessoa;
    }
    
    public Pessoa atualizar(Long id, PessoaRepository pessoaRepository) {
        Pessoa pessoa = pessoaRepository.getOne(id);
        
        //atualiza com o que veio do form
        pessoa.setNome(this.nome);
        pessoa.setNascimento(this.nascimento);
        pessoa.setEstadoCivil(this.estadoCivil);
        pessoa.setNomeParceiro(this.nomeParceiro);
        pessoa.setNascimentoParceiro(this.nascimentoParceiro);
        
        return pessoa;
    }
}
