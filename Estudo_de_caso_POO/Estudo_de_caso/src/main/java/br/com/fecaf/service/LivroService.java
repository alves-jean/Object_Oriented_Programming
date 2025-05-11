package br.com.fecaf.service;

import br.com.fecaf.model.Livro;
import br.com.fecaf.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livro_repository;

    public List<Livro> listarLivros(){
        return livro_repository.findAll();
    }

    public Livro adicionarLivros(Livro novo_livro){
        return livro_repository.save(novo_livro);
    }

    public void deletarLivro(int id){
        livro_repository.deleteById(id);
    }

}
