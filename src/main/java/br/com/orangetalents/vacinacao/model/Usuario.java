package br.com.orangetalents.vacinacao.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.hibernate.annotations.NaturalId;
import org.hibernate.validator.constraints.br.CPF;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//auto increment
    @Column(nullable = false)
    private Long id;

    @NotBlank

    @Column(length = 50, nullable = false)
    private String nome;    

    @NotBlank

    @NotBlank
    @Email

    @Column(length = 30, nullable = false)
    @NaturalId
    private String email;

    @NotBlank
    @CPF

    @Column(length = 11, nullable = false)
    private String cpf;
    
    @NotNull

    @Column(nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd")//define formato do Date do java. No caso é igual ao formato que é salvo no DB.
    private Date dataDeNascimento;//ex: "2014-12-30 12:00:32"

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public Date getDataDeNascimento() {
        return this.dataDeNascimento;
    }
}
