package br.com.orangetalents.vacinacao.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class AplicacaoDeVacina {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

	@NotBlank

    @Column(length = 50, nullable = false)
    private String nome;

    @NotNull

    @ManyToOne
    @JoinColumn(name="usuario_email", referencedColumnName="email", nullable = false)
    private Usuario usuario;

    @NotNull

    @Column(nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date dataDeVacinacao;

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

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setDataDeVacinacao(Date dataDeVacinacao) {
        this.dataDeVacinacao = dataDeVacinacao;
    }

    public Date getDataDeVacinacao() {
        return this.dataDeVacinacao;
    }
}
