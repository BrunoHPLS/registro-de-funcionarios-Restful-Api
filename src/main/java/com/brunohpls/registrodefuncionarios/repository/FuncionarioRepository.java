package com.brunohpls.registrodefuncionarios.repository;

import com.brunohpls.registrodefuncionarios.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface FuncionarioRepository extends JpaRepository<Funcionario,Long> {
    List<Funcionario> findByProfissao(String profissao);

    @Query("select distinct f.profissao from Funcionario f")
    List<String> listProfissao();
    
}
