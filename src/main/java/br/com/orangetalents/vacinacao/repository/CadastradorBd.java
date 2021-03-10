package br.com.orangetalents.vacinacao.repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.orangetalents.vacinacao.model.AplicacaoDeVacina;
import br.com.orangetalents.vacinacao.model.Usuario;

@Component
public class CadastradorBd {
    
    @PersistenceContext
    private EntityManager manager;

    @Transactional
    public Usuario adicionar(Usuario usuario) {
            return manager.merge(usuario);
    }

    @Transactional
    public AplicacaoDeVacina adicionar(AplicacaoDeVacina aplicacaoDeVacina) {
            return manager.merge(aplicacaoDeVacina);    
    }
}
