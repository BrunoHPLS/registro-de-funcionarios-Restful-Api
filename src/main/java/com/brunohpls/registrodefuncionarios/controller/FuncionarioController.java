package com.brunohpls.registrodefuncionarios.controller;

import com.brunohpls.registrodefuncionarios.model.Funcionario;
import com.brunohpls.registrodefuncionarios.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
    @Autowired
    private FuncionarioRepository funcionarios;

    @GetMapping()
    public ResponseEntity<List<Funcionario>> listFuncionarios(){
        return new ResponseEntity<>(funcionarios.findAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> getFuncionario(@PathVariable Long id){
        Funcionario funcionario = funcionarios.findById(id).orElse(null);
        HttpStatus status = (funcionario==null) ? HttpStatus.BAD_REQUEST : HttpStatus.OK;
        return new ResponseEntity<>(funcionario,status);
    }

    @GetMapping("/profissao")
    public ResponseEntity<List<String>> listProfissoes(){
        return new ResponseEntity<>(funcionarios.listProfissao(),HttpStatus.OK);
    }

    @GetMapping("/profissao/{profissao}")
    public ResponseEntity<List<Funcionario>> listFuncionaiosByProfissao(@PathVariable String profissao){
        List<Funcionario> funcionario = funcionarios.findByProfissao(profissao.toUpperCase());
        HttpStatus status = (funcionario.isEmpty()) ? HttpStatus.BAD_REQUEST : HttpStatus.OK;
        return new ResponseEntity<>(funcionario,status);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Funcionario> insertFuncionario(@RequestBody Funcionario funcionario){
        funcionario.setProfissao(funcionario.getProfissao().toUpperCase());
        return new ResponseEntity<>(funcionarios.save(funcionario), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Funcionario> updateFuncionario(@PathVariable Long id, @RequestBody Funcionario funcionario){
        Optional<Funcionario> alterado = funcionarios.findById(id);
        if(alterado.isPresent()){
            alterado.get().setNome(funcionario.getNome());
            alterado.get().setCpf(funcionario.getCpf());
            alterado.get().setDataNascimento(funcionario.getDataNascimento());
            alterado.get().setDataAdmissao(funcionario.getDataAdmissao());
            alterado.get().setSalario(funcionario.getSalario());
            alterado.get().setProfissao(funcionario.getProfissao());
            funcionarios.save(alterado.get());
        }else{
            funcionario = null;
        }
        HttpStatus status = (funcionario==null) ? HttpStatus.BAD_REQUEST : HttpStatus.ACCEPTED;
        return new ResponseEntity<>(funcionario,status);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Funcionario> deleteFuncionario(@PathVariable Long id){
        Funcionario funcionario = funcionarios.findById(id).orElse(null);
        HttpStatus status = (funcionario==null) ? HttpStatus.BAD_REQUEST : HttpStatus.OK;

        if(status==HttpStatus.OK)funcionarios.delete(funcionario);

        return new ResponseEntity<>(funcionario,status);
    }

}
