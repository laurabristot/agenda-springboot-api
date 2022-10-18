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
import java.util.List;

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
    
    @PutMapping(value = "/", produces = "application/json")
	public ResponseEntity<Contato> atualizar(@RequestBody Contato contato){
	Contato cont = contatoRepository.save(contato);
	return new ResponseEntity<Contato>(cont, HttpStatus.OK);
}
    
    @DeleteMapping(value = "/")
	@ResponseBody //a resposta vai se dar no corpo da requisição
	public ResponseEntity<String> delete(@RequestParam Long idContato){
	contatoRepository.deleteById(idContato);
	return new ResponseEntity<String>("contato deletado com sucesso!", HttpStatus.OK);
}
    @GetMapping(value = "/{idContato}") //como vem em parametro tem que por as chaves
    	public ResponseEntity<Contato> contadoById(@PathVariable(value = "idContato") Long idContato) {
    	Contato cont = contatoRepository.findById(idContato).get();
    	return new ResponseEntity<Contato>(cont, HttpStatus.OK);
    }

    @GetMapping(value= "/buscar-por-nome", produces = "application/json")
	public ResponseEntity<List<Contato>> getContatoById(@RequestParam(name = "nome") String nome){
	List<Contato> contatos = contatoRepository.getContatoByName(nome);
	return new ResponseEntity<List<Contato>>(contatos, HttpStatus.OK);
    }

}
