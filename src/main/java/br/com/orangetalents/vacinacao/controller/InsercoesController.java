package br.com.orangetalents.vacinacao.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.orangetalents.vacinacao.model.AplicacaoDeVacina;
import br.com.orangetalents.vacinacao.model.Usuario;
import br.com.orangetalents.vacinacao.repository.CadastradorBd;

@RequestMapping("insercao/")
@RestController
public class InsercoesController {
    
    @Autowired
    CadastradorBd cadastrador;
    
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "usuario", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Object insereUsuario(@RequestBody @Valid Usuario usuario) {
        try {
            return this.cadastrador.adicionar(usuario);
        }
        catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "vacinacao", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Object insereVacinacao(@RequestBody @Valid AplicacaoDeVacina aplicacaoDeVacina) {
        try {
            return this.cadastrador.adicionar(aplicacaoDeVacina);
        }
        catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
