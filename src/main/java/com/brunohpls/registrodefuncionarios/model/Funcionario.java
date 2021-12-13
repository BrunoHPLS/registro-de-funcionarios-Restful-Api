package com.brunohpls.registrodefuncionarios.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Funcionarios")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false,unique = true)
    private String cpf;

    @Column(nullable = false)
    private BigDecimal salario;

    @Column(nullable = false)
    private LocalDate dataNascimento;

    @Column(nullable = false)
    private LocalDate dataAdmissao;

    @Column(nullable = false)
    private String profissao;

    public Funcionario(String nome, String cpf, BigDecimal salario,
                       LocalDate dataNascimento, LocalDate dataAdmissao, String profissao) {
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
        this.dataNascimento = dataNascimento;
        this.dataAdmissao = dataAdmissao;
        this.profissao = profissao.toUpperCase();
    }

    @Override
    public String toString() {
        return String.format("\nFuncionário{id: %d, nome: %s, cpf: %s,salário %1.2f," +
                        "dataNascimento: %s,dataAdmissao: %s, profissao: %s}",
                id,nome,cpf,salario,dataNascimento,dataAdmissao,profissao);
    }
}
