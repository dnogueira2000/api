/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kaad.api.repository;

import br.com.kaad.api.model.Pessoa;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author diego.nogueira
 */
@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
    
    public Page<Pessoa> findByNomeContains(@Param("nome") String nome, Pageable paginacao);
    
    @Query("SELECT p FROM Pessoa p WHERE p.nome = :nome")
    List<Pessoa> carregarPorNome(@Param("nome") String nome, Pageable paginacao);
}
