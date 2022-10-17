package br.com.futurodev.agenda.controllers;

import br.com.futurodev.agenda.model.Contato;
import br.com.futurodev.agenda.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/contato")
public class ContatoController {

    @Autowired
    private ContatoRepository contatoRepository;

    @PostMapping(value = "/", produces = "application/json")
    public ResponseEntity<Contato> cadastrar(@RequestBody Contato contato){
    Contato cont = contatoRepository.save(contato);
    return new ResponseEntity<Contato>(cont, HttpStatus.CREATED);
    }

}
