/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kaad.api.service;

import org.springframework.stereotype.Service;
import br.com.kaad.api.form.PessoaForm;
import br.com.kaad.api.model.Pessoa;
import br.com.kaad.api.repository.PessoaRepository;
import java.util.Objects;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author diego.nogueira
 */
@Service
public class PessoaService {
    
    @Autowired
    private PessoaRepository pessoaRepository;
    
    @Transactional
    public void cadastrar(PessoaForm pessoaForm) {
        Pessoa pessoa = pessoaForm.converter(pessoaForm);
        pessoaRepository.save(pessoa);
    }
    
    @Transactional
    public boolean excluir(Long id) {
        Optional<Pessoa> optional = pessoaRepository.findById(id);
        
        if(optional.isPresent()) {
            pessoaRepository.deleteById(id);    
            return true;
        }
        
        return false;
    }
    
    @Transactional
    public Page<Pessoa> lista(@RequestParam(required = false) String nome, 
            @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable paginacao) {
        
        if (Objects.isNull(nome)) {
            Page<Pessoa> pessoas = pessoaRepository.findAll(paginacao);
            return pessoas;
        } else {
            Page<Pessoa> pessoas = pessoaRepository.findByNomeContains(nome, paginacao);
            return pessoas;
        }
    }
    
    @Transactional
    public Pessoa editar(@PathVariable Long id, @RequestBody @Valid PessoaForm pessoaForm) {
        
        Optional<Pessoa> optional = pessoaRepository.findById(id);
        Pessoa pessoa = new Pessoa();
        if(optional.isPresent()) {
            pessoa = pessoaForm.atualizar(id, pessoaRepository);
            return pessoa;
        }
        
        return pessoa;
    }
}
