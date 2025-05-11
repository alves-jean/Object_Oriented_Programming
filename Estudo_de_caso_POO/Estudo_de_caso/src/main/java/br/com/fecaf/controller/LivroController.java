package br.com.fecaf.controller;

import br.com.fecaf.model.Livro;
import br.com.fecaf.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
@CrossOrigin(origins = "*")
public class LivroController {

    @Autowired
    private LivroService livro_service;

    @GetMapping
    public List<Livro> listarLivros(){
        return livro_service.listarLivros();
    }

    @PostMapping
    public ResponseEntity<Livro> adicionarLivros(@RequestBody Livro livro){
        Livro novo_livro = livro_service.adicionarLivros(livro);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo_livro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLivro(@PathVariable int id){
        livro_service.deletarLivro(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
