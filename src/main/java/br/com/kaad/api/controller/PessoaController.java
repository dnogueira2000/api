/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kaad.api.controller;

import br.com.kaad.api.dto.PessoaDTO;
import br.com.kaad.api.form.PessoaForm;
import br.com.kaad.api.model.Pessoa;
import br.com.kaad.api.repository.PessoaRepository;
import br.com.kaad.api.service.PessoaService;
import java.util.Objects;
import javax.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author diego.nogueira
 */
@RestController
@RequestMapping("/pessoas")
public class PessoaController {
    
    @Autowired
    PessoaRepository pessoaRepository;
    
    @Autowired
    PessoaService pessoaService;
    
    @GetMapping
    public Page<Pessoa> lista(@RequestParam(required = false) String nome, 
            @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable paginacao){
        
        return pessoaService.lista(nome, paginacao);
    }
    
    @PostMapping
    public ResponseEntity<PessoaDTO> cadastrar(@RequestBody @Valid PessoaForm pessoaForm, UriComponentsBuilder uriComponentsBuilder) {
        pessoaService.cadastrar(pessoaForm);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Long id) {
        boolean exclui = pessoaService.excluir(id);
        
        if(exclui) {
            return ResponseEntity.ok().build();
        }
        
        return new ResponseEntity("Id nao encontrado.", HttpStatus.NOT_ACCEPTABLE);
    }

    @PutMapping("/{id}")
    public ResponseEntity editar(@PathVariable Long id, @RequestBody @Valid PessoaForm pessoaForm) {
        Pessoa p = pessoaService.editar(id, pessoaForm);
        
        if(Objects.nonNull(p.getId())) {
            return ResponseEntity.ok(new PessoaDTO(p));
        }
        
          return new ResponseEntity("Problema ao atualizar.", HttpStatus.NOT_ACCEPTABLE);
    }
}
